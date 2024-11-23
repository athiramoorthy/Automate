package API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
  @Test
  public void fileUpload() {
	  RestAssured.baseURI="https://reqres.in/api/upload";
	  Response response=RestAssured
	  .given()
	  .pathParam("endpoint", "/api/upload")
	  .multiPart("file", "/Users/athiramoorthy/eclipse-workspace/Automate/src/main/resources/fileUpload")
	  .log().all()
	  .when()
	  .post("{endpoint}");//if there is no endpoint, give only post() method
	  
	  //for debugging and understanding
	  System.out.println("Pretty print");
	  response.prettyPrint();
	  
	  //validating response
	  response
	  .then()
	  .statusCode(200);
	  
	  //validating if status line contains "created" text
	  response.getStatusLine().contains("Created");
	  
	  System.out.println(response.body().asString());
  }
}
