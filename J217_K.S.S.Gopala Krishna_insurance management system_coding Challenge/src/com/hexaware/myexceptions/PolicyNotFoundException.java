//8. Create the exceptions in package myexceptions
//Define the following custom exceptions and throw them in methods whenever needed. Handle all the
//exceptions in main method,
//1. PolicyNotFoundException :throw this exception when user enters an invalid patient number
//which doesn’t exist in db
package com.hexaware.myexceptions;

public class PolicyNotFoundException extends Exception {
	public PolicyNotFoundException(String message) {
		super(message);
	}
}
