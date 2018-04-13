package org.sunir.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class LinkedHashMapTest {
	
	private LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
	String FIRST = "first";    Integer one = 1;
	String SECOND = "second";  Integer two = 2;
	String THIRD = "third"; Integer three = 3;
	String FOURTH = "fourth"; Integer four = 4;
	String FIFTH = "fifth"; Integer five = 5;
	String SIXTH = "sixth"; Integer six = 6;
	
	
	@Test
	public void testLinkedHashMapPut() throws Exception {
		linkedHashMap.put(FIRST, one);
		linkedHashMap.put(SECOND, two);
		linkedHashMap.put(THIRD, three);
		linkedHashMap.put(FOURTH, four);
		linkedHashMap.put(FIFTH, five);
		linkedHashMap.put(SIXTH, six);
		String mapString = getMapString(new String[]{FIRST,SECOND,THIRD,FOURTH,FIFTH,SIXTH},new Integer[]{one,two,three,four,five,six});
		assertEquals(mapString, linkedHashMap.toString());	
	}


	private String getMapString(String[] keys, Integer[] values) {
		List<String> keysList = Arrays.asList(keys);
		List<Integer> valuesList = Arrays.asList(values);
		Map<String, Integer> sorted = new java.util.LinkedHashMap<>();
		Map<String, Integer> collect = IntStream.range(0, keysList.size()).boxed()
        .collect(Collectors.toMap(i -> keysList.get(i), i -> valuesList.get(i)));
		collect.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		return sorted.toString();
	}
	
//	@Test
//	public void testLinkedListRemove() throws Exception {
//		testLinkedHashMapPut();
//		linkedHashMap.remove(FIRST);
//		linkedHashMap.remove(SECOND);
//		linkedHashMap.remove(THIRD);
//		linkedHashMap.remove(FOURTH);
//		linkedHashMap.remove(FIFTH);
//		linkedHashMap.remove(SIXTH);
//		assertEquals(getListString(),
//				linkedHashMap.toString());	
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testLinkedListAddAtIndex() throws Exception {
//		linkedHashMap.add(SECOND);
//		linkedHashMap.add(FOURTH);
//		linkedHashMap.add(FIRST, 0);
//		linkedHashMap.add(THIRD, 2);
//		linkedHashMap.add(FIFTH, 4);
//		linkedHashMap.add(SIXTH, 5);
//		assertEquals(getListString(FIRST, SECOND, THIRD,FOURTH, FIFTH,SIXTH),
//				linkedHashMap.toString());	
//		linkedHashMap.add("seven", 7);
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testLinkedListRemoveAtIndex() throws Exception {
//		testLinkedHashMapPut();
//		linkedHashMap.remove(5);
//		assertEquals(getListString(FIRST, SECOND, THIRD,FOURTH, FIFTH),
//				linkedHashMap.toString());	
//		linkedHashMap.remove(2);
//		assertEquals(getListString(FIRST, SECOND,FOURTH, FIFTH),
//				linkedHashMap.toString());
//		linkedHashMap.remove(3);
//		assertEquals(getListString(FIRST, SECOND, FOURTH),
//				linkedHashMap.toString());
//		linkedHashMap.remove(1);
//		assertEquals(getListString(FIRST,FOURTH),
//				linkedHashMap.toString());
//		linkedHashMap.remove(0);
//		assertEquals(getListString(FOURTH),
//				linkedHashMap.toString());
//		
//		linkedHashMap.remove(1);
//		
//	}
//	
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testLinkedGet() throws Exception {
//		testLinkedHashMapPut();
//		assertEquals(FIRST, linkedHashMap.get(0));
//		assertEquals(SECOND, linkedHashMap.get(1));
//		assertEquals(THIRD, linkedHashMap.get(2));
//		assertEquals(FOURTH, linkedHashMap.get(3));
//		assertEquals(FIFTH, linkedHashMap.get(4));
//		assertEquals(SIXTH, linkedHashMap.get(5));
//		
//		linkedHashMap.get(6);
//	}
//	
//	
//	
//	private String getListString(String...strings){
//		List<String> list = Arrays.asList(strings);
//		return list.toString();	
//	}
	
	

}
