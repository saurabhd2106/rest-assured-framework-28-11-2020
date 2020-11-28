package requests;

import io.restassured.response.Response;

public class RequestFactory {

	RestClient restClient;

	public RequestFactory() {
		restClient = new RestClient();
	}

	public Response getAllProducts() {
		return restClient.doGetRequest("/products");
	}
	
	public Response addProducts(Object body) {
		return restClient.doPostRequest("/products", body);
	}

}
