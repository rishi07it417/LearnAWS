package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RequestPayload;
import com.example.demo.service.SNSService;
import com.example.demo.service.SQSService;

@RestController
@RequestMapping(path = "/mysqs")
public class MyRestController {
    private Logger logger = LoggerFactory.getLogger(MyRestController.class);
    
    @Autowired
    private SQSService sqsService;

    @Autowired
    private SNSService snsService;
	
	@PostMapping(path = "/sendMessage")
	public String sendMessage(@RequestBody RequestPayload requestPayload) {
		logger.info("Request Message :::"+requestPayload);
		
		return sqsService.sendMessage(requestPayload);
	}

	@PostMapping(path = "/sendTopicMessage")
	public String sendTopicMessage(@RequestBody RequestPayload requestPayload) {
		logger.info("Topic Message :::"+requestPayload);
		
		return snsService.sendMessageToTopic(requestPayload);
	}
	
}
