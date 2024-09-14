package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.model.RequestPayload;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.services.sqs.model.Message;


@Service
public class SQSService {
    private Logger logger = LoggerFactory.getLogger(SQSService.class);
    

	@Value("${aws.sqs.queue}")
	private String sqsQueue;

    @Autowired
    SqsTemplate sqsTemplate;
  	
	public String sendMessage(RequestPayload requestPayload) {
		logger.info("SQS Service Send Message Payload ::"+requestPayload.toString());

		SendResult<Object> uuId = sqsTemplate
		 .send(sqsSendOptions -> 
		    sqsSendOptions
		      .queue(sqsQueue)
		      .payload(requestPayload)
		      .messageDeduplicationId("1")
		      .messageGroupId("1")
		 );
		
		return uuId.messageId().toString();
	}
	
		@SqsListener("${aws.sqs.queue}")
		public void listen(Message message) {

			logger.info("Message Received ::"+message.body());
		}
	

}
