package foursquare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
public class FoursquareConnectionManager {

	private static final String HOST 	   = "https://api.foursquare.com/";
	private static final String VERSION	   = "v2";
	private static final String CATEGORIES = "/venues/categories/";
	
	private String clientId;
	private String clientSecret;
	
	public FoursquareConnectionManager(String clientId, String clientSecret) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public List<CategoryResponse> getCategories() {			
		
		List<CategoryResponse> categories = getCategoriesRequest();		
		return categories;
	}
	
	/**
	 * From an array of categories containing sub- and sub-sub- categories to
	 * a List of plain categories without sub levels
	 * 
	 * @return
	 */
	public List<CategoryResponse> getPlainCategories() {
		List<CategoryResponse> categoriesResult = new ArrayList<CategoryResponse>();
		List<CategoryResponse> categories		= getCategoriesRequest();
		
        for (Iterator<CategoryResponse> iterator = categories.iterator(); iterator.hasNext();) {
        	CategoryResponse category = iterator.next();
        	        	
        	categoriesResult.add(category);
        	
        	//TODO finish this method
        }  				
		return categories;
	}	
	
	private List<CategoryResponse> getCategoriesRequest() {
		HttpResponse res;
		WSRequest request;
		
		request = WS.url(HOST + VERSION + CATEGORIES);
		request.setParameter("client_id", this.clientId);
		request.setParameter("client_secret", this.clientSecret);
		request.setParameter("v", new SimpleDateFormat("yyyyMMdd").format(new Date()));
		res = request.get();
		
		Gson gson = new GsonBuilder().create();
		FoursquareApiResponse apiResponse = gson.fromJson(res.getString(), FoursquareApiResponse.class);
		
		return apiResponse.getResponse().getCategories();	
	}
}
