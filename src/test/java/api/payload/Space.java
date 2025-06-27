package api.payload;

import java.io.File;

public class Space {
	
	private String spaceName;
    private String locationName; //Jaipur, Durgapura, Jaipur Division, Rajasthan, 302018, Jaipur Division, India,
    private String gpsLatitude; //26.8520598,
    private String gpsLongitude; //75.7947802,
    private String spaceOrder; 
    private String createdFlag;
    private String selected; 
    private String type; //OTHER
    private String imageFrom; //CAMERA
    private File imageData;  // ✅ New field added
    
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(String gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}
	public String getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(String gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public String getSpaceOrder() {
		return spaceOrder;
	}
	public void setSpaceOrder(String spaceOrder) {
		this.spaceOrder = spaceOrder;
	}
	public String getCreatedFlag() {
		return createdFlag;
	}
	public void setCreatedFlag(String createdFlag) {
		this.createdFlag = createdFlag;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageFrom() {
		return imageFrom;
	}
	public void setImageFrom(String imageFrom) {
		this.imageFrom = imageFrom;
	}
	public File getImageData() {
		return imageData;
	}
	public void setImageData(File imageData) {
		this.imageData = imageData;
	}
	public void setSpaceId(int spaceId) {
		// TODO Auto-generated method stub
		
		
	}
    
    
    
    
    
}
