package com.accenture.ltt.config;

import javax.batch.api.listener.JobListener;
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
import com.accenture.ltt.mapper.CustomRecordFieldSetMapper;
import com.accenture.ltt.transformer.CustomItemProcessor;
import com.accenture.ltt.tx.listeners.MSDChunkListener;
import com.accenture.ltt.tx.listeners.MSDStepListener;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
//	@Autowired
//	private MSDStepListener msdStepListener;
//	
//	@Autowired
//	private MSDChunkListener msdChunkListener;
	

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
	
	@Bean(name="itemReader1")
	public JdbcCursorItemReader<Employee> itemReader1(@Qualifier("mysql_dataSource")DriverManagerDataSource dataSource){
		JdbcCursorItemReader<Employee> jdbcCursorItemReader=new JdbcCursorItemReader<>();
		jdbcCursorItemReader.setDataSource(dataSource);
		jdbcCursorItemReader.setSql("select * from employee");
		BeanPropertyRowMapper<Employee> beanPropertyRowMapper=new BeanPropertyRowMapper<>();
		beanPropertyRowMapper.setMappedClass(Employee.class);
		jdbcCursorItemReader.setRowMapper(beanPropertyRowMapper);
		return jdbcCursorItemReader;
	}
	@Bean(name = "itemReader2")
	public FlatFileItemReader<Employee> itemReader2() {
		FlatFileItemReader<Employee> builder = new FlatFileItemReader<>();
		builder.setResource(new ClassPathResource("employee.csv"));
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("employeeId", "employeeName", "designation", "dateOfJoining", "departmentCode","salary");
		lineMapper.setLineTokenizer(lineTokenizer);
		CustomRecordFieldSetMapper recordFieldSetMapper = new CustomRecordFieldSetMapper();
		lineMapper.setFieldSetMapper(recordFieldSetMapper);
		builder.setLineMapper(lineMapper);
		return builder;
	}

	

	@Bean
	public CustomItemProcessor itemProcessor() {
		return new CustomItemProcessor();
	}

	@Bean(name="itemWriter1")
	public StaxEventItemWriter<Employee> itemWriter1() {
		StaxEventItemWriter<Employee> staxIWriter = new StaxEventItemWriter<>();
		staxIWriter.setResource(new FileSystemResource("xml/output_db.xml"));
		staxIWriter.setMarshaller(recordMarshaller());
		staxIWriter.setRootTagName("employees");
		return staxIWriter;
	}
	@Bean(name="itemWriter2")
	public StaxEventItemWriter<Employee> itemWriter2() {
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
	public MSDChunkListener chunkListener() {
		return new MSDChunkListener();
	}
	
	@Bean
	public MSDStepListener stepListener() {
		return new MSDStepListener();
	}

	@Bean(name="step1")
	public Step step1(@Qualifier("itemReader1")ItemReader<Employee> itemReader,
			@Qualifier("itemWriter1")StaxEventItemWriter<Employee> itemWriter,
			ItemProcessor<Employee, Employee> itemProcessor,
			MSDStepListener msdStepListener,
			MSDChunkListener msdChunkListener) {
		return this.stepBuilderFactory.get("step1")
				.listener(msdStepListener)
				.<Employee, Employee>chunk(10)
				.reader(itemReader)
				.processor(itemProcessor())
				.writer(itemWriter)
				.listener(msdChunkListener)
				.build();
	}
	
	@Bean(name="step2")
	public Step step2(@Qualifier("itemReader2")ItemReader<Employee> itemReader,
			@Qualifier("itemWriter2")StaxEventItemWriter<Employee> itemWriter,
			ItemProcessor<Employee, Employee> itemProcessor,
			MSDStepListener msdStepListener,
			MSDChunkListener msdChunkListener) {
		return this.stepBuilderFactory.get("step2")
				.listener(msdStepListener)
				.<Employee, Employee>chunk(10)
				.reader(itemReader)
				.processor(itemProcessor())
				.writer(itemWriter)
				.listener(msdChunkListener)
				.build();
	}

	@Bean(name = "firstBatchJob")
	public Job firstBatchJob(@Qualifier("step1")Step step1,@Qualifier("step2")Step step2) {
		return jobBuilderFactory.get("firstBatchJob")
				.start(step1).next(step2).build();
	}	
	

}
