import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;


//CREATING NODE FOR LINK LIST
class Node
{
	String word;
	Node next = null;
} 


//CREATING LINK LIST CLASS
class LinkList<T>
{
	//HEAD NODE TYPE VAIABLE
	Node head = new Node();
	int size = 0;


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

		if(head.next == null)
		{
			head.next = newNodeWord;
			size++;
		}
		else
		{
			Node tempHead = head;
			newNodeWord.next = head;
			head = tempHead;
			newNodeWord.next = head;
			head = newNodeWord;

			newNodeWord.next = head.next;
			head.next = newNodeWord.next;
			size++;
		}
	}


	//APPEND METHOD
	public void append(String word)
	{
		//VARIABLES OF NODE	
		Node addWordNewNode = new Node();
		addWordNewNode.word = word;
		addWordNewNode.next = null;


		try 
		{
			if(head.next == null )
			{
				head.next = addWordNewNode;
				size++;
			}
			else
			{
				Node tempHead = head;
				while(tempHead.next != null)
				{
					tempHead = tempHead.next;
				}
				tempHead.next = addWordNewNode;
				size++;
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
				LinkList.this.append(findWord);
				size++;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("List endded");
		}
	}


	//METHOD TO SEARCH WORD
	void search(String findWord)
	{

		Node tempHead = head;
		int flag = 0;
		while(tempHead.next != null)
		{
			tempHead = tempHead.next;
			if(true == (tempHead.word).equals(findWord))
			{
				flag = 1;
				System.out.println(findWord+" Found in list");
			}			
		}
		if(flag == 0)
		{
			System.out.println(findWord+" Not Found in list");
		}

	}


	//METHOD TO DELETE WORD
	void remove(String remove)
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
				Node tempHead= head.next;
				while(true != ((tempHead.word).equals(remove)))
				{
					prevTempHead = tempHead;
					tempHead = tempHead.next;
				}
				System.out.println("Deleted word : "+tempHead.word);
				prevTempHead.next=prevTempHead.next.next;
				size--;
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


	//METHOD OF SIZE
	int size()
	{
		return size;
	}


	//METHOD OF IS LIST EMPTY OR NOT
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



	//METHOD OF INDEX
	int index(String findIndexOfWord)
	{
		int temp = 0;
		Node tempHead = head.next;

		while(tempHead != null)
		{
			if(findIndexOfWord.equals(tempHead.word))
			{
				return temp;
			}	
			System.out.println(tempHead.word);
			tempHead = tempHead.next;
			temp++;
		}
		return -1;
	}


	//METHOD OF TAKING INPUT
	String takeInput()
	{
		System.out.println("Enter the word which you want to find and delete : ");
		Scanner scannerObject = new Scanner(System.in);
		String findWord = scannerObject.next();
		return findWord;		
	}

	
	//METHOD OF SAVING IN SAME FILE
	void saveIntoSameFile() throws IOException
	{
		FileWriter fileWriterObject  = new FileWriter("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//TempFile.txt",true);
		BufferedWriter bufferWriterObject = new BufferedWriter(fileWriterObject);


		try 
		{
			Node tempHead = head;
			while(tempHead.next != null)
			{
				tempHead = tempHead.next;
				bufferWriterObject.newLine();
				System.out.println("Writing word data to file : "+tempHead.word);
				bufferWriterObject.write(tempHead.word);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("File write operation completed.");
		}
		bufferWriterObject.flush();
		bufferWriterObject.close();		
	}
}


//UNORDERED LIST CLASS
public class UnOrderedList
{	
	//MAIN METHOD
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException,IOException
	{
		FileReader fileRead = new FileReader(new File("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//TempFile.txt"));
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
					wordData.append(word);
				}
				line = bufferFileRead.readLine();
			}
			catch(NullPointerException e)
			{
				System.out.println("List endded");
			}
		}
		bufferFileRead.close();

		
		//SIZE METHOD CALLED
		int result = wordData.index("very");
		if(result == -1)
		{
			
			System.out.println("Word is not in list");
		}
		else
		{
			System.out.println("Index : "+(result));
		}
	}
}
