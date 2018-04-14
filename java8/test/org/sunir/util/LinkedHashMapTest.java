package org.sunir.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
	
	@Test(expected = NoSuchElementException.class)
	public void testLinkedHashMapRemove() throws Exception {
		testLinkedHashMapPut();
		linkedHashMap.remove(FIRST);
		linkedHashMap.remove(SECOND);
		linkedHashMap.remove(THIRD);
		linkedHashMap.remove(FOURTH);
		linkedHashMap.remove(FIFTH);
		linkedHashMap.remove(SIXTH);
		assertEquals(getMapString(new String[]{},new Integer[]{}),
				linkedHashMap.toString());	
		linkedHashMap.remove(FIRST);
	}

	
	@Test
	public void testLinkedGet() throws Exception {
		testLinkedHashMapPut();
		assertEquals(one, linkedHashMap.get(FIRST));
		assertEquals(two, linkedHashMap.get(SECOND));
		assertEquals(three, linkedHashMap.get(THIRD));
		assertEquals(four, linkedHashMap.get(FOURTH));
		assertEquals(five, linkedHashMap.get(FIFTH));
		assertEquals(six, linkedHashMap.get(SIXTH));
		assertNull(linkedHashMap.get("seventh"));
	}
	

	

}
