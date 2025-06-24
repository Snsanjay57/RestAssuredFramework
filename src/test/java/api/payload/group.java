package api.payload;

public class group {
	
	private String groupName;
	private String groupType;
	private String description;
	private String imageData;
	private String rules;
	private Integer assetIDs;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public Integer getAssetIDs() {
		return assetIDs;
	}
	public void setAssetIDs(int assetIDs) {
		this.assetIDs = assetIDs;
	}

}
