//NODE CLASS
class Node
{
	String word;
	Node next=null;
}


//LINK LIST CLASS
class LinkList
{
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	Node head = new Node();
	public void insertWord(String word)
	{
		Node addWordNewNode = new Node();
		addWordNewNode.word = word;
		addWordNewNode.next = null;

		
		try 
		{
			if(head.next == null )
			{
				head.next = addWordNewNode;
			}
			else
			{
				Node tempHead = head;
				while(tempHead.next != null)
				{
					tempHead = tempHead.next;
				}
				tempHead.next = addWordNewNode;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("List endded");
		}
	}


	//METHOD TO CHECK WORD IS PRESENT OR NOT
	void isWordPresent(String findWord)
	{
		try 
		{
			int flag = 0;
			Node tempHead = head;
			while(tempHead.next != null)
			{
				tempHead = tempHead.next;
				if(true == (tempHead.word).equals(findWord))
				{
					flag=1;
				}			
			}
			if(flag == 0)
			{
				LinkList.this.insertWord(findWord);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("List endded");
		}
	}

	//METHOD TO DELETE WORD
	void deleteWord(String deleteWord)
	{
		if(head.next == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			try
			{	
				Node prevTempHead = head;			
				Node tempHead = head.next;
				while(true != ((tempHead.word).equals(deleteWord)))
				{
					prevTempHead = tempHead;
					tempHead = tempHead.next;
				}
				System.out.println("Deleted word : "+tempHead.word);
				prevTempHead.next=prevTempHead.next.next;
			}
			catch(NullPointerException e) 
			{
				System.out.println("Word deletion operation completed.");
			}
		}
	}


	//METHOD TO SHOW LIST
	public void showWordList()
	{
		try 
		{
			Node tempHead = head;
			while(tempHead.next != null)
			{
				tempHead = tempHead.next;
				System.out.println(tempHead.word);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("List endded");
		}
	}


	//METHOD OF TAKING INPUT
	String takeInput()
=======
=======
>>>>>>> Stashed changes
	Node emptyList()
	{
		Node head = new Node();
		return head.next;
	}
}


//UNORDERED LIST CLASS
class UnOrderedList
{
	//MAIN FUNCTION
	public static void main(String[] args)
	{
		LinkList linkListFeatures = new LinkList();
		Node returnedEmptyResult = linkListFeatures.emptyList();
		System.out.println("Empty list : "+returnedEmptyResult);
	}
}