package foursquare;

import java.util.List;

/**
 * @author juanpedrov
 *
 */
public class ObjectResponse {

	private List<CategoryResponse> categories;

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}
}
