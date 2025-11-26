package com.minitwosample.property;

public class AddProperty {

	int propertyId;
	int basePrice;
	int builtUpArea;
	int ageOfLand;
	char location;
	
	
	public AddProperty() {
		
	}

	public AddProperty(int propertyId,int basePrice, int builtUpArea, int ageOfLand, char location) {
		this.propertyId=propertyId;
		this.basePrice = basePrice;
		this.builtUpArea = builtUpArea;
		this.ageOfLand = ageOfLand;
		this.location = location;
	}
	
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public int getBuiltUpArea() {
		return builtUpArea;
	}
	public void setBuiltUpArea(int builtUpArea) {
		this.builtUpArea = builtUpArea;
	}
	public int getAgeOfLand() {
		return ageOfLand;
	}
	public void setAgeOfLand(int ageOfLand) {
		this.ageOfLand = ageOfLand;
	}
	public char getLocation() {
		return location;
	}
	public void setLocation(char location) {
		this.location = location;
	}
	
	

	@Override
	public String toString() {
		return "AddProperty [propertyId=" + propertyId + ", basePrice=" + basePrice + ", builtUpArea=" + builtUpArea
				+ ", ageOfLand=" + ageOfLand + ", location=" + location + "]";
	}
	
	
	
	
}
