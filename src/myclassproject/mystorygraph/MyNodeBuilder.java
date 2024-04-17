package myclassproject.mystorygraph;

import java.util.List;



import com.sequences.CreateAll;
import com.sequences.*;
import com.sequences.CreateCharacterSequence;
import com.sequences.NarrationSequence;
import com.actions.*;
import com.storygraph.*;
import static myclassproject.umlclasses.All.*;


public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 * 
	 * 
	 */
	
	
	//game begins at the setting of the spooky path. 
	@BuilderMethod
	public void rootActions() {
	var root = get(MyNodeLabels.root.toString());
	root.add(new CreateAll(List.of(bridge, town, book, poison, 
			cottage, spookyPath, knight
			,ruins, castleCrossroads)))
	        .add(new CreateCharacterSequence(witch))
			.add(new CreateCharacterSequence(bart))
			.add(new CreateCharacterSequence(evan))
			.add(new SetPosition(knight, dirtPile))
			.add(new SetPosition(witch, throne))
			.add(new SetPosition(bart, spookyPath))
			.add(new SetPosition(evan, castleGate))
			.add(new Face(knight, bart))
			.add(new Draw(witch, book))
			.add(new SetCameraFocus(bart)).add(new ShowMenu());

	}
	
	@BuilderMethod
	public void hearQuestActions() {
		var node = get(MyNodeLabels.hearQuest.toString());
		node.add(new HideMenu()).add(new EnableInput())
		.add(new NarrationSequence("A Bard named Bartholomew is following a Knight  "
				+ "named Kingston. Kingston  is trying to save princess Penelope. "
				+ "Penelope was kidnapped by Evil Evan who is the King of Evilville.  "
				+ "Kingston is killed by a beast. It is now up you Bartholomew to save to "
				+ "accept the quest and save Penelope"));
		
		
	}
	@BuilderMethod
	public void chooseActions() {
		var node = get(MyNodeLabels.choose.toString());
		node.add(new HideNarration()).add(new DialogSequence(bart, knight, List.of("will you accept the quest?"),
				List.of("Hazzah!", "No! hell no boi")));
		
	}
	
	@BuilderMethod
	public void yesActions() { 
		var node = get(MyNodeLabels.yes.toString());
		node.add(new HideDialog())
		.add(new Take(bart, book, knight)).add(new Cast(knight, bart)).add(new NarrationSequence("here "
		+ "young knight, best of luck to you on this journey."
		+ "Princess Penelope is a lucky lady worth fighting for."
		+ "Your sacrifice and bravery will not be forgotten, should Evan defeat you"
		+ "with his impeccible rizz, learned from grand Turkish Quandale Dingle the fifth."));
		
	}
	//after recieving a book and good luck, you are on the path to meet the witch.
	

	@BuilderMethod
	public void pathToMeetWitchActions() {
		var node = get(MyNodeLabels.pathToMeetWitch.toString());
		node.add(new HideNarration())
		    .add(new DisableInput())
		    .add(new Exit(bart, westEnd, true))
		    
			.add(new Enter(bart, ruinsExit, true))
			//make witch
			.add(new EnableInput());
			
		}
	
	@BuilderMethod
	public void meetWitchActions() {
		var node = get(MyNodeLabels.meetWitch.toString());
		node.add(new DialogSequence(bart, witch, List.of("Oh bartholemew. Bart? May I call you that? Tee hee."
				+ "Ive heard about you, the young shining brave knight who has ventured to save our dearest princess."
				+ "I may help you in any which way I can. You may journey onward to face Evan right now, or we may adjourn on a small"
				+ "tangent to find the magic diamond sword, crafted with a crafting table from minecraft. What shall you choose?"),
				List.of("lets fight evan" , "I want to find the Magic Sword")));
	}
	
	
	@BuilderMethod
	public void questToFindMagicSwordActions() { 
		var node = get(MyNodeLabels.questToFindMagicSword.toString());
		node.add(new NarrationSequence(("I'm going to get "
				+ "that magic sword to defeat the Evil Evan! I wonder if "
				+ "anyone in the pub would know where it is?")));
	}

	@BuilderMethod
	public void pubActions() {
		var node = get(MyNodeLabels.pub.toString());
		node.add(new NarrationSequence(("this pub is nice. Where are the chests?")));
	}
		
	@BuilderMethod
	public void talkToOwnerActions() {
		var node = get(MyNodeLabels.talkToOwner.toString());
		node.add(new HideDialog());
	}
	
	@BuilderMethod
	public void chest1Actions() {
		var node = get(MyNodeLabels.chest1.toString());
		node.add(new HideDialog())
			.add(new OpenFurniture(bart, chest1))
			.add(new NarrationSequence(("Time to get the sword!")));

	}
	
	@BuilderMethod
	public void chest2Actions() {
		var node = get(MyNodeLabels.chest2.toString());
		node.add(new HideDialog())
			.add(new OpenFurniture(bart, chest2))
			.add(new Take(bart, poison))
			.add(new NarrationSequence(("What's inside the bottle?")));
	}
	
	@BuilderMethod
	public void chest3Actions() {
		var node = get(MyNodeLabels.chest3.toString());
		node.add(new HideDialog())
			.add(new OpenFurniture(bart, chest3))
			.add((new Take(bart, poison)))
			.add(new NarrationSequence(("What's inside the bottle?")));
	}
	
	
	@BuilderMethod
	public void poisonActions() {
		var node = get(MyNodeLabels.poison.toString());
		node.add(new HideNarration())
			.add(new NarrationSequence(("The bottle was full of poison!")))
			.add(new Die(bart));
	}
	
	@BuilderMethod
	public void getSwordActions() {
		var node = get(MyNodeLabels.getSword.toString());
		node.add(new NarrationSequence(("I have the sword.")));
	}
	
	@BuilderMethod
	public void goToEvanActions() {
		var node = get(MyNodeLabels.goToEvan.toString());
		node.add(new HideDialog())
		.add(new DisableInput())
		.add(new Exit(bart, ruinsExit, true))
		.add(new Enter(bart, castleWestEnd, true))
		.add(new EnableInput());

	}
	
	@BuilderMethod
	public void talkToEvanActions() {
		var node = get(MyNodeLabels.talktoEvan.toString());
		node.add(new DialogSequence(evan, bart, List.of("well well well, you wanted the smoke after all!"),
				List.of("touch dirt evil evan" , "sike I am not ready")));
	}
	
	@BuilderMethod
	public void defeatEvanActions() {
		var node = get(MyNodeLabels.defeatEvan.toString());
		node.add(new HideDialog())
		    .add(new Attack(evan, bart, true))
			.add(new Attack(evan, bart, false));
			
		
	}
	
	@BuilderMethod
	public void penelopeActions() {
		var node = get(MyNodeLabels.penelope.toString());
		node.add(new NarrationSequence("Thank you my bart!"));
	}
	
	@BuilderMethod
	public void youWinActions() {
		var node = get(MyNodeLabels.youWin.toString());
		node.add(new NarrationSequence("hey you win!"));
	}
	
	@BuilderMethod
	public void defeatByEvanActions() {
		var node = get(MyNodeLabels.defeatByEvan.toString());
		node.add(new HideDialog())
	    .add(new Attack(evan, bart, true))
		.add(new Attack(evan, bart, false))
		.add(new Dance(evan))
		.add(new NarrationSequence("You were not a match for evan after all. Dang."));
		
		
	}

	@BuilderMethod
	public void gameOverActions() {
		var node = get(MyNodeLabels.gameOver.toString());
		node.add(new NarrationSequence("You have been defeated. You lost the game!")
		.add(new HideNarration()).add(new ShowMenu()));
	}
		
}
