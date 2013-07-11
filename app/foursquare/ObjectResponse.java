package foursquare;

import java.util.List;

/**
 * @author juanpedrov
 *
 */
public class ObjectResponse {

	private List<CategoryResponse> categories;
	
	private List<VenueResponse> venues;

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}

	public List<VenueResponse> getVenues() {
		return venues;
	}

	public void setVenues(List<VenueResponse> venues) {
		this.venues = venues;
	}
}
