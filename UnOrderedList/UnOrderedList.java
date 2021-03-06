import java.io.BufferedReader;
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
	//NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY LIST METHOD
	Node emptyList()
	{
		return headNode;
	} 


	//ADD METHOD
	public void add(String addWord)
	{
		//VARIABLES
		Node newNodeWord = new Node();
		newNodeWord.word = addWord;


		if(headNode.nextNode == null)
		{
			headNode.nextNode = newNodeWord.nextNode;
			size++;
		}
		else
		{
			newNodeWord.nextNode = headNode.nextNode;
			headNode.nextNode = newNodeWord;
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
			//VARIABLES
			int isMatches = 0;
			Node temporaryHeadNode = headNode;

			
			//CHECKING WORD IS PRESENT OR NOT
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
		//VARIABLES
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
	void remove(String removeWord)
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			try
			{	
				//VARIABLES
				Node previousTemporaryHeadNode = headNode;			
				Node temporaryHeadNode= headNode.nextNode;


				while(true != ((temporaryHeadNode.word).equals(removeWord)))
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
			//VARIABLE
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
		//VARIABLE
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
		FileWriter fileWriterObject  = new FileWriter("C:\\Users\\King\\eclipse-workspace\\SnakeAndLadderProgram\\TempFile.txt",true);
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
		//VARIABLES
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
		size++;
	}


	//POP METHOD
	String pop()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
			return "";
		}
		else
		{	
			int temparoryIter = 0;
			Node temparoryHead = headNode;


			for(temparoryIter=0; temparoryIter<size-1; temparoryIter++)
			{
				temparoryHead = temparoryHead.nextNode;
			}

			String returnWord = temparoryHead.word;
			temparoryHead.nextNode = null;
			size--;
			return returnWord;
		}
	}


	//POP POSITION METHOD
	String pop(int position)
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
		}
		else
		{	
			int temporaryIter = 0;
			Node temporaryHead = headNode;


			for(temporaryIter=0; temporaryIter<size; temporaryIter++)
			{
				if(temporaryIter == position)
				{
					temporaryHead = temporaryHead.nextNode;
					this.remove(temporaryHead.word);
					return temporaryHead.word;
				}
				temporaryHead = temporaryHead.nextNode;					
			}
			size--;
		}
		return null;	
	}
}


//UNORDERED LIST CLASS
public class UnOrderedList
{	
	//MAIN METHOD
	public static void main(String[] args) throws IOException,NullPointerException,IOException
	{
		FileReader fileRead = new FileReader(new File("C:\\Users\\King\\eclipse-workspace\\SnakeAndLadderProgram\\TempFile.txt"));
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


		//DISPLAY LIST AFTER ADD METHOD CALLED
		wordData.add("New Word");


		//POP METHOD CALLED
		wordData.pop();
		wordData.pop();
		wordData.pop();


		//SHOW LIST
		wordData.showWordList();


		//SAVE TO FILE
		wordData.saveIntoSameFile();
	}
}
