package com.bestBuy.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.bestBuy.pojo.ProductPojo;

public class ProductTest extends BaseTest {

	@Test
	public void verifyGetProductApiWithBDDStyle() {

		requestFactory.getAllProducts().then().statusCode(200);

	}

	@Test
	public void verifyAddProductWithPostRequest() {
		String requestPayload = "{\r\n" + "  \"name\": \"Samsung Mobile\",\r\n" + "  \"type\": \"Mobile\",\r\n"
				+ "  \"price\": 500,\r\n" + "  \"shipping\": 10,\r\n" + "  \"upc\": \"Mobile\",\r\n"
				+ "  \"description\": \"Best Mobile in the town\",\r\n" + "  \"manufacturer\": \"Samsung\",\r\n"
				+ "  \"model\": \"M31\",\r\n" + "  \"url\": \"string\",\r\n" + "  \"image\": \"string\"\r\n" + "}";

		requestFactory.addProducts(requestPayload).then().log().all().statusCode(201);
	}

	@Test
	public void verifyAddProductWithPostRequestWithMapPayload() {

		Map<String, Object> requestPayload = new HashMap<String, Object>();

		requestPayload.put("name", "Samsung Mobile");
		requestPayload.put("type", "Mobile");
		requestPayload.put("price", 500);
		requestPayload.put("shipping", 10);
		requestPayload.put("upc", "Samsung Mobile");
		requestPayload.put("description", "Best Samsung Mobile");
		requestPayload.put("manufacturer", "Samsung Mobile");
		requestPayload.put("model", "Samsung Mobile M21");
		requestPayload.put("url", "Samsung Mobile");
		requestPayload.put("image", "Samsung Mobile");

		requestFactory.addProducts(requestPayload).then().log().all().statusCode(201);
	}

	@Test
	public void verifyAddProductWithPostRequestWithPojo() {

		ProductPojo requestPayload = new ProductPojo();

		requestPayload.setName("Samsung Mobile");
		requestPayload.setType("Mobile");
		requestPayload.setPrice(500);
		requestPayload.setShipping(10);
		requestPayload.setUpc("Mobile");
		requestPayload.setDescription("Samsung Mobile ");
		requestPayload.setManufacturer("Samsung");
		requestPayload.setModel("M21");
		requestPayload.setUrl("rwerg");
		requestPayload.setImage("shajkdas");

		requestFactory.addProducts(requestPayload).then().log().all().statusCode(201);
	}

}
