package com.imaginea.usersandgroups;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
public class TestRunner {
	public static void main(String[] args) {
	      org.junit.runner.Result userResult = JUnitCore.runClasses(UserTest.class);
	      for (Failure failure : userResult.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println("Result=="+userResult.wasSuccessful());
	   
	org.junit.runner.Result groupResult=JUnitCore.runClasses(GroupTest.class);
	for(Failure failure:groupResult.getFailures())
	{
		System.out.println(failure.toString());
	}
System.out.println("Result=="+groupResult.wasSuccessful());
}
}
