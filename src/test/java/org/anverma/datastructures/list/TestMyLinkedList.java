package org.anverma.datastructures.list;

import static org.junit.Assert.*;

import org.anverm.datastructures.list.exceptions.MyInvalidIndexException;
import org.anverm.datastructures.list.impl.MyLinkedList;
import org.junit.Test;

public class TestMyLinkedList {

	@Test
	public void testAdd() {
		MyLinkedList list = new MyLinkedList();
		try {
			list.add(2, 13);
			assertTrue(false);
		} catch (MyInvalidIndexException e) {
			assertTrue(true);
		}
		
		try {
			list.add(0, 15);
			assertTrue(true);
		} catch (MyInvalidIndexException e) {
			assertTrue(false);
		}
		
		list.add(3);
		list.add(9);
		list.add(7);
		list.add(11);
		System.out.println(list);
		assertEquals(5, list.size());
		
		list.addFront(19);
		System.out.println(list);
		assertEquals(6, list.size());
		
		try {
			list.add(8, 17);
			assertTrue(false);
		} catch (MyInvalidIndexException e) {
			assertTrue(true);
		}
		
		try {
			list.add(2, 17);
			assertTrue(true);
		} catch (MyInvalidIndexException e) {
			assertTrue(false);
		}
	}

}
