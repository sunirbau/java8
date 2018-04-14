package org.sunir.util;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Java8CollectionsTest {

	private List<User> users;
	private User one = new User("Atest@yopmail.com", "111111");
	private User two = new User("Btest22@yopmail.com", "222222");
	private User three = new User("Ctest333@yopmail.com", "333333");
	private User four = new User("Dtest4444@yopmail.com", "444444");
	
	@Before
	public void setup(){
		users = new LinkedList<User>();
		users.add(one);
		users.add(two);
		users.add(three);
		users.add(four);
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
}
