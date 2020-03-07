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

	
	//EMPTY LIST METHOD
	Node emptyList()
	{
		return headNode;
	} 
}
