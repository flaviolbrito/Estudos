package com.fiap.CervejaBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.logging.Logger;

@SpringBootApplication
@EnableBatchProcessing
public class CervejaBatchChunkApplication {

	private Logger logger = Logger.getLogger(CervejaBatchChunkApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CervejaBatchChunkApplication.class, args);
	}

	@Bean
	public ItemReader<Cerveja> itemReader(@Value("${fiap.batch.resource}") Resource resource){
		return new FlatFileItemReaderBuilder<Cerveja>()
				.name("csv item reader")
				.delimited()
				.delimiter(";").names("nome","tipo")
				.targetType(Cerveja.class)
				.resource(resource)
				.build();
	}

	@Bean
	public ItemProcessor<Cerveja, Cerveja> itemProcessor(){
		return cerveja -> {
			cerveja.setTipo(cerveja.getTipo().toUpperCase());
			return cerveja;
		};
	}

	@Bean
	public ItemWriter<Cerveja> itemWriter(DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Cerveja>()
				.dataSource(dataSource)
				.sql("insert into TB_CERVEJA(nome,tipo) values (:nome, :tipo)")
				.beanMapped()
				.build();
	}

	@Bean
	public Step step(ItemReader<Cerveja> itemReader,
					 ItemProcessor<Cerveja,Cerveja> itemProcessor,
					 ItemWriter<Cerveja> itemWriter,
					 StepBuilderFactory stepBuilderFactory){
		return stepBuilderFactory.get("Step Chunk processa CSV")
				.<Cerveja, Cerveja>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
				   Step step){
		return jobBuilderFactory.get("Job CSV Cerveja")
				.start(step)
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
