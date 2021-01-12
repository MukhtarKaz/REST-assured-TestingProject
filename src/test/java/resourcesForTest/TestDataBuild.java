package resourcesForTest;

import java.util.ArrayList;


import pojo.AddAddressToSerialize;
import pojo.Location;

public class TestDataBuild {
	
	
	public  AddAddressToSerialize addPlacePayload(String name, String language, String address) {		
		// Instaniate class, add data in
		ArrayList<String> types = new ArrayList<>();
		types.add("shoe park");
		types.add("shop");

		Location l = new Location("-38.383494", "33.427362");
		AddAddressToSerialize p = new AddAddressToSerialize(l, "50", name, "(+91) 983 893 3937",
				address, types, "http://google.com", language);
		
		return p;
		
	}
	
	public String deletePlacePayload(String place_id) {
		
		return "{\r\n"
				+ "  \"place_id\": \""+place_id+"\"\r\n"
				+ "}";
		
	}
	
	

}
