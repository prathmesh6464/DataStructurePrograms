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

