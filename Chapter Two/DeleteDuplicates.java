/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
	int data;
	Node next;
	Node(int x){
		this.data = x;
		this.next = null;
	}
}

class SLL{
	Node head;
	SLL(){
		this.head = null;
	}
	public void add(int x){
		Node newNode = new Node(x);
		if(head==null){
			head = newNode;
		}
		else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	void print(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	void DeleteDups(){
		Node temp = head;
		HashSet<Integer> hs = new HashSet<Integer>();
		Node previous = null;
		while(temp!=null){
			if(hs.contains(temp.data)){
				previous.next = temp.next;
			}
			else{
				hs.add(temp.data);
				previous = temp;
			}
			temp = temp.next;
		}
	}
	void DeleteDupsWithoutBuffer(){
		Node temp = head;
		while(temp!=null){
			Node runner = temp;
			while(runner.next!=null){
				if(temp.data!=runner.next.data){
					runner = runner.next;
				}
				else{
					runner.next = runner.next.next;
				}
			}
			temp = temp.next;
		}
	}
}

public class DeleteDuplicates
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		SLL ll = new SLL();
		ll.add(5);
		ll.add(6);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.print();
		System.out.println();
		ll.DeleteDupsWithoutBuffer();
		//ll.DeleteDups();
		ll.print();
	}
}
