package myclassproject.umlclasses;

import com.entities.Furniture;
import com.entities.Place;
import com.enums.FurnitureTypes;

public class MyFurniture extends Furniture {
	
	private Place place;
	private FurnitureTypes name;
	
	public MyFurniture(Place place, FurnitureTypes name) {
		this.place = place;
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return place.getName() + "." + name;
	}

}
