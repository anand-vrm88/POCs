package org.anverm.datastructures.list.impl;

import org.anverm.datastructures.list.MyList;
import org.anverm.datastructures.list.exceptions.MyInvalidIndexException;

public class MyLinkedList implements MyList {
	private Node head;
	
	public void add(int data) {
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

	public void addFront(int data) {
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	public void add(int index, int data) throws MyInvalidIndexException {
		if(head == null){
			if(index == 0){
				head = new Node(data);
				return;
			} else {
				throw new MyInvalidIndexException();
			}
		}

		if(index == 0){
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
			return;
		}
		
		Node curr = head;
		Node prev = null;
		
		for(int i = 1; i < index; i++){
			prev = curr;
			if(curr.next == null){
				throw new MyInvalidIndexException();
			} else {
				curr = curr.next;
			}
		}
		
		prev.next = new Node(data);
		prev.next.next = curr;
	}

	public int get(int index) throws MyInvalidIndexException {
		if(index < 0){
			throw new MyInvalidIndexException();
		}
		
		if(head == null){
			throw new MyInvalidIndexException();
		}
		
		Node temp = head;
		
		for(int i = 0; i < index; i++){
			if(temp.next == null){
				throw new MyInvalidIndexException();
			} else {
				temp = temp.next;
			}
		}
		return temp.data;
	}

	public int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeFront() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(int index) throws MyInvalidIndexException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int index, int data) throws MyInvalidIndexException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int size(){
		if(head == null){
			return 0;
		}
		
		Node temp = head;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.next;
		}
		
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(head == null){
			return sb.toString();
		}
		
		Node temp = head;
		while(temp != null){
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		
		return sb.toString();
	}

	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
