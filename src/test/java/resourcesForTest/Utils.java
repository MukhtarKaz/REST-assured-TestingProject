package resourcesForTest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	// made static to make it available across all class. It keeps data after first
	// usage, so it allows save into one file all test cases

	public static RequestSpecification reqSpec;
	ResponseSpecification responseSpec;

	public RequestSpecification requestSpecification(String name) throws IOException {

		// if necessary, you can use name parameter to create separate file for each
		// test

		if (reqSpec == null) {
			// Define PrintStream Object to log info into file
			PrintStream log = new PrintStream(new File("logging.txt")); // like logging+name+.txt
			// generalized request builder
			reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
					.addFilter(RequestLoggingFilter.logRequestTo(log)) // It logs all info from request to file or
																		// console
					.addFilter(ResponseLoggingFilter.logResponseTo(log)) // It logs all info from response to file or
																			// console
					.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
			return reqSpec;
		}
		return reqSpec;
	}

	public ResponseSpecification responseSpecification() {
		// generalized response builder
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return responseSpec;

	}

	public static String getGlobalValue(String key) throws IOException {

		// To read data from properties file
		// define class Properties
		Properties properties = new Properties();
		// give knowledge about file
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resourcesForTest\\global.properties");
		properties.load(fis);

		// System.out.println( "systemName "+System.getProperty("user.dir"));
		return properties.getProperty(key);

	}

	// util to get value using response key
	public String getJsonPath(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		return js.get(key).toString();

	}

}
