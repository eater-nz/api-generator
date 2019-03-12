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

	@JsonProperty(access = Access.WRITE_ONLY)
	public String addressLine;

	public String latlng;
	
	public List<String> tags;

	public String summary;
}