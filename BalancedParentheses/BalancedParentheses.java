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
		System.out.println("Enter the word which you want to find and delete : ");
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
}


//ORDERED LIST CLASS
public class BalancedParentheses
{	
	//MAIN METHOD
	public static void main(String[] args)
	{
		StackList<String> StackObject = new StackList<String>();
		StackObject.stack();
		StackObject.push("(");
		StackObject.showStack();
	}
}
