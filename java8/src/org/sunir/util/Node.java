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
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}
