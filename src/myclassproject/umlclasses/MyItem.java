package myclassproject.umlclasses;

import com.entities.Item;
import com.enums.Items;
public class MyItem extends Item {
	private String name;
	private Items template;
	
	public MyItem(String name, Items template) {
		this.name = name;
		this.template = template;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public Items getTemplate() {
		// TODO Auto-generated method stub
		return template;
	}
	

}
