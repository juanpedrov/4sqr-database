package googlemaps;

public class BoundsResponse {

	private LocationResponse northeast;
	private LocationResponse southwest;
	
	public LocationResponse getNortheast() {
		return northeast;
	}
	public LocationResponse getSouthwest() {
		return southwest;
	}	
}
