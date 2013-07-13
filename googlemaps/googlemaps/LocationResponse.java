package googlemaps;

public class LocationResponse {

	private double lat;
	private double lng;

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}
	
	public double[] getLocation() {
		
		return new double[] {lng,lat};
	}
}
