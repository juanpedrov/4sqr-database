package models;

import geolocation.VenueLocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.GenericModel;

@Entity
public class Venue extends BaseModel {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")	
	private String id;
	
	private String name;
	
	private double lat;
	
	private double lng;
	
	private String locationId;

	public Venue(String name, double longitude, double latitude) {
		super();
		this.name = name;
		this.lat = latitude;
		this.lng = longitude;
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
		return lng;
	}

	public void setLongitude(double lng) {
		this.lng = lng;
	}

	public double getLatitude() {
		return lat;
	}

	public void setLatitude(double lat) {
		this.lat = lat;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public static List<Venue> findByLocations(List<VenueLocation> locations) {
		List<Venue> venues = new ArrayList<Venue>();
		Venue venue;
		
		for (Iterator<VenueLocation> iterator = locations.iterator(); iterator.hasNext();) {
			VenueLocation location = iterator.next();
			
			venue = Venue.findByLocationId(location.getIdAsStr());
			venues.add(venue);
		}

		return venues;
	}

	public static Venue findByLocationId(String locationId) {

		return Venue.find("locationId = ?", locationId).first();
	}	
}
