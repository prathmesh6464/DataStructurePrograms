package BankingCashCounter;
import java.util.Scanner;


//PERSON NODE
class Person
{
	int balanceCash = 100;
	Person nextPerson = null;
}


//QUEUE CLASS
class Queue<T>
{
	Person startRow = new Person();
	static int size = 0;


	//EMPTY QUEUE METHOD
	Person emptyQueue()
	{
		return startRow;
	}


	//ENQUEUE METHOD
	public void enQueue()
	{
		//VARIABLES OF PERSON
		Person nextPersonInQueue = new Person();
		nextPersonInQueue.balanceCash = 100;
		nextPersonInQueue.nextPerson = null;


		if(startRow.nextPerson == null )
		{
			startRow.nextPerson = nextPersonInQueue;
			size++;
		}
		else
		{
			Person temparoryStartRow = startRow;
			while(temparoryStartRow.nextPerson != null)
			{
				temparoryStartRow = temparoryStartRow.nextPerson;
			}
			temparoryStartRow.nextPerson = nextPersonInQueue;
			size++;
		}
	}	


	//DEQUEUE METHOD REMOVE FRONT PERSON
	void deQueue()
	{
		if(size == 0)
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


	//METHOD TO SHOW STACK
	public void showQueue()
	{
		//VARIABLE
		Person temporaryHeadNode = startRow;


		while(temporaryHeadNode.nextPerson != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextPerson;
		}
	}
}


//BANKING CASH COUNTER
public class BankingCashCounter 
{
	//MAIN CLASS
	public static void main(String[] args) 
	{
		double cashCounterBalanceMoney = 5000.00;
		Queue<Integer> newPerson = new Queue<Integer>();
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("What is queue capacity of bank ?");
		int queueCapacity = scannerObject.nextInt();


		for(int capacityIter=0; capacityIter<queueCapacity; capacityIter++)
		{
			newPerson.enQueue();
		}


		newPerson.showQueue();
		while(true)
		{
			System.out.println("Do you want to withdraw or deposite ?");
			System.out.println("Input 1 for withdraw");
			System.out.println("Input 2 for deposite");
			int choiceWithdrawOrDeposite = scannerObject.nextInt();


			switch(choiceWithdrawOrDeposite)
			{
			case 1:
				System.out.println("Enter amount do you to withdraw ?");
				double amountWithdraw = scannerObject.nextInt();
				cashCounterBalanceMoney = cashCounterBalanceMoney - amountWithdraw;
				System.out.println("Bank total amout : "+cashCounterBalanceMoney);


				newPerson.deQueue();


				System.out.println(newPerson.size()+" Peoples are in row");
				queueCapacity--;
				break;

			case 2:
				System.out.println("Enter amount do you to deposite ?");
				double amountDeposite = scannerObject.nextInt();					
				cashCounterBalanceMoney = cashCounterBalanceMoney + amountDeposite;
				System.out.println("Bank total amout : "+cashCounterBalanceMoney);


				newPerson.deQueue();


				System.out.println(newPerson.size()+" Peoples are in row");
				queueCapacity--;
				break;

			default:
				System.out.println("Invalid input");
			}	


			if(cashCounterBalanceMoney <= 0)
			{
				System.out.println("Insufficient balance in bank");
				break;				
			}
			
			
			if(queueCapacity <= 0) 
			{
				System.out.println("Row is empty");
				break;
			}
		}
	}	
}

