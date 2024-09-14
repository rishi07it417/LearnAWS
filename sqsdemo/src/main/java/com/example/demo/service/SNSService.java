package com.example.demo.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.model.RequestPayload;

import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsTemplate;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.services.sqs.model.Message;


@Service
public class SNSService {
    private Logger logger = LoggerFactory.getLogger(SNSService.class);
    

	@Value("${aws.topic.arn}")
	private String topicarn;

    @Autowired
    SnsTemplate snsTemplate;
  	
	public String sendMessageToTopic(RequestPayload requestPayload) {
        UUID uuid = UUID.randomUUID();
		logger.info("SNS Service Send Message Payload ::"+requestPayload.toString()+":::UUID:::"+uuid);


		snsTemplate.sendNotification(topicarn, SnsNotification.builder(requestPayload).groupId("1").deduplicationId(uuid.toString()).build());
		
		return requestPayload.toString();
	}
	
	
	


}
