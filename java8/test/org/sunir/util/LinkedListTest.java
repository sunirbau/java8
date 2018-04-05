package org.sunir.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {
	
	private LinkedList<String> linkedList = new LinkedList<String>();
	String FIRST = "first";
	String SECOND = "second";
	String THIRD = "third";
	String FOURTH = "fourth";
	String FIFTH = "fifth";
	String SIXTH = "sixth";
	
	
	@Test
	public void testLinkedListAdd() throws Exception {
		linkedList.add(FIRST);
		linkedList.add(SECOND);
		linkedList.add(THIRD);
		linkedList.add(FOURTH);
		linkedList.add(FIFTH);
		linkedList.add(SIXTH);
		assertEquals(getListString(FIRST, SECOND, THIRD,FOURTH, FIFTH,SIXTH),
				linkedList.toString());	
	}
	
	@Test
	public void testLinkedListRemove() throws Exception {
		testLinkedListAdd();
		linkedList.remove(FIRST);
		linkedList.remove(SECOND);
		linkedList.remove(THIRD);
		linkedList.remove(FOURTH);
		linkedList.remove(FIFTH);
		linkedList.remove(SIXTH);
		assertEquals(getListString(),
				linkedList.toString());	
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testLinkedListAddAtIndex() throws Exception {
		linkedList.add(SECOND);
		linkedList.add(FOURTH);
		linkedList.add(FIRST, 0);
		linkedList.add(THIRD, 2);
		linkedList.add(FIFTH, 4);
		linkedList.add(SIXTH, 5);
		assertEquals(getListString(FIRST, SECOND, THIRD,FOURTH, FIFTH,SIXTH),
				linkedList.toString());	
		linkedList.add("seven", 7);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testLinkedListRemoveAtIndex() throws Exception {
		testLinkedListAdd();
		linkedList.remove(5);
		assertEquals(getListString(FIRST, SECOND, THIRD,FOURTH, FIFTH),
				linkedList.toString());	
		linkedList.remove(2);
		assertEquals(getListString(FIRST, SECOND,FOURTH, FIFTH),
				linkedList.toString());
		linkedList.remove(3);
		assertEquals(getListString(FIRST, SECOND, FOURTH),
				linkedList.toString());
		linkedList.remove(1);
		assertEquals(getListString(FIRST,FOURTH),
				linkedList.toString());
		linkedList.remove(0);
		assertEquals(getListString(FOURTH),
				linkedList.toString());
		
		linkedList.remove(1);
		
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testLinkedGet() throws Exception {
		testLinkedListAdd();
		assertEquals(FIRST, linkedList.get(0));
		assertEquals(SECOND, linkedList.get(1));
		assertEquals(THIRD, linkedList.get(2));
		assertEquals(FOURTH, linkedList.get(3));
		assertEquals(FIFTH, linkedList.get(4));
		assertEquals(SIXTH, linkedList.get(5));
	}
	
	
	
	private String getListString(String...strings){
		List<String> list = Arrays.asList(strings);
		return list.toString();	
	}
}
