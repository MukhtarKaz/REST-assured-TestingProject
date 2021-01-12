package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;
import io.cucumber.junit.Cucumber;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resourcesForTest.APIResources;
import resourcesForTest.TestDataBuild;
import resourcesForTest.Utils;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils{


	RequestSpecification res;
	ResponseSpecification responseSpec;
	Response response;
	 TestDataBuild data = new TestDataBuild();
	// make static to share data after first test completed
	 static String place_id;
	

	  @Given("^add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void add_place_payload_with(String name, String language, String address) throws Throwable {
		 
			
		  // arguments comes from feature file
			res = given().spec(requestSpecification(name)) // using reusable requests
					.body(data.addPlacePayload(name, language, address)); // body comes from serialized JAVA object

	    }
	

	  @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	    public void user_calls_with_http_request(String resource, String httpMethod) throws Throwable {
		// Using Enum class for resources
		APIResources resForBody = APIResources.valueOf(resource);
		String readyResource = resForBody.getResource();
		System.out.println(readyResource);
		


		if (httpMethod.equalsIgnoreCase("POST")) {
			response = res.when().post(readyResource);
		} else if (httpMethod.equalsIgnoreCase("GET")) {
			response = res.when().get(readyResource);
		} else if (httpMethod.equalsIgnoreCase("DELETE")) {
			response = res.when().delete(readyResource);
		}

		
	}

	@Then("^the API call is success with status code 200$")
	public void the_api_call_is_success_with_status_code_200() throws Throwable {

		assertEquals(response.getStatusCode(), 200);

	}

	@And("^\"([^\"]*)\" in responce body is \"([^\"]*)\"$")
	public void something_in_responce_body_is_something(String key, String expectedValue) throws Throwable {

		
		assertEquals(getJsonPath(response, key), expectedValue);

	}
	
	@And("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws Throwable {
		
		 place_id = getJsonPath(response, "place_id");
		
		res = given().spec(requestSpecification(expectedName)) // using reusable requests
				.queryParam("place_id", place_id);
		//calling method to get response
		user_calls_with_http_request(resource, "GET");
		// after calling above method response comes from GET request instead of POST before
		 String actualName = getJsonPath(response, "name");
		 // JUNit assertEquals to check name from feature file
		 assertEquals(actualName, expectedName);
	   
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
					res = given().spec(requestSpecification("deletePlaceAPI")) // using reusable requests
							.body(data.deletePlacePayload(place_id)); // body comes from serialized JAVA object
					
	}
}
