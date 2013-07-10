package controllers;

import java.util.List;

import models.FoursquareCredentials;

import play.mvc.Controller;
import foursquare.CategoryResponse;
import foursquare.FoursquareConnectionManager;

/**
 * @author juanpedrov
 *
 */
public class Application extends Controller {


	
    public static void index() {
    	
    	render();
    }

    public static void credentials(String clientId, String clientSecret) {
    	
    	FoursquareCredentials credentials = new FoursquareCredentials(clientId, clientSecret);
    	credentials.save();
    	FoursquareConnectionManager FsqrConnector = new FoursquareConnectionManager(credentials.getClientId(), credentials.getClientSecret());
    	List<CategoryResponse> categories = FsqrConnector.getCategories();
    	render("Application/categories.html", categories);
    }
    
    public static void categories() {
    	
        render();    	
    }
    
    public static void fillVenuesDb(String categoryId, String aaa) {
    	
    	
    	render();
    }
}