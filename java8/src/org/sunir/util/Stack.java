package org.sunir.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack <T extends Serializable> { 
	private List<T> stack = new ArrayList<T>();
	
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
