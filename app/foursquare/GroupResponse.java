package foursquare;

import java.util.List;

public class GroupResponse {

	private String type;
	
	private String name;
	
	private int count;
	
	private List<CheckinResponse> items;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public List<CheckinResponse> getItems() {
		return items;
	}
}
