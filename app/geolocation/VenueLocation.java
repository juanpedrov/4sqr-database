package geolocation;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Entity;

@Entity
public class VenueLocation extends Location {

	public VenueLocation(double[] location) {
		super(location);	
	}

	public static List<VenueLocation> findNear(double longitude, double latitude, double maxDistance) {
		List<VenueLocation> locations;
		List<Model> modelLocations;
		
		modelLocations = VenueLocation.find().field("location").near(longitude, latitude, maxDistance, true).asList();
		locations = new ArrayList<VenueLocation>();
		
		for (Iterator<Model> iterator = modelLocations.iterator(); iterator.hasNext();) {
			Model modelLocation = iterator.next();
			VenueLocation location = (VenueLocation) modelLocation;
			
			locations.add(location);
		}
		
		return locations;
	}
}
