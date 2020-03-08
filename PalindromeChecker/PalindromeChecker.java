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
		Node newNodeWord = new Node();
		newNodeWord.word = addWord;


		if(headNode.nextNode == null)
		{
			headNode.nextNode = newNodeWord.nextNode;
			size++;
		}
		else
		{
			newNodeWord.nextNode = headNode.nextNode;
			headNode.nextNode = newNodeWord;
			size++;
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
	}
}

