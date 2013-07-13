package models;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;

@Entity
public class Location extends Model {
		
    @Indexed(IndexDirection.GEO2D)
    protected double[] location = null;	
	
	public Location(double[] location) {
		super();		
		this.location = location;
	}

	public double getLatitude() {
		return this.location[1];
	}

	public void setLatitude(double latitude) {
		this.location[1] = latitude;
	}

	public double getLongitude() {
		return this.location[0];
	}

	public void setLongitude(double longitude) {
		this.location[0] = longitude;
	}	
	
	public static List<Location> findNear(double longitude, double latitude, double maxDistance) {
		List<Location> locations;
		List<Model> modelLocations;
		
		modelLocations = Location.find().field("location").near(longitude, latitude, maxDistance, true).asList();
		locations = new ArrayList<Location>();
		
		for (Iterator<Model> iterator = modelLocations.iterator(); iterator.hasNext();) {
			Model modelLocation = iterator.next();
			Location location = (Location) modelLocation;
			
			locations.add(location);
		}
		
		return locations;
	}
}
