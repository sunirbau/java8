package org.sunir.util;

import java.util.List;

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
				break;
			}
			current = current.next;
		}
		
	}
	
	public void remove(int index){
		Node<T> current = head;
		if(index > size -1 || index < 0){
			throw new IndexOutOfBoundsException();
		}
		for(int i = 0; i< index; i ++){
			current = current.next;
		}
		current.next = current.next.next;	
		size --;
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
	
	@Override
	public String toString(){
		return getAll().toString();
	}

}


  class Node<T> {
	Node<T> next = null;
	T t = null;
	
	public Node(T t) {
		super();
		this.t = t;
	}
	public Node() {
		super();
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	
	
	
}
