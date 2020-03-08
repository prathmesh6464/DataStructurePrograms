package BalancedParentheses;
import java.util.Scanner;


//CREATING NODE FOR LINK LIST
class Node
{
	String parentheses;
	Node nextNode = null;
} 


//CREATING LINK LIST CLASS
class StackList<T>
{
	//NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY STACK METHOD
	Node stack()
	{
		return headNode;
	} 


	//METHOD OF TAKING INPUT
	String takeInput()
	{
		System.out.println("Enter Your parentheses : ");
		Scanner scannerObject = new Scanner(System.in);
		String parenthesesInput = scannerObject.next();
		return parenthesesInput;		
	}


	//PUSH METHOD
	public void push(String parentheses)
	{
		//VARIABLES OF NODE	
		Node addingparentheses = new Node();
		addingparentheses.parentheses = parentheses;
		addingparentheses.nextNode = null;


		if(headNode.nextNode == null )
		{
			headNode.nextNode = addingparentheses;
			size++;
		}
		else
		{
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
			}
			temporaryHeadNode.nextNode = addingparentheses;
			size++;
		}
	}


	//METHOD TO SHOW STACK
	public void showStack()
	{
		//VARIABLE
		Node temporaryHeadNode = headNode;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			System.out.println(temporaryHeadNode.parentheses);
		}
	}


	//POP METHOD
	String pop()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("Stack is empty");
			return "";
		}
		else
		{	
			//VARIABLE
			int temparoryIter = 0;
			Node temparoryHead = headNode;


			for(temparoryIter=0; temparoryIter<size-1; temparoryIter++)
			{
				temparoryHead = temparoryHead.nextNode;
			}

			String returnWord = temparoryHead.parentheses;
			temparoryHead.nextNode = null;
			size--;
			return returnWord;
		}
	}


	//PEEK METHOD
	String peek()
	{
		//VARIABLE
		Node temporaryHeadNode = headNode;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
		}
		return temporaryHeadNode.parentheses;
	}


	//METHOD OF SIZE
	int size()
	{
		return size;
	}


	//STACK EMPTY OR NOT
	void isEmpty()
	{
		if(size == 0)
		{
			System.out.println("List is empty");
		}
		else
		{
			System.out.println("List is Not empty");
		}
	}
}


//STACK CLASS
public class BalancedParentheses
{	
	//MAIN METHOD
	public static void main(String[] args)
	{
		StackList<String> StackObject = new StackList<String>();


		//IS EMPTY METHOD CALLED
		StackObject.isEmpty();
		
		
		//SIZE METHOD CALLED
		System.out.println(StackObject.size());
	}
}
