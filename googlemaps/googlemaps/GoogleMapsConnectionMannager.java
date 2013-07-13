package googlemaps;

import java.util.List;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author juanpedrov
 *
 */
public class GoogleMapsConnectionMannager {

	private static final String HOST	= "http://maps.googleapis.com";
	private static final String GEOCODE = "/maps/api/geocode/json";
	
	public GoogleMapsConnectionMannager() {
	}	
	
	public List<GeocodeResponse> getGeocode(String address, String components) {
				
		return getGeocodeRequest(address, components);
	}

	
	private List<GeocodeResponse> getGeocodeRequest(String address, String components) {
		HttpResponse res;
		WSRequest request;
		
		request = WS.url(HOST + GEOCODE);
		request.setParameter("address", address);
		request.setParameter("components", components);
		request.setParameter("sensor", false);
		res = request.get();
		
		Gson gson = new GsonBuilder().create();
		GoogleMapsApiResponse apiResponse = gson.fromJson(res.getString(), GoogleMapsApiResponse.class);		
		return apiResponse.getResults();
	}
}
