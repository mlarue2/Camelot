package myclassproject.umlclasses;

import com.entities.Place;
import com.enums.Places; 

public class MyPlace extends Place {
	
	private String name;
	private Places template;
	
	public MyPlace(String name, Places template) {
		this.name = name;
		this.template = template;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Places getTemplate() {
		// TODO Auto-generated method stub
		return template;
	}
	

}
