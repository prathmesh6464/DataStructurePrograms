//CLASS NODE
class Node
{
	String word;
	Node next;
}


//CLASS LINK LIST
class LinkList<T>
{
	Node head = new Node();
	
	
	//EMPTY LIST METHOD
	Node emptyList()
	{
		return head;
	} 
	
	
	//ADD METHOD
	public void add(String addWord)
	{
		Node newNodeWord = new Node();
		newNodeWord.word = addWord;
		newNodeWord.next = null;
		
		if(head == null)
		{
			head = newNodeWord;
		}
		else
		{
			Node tempHead = head;
			newNodeWord.next = head;
			head = newNodeWord;
		}
	}
	
	
	//APPEND METHOD
	public void append(String addWord)
	{
		Node newNodeOfWord = new Node();
		newNodeOfWord.word = addWord;
		newNodeOfWord.next = null;
		
		if(head == null)
		{
			head = newNodeOfWord;
		}
		else
		{
			Node tempHead = head;
			while(tempHead.next != null)
			{
				tempHead = tempHead.next;
			}
			tempHead.next = newNodeOfWord;
		}
	}	
	
	
	//SHOW LINK LIST
	void showLinkList()
	{
		Node tempHead = head;
		while(tempHead != null)
		{
			System.out.println("Link list data : "+tempHead.word);
			tempHead = tempHead.next;
		}
	}	
}

public class UnOrderedList
{
	public static void main(String args[])
	{
		LinkList<String> featuresOfLinkList = new LinkList<String>();
		Node r = featuresOfLinkList.emptyList();
		System.out.println("Empty list : "+r.next);
		featuresOfLinkList.append("abc");
		featuresOfLinkList.append("hii");
		featuresOfLinkList.append("abcx");
		featuresOfLinkList.add("dsfdsfdsf");
		featuresOfLinkList.showLinkList();
	}
}