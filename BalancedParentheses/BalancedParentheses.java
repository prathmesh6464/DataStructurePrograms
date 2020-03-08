package BalancedParentheses;


//CREATING NODE FOR LINK LIST
class Node
{
	String word;
	Node nextNode = null;
} 


//CREATING LINK LIST CLASS
class StackList<T>
{
	//headNode NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY STACK METHOD
	Node stack()
	{
		return headNode;
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
	}
}
