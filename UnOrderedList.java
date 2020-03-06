//NODE CLASS
class Node
{
	String word;
	Node next=null;
}


//LINK LIST CLASS
class LinkList<T>
{
	Node head = new Node();
	//EMPTY LIST METHOD
	Node emptyList()
	{
		return head.next;
	}
	

	//ADD METHOD
	void add(String addWord)
	{
		Node tempHead = head;
		tempHead.word = addWord;
		tempHead.next = null;
		if(head.next == null)
		{
			head.next = tempHead;
		}
		else
		{
			while(tempHead.next != null)
			{
				tempHead=tempHead.next;
			}
			tempHead.next = tempHead;
		}
	}
	
	
	//SHOW METHOD
}



//UNORDERED LIST CLASS
public class UnOrderedList
{
	//MAIN FUNCTION
	public static void main(String[] args)
	{
		LinkList<String> linkListFeatures = new LinkList<String>();
		Node returnedEmptyResult = linkListFeatures.emptyList();
		System.out.println("Empty list : "+returnedEmptyResult);
		linkListFeatures.add("hii");
	}
}