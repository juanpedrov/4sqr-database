package foursquare;

public class LocationResponse {

	private String address;
	
	private double lat;
	
	private double lng;
	
	private long distance;
	
	private String postalCode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String cc;

	public String getAddress() {
		return address;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public long getDistance() {
		return distance;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getCc() {
		return cc;
	}	
}
