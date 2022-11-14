package com.myapp.springawsses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AwsPropertyConfig {

	@Value("${mailFrom}")
	public String mailFrom;

	@Value("${awsAccessKey}")
	public String awsAccessKey;

	@Value("${awsSecretKey}")
	public String awsSecretKey;

}
