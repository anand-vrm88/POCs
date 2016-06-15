package org.anverm.datastructures;

import java.util.LinkedList;

import org.anverm.datastructures.MyLinkedList1.Node;

public class LinkedListDemo {

	public static void main(String[] args) {
		MyLinkedList1 linkedList = new MyLinkedList1();
/*		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		linkedList.head.next = second;
		second.next = third;*/
		
/*		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.addFront(4);
		linkedList.add(5);
		linkedList.addFront(6);
		linkedList.addAt(2, 7);*/
		linkedList.addAt(0, 8);
		linkedList.addAt(0, 9);
		//System.out.println("size = "+linkedList.getSizeRecAlgo());
		
		linkedList.printAll();
		System.out.println("");
		linkedList.reverseRecursive();
		linkedList.printAll();
	}
	
	MyLinkedList1 mergeSortedList(MyLinkedList1 a, MyLinkedList1 b){
		MyLinkedList1 result = new MyLinkedList1();
		if(a.getSize() == 0 && b.getSize() == 0){
			return result;
		}
		
		if(a.getSize() == 0){
			
		}
		
		return result;
	}

}


class MyLinkedList1 {
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			
		}

	}
	
	void printAll(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	void add(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node temp = head;
		
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = new Node(data);
	}
	
	void addFront(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node temp = head;
		
		temp = new Node(data);
		
		temp.next = head;
		head = temp;
	}
	
	void addAt(int index, int data){
		if(index < 0){
			System.out.println("throws invalid index exception");
		}
		
		if(head == null){
			if(index == 0){
				head = new Node(data);
				return;
			} else {
				System.out.println("throws invalid index exception");
			}
		}
		
		Node temp1 = head;
		Node temp2 = temp1;
		
		for(int i = 0; i < index; i++){
			if(temp1 == null){
				//TODO: throw exception.
				System.out.println("throws invalid index exception");
				return;
			}
			temp2 = temp1;
			temp1 = temp1.next;
		}
		
		if(temp1 == temp2){
			head = new Node(data);
			head.next = temp1;
		} else {
			temp2.next = new Node(data);
			temp2.next.next = temp1;
		}
	}
	
	int getSize(){
		if(head == null){
			return 0;
		}
		
		Node temp = head;
		int size = 0;
		while(temp != null){
			temp = temp.next;
			size++;
		}
		return size;
	}
	
	int getSizeRecAlgo(){
		return getSizeRec(head);
	}
	
	int getSizeRec(Node temp){
		if(temp == null){
			return 0;
		}
		
		return 1 + getSizeRec(temp.next);
	}
	
	void reverseIterative(){
		if(head == null){
			return;
		}
		
		if(head.next == null){
			return;
		}
		
		Node temp1 = null;
		Node temp2 = head;
		Node temp3 = head.next;
		
		while(temp2 != null){
			temp2.next = temp1;
			temp1 = temp2;
			temp2 = temp3;
			if(temp3 != null){
				temp3 = temp3.next;
			}
		}
		
		head = temp1;
	}
	
	void reverseRecursive(){
		if(head == null || head.next == null){
			return;
		}
		Node temp = head;
		Node next = revRec(temp);
		next = temp;
	}
	
	Node revRec(Node temp){
		if(temp.next == null){
			head = temp;
			return temp.next;
		}
		Node next = revRec(temp.next);
		next = temp;
		return temp.next;
	}
	
}


