package org.sunir.util;

public class NodeKeyValue<K, V> {
	NodeKeyValue<K, V> next = null;
	K key = null;
	V value = null;
	
	
	
	public NodeKeyValue() {
		super();
	}
	
	
	public NodeKeyValue(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}


	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	

}
