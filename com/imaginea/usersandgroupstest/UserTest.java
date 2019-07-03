package com.imaginea.usersandgroupstest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.imaginea.usersandgroups.RepositoryStore;
import com.imaginea.usersandgroups.User;

public class UserTest {
	@Test
	public void fieldNames_Are_Correct()
	{
		User user=new User();
		java.lang.reflect.Field[] fields=user.getClass().getDeclaredFields();
		List<String> actualFieldNames = getFieldNames(fields);
		 
	    assertTrue(Arrays.asList("userName", "userId")
	      .containsAll(actualFieldNames));
	    System.out.println("field names are correctly tested");
	}
	public List<String> getFieldNames(java.lang.reflect.Field[] fields)
	{
		List<String> fieldNames = new ArrayList<>();
	    for (java.lang.reflect.Field field : fields)
	      fieldNames.add(field.getName());
	    return fieldNames;

	}
	@Test
	public void getUserTest()
	{
		User user=new User("mounika","101");
		assertEquals("mounika",user.getUser());
		System.out.println("get user method tetsed correctly");
		
	}
	@Test
	public void UniqueIdentifierTest()
	{
		User user=new User("mounika","101");
		assertEquals("101",user.uniqueIdentifier());
		System.out.println("get uniqueIdentifier method tested correctly");
	}
	@Test
	public void addUserTest()
	{
		RepositoryStore repo=new RepositoryStore();
		User user1=new User("user1","100");
		User user2=new User("user2","101");
		repo.addUser(user1);
		repo.addUser(user2);
		assertEquals(2,repo.getNoOfUsers());
		System.out.println("add user method verified correctly");
	}
	@Test
	public void removeUserTest()
	{
		RepositoryStore repo=new RepositoryStore();
		User user1=new User("user1","100");
		User user2=new User("user2","101");
		repo.addUser(user1);
		repo.addUser(user2);
		repo.removeUser(user1.uniqueIdentifier());
		assertEquals(1,repo.getNoOfUsers());
		System.out.println("remove user method verified correctly");
	}
	
}
