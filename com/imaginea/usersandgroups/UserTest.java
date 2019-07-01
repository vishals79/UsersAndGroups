package com.imaginea.usersandgroups;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
}
