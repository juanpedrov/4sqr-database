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

	private static final String HOST		 	   = "https://api.foursquare.com/";
	private static final String VERSION			   = "v2";
	private static final String VENUES_CATEGORIES  = "/venues/categories/";
	private static final String VENUES_SEARCH 	   = "/venues/search/";
	
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
        	
        	List<CategoryResponse> subCategories = category.getCategories();
        	if ( subCategories.size() > 0) {
        		
                for (Iterator<CategoryResponse> subIterator = subCategories.iterator(); subIterator.hasNext();) {
                	CategoryResponse subCategory = subIterator.next();
                	        	
                	categoriesResult.add(subCategory);
            
                	List<CategoryResponse> subSubCategories = subCategory.getCategories();
                	if (subSubCategories.size() > 0) {
                		
                        for (Iterator<CategoryResponse> subSubIterator = subSubCategories.iterator(); subSubIterator.hasNext();) {
                        	CategoryResponse subSubCategory = subSubIterator.next();
                        	        	
                        	categoriesResult.add(subSubCategory);
                        }                 		
                	}
                }          		
        	}
        }  				
		return categoriesResult;
	}	
	
	public List<VenueResponse> getVenues(String categoryId, String ll, String city) {
		
		return getVenuesRequest(categoryId, ll, city);
	}
	
	private List<VenueResponse> getVenuesRequest(String categoryId, String ll, String city) {
		HttpResponse res;
		WSRequest request;
		
		request = WS.url(HOST + VERSION + VENUES_SEARCH);		
		if (ll.length() != 0)			
			request.setParameter("ll", ll);
		if (city.length() != 0)
			request.setParameter("near", city);
		request.setParameter("categoryId", categoryId);
		request.setParameter("client_id", this.clientId);
		request.setParameter("client_secret", this.clientSecret);
		request.setParameter("v", new SimpleDateFormat("yyyyMMdd").format(new Date()));
		res = request.get();
		
		Gson gson = new GsonBuilder().create();
		FoursquareApiResponse apiResponse = gson.fromJson(res.getString(), FoursquareApiResponse.class);
		
		return apiResponse.getResponse().getVenues();
	}

	private List<CategoryResponse> getCategoriesRequest() {
		HttpResponse res;
		WSRequest request;
		
		request = WS.url(HOST + VERSION + VENUES_CATEGORIES);
		request.setParameter("client_id", this.clientId);
		request.setParameter("client_secret", this.clientSecret);
		request.setParameter("v", new SimpleDateFormat("yyyyMMdd").format(new Date()));
		res = request.get();
		
		Gson gson = new GsonBuilder().create();
		FoursquareApiResponse apiResponse = gson.fromJson(res.getString(), FoursquareApiResponse.class);
		
		return apiResponse.getResponse().getCategories();	
	}


}
