package googlemaps;

import java.util.List;

public class GoogleMapsApiResponse {

	private List<GeocodeResponse> results;
	
	private String status;

	public List<GeocodeResponse> getResults() {
		return results;
	}

	public String getStatus() {
		return status;
	}		
}
