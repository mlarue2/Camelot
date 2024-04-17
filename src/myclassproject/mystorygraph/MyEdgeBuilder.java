package myclassproject.mystorygraph;

import static myclassproject.umlclasses.All.*;



import java.util.List;

import com.playerInput.CloseNarrationChoice;
import com.playerInput.DialogChoice;
import com.playerInput.KeyboardChoice;
import com.playerInput.MenuChoice;
import com.playerInput.PlayerInteraction;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;


public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	//root edges leads to hear quest, allows user to start 
	@BuilderMethod
	public void rootEdges() {
	 var root = get(MyNodeLabels.root.toString());
	 var choice = new MenuChoice(MenuChoice.Options.Start);
	   var nextNode = get(MyNodeLabels.hearQuest.toString());
	   root.add(new Edge(choice, nextNode));
	}
	 
	@BuilderMethod
	public void hearQuestEdge(){
	 var node = get(MyNodeLabels.hearQuest.toString());
	// var choice1 = new PlayerInteraction(MyChoiceLabels.HearQuest.toString(), witch, Icons.talk, "Talk to the witch?");
	// var nextNode1 = get(MyNodeLabels.choose.toString());
	  //   node.add(new Edge(choice1, nextNode1));
	 var choice = new CloseNarrationChoice();
	 var nextNode = get(MyNodeLabels.choose.toString());
	 	node.add(new Edge(choice, nextNode));
	 
	}
	
	
	/*this is where they choose yes or no
	 * nodeLabel: choose
	 * goes to node label: yes no
	 * if they choose no: points to gameOver, game ends. 
	 */
	@BuilderMethod
	public void chooseEdge(){
	 var node = get(MyNodeLabels.choose.toString());
	 var choice1 = new DialogChoice("Hazzah!");
	   var nextNode1 = get(MyNodeLabels.yes.toString());
	   node.add(new Edge(choice1, nextNode1));
	 //if they choose no, game is over!
	 var choice2 = new DialogChoice("No! Hell no boi");
	   var nextNode2 = get(MyNodeLabels.gameOver.toString());
	   node.add(new Edge(choice2, nextNode2));
	   
	}
	
	
	/*if they choose yes they now go to the witch
	 * nodeLabel: yes
	 * goes to node label: meetWitch
	 * ChoiceLabel: GoMeetWitch
	 */
	@BuilderMethod
	public void yesEdge() {
	 var node = get(MyNodeLabels.yes.toString());
	   var choice = new CloseNarrationChoice();
	   var nextNode = get(MyNodeLabels.pathToMeetWitch.toString());
	   node.add(new Edge(choice, nextNode));
	}


	@BuilderMethod
	public void pathToMeetWitchEdge() {
		var node = get(MyNodeLabels.pathToMeetWitch.toString());
		var choice1 = new KeyboardChoice(KeyboardChoice.Keys.Interact);
		var nextNode1 = get(MyNodeLabels.meetWitch.toString());
		node.add(new Edge(choice1, nextNode1));
		//var choice = new PlayerInteraction(MyChoiceLabels.MeetWitch.toString(),witch, Icons.talk, "talk to the witch!");
		//var nextNode = get(MyNodeLabels.meetWitch.toString());
		//node.add(new Edge(choice, nextNode));
	}

	/* node: meetWitch
	 * pick between fight evan now and finding magic sword
	 * goes to nodelabels: fightEvanNow or
	 * findMagicSword
	 * 
	 * 
	 * 
	 */
	@BuilderMethod
	public void meetWitchEdge() {
	 var node = get(MyNodeLabels.meetWitch.toString());
	 var choice1= new DialogChoice("lets fight evan");
	   var nextNode1 = get(MyNodeLabels.goToEvan.toString());
	   node.add(new Edge(choice1, nextNode1));
	 var choice2 = new DialogChoice("I want to find the Magic Sword!");
	   var nextNode2 = get(MyNodeLabels.questToFindMagicSword.toString());
	   node.add(new Edge(choice2, nextNode2));
	}
	
	 /*
	  * node:findMagicSword
	  * points to new dialog choice to go to the pub, which leads to next edge, pub. 
	  */
	@BuilderMethod
	public void questTofindMagicSwordEdge() {
	 var node = get(MyNodeLabels.questToFindMagicSword.toString());
	   var choice = new DialogChoice("Now you should go to the pub!");
	   var nextNode = get(MyNodeLabels.pub.toString());
	   node.add(new Edge(choice, nextNode));
	}
	
	/*
	 * node:pub
	 * allows user to talk to the owner of the pub by interacting with pubOwner, and choosing to talk 
	 * gets the next node, talk to owner
	 */
	@BuilderMethod
	public void pubEdge() {
	 var node = get(MyNodeLabels.pub.toString());
	   var choice = new PlayerInteraction(MyChoiceLabels.goTalkToOwner.toString(), pubOwner, Icons.talk, "Want to talk to the owner?");
	   var nextNode = get(MyNodeLabels.talkToOwner.toString());
	   node.add(new Edge(choice, nextNode));
	}
	
	/* node: talkToOwner
	 * choices: chest1 , chest2, chest 3
	 * openChest 1, points to node chest1
	 * Openchest2, points to node chest2
	 * Openchest3, points to node chest3.
	 * Chest 2 and 3 point to poison, chest 1 continues game
	 * 
	 */
	@BuilderMethod
	public void talkToOwnerEdge(){
	 var node = get(MyNodeLabels.talkToOwner.toString());
	 //chest1
	 var choice1 = new PlayerInteraction(MyChoiceLabels.OpenChest1.toString(), chest1, Icons.unlock, "Open chest 1?");
	   var nextNode1 = get(MyNodeLabels.chest1.toString());
	   node.add(new Edge(choice1, nextNode1));
	 //chest2
	 var choice2 = new PlayerInteraction(MyChoiceLabels.OpenChest2.toString(), chest2, Icons.unlock, "Open chest 2?");
	   var nextNode2 = get(MyNodeLabels.chest2.toString());
	   node.add(new Edge(choice2, nextNode2));
	  //chest3
	 var choice3 = new PlayerInteraction(MyChoiceLabels.OpenChest3.toString(), chest3, Icons.unlock, "Open chest 3?");
	   var nextNode3 = get(MyNodeLabels.chest3.toString());
	   node.add(new Edge(choice3, nextNode3));
	}
	/* node: chest1
	 * points to -> get sword
	 * will show a sword icon to interact, indicating a good choice as chest 1 has the sword
	 */
	@BuilderMethod
	public void chest1Edge() {
	 var node = get(MyNodeLabels.chest1.toString());
	  var choice = new PlayerInteraction(MyChoiceLabels.getSword.toString(), chest1, Icons.sword, "Here is the sword!" );
	   var nextNode = get(MyNodeLabels.getSword.toString());
	   node.add(new Edge(choice, nextNode));
	}
	/* node: chest2
	 * points to --> chest has poison edge, which has the next node set as poison
	 * has poison to interact, user has no choice but to pick up the poison
	 */
	@BuilderMethod
	public void chest2Edge () {
	 var node = get(MyNodeLabels.chest2.toString());
	  var choice = new PlayerInteraction(MyChoiceLabels.ChestHasPoison.toString(), chest2, Icons.poison, "Yikes...there is poison");
	   var nextNode = get(MyNodeLabels.poison.toString());
	   node.add(new Edge(choice, nextNode));
	}
	/*node: chest3
	 * chest 3 has poison in it, points to choice chestHasPoison death by poison, which goes to make user pick up poison
	 * and take it. 
	 * Points to  --> chest has poison edge, node=poison
	 */
	@BuilderMethod
	public void chest3Edge () {
	 var node = get(MyNodeLabels.chest3.toString());
	  var choice = new PlayerInteraction(MyChoiceLabels.ChestHasPoison.toString(), chest2, Icons.poison, "Yikes...there is poison");
	   var nextNode = get(MyNodeLabels.poison.toString());
	   node.add(new Edge(choice, nextNode));
	}
	
	/*node: poison
	 * when the user picks chest 2 or 3, will point to poison, which points to game over. 
	 * points to --> game Over, ends game when user picks up poison. 
	 * Does not need player interaction. Just user drinking poison
	 * 
	 */
	@BuilderMethod
	public void ChestHasPoisonEdge () {
	 var node = get(MyNodeLabels.poison.toString());
	  var choice = new DialogChoice("Hmmm. Is this a healing potion?");
	   var nextNode = get(MyNodeLabels.gameOver.toString());
	   node.add(new Edge(choice, nextNode));
	}

	/* node: getSword
	 * points to -->go to Evan
	 * user after opening chest1, receives a sword. Now, given choice to go to Evan. 
	 */
	@BuilderMethod
	public void getSwordEdge() {
	 var node = get(MyNodeLabels.getSword.toString());
	  var choice = new PlayerInteraction(MyChoiceLabels.GotoEvan.toString(), witch, Icons.talk, "would you like to go to Evan?" );
	   var nextNode = get(MyNodeLabels.goToEvan.toString());
	   node.add(new Edge(choice, nextNode));
	}
	/* node:goToEvan
	 * points to-->defeat Evan
	 * if user chooses to go to Evan, he will defeat him in battle
	 */
	@BuilderMethod
	public void goToEvanEdge() {
	 var node = get(MyNodeLabels.goToEvan.toString());
	 var choice1 = new KeyboardChoice(KeyboardChoice.Keys.Interact);
	 var choice = new PlayerInteraction(MyChoiceLabels.TalkToEvan.toString(), evan, Icons.talk, "who want the smoke?");
	 var nextNode = get(MyNodeLabels.talkToEvan.toString());
	 var nextNode1 = get(MyNodeLabels.talkToEvan.toString());
	   node.add(new Edge(choice1, nextNode1));
	   node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void talkToEvanEdge() {
		var node=get(MyNodeLabels.talkToEvan.toString());
		var choice = new DialogChoice("touch dirt evil evan");
		var nextNode = get(MyNodeLabels.defeatByEvan.toString());
		node.add(new Edge(choice, nextNode));
		var choice1 = new DialogChoice("sike I am not ready");
		var nextNode1 = get(MyNodeLabels.runFromEvan.toString());
		node.add(new Edge(choice1, nextNode1));
	}
	/* node: defeatEvan
	 * points to--> Save Penelope
	 * when user chose to see Evan, they defeat Evan and go save Penelope
	 * 
	 */
	@BuilderMethod
	public void defeatEvanEdge() {
	 var node = get(MyNodeLabels.defeatEvan.toString());
	  var choice = new DialogChoice("I did it! Evan has finally seen his demise! I can finally save princess Penelope!");
	   var nextNode = get(MyNodeLabels.penelope.toString());
	   node.add(new Edge(choice, nextNode));
	}
	 /*node:penelope
	  * points to --> you win
	  * when user chooses to save Penelope, they will be able to win the game
	  */
	
	@BuilderMethod
	public void penelopeEdge() {
	 var node = get(MyNodeLabels.penelope.toString());
	  var choice = new PlayerInteraction(MyChoiceLabels.YouWin.toString(), pen, Icons.talk, "talk to princess?");
	   var nextNode = get(MyNodeLabels.youWin.toString());
	   node.add(new Edge(choice, nextNode));
	}
	
	/*node: youWin
	 * points to--> game is won! 
	 * 
	 */
	@BuilderMethod
	public void youWinEdge() {
	 get(MyNodeLabels.youWin.toString());
	}
	/* node: defeatByEvan 
	 * points to --> gameOver
	 * game is over, Evan defeats you
	 */
	@BuilderMethod
	public void defeatByEvanEdge() {
	 var node = get(MyNodeLabels.defeatByEvan.toString());
	 var choice = new PlayerInteraction(MyChoiceLabels.GameOver.toString(), evan, Icons.talk, "Talk to Evan one last time?");
	   var nextNode = get(MyNodeLabels.gameOver.toString());
	   node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void runFromEvanEdge() {
		var node = get(MyNodeLabels.runFromEvan.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.MeetWitch.toString(), evan, Icons.talk, "run run run!");
		var nextNode = get(MyNodeLabels.meetWitch.toString());
		node.add(new Edge(choice, nextNode));
		
	}
	/* node: gameOver 
	 * just gets game over node to end game.
	 * game is over, Evan defeats you
	 */
	@BuilderMethod
	public void gameOverEdge() {
	 get(MyNodeLabels.gameOver.toString());
	  
	}

	
}
	


