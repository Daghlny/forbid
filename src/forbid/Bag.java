package forbid;

import java.util.Iterator;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Bag<Item>{
	public class Node{
		Item item;
		Node next;
		
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	private Node first;
	private Node node;
	private int N;
	public  Bag(){
		first=new Node();
	}
	
	public Node getNode(){
		return first;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return N;
	}
	public void add(Item item) throws Exception{
		Node second=new Node();
		second.item=item;		
		second.next=first.next;
		first.next=second;
		N++;
	}	
}

