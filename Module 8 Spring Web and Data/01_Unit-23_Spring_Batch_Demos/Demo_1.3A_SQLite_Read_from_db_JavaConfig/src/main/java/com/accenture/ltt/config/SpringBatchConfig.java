package com.accenture.ltt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

import com.accenture.ltt.dto.Employee;
import com.accenture.ltt.transformer.CustomItemProcessor;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	@Bean
	public ResourceDatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-drop-sqlite.sql"));
		populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-sqlite.sql"));
		return populator;
	}

	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverSource = new DriverManagerDataSource();
		driverSource.setDriverClassName("org.sqlite.JDBC");
		driverSource.setUrl("jdbc:sqlite:repository.sqlite");
		driverSource.setUsername("");
		driverSource.setPassword("");
		return driverSource;
	}
	
	@Bean(name="mysql_dataSource")
	public DriverManagerDataSource mydataSource() {
		DriverManagerDataSource driverSource = new DriverManagerDataSource();
		driverSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverSource.setUrl("jdbc:mysql://localhost:3306/spring_batch_demos");
		driverSource.setUsername("root");
		driverSource.setPassword("root");
		return driverSource;
	}

	@Bean
	public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
			throws Exception {
		JobRepositoryFactoryBean jobRepoFactory = new JobRepositoryFactoryBean();
		jobRepoFactory.setDataSource(dataSource);
		jobRepoFactory.setTransactionManager(transactionManager);
		jobRepoFactory.setDatabaseType("sqlite");
		return jobRepoFactory.getObject();
	}

	@Bean 
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean
	public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
		SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
		simpleJobLauncher.setJobRepository(jobRepository);
		return simpleJobLauncher;
	}

	@Bean
	public JobBuilderFactory jobBuilderFactory(JobRepository jobRepository) {
		return new JobBuilderFactory(jobRepository);
	}

	@Bean
	public StepBuilderFactory stepBuilderFactory(JobRepository jobRepository,
			PlatformTransactionManager transactionManager) {
		return new StepBuilderFactory(jobRepository, transactionManager);
	}
	
	@Bean
	public JdbcCursorItemReader<Employee> itemReader(@Qualifier("mysql_dataSource")DriverManagerDataSource dataSource){
		JdbcCursorItemReader<Employee> jdbcCursorItemReader=new JdbcCursorItemReader<>();
		jdbcCursorItemReader.setDataSource(dataSource);
		jdbcCursorItemReader.setSql("select * from employee");
		BeanPropertyRowMapper<Employee> beanPropertyRowMapper=new BeanPropertyRowMapper<>();
		beanPropertyRowMapper.setMappedClass(Employee.class);
		jdbcCursorItemReader.setRowMapper(beanPropertyRowMapper);
		return jdbcCursorItemReader;
	}
	
	

	@Bean
	public CustomItemProcessor itemProcessor() {
		return new CustomItemProcessor();
	}

	@Bean
	public StaxEventItemWriter<Employee> itemWriter() {
		StaxEventItemWriter<Employee> staxIWriter = new StaxEventItemWriter<>();
		staxIWriter.setResource(new FileSystemResource("xml/output.xml"));
		staxIWriter.setMarshaller(recordMarshaller());
		staxIWriter.setRootTagName("employees");
		return staxIWriter;
	}

	public Jaxb2Marshaller recordMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Employee.class);
		return marshaller;
	}

	@Bean
	public Step step1( ItemReader<Employee> itemReader,
			StaxEventItemWriter<Employee> itemWriter,
			ItemProcessor<Employee, Employee> itemProcessor) {
		return this.stepBuilderFactory.get("step1").<Employee, Employee>chunk(10).reader(itemReader)
				.processor(itemProcessor()).writer(itemWriter).build();
	}

	@Bean(name = "firstBatchJob")
	public Job firstBatchJob(Step step1) {
		return jobBuilderFactory.get("firstBatchJob").start(step1).build();
	}


}
