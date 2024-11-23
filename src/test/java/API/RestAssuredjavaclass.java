package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredjavaclass {
	
	public static void main(String args[]) {
		Response response = RestAssured.get("https://thinking-tester-contact-list.herokuapp.com/contacts");
		System.out.println(response.getBody().asString());
	}

}
