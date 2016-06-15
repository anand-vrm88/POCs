package org.anverm.datastructures.list;

import org.anverm.datastructures.list.exceptions.MyInvalidIndexException;

public interface MyList {
	void add(int data);
	void addFront(int data);
	void add(int index, int data) throws MyInvalidIndexException;
	
	int get(int index) throws MyInvalidIndexException;
	
	int remove();
	int removeFront();
	int remove(int index) throws MyInvalidIndexException;
	
	int update(int index, int data) throws MyInvalidIndexException;
	
	int size();
}
