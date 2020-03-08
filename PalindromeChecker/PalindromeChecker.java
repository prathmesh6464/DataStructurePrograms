package PalindromeChecker;
import java.util.Scanner;


//NODE
class Node
{
	String word;
	Node nextNode = null;
} 


//CREATING DEQUEUE CLASS
class Dequeue<T>
{
	//NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY DEQUEUE METHOD
	Node deQueue()
	{
		return headNode;
	} 


	//ADD FRONT METHOD
	public void addFront(String addWord)
	{
		//VARIABLES
		Node addingNewCharacter = new Node();
		addingNewCharacter.word = addWord;


		if(headNode.nextNode == null)
		{
			headNode.nextNode = addingNewCharacter.nextNode;
			size++;
		}
		else
		{
			addingNewCharacter.nextNode = headNode.nextNode;
			headNode.nextNode = addingNewCharacter;
			size++;
		}
	}


	//ADD REAR METHOD
	public void addRear(String addWord)
	{
		//VARIABLES OF NODE	
		Node addingNewCharacter = new Node();
		addingNewCharacter.word = addWord;
		addingNewCharacter.nextNode = null;


		if(headNode.nextNode == null )
		{
			headNode.nextNode = addingNewCharacter;
			size++;
		}
		else
		{
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
			}
			temporaryHeadNode.nextNode = addingNewCharacter;
			size++;
		}
	}


	//REMOVE REAR METHOD
	String removeRear()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("Deque is empty");
			return "";
		}
		else
		{	
			int temparoryIter = 0;
			Node temparoryHead = headNode;


			for(temparoryIter=0; temparoryIter<size-1; temparoryIter++)
			{
				temparoryHead = temparoryHead.nextNode;
			}

			
			String returnWord = temparoryHead.word;
			temparoryHead.nextNode = null;
			size--;
			return returnWord;
		}
	}
}


//PALINDROME CLASS
public class PalindromeChecker
{
	//MAIN METHOD
	public static void main(String[] args)
	{
		//OBJECT
		Dequeue<String> dequeueObject = new Dequeue<String>();


		//EMPTY DEQUEUE METHOD CALLED
		dequeueObject.deQueue();


		//ADD FRONT METHOD CALLED
		dequeueObject.addFront("hello");


		//ADD REAR METHOD CALLED
		dequeueObject.addRear("testing");
		
		
		//REMOVE REAR METHOD CALLED
		System.out.print(dequeueObject.removeRear());
	}
}

