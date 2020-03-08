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
			startRow.nextPerson = nextPersonInQueue.nextPerson;
			size++;
		}
		else
		{
			Person temparoryStartRow = startRow.nextPerson;
			while(temparoryStartRow.nextPerson != null)
			{
				temparoryStartRow = temparoryStartRow.nextPerson;
				System.out.println("Queue is empty"+temparoryStartRow.balanceCash);
			}
			temparoryStartRow.nextPerson = nextPersonInQueue;
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
			Person temparoryStart = startRow.nextPerson;
			startRow.nextPerson = temparoryStart.nextPerson;
		}
	}
	
	
	//METHOD OF SIZE
	public int size()
	{
		return size;
	}


	//QUEUE EMPTY OR NOT
	public void isEmpty()
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
		Queue<Integer> newPerson = new Queue<Integer>();


		//EMPTY QUEUE METHOD CALLED
		newPerson.emptyQueue();
		
		
		//ENQUEUE METHOD CALLED
		newPerson.enQueue(1008);
		newPerson.enQueue(1008);
		newPerson.enQueue(1008);
		
		
		//DEQUEUE METHOD CALLED
		newPerson.deQueue();
		newPerson.deQueue();
		
		
		//IS EMPTY QUEUE METHOD CALLED
		newPerson.isEmpty();
		
		
		//SIZE METHO CALLED
		System.out.println(newPerson.size());
	}
}
