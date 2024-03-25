//9. Create class named MainModule with main method in package mainmod.
//Trigger all the methods in service implementation class.
package com.hexaware.main;
import java.util.Scanner;
import com.hexaware.controller.*;
import com.hexaware.myexceptions.PolicyNotFoundException;
public class View {
	static InsuranceServiceController insuranceservice=new InsuranceServiceController();
	static Scanner scanner=new Scanner(System.in);
public static void main(String[] args) {
	while(true) {
		System.out.println("\n*** Policy Menu ***");
        System.out.println("1. Create Policy");
        System.out.println("2. Get Policy");
        System.out.println("3. Get All Policies");
        System.out.println("4. Update Policy");
        System.out.println("5. Delete Policy");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice=scanner.nextInt();
        switch(choice) {
        case 1:
        	insuranceservice.createPolicy();
        	break;
        case 2:
        	try {
				insuranceservice.getPolicy();
			} catch (PolicyNotFoundException e) {
				e.printStackTrace();
			}
        	break;
        case 3:
        	try {
				insuranceservice.getAllPolicies();
			} catch (PolicyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case 4:
			try {
				insuranceservice.updatePolicy();
			} catch (PolicyNotFoundException e) {
				e.printStackTrace();
			}
           break;
        case 5:
        	try {
				insuranceservice.deletePolicy();
			} catch (PolicyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case 6:
        	System.out.println("Thank you");
        	break;
        default:
        	System.out.println("invalid option try again");
        }
	}
	
}
}
