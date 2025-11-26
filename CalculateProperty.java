package com.minitwosample.property;

public class CalculateProperty {

	AddProperty obj=new AddProperty();


	public double city() { 
		double tax=(obj.builtUpArea * obj.ageOfLand * obj.basePrice) + (0.5 * obj.builtUpArea);
		 return tax;
	}
	
	public double notCity() {
		
		double tax = obj.builtUpArea * obj.ageOfLand * obj.basePrice;
		return tax;
	}
	
	
}
