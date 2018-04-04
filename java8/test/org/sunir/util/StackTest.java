package org.sunir.util;


import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;


public class StackTest {
	
	private Stack<String> stack = new Stack<String>();
	String FIRST = "first";
	String SECOND = "second";
	String THIRD = "third";
	
	
	@Test(expected = EmptyStackException.class)
	public void testEmptyStackPop() throws Exception {
		stack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testEmptyStackPeek() throws Exception {
		stack.peek();
	}
	
	@Test
	public void testEmptyStackPush() throws Exception {
		stack.push(FIRST);
		assertEquals(1, stack.size());
	}
	
	@Test
	public void testPushPopPeek() throws Exception {
		stack.push(FIRST);
		stack.push(SECOND);
		stack.push(THIRD);
		assertEquals(THIRD, stack.peek());
		assertEquals(THIRD, stack.pop());
		assertEquals(SECOND, stack.peek());
		assertEquals(SECOND, stack.pop());
		assertEquals(FIRST, stack.peek());
		assertEquals(FIRST, stack.pop());
		assertEquals(0, stack.size());
	}
	
	
	


}
