package com.bestBuy.test;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import requests.RequestFactory;
import utils.ConfigFileUtils;

public class BaseTest {

	String currentWorkingDirectory;
	String configFilename;
	Properties configProperties;
	
	RequestFactory requestFactory;

	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");

		configFilename = String.format("%s/config/config.properties", currentWorkingDirectory);

		configProperties = ConfigFileUtils.configFileReader(configFilename);
		
		
	}

	@BeforeClass
	public void setup() {

		RestAssured.baseURI = configProperties.getProperty("baseUrl");
		RestAssured.port = Integer.parseInt(configProperties.getProperty("port"));
		
		requestFactory = new RequestFactory();
	}

	@AfterClass
	public void cleanup() {
		RestAssured.reset();
	}
}
