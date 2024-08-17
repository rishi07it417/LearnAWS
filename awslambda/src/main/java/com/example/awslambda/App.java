package com.example.awslambda;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Hello world!
 *
 */
public class App implements RequestHandler<Map<String,Object>, String> {
	
    public String handleRequest(final Map<String,Object> input, final Context context) {

    	LambdaLogger logger = context.getLogger();
    	logger.log("====App Lambda Start :"+context.getAwsRequestId());
    	
    	logger.log("===Input==="+input.toString());
    	logger.log("===context==="+context.toString());
    	
    	logger.log("====App Lambda End :"+context.getAwsRequestId());

    	return input.toString();
    }
}
