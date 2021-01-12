package resourcesForTest;



public enum APIResources {
	
	addPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	
	String resource;

	APIResources(String resource) {

		this.resource = resource;
	}

	// It for addPlaceAPI  returns "maps/api/place/add/json"
	public String getResource() {
		return resource;
	}
	
	
	
	

}
