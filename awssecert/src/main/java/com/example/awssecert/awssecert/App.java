package com.example.awssecert.awssecert;

import java.util.Map;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;	


/**
 * Hello world!
 *
 */
public class App  {
	
	 public static void main(String[] args) {
		 getSecret();
	  }

	 public static void getSecret() {

		    String secretName = "dev/client/details";
		    Region region = Region.of("ap-south-1");

		    // Create a Secrets Manager client
		    SecretsManagerClient client = SecretsManagerClient.builder()
		            .region(region)
		            .build();

		    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
		            .secretId(secretName)
		            .build();

		    GetSecretValueResponse getSecretValueResponse;

		    try {
		        getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
		        
		        System.out.println("getSecretValueResponse :::"+getSecretValueResponse);
		        System.out.println("getSecretValueResponse :::"+getSecretValueResponse.sdkFields());
		        System.out.println("getSecretValueResponse name :::"+getSecretValueResponse.name());
		        System.out.println("getSecretValueResponse secretString :::"+getSecretValueResponse.secretString());

		        
		        
		        
		    } catch (Exception e) {
		        // For a list of exceptions thrown, see
		        // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
		        throw e;
		    }

		    String secret = getSecretValueResponse.secretString();

		    // Your code goes here.
		}
}
