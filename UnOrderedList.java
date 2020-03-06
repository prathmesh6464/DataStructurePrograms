class Node
{
	String word;
	Node next=null;
}


class LinkList
{
	Node emptyList()
	{
		Node head = new Node();
		return head.next;
	}
}


class UnOrderedList
{
	public static void main(String[] args)
	{
		LinkList linkListFeatures = new LinkList();
		Node returnedEmptyResult = linkListFeatures.emptyList();
		System.out.println("Empty list : "+returnedEmptyResult);
	}
}