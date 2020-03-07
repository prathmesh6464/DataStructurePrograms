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
	Node nextNode = null;
} 


//CREATING LINK LIST CLASS
class LinkList<T>
{
	//headNode NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY LIST METHOD
	Node emptyList()
	{
		return headNode;
	} 


	//ADD METHOD
	public void add(String addingWord)
	{
		Node newNodeWord = new Node();
		newNodeWord.word = addingWord;
		newNodeWord.nextNode = null;
		

		if(headNode.nextNode == null)
		{
			headNode.nextNode = newNodeWord;
			size++;
		}
		else
		{
			Node temporaryHeadNode = headNode;
			newNodeWord.nextNode = headNode;
			headNode = temporaryHeadNode;
			newNodeWord.nextNode = headNode;
			headNode = newNodeWord;

			newNodeWord.nextNode = headNode.nextNode;
			headNode.nextNode = newNodeWord.nextNode;
			size++;
		}
	}


	//APPEND METHOD
	public void append(String word)
	{
		//VARIABLES OF NODE	
		Node addingWordNewNode = new Node();
		addingWordNewNode.word = word;
		addingWordNewNode.nextNode = null;


		try 
		{
			if(headNode.nextNode == null )
			{
				headNode.nextNode = addingWordNewNode;
				size++;
			}
			else
			{
				Node temporaryHeadNode = headNode;
				while(temporaryHeadNode.nextNode != null)
				{
					temporaryHeadNode = temporaryHeadNode.nextNode;
				}
				temporaryHeadNode.nextNode = addingWordNewNode;
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
			int isMatches = 0;
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
				if(true == (temporaryHeadNode.word).equals(findWord))
				{
					isMatches=1;
				}			
			}
			if(isMatches == 0)
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
		Node temporaryHeadNode = headNode;
		int isMatches = 0;
		
		
		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			if(true == (temporaryHeadNode.word).equals(findWord))
			{
				isMatches = 1;
				System.out.println(findWord+" Found in list");
			}			
		}
		
		
		if(isMatches == 0)
		{
			System.out.println(findWord+" Not Found in list");
		}

	}


	//METHOD TO DELETE WORD
	void remove(String remove)
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			try
			{	
				Node previousTemporaryHeadNode = headNode;			
				Node temporaryHeadNode= headNode.nextNode;
				while(true != ((temporaryHeadNode.word).equals(remove)))
				{
					previousTemporaryHeadNode = temporaryHeadNode;
					temporaryHeadNode = temporaryHeadNode.nextNode;
				}
				System.out.println("Deleted word : "+temporaryHeadNode.word);
				previousTemporaryHeadNode.nextNode=previousTemporaryHeadNode.nextNode.nextNode;
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
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
				System.out.println(temporaryHeadNode.word);
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
		Node temporaryHeadNode = headNode.nextNode;

		while(temporaryHeadNode != null)
		{
			if(findIndexOfWord.equals(temporaryHeadNode.word))
			{
				return temp;
			}	
			System.out.println(temporaryHeadNode.word);
			temporaryHeadNode = temporaryHeadNode.nextNode;
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
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
				bufferWriterObject.newLine();
				System.out.println("Writing word data to file : "+temporaryHeadNode.word);
				bufferWriterObject.write(temporaryHeadNode.word);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("File write operation completed.");
		}
		bufferWriterObject.flush();
		bufferWriterObject.close();		
	}


	//INSERT ITEM ON POSITION
	void insert(int position,String addingWord)
	{
		Node newNodeWord = new Node();
		newNodeWord.word = addingWord;
		newNodeWord.nextNode = null;
		
		Node temporaryHeadNode = headNode;
		for(int iter=0; iter<(position); iter++)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
		}
		newNodeWord.nextNode = temporaryHeadNode.nextNode;
		temporaryHeadNode.nextNode = newNodeWord;
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


		//INSERT METHOD CALLED
		wordData.insert(1,"New Word");
		wordData.showWordList();
	}
}
