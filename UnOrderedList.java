import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


//CREATING NODE FOR LINK LIST
class Node
{
	String word;
	Node next = null;
} 


//CREATING LINK LIST CLASS
class LinkList<T>
{
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
			System.out.println("");
		}
	}

	
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
				Node prevtempHead = head;			
				Node tempHead = head.next;
				while(true != ((tempHead.word).equals(deleteWord)))
				{
					prevtempHead = tempHead;
					tempHead = tempHead.next;
				}
				System.out.println("Deleted word : "+tempHead.word);
				prevtempHead.next=prevtempHead.next.next;
			}
			catch(NullPointerException e) 
			{
				System.out.println("");
			}
		}
	}


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
			System.out.println("");
		}
	}
	
	
	String takeInput()
	{
		System.out.println("Enter the word which you want to find and delete : ");
		Scanner scannerObject = new Scanner(System.in);
		String findWord = scannerObject.next();
		return findWord;
	}
	
}


public class UnOrderedList
{
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException
	{
		FileReader fileRead = new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//TempFile.txt");
		BufferedReader bufferFileRead = new BufferedReader(fileRead);
		String line = bufferFileRead.readLine();
		LinkList<String> wordData = new LinkList<String>();

		while(line != null) 
		{
			try
			{
				String[] splitWords = line.split(" ");
				for(String word : splitWords)
				{
					wordData.insertWord(word);
				}
				line = bufferFileRead.readLine();
			}
			catch(NullPointerException e)
			{
				System.out.println("");
			}
		}


		//SHOW LINK LIST CALLED METHOD OF LINKLIST
		wordData.showWordList();
		String wordToDelete=wordData.takeInput();
		wordData.deleteWord(wordToDelete);
		wordData.showWordList();
	}
}
