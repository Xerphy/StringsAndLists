package tools.controller;

import java.util.List;
import java.util.ArrayList;

import tools.model.Kahoot;
import tools.view.PopupDisplay;

public class Controller
{
	private List<Kahoot> myKahoots;
	private PopupDisplay popup;
	
	public Controller()
	{
		myKahoots = new ArrayList<Kahoot>();
		popup = new PopupDisplay();
	}
	
	public void start()
	{
		Kahoot myFirstKahoot = new Kahoot();				//Creates a Kahoot with default values
		myKahoots.add(myFirstKahoot);
		fillTheList();
//		showTheList();
//		changeTheList();
		practiceWithList();
	}
	
	private void showTheList()
	{
		String currentCreator = "";
		for (int index = 0; index < myKahoots.size(); index++)
		{
			currentCreator = myKahoots.get(index).getCreator();
			
			Kahoot currentKahoot = myKahoots.get(index);
			String creator = currentKahoot.getCreator();
			
			popup.displayText(myKahoots.get(index).toString());
			
			if (currentCreator.equals("Nobody"))
			{
				for (int loop = 0; loop < 5; loop += 1)
				{
					popup.displayText("wow nobody does a lot");
				}
			}
			
			for (int currentLetterIndex = 0; currentLetterIndex < currentCreator.length(); currentLetterIndex += 1)
			{
				popup.displayText(currentCreator.substring(currentLetterIndex, currentLetterIndex + 1));
			}
			
			String topic = currentKahoot.getTopic();
			for (int letter = currentKahoot.getTopic().length() - 1; letter >= 0; letter -= 1)
			{
				popup.displayText(topic.substring(letter, letter + 1));
			}
		}
	}
	
	private void fillTheList()
	{
		Kahoot fiftyStates = new Kahoot("Kashish", 50, "The fifty United States");	//Creates a new class with the inserted values
		Kahoot mySecondKahoot = new Kahoot("Ethan", 2, "The Double data type");
		Kahoot bigQuiz = new Kahoot("Derek", Integer.MAX_VALUE, "Everything");
		Kahoot animalColor = new Kahoot("Branton", 10, "All the colors of the animals");
		Kahoot presidents = new Kahoot("Obama", 44, "The 44th president of the US");
		
		myKahoots.add(fiftyStates);
		myKahoots.add(mySecondKahoot);
		myKahoots.add(bigQuiz);
		myKahoots.add(animalColor);
		myKahoots.add(presidents);
	}
	
	private void changeTheList()
	{
		popup.displayText("The current list size is: " + myKahoots.size());
		Kahoot removed = myKahoots.remove(3);
		popup.displayText("I removed the kahoot by " + removed.getCreator());
		popup.displayText("The list now has: " + myKahoots.size() + " items inside." );
		myKahoots.add(0, removed);
		
		popup.displayText("The list is still : " + myKahoots.size() + " items big.");
		removed = myKahoots.set(2, new Kahoot());
		popup.displayText("The Kahoot by " + removed.getCreator() + " was replaced with one by: " + myKahoots.get(2).getCreator());
	}
	
	private void practiceWithList()
	{
		String response = popup.getResponse("I'm going to add a list with pre-added values, who would you like the list to be made by?");
		myKahoots.add(0, new Kahoot(response, 10, "Default Topic"));
		popup.displayText("Your Kahoot was added to the first position with these values.  Creator: " + myKahoots.get(0).getCreator() 
							+ " | Question Count: " + myKahoots.get(0).getQuestionCount() + " | Topic: " + myKahoots.get(0).getTopic());
		
		popup.displayText("I will be removing the 5th Kahoot in the list.");
		Kahoot removed = myKahoots.remove(5);
		popup.displayText("There are now " + myKahoots.size() + " Kahoots left.");
		
		popup.displayText("I will now add the removed Kahoot to the end of the list");
		myKahoots.add(6, removed);
		popup.displayText("There are now " + myKahoots.size() + " Kahoots in the list");
		
		
		int count = 0;
		
		for (Kahoot kahoot : myKahoots)
		{
			count++;
			popup.displayText("The #" + count + " item in the list is created by " + kahoot.getCreator() + 
							", the question count is " + kahoot.getQuestionCount() + " and the topic is '" + kahoot.getTopic() + "'.");
		}
		
		
		for (int loop = myKahoots.size() - 1; loop > -1; loop--)
		{
			popup.displayText("The #" + (loop + 1) + " item in the lists is created by " + myKahoots.get(loop).getCreator() + 
							", the question count is " + myKahoots.get(loop).getQuestionCount() + " and the topic is '" + myKahoots.get(loop).getTopic() + "'.");
			
		}
	}
	
	public PopupDisplay getPopup()
	{
		return popup;
	}
	
	public ArrayList<Kahoot> getMyKahoots()
	{
		return (ArrayList<Kahoot>) myKahoots;
	}
	
	public int findMaxLength(ArrayList<String> myList)
	{
		int max = 0;
		
		for (int index = 0; index < myList.size(); index++)
		{
			if (myList.get(index).length() > max)
			{
				max = myList.get(index).length();
			}
		}
		return max;
	}
	
	public int findMinLength(ArrayList<String> myList)
	{
		int min = Integer.MAX_VALUE;
		
		for (int index = 0; index < myList.size(); index++)
		{
			if (myList.get(index).length() < min)
			{
				min = myList.get(index).length();
			}
		}
		return min;
	}
}
