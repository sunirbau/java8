package org.sunir.util;

import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> {
	
	private Node<T> head = new Node<T>();
	private int size = 0;
	
	
	public T get(int index){
		Node<T> current = head;
		if(index > size - 1 || index < 0){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 0; i<= index; i ++){
			current = current.next;
		}
		return current.getT();
	}
	
	public void add(T t, int index){
		Node<T> current = head;
		Node<T> add = new Node<T>(t);
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 0; i< index; i ++){
			current = current.next;
		}
		add.next = current.next;
		current.next = add;
		size++;	
	}
	
	public void add(T t){
		Node<T> current = head;
		for(int i =0; i< size; i++){
			current = current.next;
		}
		current.next = new Node<T>(t);
		size ++;
	}
	
	public void remove(T t){
		Node<T> current = head;
		for(int i = 0; i< size; i ++){
			if(current.next != null && current.next.getT().equals(t)){
				current.next = current.next.next;	
				size --;
				return;
			}
			current = current.next;
		}
		throw new NoSuchElementException();
		
	}
	
	public T remove(int index){
		Node<T> current = head;
		if(index > size -1 || index < 0){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 0; i< index; i ++){
			current = current.next;
		}
		Node<T> remove = current.next;
		current.next = current.next.next;	
		size --;
		return remove.getT();
	}
	
	public List<T> getAll(){
		java.util.LinkedList<T> list = new java.util.LinkedList<T>();
		Node<T> current = head;
		for(int i = 0; i< size; i ++){
			current = current.next;
			list.add(current.getT());
		}
		return list;
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String toString(){
		return getAll().toString();
	}

	
}
