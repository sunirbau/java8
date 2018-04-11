package org.sunir.util;

import java.util.EmptyStackException;

public class Stack <T> { 
	private LinkedList<T> stack = new LinkedList<T>();
	
	public void push(T t){
		stack.add(t);
	}
	
	public T pop(){
		if(size() == 0){
			throw new EmptyStackException();
		}
		return stack.remove(size()-1);
		
	}
	
	public T peek(){
		if(size() == 0){
			throw new EmptyStackException();
		}
		return stack.get(size()-1);
		
	}
	
	public int size(){
		return stack.size();
	}

}
