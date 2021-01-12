package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@deletePlace")
	public void gettingPlaceID() throws Throwable {

		// Calling Stepdefintion class to run methods independently
		StepDefinition step = new StepDefinition();

		if (StepDefinition.place_id == null) {
			step.add_place_payload_with("Mukhtar", "Russian", "Kazakhstan");
			step.user_calls_with_http_request("addPlaceAPI", "POST");
			step.verify_place_id_created_maps_to_using("Mukhtar", "getPlaceAPI");
		}

	}
	
	
	@After("@deletePlace")
	public void salutationJust() {
		System.out.println("Now HOOK was implemented");
	}
	

}
