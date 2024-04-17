package myclassproject.umlclasses;

import com.entities.Character; 
import com.enums.*;
import com.entities.*;

public class MyCharacter extends Character {

	private String name;
	private BodyTypes bodyType;
	private Clothing clothing;
	private HairStyle hairStyle;
	private Colors hairColor;
	private int skinColor;
	
	public MyCharacter(String name, BodyTypes bodyType, Clothing clothing, HairStyle hairStyle, Colors hairColor, int skinColor) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
		this.hairColor = hairColor;
		this.skinColor = skinColor; 
	}
	
	//what we had before
		////idea 1
		//public MyCharacter(String name) {
			//this.name = name;
			//}
			//public MyCharacter(String name, BodyTypes bodyType) {
			//this.name = name;
			//this.bodyType = bodyType;
			//}
	
	public MyCharacter(String name) {
		this(name, BodyTypes.A, Clothing.Peasant, HairStyle.Bald, Colors.Blonde, 1); //Review in zybooks calling another constructor with this keyword
		
	}
	
	public MyCharacter(String name, BodyTypes bodyType) {
		this(name, bodyType, Clothing.Peasant, HairStyle.Bald, Colors.Blonde, 1);
	}

	@Override
	public BodyTypes getTemplate() {
		// TODO Auto-generated method stub
		return bodyType;
	}

	@Override
	public Clothing getClothing() {
		// TODO Auto-generated method stub
		return clothing;
	}

	@Override
	public Colors getHairColor() {
		// TODO Auto-generated method stub
		return hairColor;
	}

	@Override
	public HairStyle getHairStyle() {
		// TODO Auto-generated method stub
		return hairStyle;
	}

	@Override
	public int getSkinColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
