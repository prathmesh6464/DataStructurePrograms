package BankingCashCounter;


//PERSON NODE
class Person
{
	int balanceCash = 100;
	Person nextPerson = null;
}


//QUEUE CLASS
class Queue
{
	Person startRow = new Person();
	
	
	//EMPTY QUEUE METHOD
	Person emptyQueue()
	{
		return startRow;
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
	}
}
