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
					wordData.insertWord(word);
				}
				line = bufferFileRead.readLine();
			}
			catch(NullPointerException e)
			{
				System.out.println("List endded");
			}
		}
		bufferFileRead.close();


		//SHOW LINK LIST CALLED METHOD
		wordData.showWordList();
		//TAKING INPUT METHOD CALLED
		String wordToDelete=wordData.takeInput();
		//DELETE WORD METHOD CALLED
		wordData.deleteWord(wordToDelete);
		//IS WORD PRESENT OR NOT METHOD CALLED
		wordData.isWordPresent(wordToDelete);
		//SAVE INTO SAME FILE METHOD CALLED
		wordData.saveIntoSameFile();
		//SHOW LINK LIST METHOD CALLED
		wordData.showWordList();
	}
}
