//package com.fiap.CervejaBatch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.io.File;
//import java.nio.file.Paths;
//import java.util.logging.Logger;
//
//@SpringBootApplication
//@EnableBatchProcessing
//public class CervejaBatchApplication {
//
//	private Logger logger = Logger.getLogger(CervejaBatchApplication.class.getSimpleName());
//
//	public static void main(String[] args) {
//		SpringApplication.run(CervejaBatchApplication.class, args);
//	}
//
//	@Bean
//	public Tasklet tasklet(@Value("${fiap.batch.arquivo}") String path){
//		return (stepContribution, chunkContext) -> {
//			File file = Paths.get(path).toFile();
//
//			if(file.delete()){
//				logger.info("arquivo deletado");
//			} else {
//				logger.warning("não foi possível deletar o arquivo");
//			}
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Step step(StepBuilderFactory stepBuilderFactory,
//					 Tasklet tasklet){
//		return stepBuilderFactory.get("Step deleta arquivo")
//				.tasklet(tasklet)
//				.allowStartIfComplete(true)
//				.build();
//	}
//
//	@Bean
//	public Job job(JobBuilderFactory jobBuilderFactory,
//				   Step step){
//		return jobBuilderFactory.get("Job Setup Arquivo")
//				.start(step)
//				.incrementer(new RunIdIncrementer())
//				.build();
//	}
//
//}
