package org.sunir.util;

public class Node<T> {
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
