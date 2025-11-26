package com.minitwosample.property;

import java.util.ArrayList;
import java.util.List;

import com.minitwosample.main.Read;

public class PropertyTax {

	AddProperty addProperty = new AddProperty();
	CalculateProperty calProperty = new CalculateProperty();
	DisplayProperty disProperty = new DisplayProperty();
	List<AddProperty> properlist=new ArrayList<>();
	
	public void f1() {
		int n = Read.sc.nextInt();
		while(n!=4) {
			switch(n) {
			case 1:
				addProperty.setPropertyId(Read.sc.nextInt());
				addProperty.setBasePrice(Read.sc.nextInt());
				addProperty.setBuiltUpArea(Read.sc.nextInt());
				addProperty.setAgeOfLand(Read.sc.nextInt());
				addProperty.setLocation(Read.sc.nextLine().charAt(0));
		
				properlist.add(addProperty);
				
				break;
			case 2:
				if(addProperty.getLocation() == 'Y') {
					calProperty.city();
				}else {
					calProperty.notCity();
				}
				break;
			case 3:
				
			default:
				System.out.println("...");
				
			}
			n=Read.sc.nextInt();
		}
	}
}
