package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.GenericModel;

@Entity
public class Venue extends GenericModel {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")	
	private String id;
	
	private String name;
	
	private double latitude;
	
	private double longitude;
	
	private String locationId;

	public Venue(String name, double longitude, double latitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public static List<Venue> findByLocations(List<Location> locations) {
		List<Venue> venues = new ArrayList<Venue>();
		Venue venue;
		
		for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext();) {
			Location location = iterator.next();
			
			venue = Venue.findByLocationId(location.getIdAsStr());
			venues.add(venue);
		}

		return venues;
	}

	public static Venue findByLocationId(String locationId) {

		return Venue.find("locationId = ?", locationId).first();
	}	
}
