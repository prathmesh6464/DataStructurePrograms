package BalancedParentheses;
import java.util.Scanner;


//CREATING NODE FOR LINK LIST
class Node
{
	String expression;
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
		System.out.println("Enter your expression : ");
		Scanner scannerObject = new Scanner(System.in);
		String expressionInput = scannerObject.next();
		return expressionInput;		
	}


	//PUSH METHOD
	public void push(String expression)
	{
		//VARIABLES OF NODE	
		Node addingExpression = new Node();
		addingExpression.expression = expression;
		addingExpression.nextNode = null;


		if(headNode.nextNode == null )
		{
			headNode.nextNode = addingExpression;
			size++;
		}
		else
		{
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
			}
			temporaryHeadNode.nextNode = addingExpression;
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
			System.out.println(temporaryHeadNode.expression);
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


			String returnWord = temparoryHead.expression;
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
		return temporaryHeadNode.expression;
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
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println("Stack is Not empty");
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
		String InputExpression = StackObject.takeInput();
		System.out.println(InputExpression.length());
		int indexOfString = 0;
		while(indexOfString < InputExpression.length())
		{
			String eachCharacter = Character.toString(InputExpression.charAt(indexOfString));
			if(eachCharacter.equals("{") || eachCharacter.equals("[") || eachCharacter.equals("("))
			{
				StackObject.push(eachCharacter);
				System.out.println(eachCharacter+" opening");
			}
			if(eachCharacter.equals("}") || eachCharacter.equals("]") || eachCharacter.equals(")"))
			{
				System.out.println(eachCharacter+" closing");
				
			}
			indexOfString++;
		}
		//StackObject.showStack();
		//System.out.println(StackObject.pop());
	}
}

