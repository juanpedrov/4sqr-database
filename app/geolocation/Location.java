package geolocation;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;

public abstract class Location extends Model {

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
}
