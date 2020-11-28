package requests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {

	public Response doGetRequest(String request) {

		return given().when().get(request);

	}

	public Response doPostRequest(String uri, Object body) {

		return given().contentType(ContentType.JSON).when().body(body).post(uri);

	}

	public Response doPutRequest(String uri, Object body) {

		return given().contentType(ContentType.JSON).when().body(body).put(uri);

	}
	
	public Response doPatchRequest(String uri, Object body) {

		return given().contentType(ContentType.JSON).when().body(body).patch(uri);

	}
	
	public Response doDeleteRequest(String uri) {

		return given().when().delete(uri);

	}

}
