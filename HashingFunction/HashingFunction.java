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
	Node nextNode = null;
} 


//CREATING LINK LIST CLASS
class LinkList<T>
{
	//headNode NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


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
		addingNumberNewNode.number = number;
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
				Node temporaryHeadNode = headNode;
				while(temporaryHeadNode.nextNode != null)
				{
					temporaryHeadNode = temporaryHeadNode.nextNode;
				}
				temporaryHeadNode.nextNode = addingNumberNewNode;
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
		Node temporaryHeadNode = headNode;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			if(temporaryHeadNode.number == findNumber)
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
		Node temporaryHeadNode = headNode;
		int isMatches = 0;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			if(temporaryHeadNode.number == findNumber)
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
				Node previousTemporaryHeadNode = headNode;			
				Node temporaryHeadNode = headNode.nextNode;


				while(temporaryHeadNode.number != removeNumber)
				{

					previousTemporaryHeadNode = temporaryHeadNode;
					temporaryHeadNode = temporaryHeadNode.nextNode;
				}


				System.out.println("Deleted word : "+temporaryHeadNode.number);
				previousTemporaryHeadNode.nextNode = previousTemporaryHeadNode.nextNode.nextNode;
				size--;
			}
			catch(NullPointerException e) 
			{
				System.out.println("Word deletion operation completed.");
			}
		}
	}


	//METHOD TO SHOW LIST
	public void showNumberList()
	{
		//VARIABLES
		Node temporaryHeadNode = headNode;


		if(temporaryHeadNode.nextNode == null)
		{
			System.out.println("List is empty");
		}


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			System.out.println(temporaryHeadNode.number);
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
		int temp = 0;
		Node temporaryHeadNode = headNode.nextNode;


		while(temporaryHeadNode != null)
		{
			if(findIndexOfNumber == temporaryHeadNode.number)
			{
				return temp;
			}	
			System.out.println(temporaryHeadNode.number);
			temporaryHeadNode = temporaryHeadNode.nextNode;
			temp++;
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
		Node temporaryHeadNode2 = headNode;
		int arrayIndex = 0;


		//ADDING LIST'S numberS INTO ARRAY
		while(temporaryHeadNode2.nextNode != null)
		{				
			temporaryHeadNode2 = temporaryHeadNode2.nextNode;
			arrayForSortingNumbers[arrayIndex] = temporaryHeadNode2.number;				
			arrayIndex++;
		}


		//SORTING ARRAY AND ADDING INTO FILE
		for(int arrayIndex2=0; arrayIndex2<arrayForSortingNumbers.length; arrayIndex2++)
		{
			for(int arrayIndex3=arrayIndex2+1; arrayIndex3<arrayForSortingNumbers.length; arrayIndex3++)
			{
				if(arrayForSortingNumbers[arrayIndex2] > arrayForSortingNumbers[arrayIndex3])
				{
					int temparorySwapVairable = arrayForSortingNumbers[arrayIndex2];
					arrayForSortingNumbers[arrayIndex2] = arrayForSortingNumbers[arrayIndex3];
					arrayForSortingNumbers[arrayIndex3] = temparorySwapVairable;		
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
		Node temporaryHeadNode = headNode;


		for(int iter=0; iter<(position); iter++)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
		}


		newNodeNumber.nextNode = temporaryHeadNode.nextNode;
		temporaryHeadNode.nextNode = newNodeNumber;
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
			int temparoryIter = 0;
			Node temparoryHead = headNode;


			for(temparoryIter=0; temparoryIter<size-1; temparoryIter++)
			{
				temparoryHead = temparoryHead.nextNode;
			}

			int returnNumber = temparoryHead.number;
			temparoryHead.nextNode = null;
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
			int temporaryIter = 0;
			Node temporaryHead = headNode;


			for(temporaryIter=0; temporaryIter<size; temporaryIter++)
			{
				if(temporaryIter == position)
				{
					temporaryHead = temporaryHead.nextNode;
					this.remove(temporaryHead.number);
					return temporaryHead.number;
				}
				temporaryHead = temporaryHead.nextNode;					
			}
			size--;
		}
		return -1;	
	}
}


//ORDERED LIST CLASS
public class HashingFunction
{	
	//MAIN METHOD
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException,IOException
	{
		LinkList<Integer> numberData = new LinkList<Integer>();
		FileReader fileRead = new FileReader(new File("C:\\Users\\King\\eclipse-workspace\\SnakeAndLadderProgram\\TempFile.txt"));
		BufferedReader bufferFileRead = new BufferedReader(fileRead);
		String line = bufferFileRead.readLine();

		//SHOWING EMPTY LIST
		numberData.showNumberList();


		//ADDING FILE NUMBERS TO LINK LIST
		while(line != null) 
		{
			int number = Integer.parseInt(line);
			numberData.append(number);
			line = bufferFileRead.readLine();
		}


		//BUFFER READER CLOSED
		bufferFileRead.close();


		//SHOWING LIST
		numberData.showNumberList();


		//TAKING USER INPUT TO DELETE THAT NUMBER OR ADDING INTO LIST
		int findNumber = numberData.takeInput();


		//CHECKING NUMBER IS PRESENT OR NOT THEN ADD INTO FILE OR DELETE THAT NUMBER
		numberData.isNumberPresent(findNumber);


		//SAVING ORDERED LIST IN SAME FILE
		numberData.saveIntoSameFile();
	}
}
