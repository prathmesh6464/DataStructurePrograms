//NODE CLASS
class Node
{
	String word;
	Node next=null;
}


//LINK LIST CLASS
class LinkList
{
	Node emptyList()
	{
		Node head = new Node();
		return head.next;
	}
}


//UNORDERED LIST CLASS
class UnOrderedListFeature
{
	//MAIN FUNCTION
	public static void main(String[] args)
	{
		LinkList linkListFeatures = new LinkList();
		Node returnedEmptyResult = linkListFeatures.emptyList();
		System.out.println("Empty list : "+returnedEmptyResult);
	}
}