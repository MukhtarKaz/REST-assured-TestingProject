package pojo;

import java.util.ArrayList;

public class AddAddressToSerialize {
	
	private Location location;
	private String accuracy;
	private String name;
	private String phone_number;
	private String address;
	private ArrayList<String> types;
	private String website;
	private String language;
	
	
	
	public AddAddressToSerialize(Location location, String accuracy, String name, String phone_number, String address,
			ArrayList<String> types, String website, String language) {
		super();
		this.location = location;
		this.accuracy = accuracy;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.types = types;
		this.website = website;
		this.language = language;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	
}
