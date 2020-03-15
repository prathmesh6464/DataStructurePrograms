package HashingFunction;
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
	int number;
	int index = -1;
	Node nextNode = null;
} 


//INDEX NODE
class indexNode
{
	int index = -1;
	int number;
	indexNode nextNode = null;
} 


//CREATING LINK LIST CLASS
class LinkList<T>
{
	//headNode NODE TYPE VAIABLE
	Node headNode = new Node();
	indexNode headIndexNode = new indexNode();
	int size = 0;
	int temparoryIndex = 0;


	//EMPTY LIST METHOD
	Node emptyOrderedList()
	{
		return headNode;
	} 


	//ADD METHOD
	public void add(int addNumber)
	{
		//VARIABLES
		Node newNodeNumber = new Node();
		newNodeNumber.number = addNumber;


		if(headNode.nextNode == null)
		{
			headNode.nextNode = newNodeNumber.nextNode;
			size++;
		}
		else
		{
			newNodeNumber.nextNode = headNode.nextNode;
			headNode.nextNode = newNodeNumber;
			size++;
		}
	}


	//APPEND METHOD
	public void append(int number)
	{
		//VARIABLES OF NODE	
		Node addingNumberNewNode = new Node();
		//int index = size;
		addingNumberNewNode.number = number;
		addingNumberNewNode.index = size;
		addingNumberNewNode.nextNode = null;


		try 
		{
			if(headNode.nextNode == null )
			{
				headNode.nextNode = addingNumberNewNode;
				size++;
			}
			else
			{
				Node temparoryIndexoraryHeadNode = headNode;
				while(temparoryIndexoraryHeadNode.nextNode != null)
				{
					temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
				}
				temparoryIndexoraryHeadNode.nextNode = addingNumberNewNode;
				size++;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("List endded");
		}
	}


	//METHOD TO CHECK number IS PRESENT OR NOT
	void isNumberPresent(int findNumber)
	{
		//VARIABLES
		int isMatches = 0;
		Node temparoryIndexoraryHeadNode = headNode;


		while(temparoryIndexoraryHeadNode.nextNode != null)
		{
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			if(temparoryIndexoraryHeadNode.number == findNumber)
			{
				isMatches=1;
			}			
		}


		if(isMatches == 0)
		{
			LinkList.this.append(findNumber);
			size++;
		}
		else
		{
			LinkList.this.remove(findNumber);
		}
	}


	//METHOD TO SEARCH number
	int search(int findNumber)
	{
		//VARIABLES
		Node temparoryIndexoraryHeadNode = headNode;
		int isMatches = 0;


		while(temparoryIndexoraryHeadNode.nextNode != null)
		{
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			if(temparoryIndexoraryHeadNode.number == findNumber)
			{
				isMatches = 1;
				System.out.println(findNumber+" Found in list");
				return isMatches;
			}			
		}


		if(isMatches == 0)
		{
			System.out.println(findNumber+" Not found in list");
		}
		return -1;
	}


	//METHOD TO DELETE NUMBER
	void remove(int removeNumber)
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
				Node previoustemparoryIndexoraryHeadNode = headNode;			
				Node temparoryIndexoraryHeadNode = headNode.nextNode;


				while(temparoryIndexoraryHeadNode.number != removeNumber)
				{

					previoustemparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode;
					temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
				}


				System.out.println("Deleted number : "+temparoryIndexoraryHeadNode.number);
				previoustemparoryIndexoraryHeadNode.nextNode = previoustemparoryIndexoraryHeadNode.nextNode.nextNode;
				size--;
			}
			catch(NullPointerException e) 
			{
				System.out.println("Number deletion operation completed.");
			}
		}
	}


	//METHOD TO SHOW LIST
	public void showNumberList()
	{
		//VARIABLES
		Node temparoryIndexoraryHeadNode = headNode;


		if(temparoryIndexoraryHeadNode.nextNode == null)
		{
			System.out.println("List is empty");
		}


		while(temparoryIndexoraryHeadNode.nextNode != null)
		{
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			System.out.println(temparoryIndexoraryHeadNode.number);

			System.out.println("nnnnnnnn "+temparoryIndexoraryHeadNode.number);
			System.out.println("iiiiiiii "+temparoryIndexoraryHeadNode.index);
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
			System.out.println("List is not empty");
		}
	}
	

	//METHOD OF INDEX
	int index(int findIndexOfNumber)
	{
		//VARIABLE
		int temparoryIndex = 0;
		Node temparoryIndexoraryHeadNode = headNode.nextNode;


		while(temparoryIndexoraryHeadNode != null)
		{
			if(findIndexOfNumber == temparoryIndexoraryHeadNode.number)
			{
				return temparoryIndex;
			}	
			System.out.println(temparoryIndexoraryHeadNode.number);
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			temparoryIndex++;
		}
		return -1;
	}


	//METHOD OF TAKING INPUT
	int takeInput()
	{
		System.out.println("Enter the number which you want to find and delete : ");
		Scanner scannerObject = new Scanner(System.in);
		int findNumber = scannerObject.nextInt();
		return findNumber;		
	}


	//METHOD OF SAVING IN SAME FILE
	void saveIntoSameFile() throws IOException,FileNotFoundException
	{
		FileWriter fileWriterObject  = new FileWriter("C:\\Users\\King\\eclipse-workspace\\SnakeAndLadderProgram\\TempFile.txt",true);
		BufferedWriter bufferWriterObject = new BufferedWriter(fileWriterObject);
		int[] arrayForSortingNumbers = new int[size];


		//VARIABLES
		Node temparoryIndexOfArrayHeadNode2 = headNode;
		int arrayIndex = 0;


		//ADDING LIST'S numberS INTO ARRAY
		while(temparoryIndexOfArrayHeadNode2.nextNode != null)
		{				
			temparoryIndexOfArrayHeadNode2 = temparoryIndexOfArrayHeadNode2.nextNode;
			arrayForSortingNumbers[arrayIndex] = temparoryIndexOfArrayHeadNode2.number;				
			arrayIndex++;
		}


		//SORTING ARRAY AND ADDING INTO FILE
		for(int arrayIndex2=0; arrayIndex2<arrayForSortingNumbers.length; arrayIndex2++)
		{
			for(int arrayIndex3=arrayIndex2+1; arrayIndex3<arrayForSortingNumbers.length; arrayIndex3++)
			{
				if(arrayForSortingNumbers[arrayIndex2] > arrayForSortingNumbers[arrayIndex3])
				{
					int temparoryIndexValueSwapVairable = arrayForSortingNumbers[arrayIndex2];
					arrayForSortingNumbers[arrayIndex2] = arrayForSortingNumbers[arrayIndex3];
					arrayForSortingNumbers[arrayIndex3] = temparoryIndexValueSwapVairable;		
				}						
			}
		}


		//WRITING SORTED ARRAY INTO FILE
		for(int index=0; index<size; index++)
		{
			bufferWriterObject.newLine();
			bufferWriterObject.write(String.valueOf(arrayForSortingNumbers[index]));
		}


		//BUFFERWRITER FLUSH AND THEN CLOSED
		bufferWriterObject.flush();
		bufferWriterObject.close();		
	}


	//INSERT ITEM ON POSITION
	void insert(int position,int addingNumber)
	{
		//VARIABLES
		Node newNodeNumber = new Node();
		newNodeNumber.number = addingNumber;
		newNodeNumber.nextNode = null;
		Node temparoryIndexoraryHeadNode = headNode;


		for(int iter=0; iter<(position); iter++)
		{
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
		}


		newNodeNumber.nextNode = temparoryIndexoraryHeadNode.nextNode;
		temparoryIndexoraryHeadNode.nextNode = newNodeNumber;
		size++;
	}


	//POP METHOD
	int pop()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
			return -1;
		}
		else
		{	
			//VARIABLES
			int temparoryIndexaroryIter = 0;
			Node temparoryIndexaroryHead = headNode;


			for(temparoryIndexaroryIter=0; temparoryIndexaroryIter<size-1; temparoryIndexaroryIter++)
			{
				temparoryIndexaroryHead = temparoryIndexaroryHead.nextNode;
			}


			int returnNumber = temparoryIndexaroryHead.number;
			temparoryIndexaroryHead.nextNode = null;
			size--;
			return returnNumber;
		}
	}		


	//POP POSITION METHOD
	int pop(int position)
	{
		if(headNode.nextNode == null)
		{
			System.out.println("List is empty");
		}
		else
		{	
			//VARIABLES
			int temparoryIndexoraryIter = 0;
			Node temparoryIndexoraryHead = headNode;


			for(temparoryIndexoraryIter=0; temparoryIndexoraryIter<size; temparoryIndexoraryIter++)
			{
				if(temparoryIndexoraryIter == position)
				{
					temparoryIndexoraryHead = temparoryIndexoraryHead.nextNode;
					this.remove(temparoryIndexoraryHead.number);
					return temparoryIndexoraryHead.number;
				}
				temparoryIndexoraryHead = temparoryIndexoraryHead.nextNode;					
			}
			size--;
		}
		return -1;	
	}


	//HASHING INDEX FROM 0 TO 10 
	void createIndexes()
	{
		//VARIABLES
		int temparoryIndex = 0;
		indexNode temparoryIndexoraryHeadNode = headIndexNode;
		
		
		while(temparoryIndex < 11)
		{
			//temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			temparoryIndexoraryHeadNode.index = temparoryIndex;
			System.out.println("nnnnnnnn vvvv : "+temparoryIndexoraryHeadNode.number);
			System.out.println("iiiiiiii vvvv : "+temparoryIndexoraryHeadNode.index);
			temparoryIndexoraryHeadNode.nextNode = temparoryIndexoraryHeadNode;
			temparoryIndexoraryHeadNode = temparoryIndexoraryHeadNode.nextNode;
			temparoryIndex++;
		}		
	}
	
	
	//CREATING INDEX FOR HASHING
	int hashingIndexGeneration(int makeIndexOfNumber)
	{	return makeIndexOfNumber%11;	}
}


//HASHING FUNCTION CLASS
public class HashingFunction
{	
	//MAIN METHOD
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException,IOException
	{
		LinkList<Integer> numberData = new LinkList<Integer>();
		FileReader fileRead = new FileReader(new File("C:\\Users\\King\\eclipse-workspace\\SnakeAndLadderProgram\\TempFile.txt"));
		BufferedReader bufferFileRead = new BufferedReader(fileRead);
		String line = bufferFileRead.readLine();
		
		
		//CREATED INDEXES
		numberData.createIndexes();
		
		
		//SHOWING EMPTY LIST
		numberData.showNumberList();


		//ADDING FILE NUMBERS TO LINK LIST
		while(line != null) 
		{
			if(line != "")
			{
				int number = Integer.parseInt(line);
				int hashingIndex = numberData.hashingIndexGeneration(number);
				System.out.println("Hashing index : "+hashingIndex);
				//numberData.insert(hashingIndex,number);
				line = bufferFileRead.readLine();
			}
		}


		//BUFFER READER CLOSED
		bufferFileRead.close();


		//SHOWING LIST
		numberData.showNumberList();


		//SAVING ORDERED LIST IN SAME FILE
		numberData.showNumberList();
	}
}