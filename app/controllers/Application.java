package controllers;

import java.util.Iterator;
import java.util.List;

import models.FoursquareCredentials;
import models.Location;
import models.Venue;
import play.mvc.Controller;
import play.mvc.Util;

import com.google.code.morphia.Datastore;

import foursquare.CategoryResponse;
import foursquare.FoursquareConnectionManager;
import foursquare.VenueResponse;

/**
 * @author juanpedrov
 *
 */
public class Application extends Controller {



	public static void findVenuesAround(String ll) {

		String[] loc;
		List<Location> locations;
		List<Venue> venues;
		
		loc = ll.split(",");
		locations = Location.findNear(Double.parseDouble((loc[1])), Double.parseDouble((loc[0])), 10);
		
		venues = Venue.findByLocations(locations);
		
		render(venues);
	}
	
    public static void index() {
    	
    	mongotest();
    	render();
    }

    private static void mongotest() {
    	 
//    	Location loc = new Location(new double[] {31,32});
//    	loc.save();
//    	loc = new Location(new double[] {31,32});
//    	loc.save();
//    	
//    	Location loc2 = (Location) Location.find().field("location").near(0, 0, 0, true).get();  	
	}

	public static void credentials(String clientId, String clientSecret) {
    	FoursquareCredentials credentials = new FoursquareCredentials(clientId, clientSecret);
    	credentials.save();    	
    	List<CategoryResponse> categories = getCategoriesUtil(credentials);

    	render("Application/categories.html", categories);
    }
    
    public static void categories() {    	
    	List<CategoryResponse> categories = getCategoriesUtil(null);
    	
        render(categories);    	
    }

	public static void fillVenuesDb(String categoryId, String ll, String city) {
    	List<VenueResponse> venues;
    	Location loc;
    	
    	venues = getVenuesUtil(null, categoryId, ll, city);
        for (Iterator<VenueResponse> iterator = venues.iterator(); iterator.hasNext();) {
        	VenueResponse venue = iterator.next();

    		loc		= new Location(new double[] {venue.getLocation().getLng(), venue.getLocation().getLat()});
    		loc.save();

        	Venue dbVenue = Venue.find("name = ?", venue.getName()).first();
        	if (dbVenue == null) {
        		
        		dbVenue = new Venue(venue.getName(), venue.getLocation().getLng(), venue.getLocation().getLat());
        		dbVenue.setLocationId(loc.getIdAsStr());
        		dbVenue.save();
        	}
        	else {

        		dbVenue.setLocationId(loc.getIdAsStr());
        		dbVenue.save();
        	}
        }   
        
    	render(venues);
    }
	    
	@Util
    private static List<CategoryResponse> getCategoriesUtil(FoursquareCredentials credentials) {
    	if (credentials == null)
    		credentials = (FoursquareCredentials) FoursquareCredentials.findAll().get(0);
    	
    	FoursquareConnectionManager FsqrConnector = new FoursquareConnectionManager(credentials.getClientId(), credentials.getClientSecret());
    	List<CategoryResponse> categories = FsqrConnector.getPlainCategories();
    	
		return categories;
	}	

	@Util
    private static List<VenueResponse> getVenuesUtil(FoursquareCredentials credentials, String categoryId, String ll, String city) {
    	List<VenueResponse> venues;
    	FoursquareConnectionManager FsqrConnector;
    	
    	if (credentials == null)
    		credentials = (FoursquareCredentials) FoursquareCredentials.findAll().get(0);    	
    	FsqrConnector = new FoursquareConnectionManager(credentials.getClientId(), credentials.getClientSecret());
    	venues = FsqrConnector.getVenues(categoryId, ll, city);
    	
		return venues;
	}	
}