package org.sunir.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class Java8CollectionsTest {

	private List<User> users;
	private User one = new User("Atest@yopmail.com", 1);
	private User two = new User("Btest22@yopmail.com", 2);
	private User three = new User("Ctest333@yopmail.com", 3);
	private User four = new User("Dtest4444@yopmail.com", 4);
	private Map<Integer, String> usersMap;
	private Random random;
	
	@Before
	public void setup(){
		users = new LinkedList<User>();
		users.add(one);
		users.add(two);
		users.add(three);
		users.add(four);
		usersMap = users.stream().collect(Collectors.toMap(User :: getUserId, User :: getUserName));
		random = new Random();
		
	}
	
	
	@Test
	public void testSort() throws Exception {
		 Comparator<? super User> comparator = (x,y) -> x.getUserName().compareTo(y.getUserName());
		 Comparator<? super User> comparator2 = (x,y) -> y.getUserName().compareTo(x.getUserName());
		 users.sort(comparator);
		 assertEquals(one ,users.get(0));
		 users.sort(comparator.reversed());
		 assertEquals(four ,users.get(0));
		 users.sort(comparator2);
		 assertEquals(four ,users.get(0));
		 users.sort(comparator2.reversed());
		 assertEquals(one ,users.get(0));
		 users.forEach(x -> System.out.println(x.getUserName() + "-" + x.getUserId()));
	}
	

	@Test
	public void testFilter() throws Exception {
		List<User> result = users.stream().filter(x -> x.getUserId() > 2).collect(Collectors.toList());
		assertEquals(three, result.get(0));
		assertEquals(four, result.get(1));
		List<String> userNames = users.stream().filter(x -> x.getUserId() <= 2).map(User :: getUserName).collect(Collectors.toList());
		assertEquals(one.getUserName(), userNames.get(0));
		assertEquals(two.getUserName(), userNames.get(1));
		
	}
	
	@Test
	public void testMap() throws Exception {
		List<Integer> userIds = users.stream().map(x -> x.getUserId()).collect(Collectors.toList());
		assertTrue(one.getUserId() == userIds.get(0));
		assertTrue(two.getUserId() == userIds.get(1));
		assertTrue(three.getUserId() == userIds.get(2));
		assertTrue(four.getUserId() == userIds.get(3));
	}
	
	@Test
	public void testSortedMap() throws Exception {
		
		Map<Integer, String> result = usersMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap :: new ));
	    Iterator<Entry<Integer, String>> iterator = result.entrySet().iterator();
	    assertEquals(four.getUserName(), iterator.next().getValue());
	    assertEquals(three.getUserName(), iterator.next().getValue());
	    assertEquals(two.getUserName(), iterator.next().getValue());
	    assertEquals(one.getUserName(), iterator.next().getValue());
	    
	    List<Integer> keys = usersMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	    assertTrue(four.getUserId() ==  keys.get(0));
	    assertTrue(three.getUserId()  == keys.get(1));
	    assertTrue(two.getUserId() ==  keys.get(2));
	    assertTrue(one.getUserId() ==  keys.get(3));
	    
	    List<String> values = usersMap.values().stream().sorted().collect(Collectors.toList());
	    assertEquals(one.getUserName(),  values.get(0));
	    assertEquals(two.getUserName(), values.get(1));
	    assertEquals(three.getUserName(), values.get(2));
	    assertEquals(four.getUserName(), values.get(3));
	
	}
	
	@Test
	public void testArrayStream() throws Exception {
		String[] usernames = new String[]{one.getUserName(),two.getUserName(), three.getUserName(), four.getUserName()};
		Stream<String> stream = Arrays.stream(usernames);
		List<String> result = stream.filter(x -> x.matches(".*\\d+.*")).collect(Collectors.toList());
		assertEquals(two.getUserName(),result.get(0));
		assertEquals(three.getUserName(),result.get(1));
		assertEquals(four.getUserName(),result.get(2));
		
		Supplier<Stream<String>> streamSupplier = () -> Stream.of(usernames);
		List<String> collect = streamSupplier.get().filter(x -> x.matches("\\D+")).collect(Collectors.toList());
		assertEquals(one.getUserName(), collect.get(0));
		assertEquals(1, collect.size());
		List<String> collect2 = streamSupplier.get().filter(x -> x.contains("B")).collect(Collectors.toList());
		assertEquals(two.getUserName(), collect2.get(0));
		assertEquals(1, collect2.size());
	
	}
	
	@Test
	public void testRandom() throws Exception {
		List<Integer> collect = random.ints(20, 5, 10).boxed().collect(Collectors.toList());
		collect.forEach(x -> assertTrue(x >= 5 && x < 10));
		List<Integer> collect2 = random.ints(20, 5, 10 +1 ).boxed().collect(Collectors.toList());
		collect2.forEach(x -> assertTrue(x >= 5 && x <= 10));
	}
	
	@Test
	public void testStringJoiner() throws Exception {
		String delimiter = ", ";
		StringJoiner sj = new StringJoiner(delimiter);
		Supplier<Stream<User>> streamSupplier = ()-> users.stream();
		List<String> collect = streamSupplier.get().map(User :: getUserName).collect(Collectors.toList());
		collect.forEach(x ->  sj.add(x.toString()));
	    String joined = streamSupplier.get().map(User :: getUserName).collect(Collectors.joining(delimiter));
		assertEquals(joined, sj.toString());
	}
	
	@Test
	public void testMatch() throws Exception {
		boolean anyMatch = users.stream().anyMatch(x -> x.getUserId() > 4);
		assertFalse(anyMatch);
		boolean anyMatch2 = users.stream().anyMatch(x -> x.getUserId() < 4);
		assertTrue(anyMatch2);
	}
	
	@Test
	public void testFile() throws Exception {
		List<String> collect = Files.lines(Paths.get("test.txt")).collect(Collectors.toList());
		List<String> collect2 = Files.newBufferedReader(Paths.get("test.txt")).lines().collect(Collectors.toList());
		assertEquals(collect, collect2);
	}
	
	@Test
	public void testOptional() throws Exception {
        Optional<List<User>> nonEmpty = Optional.ofNullable(users);
        Optional<List<User>> empty = Optional.empty();
        
        assertEquals(4, nonEmpty.get().size());
        
        Optional<List<User>> empty2 = Optional.ofNullable(null);
        assertEquals(empty, empty2);
        
        assertTrue(nonEmpty.isPresent());
        assertFalse(empty.isPresent());
        assertEquals(users, nonEmpty.orElse(new ArrayList<User>()));
        assertEquals(users, empty.orElse(nonEmpty.get()));
        
        assertEquals(four, nonEmpty.orElse(new ArrayList<User>()).stream().filter(x -> x.getUserId() > 3).findFirst().orElse(null));
        assertNull(empty.orElse(new ArrayList<User>()).stream().filter(x -> x.getUserId() > 3).findFirst().orElse(null));
	}

}
