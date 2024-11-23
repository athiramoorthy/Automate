package API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTestNG {
  @Test
  public void test() {
	  RestAssured.baseURI="https://api.restful-api.dev/objects";
	  Response response=RestAssured.get();
	  System.out.println("Response:"+response.getBody().asString());
	  
  }
}
