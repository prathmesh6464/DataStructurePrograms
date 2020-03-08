package BankingCashCounter;


//PERSON Person
class Person
{
	int balanceCash = 100;
	Person nextPerson = null;
}


//QUEUE CLASS
class Queue<T>
{
	Person startRow = new Person();
	int size=0;


	//EMPTY QUEUE METHOD
	Person emptyQueue()
	{
		return startRow;
	}


	//ENQUEUE METHOD
	public void enQueue(int balanceCash)
	{
		//VARIABLES OF PERSON
		Person nextPersonInQueue = new Person();
		nextPersonInQueue.balanceCash = balanceCash;
		nextPersonInQueue.nextPerson = null;


		if(startRow.nextPerson == null )
		{
			startRow.nextPerson = nextPersonInQueue;
			size++;
		}
		else
		{
			Person temporaryStartRow = startRow;
			while(temporaryStartRow.nextPerson != null)
			{
				temporaryStartRow = temporaryStartRow.nextPerson;
				System.out.println("Queue is empty"+temporaryStartRow.balanceCash);
			}
			temporaryStartRow.nextPerson = nextPersonInQueue;
			size++;
		}
	}	
	

	//DEQUEUE METHOD
	public void deQueue()
	{
		if(startRow.nextPerson == null)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			startRow.nextPerson = startRow.nextPerson.nextPerson;
			size--;
		}
	}
	
	
	//METHOD OF SIZE
	int size()
	{
		return size;
	}


	//QUEUE EMPTY OR NOT
	void isEmpty()
	{
		if(size == 0)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			System.out.println("Queue is Not empty");
		}
	}
}


//BANKING CASH COUNTER
public class BankingCashCounter 
{
	//MAIN CLASS
	public static void main(String[] args) 
	{
		Queue newPerson = new Queue();


		//EMPTY QUEUE METHOD CALLED
		newPerson.emptyQueue();
		
		
		//ENQUEUE METHOD CALLED
		newPerson.enQueue(1008);
		
		
		//DEQUEUE METHOD CALLED
		newPerson.deQueue();
		
		
		//IS EMPTY QUEUE METHOD CALLED
		newPerson.isEmpty();
		
		
		//SIZE METHO CALLED
		System.out.println(newPerson.size());
	}
}
