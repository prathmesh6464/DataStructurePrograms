package PalindromeChecker;


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
		{			addingNewCharacter.nextNode = headNode.nextNode;
			headNode.nextNode = addingNewCharacter;
			size++;;
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


	//REMOVE FRONT METHOD
	String removeFront()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("Deque is empty");
			return "";
		}
		else
		{	
			String temparoryHead = headNode.nextNode.word;
			headNode.nextNode = headNode.nextNode.nextNode;
			size--;
			return temparoryHead;
		}
	}


	//METHOD TO SHOW DEQUEUE
	public void showDequeue()
	{
		//VARIABLE
		Node temporaryHeadNode = headNode;


		if(headNode.nextNode == null)
		{
			System.out.println("Dequeue is empty");
		}


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			System.out.println(temporaryHeadNode.word);
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

		//ADD FRONT METHOD CALLED
		dequeueObject.addFront("hello");
		dequeueObject.addRear("testing");
		dequeueObject.addFront("hello");
		dequeueObject.addFront("hello");

		//REMOVE REAR METHOD CALLED
		System.out.println(dequeueObject.removeRear());


		//REMOVE FRONT METHOD CALLED
		System.out.print(dequeueObject.removeFront());
	}
}

