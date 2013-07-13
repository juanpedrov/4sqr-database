package googlemaps;

public class GeocodeResponse {

	private GeometryResponse geometry;

	public GeometryResponse getGeometry() {
		return geometry;
	}	
	
	public double[] northeastBound() {
		
		return this.geometry.getBounds().getNortheast().getLocation();
	}
	
	public double[] southwestBound() {
		
		return this.geometry.getBounds().getSouthwest().getLocation();
	}	
}
