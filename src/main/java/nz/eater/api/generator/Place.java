package nz.eater.api.generator;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Place {

	public static class Address {
		
		public String street;
		
		public String number;
		
		public String postCode;
		
		public String suburb;
		
		public String district;
		
		public String city;
	}

	public String name;
	
	public Address address;

	public List<String> id;

	public boolean permanentlyClosed;

	public List<String> openingHours;

	public String phone;
	
	public double rating;
	
	public int rating_count;
	
	public String website;

	@JsonProperty(access = Access.WRITE_ONLY)
	public String addressLine;

	public String latlng;
	
	public List<String> tags;

	public String summary;
}