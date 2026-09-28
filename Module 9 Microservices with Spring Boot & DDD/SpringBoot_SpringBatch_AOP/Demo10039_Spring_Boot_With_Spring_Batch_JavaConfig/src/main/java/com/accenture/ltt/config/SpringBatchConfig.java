package com.accenture.ltt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.repeat.support.RepeatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.accenture.ltt.custom.launcher.CustomJobLauncher;
import com.accenture.ltt.dto.Employee;
import com.accenture.ltt.mapper.CustomRecordFieldSetMapper;
import com.accenture.ltt.transformer.CustomItemProcessor;
import com.accenture.ltt.tx.listeners.MSDChunkListener;
import com.accenture.ltt.tx.listeners.MSDStepListener;

@Configuration
public class SpringBatchConfig {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = "reader1")
	public JdbcCursorItemReader<Employee> itemReader1() {
		JdbcCursorItemReader<Employee> itemReader = new JdbcCursorItemReader<>();
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_batch_boot_demos");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		itemReader.setDataSource(driverManagerDataSource);
		itemReader.setSql("select * from employee");
		BeanPropertyRowMapper<Employee> beanPropertyRowMapper = new BeanPropertyRowMapper<>();
		beanPropertyRowMapper.setMappedClass(Employee.class);
		itemReader.setRowMapper(beanPropertyRowMapper);
		return itemReader;
	}

	@Bean(name = "reader2")
	public FlatFileItemReader<Employee> itemReader2() {
		FlatFileItemReader<Employee> builder = new FlatFileItemReader<>();
		builder.setResource(new FileSystemResource("src/main/resources/employee.csv"));
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("employeeId", "employeeName", "designation", "dateOfJoining", "departmentCode",
				"salary");
		lineMapper.setLineTokenizer(lineTokenizer);

		CustomRecordFieldSetMapper recordSetMapper = new CustomRecordFieldSetMapper();
		lineMapper.setFieldSetMapper(recordSetMapper);
		builder.setLineMapper(lineMapper);
		return builder;
	}

	@Bean
	public CustomItemProcessor itemProcessor() {
		return new CustomItemProcessor();
	}

	public Jaxb2Marshaller recordMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Employee.class);
		return marshaller;
	}

//	<beans:bean id="itemWriter1" scope="step"
//			class="org.springframework.batch.item.xml.StaxEventItemWriter">
//			<beans:property name="resource"
//				value="file:xml/output_db-#{jobParameters['time']}.xml" />
//			<beans:property name="marshaller"
//				ref="recordMarshaller" />
//			<beans:property name="rootTagName" value="employees" />
//		</beans:bean>

	@Bean(name = "writer1")
	@StepScope	
	public StaxEventItemWriter<Employee> itemWriter1(@Value("#{jobParameters['time']}.xml")String param) {
		StaxEventItemWriter<Employee> staxIWriter=new StaxEventItemWriter<>();
		staxIWriter.setResource(new FileSystemResource("xml/output_db-"+param));
		staxIWriter.setMarshaller(recordMarshaller());
		staxIWriter.setRootTagName("employees");
		return staxIWriter;
	}

	@Bean(name = "writer2")
	@StepScope
	public StaxEventItemWriter<Employee> itemWriter2(@Value("#{jobParameters['time']}.xml") String param) {
		StaxEventItemWriter<Employee> staxIWriter = new StaxEventItemWriter<>();
		staxIWriter.setResource(new FileSystemResource("xml/output-" + param));
		staxIWriter.setMarshaller(recordMarshaller());
		staxIWriter.setRootTagName("employees");
		return staxIWriter;

	}

	@Bean
	public MSDStepListener stepListener() {
		return new MSDStepListener();
	}

	@Bean
	public MSDChunkListener chunkListener() {
		return new MSDChunkListener();
	}

	@Bean
	public Step step1(@Qualifier("reader1") JdbcCursorItemReader<Employee> itemReader1,
			@Qualifier("writer1") StaxEventItemWriter<Employee> itemWriter1, MSDChunkListener chunkListener) {
		return this.stepBuilderFactory.get("step1")
															.<Employee, Employee>chunk(10)
															.reader(itemReader1)
															.writer(itemWriter1)
															.listener(chunkListener).build();
		}

	@Bean
	public Step step2(@Qualifier("reader2") FlatFileItemReader<Employee> itemReader2,
			@Qualifier("writer2") StaxEventItemWriter<Employee> itemWriter2, MSDChunkListener chunkListener) {
		return this.stepBuilderFactory.get("step2").<Employee, Employee>chunk(10).reader(itemReader2)
				.writer(itemWriter2).listener(chunkListener).build();
	}

	@Bean
	public Job firstBatchJob(@Qualifier("step1")Step step1,@Qualifier("step2") Step step2) {
		return jobBuilderFactory.get("firstBatchJob").start(step1).next(step2).build();
	}

	@Bean
	public CustomJobLauncher customJobLauncher(Job firstBatchJob) {
		return new CustomJobLauncher(jobLauncher, firstBatchJob, 12);
	}

	@Bean
	public RepeatTemplate repeatTemplate() {
		return new RepeatTemplate();
	}
}
