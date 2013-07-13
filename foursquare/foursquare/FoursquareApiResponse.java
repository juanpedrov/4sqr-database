package foursquare;

/**
 * @author juanpedrov
 *
 */
public class FoursquareApiResponse {
	
	private MetaResponse meta;
	private ObjectResponse response;
	
	public MetaResponse getMeta() {
		return meta;
	}
	public void setMeta(MetaResponse meta) {
		this.meta = meta;
	}
	public ObjectResponse getResponse() {
		return response;
	}
	public void setResponse(ObjectResponse response) {
		this.response = response;
	}
}
