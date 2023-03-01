import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class textGame
{
	JFrame f1;
	Container con;
	JPanel titlePanel,startButtonPanel,mainTextPanel,choiceButtonPanel,endTextPanel,endButtonPanel;
	JLabel title,endText;
	JButton startButton,choice1, choice2, choice3,endButton;
	JTextArea mainText;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	String position;
	
	
	Font titleFont = new Font("Times New Roman", Font.ITALIC, 60);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
	Font buttonFont2 = new Font("Times New Roman", Font.PLAIN, 25);
	Font endFont = new Font("Times New Roman", Font.BOLD, 30);
	
	
	public static void main(String [] args)
	{
		new textGame();
	}
  

    public textGame()
	{
		f1 = new JFrame();
		f1.setSize(900, 700);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.getContentPane().setBackground(Color.black);
		f1.setLayout(null);
		con = f1.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(140, 100, 600, 170);
		titlePanel.setBackground(Color.black);
		
		title = new JLabel("Haunted House Escape");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(330, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(buttonFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titlePanel.add(title);
		con.add(titlePanel);
		startButtonPanel.add(startButton);
		con.add(startButtonPanel);
		f1.setVisible(true);
		
	}	
	
	public void mainGameScreen()
	{
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(140, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainText = new JTextArea("text goes here");
		mainText.setBounds(100, 100, 600, 250);
		mainText.setBackground(Color.black);
		mainText.setForeground(Color.white);
		mainText.setFont(buttonFont2);
		mainText.setLineWrap(true);
		mainText.setEditable(false); 
		mainTextPanel.add(mainText);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(45, 350, 800, 70);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(1,4));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(buttonFont2);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(buttonFont2);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(buttonFont2);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		darkRoom();
		
	}
	public void endScreen()
	{
		mainTextPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		
		endTextPanel = new JPanel();
		endTextPanel.setBounds(140, 100, 600, 170);
		endTextPanel.setBackground(Color.black);
		con.add(endTextPanel);
		
		endText = new JLabel("You escaped! The end.");
		endText.setBackground(Color.black);
		endText.setForeground(Color.white);
		endText.setFont(endFont); 
		endTextPanel.add(endText);
		
		
		endGame();
		
	}	
	public void endGame()
	{
		position = "endGame";
		endText.setText("You escaped! The end.");
	}
	
	public void darkRoom()
	{
		position = "darkRoom";
		mainText.setText("You awake in a dark room.\nThere is a lighter in your pocket.\nWhat do you do?");		
		choice1.setText("Check the window");
		choice2.setText("Use lighter");
		choice3.setText("Try the door");
	}
	
	public void lightFire()
	{
		position = "lightFire";
		mainText.setText("The room bathes in a dull glow.\nA table is vaguely visible.");		
		choice1.setText("Check the window");
		choice2.setText("Approach table");
		choice3.setText("Try the door");
	}
	
	public void checkWindow()
	{
		position = "checkWindow";
		mainText.setText("It is pitch dark outside.\nNothing to see.");		
		choice1.setText("");
		choice2.setText("Use lighter");
		choice3.setText("Try the door");
	}
	
	public void tryDoor()
	{
		position = "tryDoor";
		mainText.setText("The door is locked.");		
		choice1.setText("Check the window");
		choice2.setText("Use lighter");
		choice3.setText("");
	}
	public void approachTable()
	{
		position = "approachTable";
		mainText.setText("There are some papers on the table. \nA rusty key lies on a cabinet behind the table.");		
		choice1.setText("Pick up key");
		choice2.setText("Read papers");
		choice3.setText("Open cabinet");
	}
	public void openCab()
	{
		position = "openCab";
		mainText.setText("The doors on the cabinet are locked.\nThe handles have rusted.");		
		choice1.setText("Pick up key");
		choice2.setText("Read papers");
		choice3.setText("");
	}
	public void readPapers()
	{
		position = "readPapers";
		mainText.setText("Some scribbles. Nothing of importance.");		
		choice1.setText("Pick up key");
		choice2.setText("Open cabinet");
		choice3.setText("Try the door");
	}
	public void pickKey()
	{
		position = "pickKey";
		mainText.setText("The key feels cold in your hands.");		
		choice1.setText("");
		choice2.setText("Check the window");
		choice3.setText("Try the door again");
	}
	public void tryDoor2()
	{
		position = "tryDoor2";
		mainText.setText("The key worked.\nYou step into a dark hallway which ends in a staircase.");		
		choice1.setText("Go downstairs");
		choice2.setText("");
		choice3.setText("");
	}
	public void downstairs()
	{
		position = "downstairs";
		mainText.setText("The stairs end at a dimly lit room. \nThere are a few dusty sofas. \nLight comes out of the creaks on a broken door.");		
		choice1.setText("Check under cushions");
		choice2.setText("Try main door");
		choice3.setText("Go to broken door");
	}
	public void checkCushions()
	{
		position = "checkCushions";
		mainText.setText("A large spider jumps out.\nNothing else other than cobwebs.");		
		choice1.setText("");
		choice2.setText("Try main door");
		choice3.setText("Go to broken door");
	}
	public void tryMainDoor()
	{
		position = "tryMainDoor";
		mainText.setText("Jammed. \nDoes not even have handles.");		
		choice1.setText("Check under cushions");
		choice2.setText("");
		choice3.setText("Go to broken door");
	}
	public void brokenDoor()
	{
		position = "brokenDoor";
		mainText.setText("The door opens to reveal what looks like a kitchen. \nA knife lies on the floor next to a broken refrigerator.");		
		choice1.setText("Open fridge");
		choice2.setText("Pick up knife");
		choice3.setText("");
	}
	public void fridge()
	{
		position = "fridge";
		mainText.setText("Nothing but sour milk.");		
		choice1.setText("");
		choice2.setText("Pick up knife");
		choice3.setText("");
	}
	public void knife()
	{
		position = "knife";
		mainText.setText("The knife has a beautiful ornate hilt. \nThere is surprisingly little rust.");		
		choice1.setText("Open fridge");
		choice2.setText("");
		choice3.setText("Leave kitchen");
	}
	public void leave()
	{
		position= "leave";
		mainText.setText("A floating ghost blocks your path!");		
		choice1.setText("next");
		choice2.setText("");
		choice3.setText("");
	}
	public void next()
	{
		position= "next";
		mainText.setText("The ghost jumps at you!");		
		choice1.setText("Stab with knife!");
		choice2.setText("Dodge!");
		choice3.setText("");
	}
	public void stab()
	{
		position= "stab";
		mainText.setText("The knife passes through the ghost harmlessly. \nGhost: You dare try to kill me in my own house?? \nThe ghost closes in on you. \nYour vision goes dark. \nYou have died.");		
		choice1.setText("Restart");
		choice2.setText("Leave game");
		choice3.setText("");
	}
	public void dodge()
	{
		position= "dodge";
		mainText.setText("The ghost passes through you and enters the kitchen. \nGhost: You are the first of many who was not hostile to me.\nThe ghost hands you a key from the kitchen table. \nGhost: Search the upstairs cabinet. \nYou will know how to escape.");		
		choice1.setText("Go upstairs");
		choice2.setText("");
		choice3.setText("");
	}
	public void goUpstairs()
	{
		position= "goUpstairs";
		mainText.setText("Back at the room. \nYou approach the cabinet.");		
		choice1.setText("Use key");
		choice2.setText("Force open it");
		choice3.setText("");
	}
	public void forceCab()
	{
		position= "forceCab";
		mainText.setText("Does not work.");		
		choice1.setText("Use key");
		choice2.setText("");
		choice3.setText("");
	}
	
	public void useKey()
	{
		position= "useKey";
		mainText.setText("The cabinet opens. \nA sturdy crowbar rests against it's back wall.");		
		choice1.setText("Leave room");
		choice2.setText("");
		choice3.setText("");
	}
	public void leaveRoom()
	{
		position= "leaveRoom";
		mainText.setText("You make your way downstairs. \nThe ghost is nowhere to be seen. \nYou walk towards the main door.");		
		choice1.setText("Use crowbar");
		choice2.setText("");
		choice3.setText("");
	}
	
	public class TitleScreenHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
			
			mainGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
			
			String yourChoice = event.getActionCommand();
			
			switch(position)
			{
				case "darkRoom":
				switch(yourChoice)
				{
					case "c1": checkWindow();break;
					case "c2": lightFire();break;
					case "c3": tryDoor();break;
				}break;
				case "checkWindow":
				switch(yourChoice)
				{
					case "c2": lightFire();break;
					case "c3": tryDoor();break;
				}break;
				case "tryDoor":
				switch(yourChoice)
				{
					case "c1": checkWindow();break;
					case "c2": lightFire();break;
					
				}break;
				case "lightFire":
				switch(yourChoice)
				{
					case "c1": checkWindow();break;
					case "c2": approachTable();break;
					case "c3": tryDoor();break;
				}break;
				case "approachTable":
				switch(yourChoice)
				{
					case "c1": pickKey();break;
					case "c2": readPapers();break;
					case "c3": openCab();break;
				}break;
				case "openCab":
				switch(yourChoice)
				{
					case "c1": pickKey();break;
					case "c2": readPapers();break;
				}break;
				case "readPapers":
				switch(yourChoice)
				{
					case "c1": pickKey();break;
					case "c3": tryDoor();break;
				}break;
				case "pickKey":
				switch(yourChoice)
				{
					case "c2": checkWindow();break;
					case "c3": tryDoor2();break;
				}break;
				case "tryDoor2":
				switch(yourChoice)
				{
					case "c1": downstairs();break;
					
				}break;
				case "downstairs":
				switch(yourChoice)
				{
					case "c1": checkCushions();break;
					case "c2": tryMainDoor();break;
					case "c3": brokenDoor();break;
				}break;
				case "checkCushions":
				switch(yourChoice)
				{
					case "c2": tryMainDoor();break;
					case "c3": brokenDoor();break;
				}break;
				case "tryMainDoor":
				switch(yourChoice)
				{
					case "c1": checkCushions();break;
					case "c3": brokenDoor();break;
				}break;
				case "brokenDoor":
				switch(yourChoice)
				{
					case "c1": fridge();break;
					case "c2": knife();break;
					
				}break;
				case "fridge":
				switch(yourChoice)
				{
					case "c2": knife();break;
				}break;
				case "knife":
				switch(yourChoice)
				{
					case "c1": fridge();break;
					case "c3": leave();break;
				}break;
				case "leave":
				switch(yourChoice)
				{
					case "c1": next();break;
				}break;
				case "next":
				switch(yourChoice)
				{
					case "c1": stab();break;
					case "c2": dodge();break;
				}break;
				case "stab":
				switch(yourChoice)
				{
					case "c1": darkRoom();break;
					case "c2": f1.dispose();break;
				}break;
				case "dodge":
				switch(yourChoice)
				{
					case "c1": goUpstairs();break;
				}break;
				case "goUpstairs":
				switch(yourChoice)
				{
					case "c1": useKey();break;
					case "c2": forceCab();break;
				}break;
				case "forceCab":
				switch(yourChoice)
				{
					case "c1": useKey();break;
				}break;
				case "useKey":
				switch(yourChoice)
				{
					case "c1": leaveRoom();break;
				}break;
				case "leaveRoom":
				switch(yourChoice)
				{
					case "c1": endScreen();break;
				}break;
				
			}
		}
	}
}	