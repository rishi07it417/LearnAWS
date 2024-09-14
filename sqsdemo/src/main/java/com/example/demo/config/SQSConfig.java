package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.Message;

@Configuration
public class SQSConfig {
    private Logger logger = LoggerFactory.getLogger(SQSConfig.class);


	 @Value("${spring.cloud.aws.credentials.access-key}")
	  private String accessKey;

	  @Value("${spring.cloud.aws.credentials.secret-key}")
	  private String secretKey;

	  @Value("${spring.cloud.aws.region.static}")
	  private String region;

	  @Primary
	  @Bean
	  SqsAsyncClient sqsAsyncClient(){
	    return SqsAsyncClient
	      .builder()
	      .region(Region.of(region))
	      .credentialsProvider(StaticCredentialsProvider
	        .create(AwsBasicCredentials.create(accessKey, secretKey)))
	      .build();
	  }

	  @Bean
	  public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient){
	      return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
	  }
	  
	  

}
