package foursquare;

import java.util.List;

public class VenueResponse {

	private String id;
	
	private String name;
	
	private ContanctResponse contact;
	
	private LocationResponse location;
	
	private String canonicalUrl;
	
	private List<CategoryResponse> categories;
	
	private boolean verified;
	
	private boolean restricted;
	
	private StatsResponse stats;
	
	private String url;
	
	private SpecialsResponse specials;
	
	private HereNowResponse hereNow;
	
	private VenuePageResponse venuePage;
	
	private String storeId;
	
	private String referralId;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ContanctResponse getContact() {
		return contact;
	}

	public LocationResponse getLocation() {
		return location;
	}

	public String getCanonicalUrl() {
		return canonicalUrl;
	}

	public List<CategoryResponse> getCategories() {
		return categories;
	}

	public boolean isVerified() {
		return verified;
	}

	public boolean isRestricted() {
		return restricted;
	}

	public StatsResponse getStats() {
		return stats;
	}

	public String getUrl() {
		return url;
	}

	public SpecialsResponse getSpecials() {
		return specials;
	}

	public HereNowResponse getHereNow() {
		return hereNow;
	}

	public VenuePageResponse getVenuePage() {
		return venuePage;
	}

	public String getStoreId() {
		return storeId;
	}

	public String getReferralId() {
		return referralId;
	}
}
