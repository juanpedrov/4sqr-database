package foursquare;

import java.util.List;

/**
 * @author juanpedrov
 *
 */
public class CategoryResponse {
	
	private String id;
	private String name;
	private String pluralName;
	private String shortName;
	private IconResponse icon;
	private String primary;
	private List<CategoryResponse> categories;
	
	
	public CategoryResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public String getPluralName() {
		return pluralName;
	}
	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public IconResponse getIcon() {
		return icon;
	}
	public void setIcon(IconResponse icon) {
		this.icon = icon;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public List<CategoryResponse> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}		
}
