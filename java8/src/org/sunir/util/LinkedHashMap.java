package org.sunir.util;

import java.util.NoSuchElementException;

public class LinkedHashMap<K,V> {

	private NodeKeyValue<K,V> head = new NodeKeyValue<K,V>();
	private int size = 0;

	public void put(K key, V value){
		NodeKeyValue<K,V> current = head;
		for (int index = 0 ; index < size ; index++){
			current = current.next;
		}
		current.next = new NodeKeyValue<K, V>(key, value);
		size++;
	}

	public V get(K key){
		NodeKeyValue<K,V> current = head;
		for (int index = 0 ; index < size ; index++){
			current = current.next;
			if(current.getKey().equals(key)){
				return current.getValue();
			}
		}
		return null;
	}
	
	public void remove(K key){
		NodeKeyValue<K,V> current = head;
		for (int index = 0 ; index < size ; index++){
			if(current.next != null && current.next.getKey().equals(key)){
				current.next = current.next.next;
				size --;
				return;
			}
			current = current.next;
		}
		throw new NoSuchElementException();
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String toString(){
		NodeKeyValue<K,V> current = head;
		StringBuilder builder = new StringBuilder("{");
		for(int i = 0; i< size; i++){
			current = current.next;
			builder.append(i == 0 ? "" : ", ");
			builder.append(current.getKey()).append("=").append(current.getValue());
		}
		builder.append("}");
		return builder.toString();
	}

}
