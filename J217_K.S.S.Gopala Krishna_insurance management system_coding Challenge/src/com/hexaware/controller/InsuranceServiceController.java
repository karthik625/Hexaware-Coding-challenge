package com.hexaware.controller;
import java.util.Collection;
import java.util.Scanner;

import com.hexaware.dao.InsuranceServiceImpl;
import com.hexaware.entity.Policy;
import com.hexaware.myexceptions.PolicyNotFoundException;
public class InsuranceServiceController {
	static Scanner scanner =new Scanner(System.in);
	static InsuranceServiceImpl insuranceserviceimpl=new InsuranceServiceImpl();
public void createPolicy() {
	 System.out.println("Enter Policy ID:");
     int policyId = scanner.nextInt();
     System.out.println("Enter Policy Name:");
     scanner.nextLine(); 
     String policyName = scanner.nextLine();
     System.out.println("Enter Policy Type:");
     String policyType = scanner.nextLine();
     System.out.println("Enter Coverage Amount");
     double CoverageAmount = scanner.nextDouble();

     Policy newPolicy = new Policy(policyId, policyName, policyType, CoverageAmount);

     if (insuranceserviceimpl.createPolicy(newPolicy)) {
         System.out.println("Policy created successfully!");
     } else {
         System.out.println("Policy creation failed!");
     }
 }
public static void getPolicy() throws PolicyNotFoundException {
	 System.out.println("Enter Policy ID to retrieve:");
     int policyIdToRetrieve = scanner.nextInt();
     Policy retrievedPolicy = insuranceserviceimpl.getPolicy(policyIdToRetrieve);

     if (retrievedPolicy != null) {
         System.out.println("Retrieved Policy: " + retrievedPolicy);
     } else {
         System.out.println("Policy with ID " + policyIdToRetrieve + " not found.");
     }
 }
public static void getAllPolicies() throws PolicyNotFoundException {
	 Collection<Policy> allPolicies = insuranceserviceimpl.getAllPolicies();

     if (allPolicies != null && !allPolicies.isEmpty()) {
         System.out.println("All Policies are");
         for (Policy policy : allPolicies) {
             System.out.println(policy);
         }
     } else {
         System.out.println("No policies found.");
     }
}
public void updatePolicy() throws PolicyNotFoundException {
	System.out.println("Enter Policy ID to update:");
    int policyIdToUpdate = scanner.nextInt();
    Policy policyToUpdate = insuranceserviceimpl.getPolicy(policyIdToUpdate);

    if (policyToUpdate != null) {
        System.out.println("Enter updated Policy Name:");
        scanner.nextLine(); 
        String updatedPolicyName = scanner.nextLine();
        policyToUpdate.setPolicyName(updatedPolicyName);
        System.out.println("Enter Updated policy type");
        String updatedPolicyType= scanner.nextLine();
        policyToUpdate.setPolicyType(updatedPolicyType);
        System.out.println("Enter updated Coverage Amount:");
        double updatedCoverageAmount = scanner.nextDouble();
        policyToUpdate.setCoverageAmount(updatedCoverageAmount);

        if (insuranceserviceimpl.updatePolicy(policyToUpdate)) {
            System.out.println("Policy updated successfully!");
        } else {
            System.out.println("Policy update failed!");
        }
    } else {
        throw new PolicyNotFoundException("Policy with ID " + policyIdToUpdate + " not found.");
    }
}
public void deletePolicy() throws PolicyNotFoundException {
	System.out.println("Enter Policy ID to delete:");
    int policyIdToDelete = scanner.nextInt();

    if (insuranceserviceimpl.deletePolicy(policyIdToDelete)) {
        System.out.println("Policy deleted successfully!");
    } else {
        System.out.println("Policy with ID " + policyIdToDelete + " not found.");
    }
}
}


