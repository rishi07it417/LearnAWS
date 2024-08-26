package com.example.awsparam.awsparam;

import java.util.Map;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;


/**
 * Hello world!
 *
 */
public class App  {
	
	 public static void main(String[] args) {
	      /*  final String usage = """

	                Usage:
	                    <paraName>

	                Where:
	                    paraName - The name of the parameter.
	                """;

	        if (args.length != 1) {
	            System.out.println(usage);
	            System.exit(1);
	        }*/

	        String paraName = "first-store-param";
	        Region region = Region.AP_SOUTH_1;
	        SsmClient ssmClient = SsmClient.builder()
	                .region(region)
	                .build();

	        getParaValue(ssmClient, paraName);
	        ssmClient.close();
	    }

	    public static void getParaValue(SsmClient ssmClient, String paraName) {
	        try {
	            GetParameterRequest parameterRequest = GetParameterRequest.builder()
	                    .name(paraName)
	                    .build();

	            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
	            System.out.println("The parameter value is :::::::::: " + parameterResponse.parameter().value());

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	        }
	    }
}
