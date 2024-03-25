//3. Define IPolicyService interface/abstract class with following methods to interact with database
//Keep the interfaces and implementation classes in package dao
package com.hexaware.dao;

import java.util.Collection;

import com.hexaware.entity.Policy;
import com.hexaware.myexceptions.PolicyNotFoundException;

public interface IPolicyService {
	 boolean createPolicy(Policy policy);
	    Policy getPolicy(int policyId) throws PolicyNotFoundException;
	    Collection<Policy> getAllPolicies() throws PolicyNotFoundException;
	    boolean updatePolicy(Policy policy);
	    boolean deletePolicy(int policyId) throws PolicyNotFoundException ;
}
