package com.imaginea.usersandgroups;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GroupTest {
	@Test
	public void fieldNames_Are_Correct()
	{   User user=new User();
	java.lang.reflect.Field[] fields=user.getClass().getFields();
		List<String> fieldNames=new ArrayList<>();
		for(java.lang.reflect.Field field:fields)
		{
		    	fieldNames.add(field.getName());
		}
		assertTrue(Arrays.asList("groupNames","groupid").containsAll(fieldNames));
		System.out.println("group field names are verified correctly ");
	}
	@Test
	public void getGroupTest()
	{
		Group group=new Group("g1","1");
		assertEquals("g1",group.getGroup());
		System.out.println("get group method verified correctly");
	}
	@Test
	public void uniqueIdentiferTest()
	{
		Group group=new Group("g1","1");
		assertEquals("1",group.uniqueIdentifier());
		System.out.println("get uniqeuIdentifier verified correctly ");
		
	}
	@Test
	public void addGroupTest()
	{
		RepositoryStore repo=new RepositoryStore();
		Group group1=new Group("group11","100");
		Group group2=new Group("group2","101");
		repo.addGroup(group1);
		repo.addGroup(group2);
		assertEquals(2,repo.getNoOfGroups());
		System.out.println("add Group method verified correctly");
	}
	@Test
	public void removeGroupTest()
	{
		RepositoryStore repo=new RepositoryStore();
		Group group1=new Group("group11","100");
		Group group2=new Group("group2","101");
		repo.addGroup(group1);
		repo.addGroup(group2);
		repo.removeGroup(group1.uniqueIdentifier());
		assertEquals(1,repo.getNoOfGroups());
		System.out.println("remove Group method verified correctly");
	}
}
