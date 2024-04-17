package myclassproject.umlclasses;

import com.entities.Character;
import com.entities.Furniture;
import com.entities.Item;
import com.entities.Place;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.Colors;
import com.enums.FurnitureTypes;
import com.enums.HairStyle;
import com.enums.Items;
import com.enums.Places;


public final class All {
	public static final Character player = new MyCharacter("Player", BodyTypes.D, Clothing.Beggar, HairStyle.Long, Colors.Brown, 2);
	public static final Character bandit = new MyCharacter("Bandit", BodyTypes.F, Clothing.Bandit, HairStyle.Bald, Colors.Black, 4);
	public static final Place cottage = new MyPlace("Home", Places.Cottage);
	public static final Place town = new MyPlace("Town", Places.City);
	public static final Item sword = new MyItem("Sword", Items.Sword);
	public static final Furniture cottageDoor = new MyFurniture(cottage, FurnitureTypes.Door);
	public static final Furniture table = new MyFurniture(cottage, FurnitureTypes.Table);
	public static final Furniture chair = new MyFurniture(cottage, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new MyFurniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new MyFurniture(town, FurnitureTypes.NorthEnd);
	//implement all characters
	
	public static final Character bart = new MyCharacter("Bartholomew", BodyTypes.F, Clothing.Merchant, HairStyle.Short, Colors.Brown, 6);
	public static final Character knight = new MyCharacter("Knight", BodyTypes.D, Clothing.HeavyArmour, HairStyle.Long, Colors.Black, 4);
	public static final Character pen = new MyCharacter(" Penelope", BodyTypes.A, Clothing.Merchant, HairStyle.Long, Colors.Black, 4);
	public static final Character witch = new MyCharacter("Witch", BodyTypes.E, Clothing.Noble, HairStyle.Short, Colors.Black, 6);
	public static final Character evan = new MyCharacter("Evil Evan", BodyTypes.H, Clothing.Bandit, HairStyle.Musketeer_Full, Colors.Black, 4);
	public static final Character pubOwner = new MyCharacter("Pub Owner", BodyTypes.F, Clothing.Peasant, HairStyle.Mage, Colors.Black, 4);
	//implement all places 
	
	public static final Place bridge = new MyPlace("Bridge", Places.Bridge);
	//furniture at bridge
	public static final Furniture northSign = new MyFurniture(bridge, FurnitureTypes.NorthSign);
	public static final Furniture bridgeExit = new MyFurniture(bridge, FurnitureTypes.EastEnd);
	public static final Place spookyPath = new MyPlace("Spooky Path", Places.SpookyPath);
	public static final Place camp = new MyPlace("Camp", Places.Camp);
	public static final Place alchemyShop = new MyPlace("Alchemy Shop", Places.AlchemyShop);
	public static final Place greatHall = new MyPlace("Great Hall", Places.GreatHall);
	public static final Place tavern = new MyPlace("Tavern", Places.Tavern);
	public static final Place storage = new MyPlace("Storage", Places.Storage);
	public static final Place castleBedroom = new MyPlace("Castle Bedroom", Places.CastleBedroom);
	public static final Place city = new MyPlace("City", Places.City);
	//implement all items 
	//spooky path 
	public static final Furniture dirtPile = new MyFurniture(spookyPath, FurnitureTypes.DirtPile);
	public static final Furniture westEnd = new MyFurniture(spookyPath, FurnitureTypes.WestEnd);
	
	
	//ruins
	public static final Place ruins = new MyPlace("Ruins" , Places.Ruins);
	public static final Furniture throne = new MyFurniture(ruins, FurnitureTypes.Throne);
	public static final Furniture ruinsExit = new MyFurniture(ruins, FurnitureTypes.Exit);
	
	//implement all items
	public static final Item book = new MyItem("Book", Items.BlueBook);
	public static final Item poison = new MyItem("Bottle", Items.GreenPotion);
	
//implement furniture
public static final Furniture tavernDoor = new MyFurniture(tavern, FurnitureTypes.Door);
public static final Furniture chest1 = new MyFurniture(storage, FurnitureTypes.Chest);
public static final Furniture chest2 = new MyFurniture(storage, FurnitureTypes.Chest);
public static final Furniture chest3 = new MyFurniture(storage, FurnitureTypes.Chest);
public static final Furniture greatHallDoor = new MyFurniture(greatHall, FurnitureTypes.Door);

//castle crossroads 
public static final Place castleCrossroads = new MyPlace("Castle Crossroads", Places.CastleCrossroads);
public static final Furniture castleWestEnd = new MyFurniture(castleCrossroads, FurnitureTypes.WestEnd);
public static final Furniture castleGate = new MyFurniture(castleCrossroads, FurnitureTypes.Gate);

//public static final Character witch = new MyCharacter("witch", BodyTypes.A, Clothing.Bandit, HairStyle.Long, Colors.Red, 7);

}

