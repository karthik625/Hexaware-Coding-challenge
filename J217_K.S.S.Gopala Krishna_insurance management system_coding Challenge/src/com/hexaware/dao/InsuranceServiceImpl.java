//6. Define InsuranceServiceImpl class and implement all the methods InsuranceServiceImpl .
package com.hexaware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hexaware.entity.Policy;
import com.hexaware.myexceptions.PolicyNotFoundException;
import com.hexaware.util.PropertyUtil;


public class InsuranceServiceImpl implements IPolicyService{
static String connectionString = PropertyUtil.getPropertyString();
	
//	private final Connection connection;
//	
//	public InsuranceServiceImpl(Connection connection) {
//		this.connection=connection;
//	}
	 
	public InsuranceServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean createPolicy(Policy policy){
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "INSERT INTO policy (policyId, policyName, policyType,coverageAmount) VALUES (?, ?, ?,?)"
	             )) {
	            preparedStatement.setInt(1, policy.getPolicyId());
	            preparedStatement.setString(2, policy.getPolicyName());
	            preparedStatement.setString(3, policy.getPolicyType());
	            preparedStatement.setDouble(4, policy.getCoverageAmount());

	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 public Policy getPolicy(int policyId) throws PolicyNotFoundException {
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT * FROM policy WHERE policyId = ?"
	             )) {
	            preparedStatement.setInt(1, policyId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                int pid=resultSet.getInt("policyId");
	                String policyName=resultSet.getString("policyName");
	                String policyType=resultSet.getString("policyType");
	                double coverageAmount=resultSet.getDouble("coverageAmount");
	                Policy policy=new Policy(pid,policyName,policyType,coverageAmount);
	                return policy;
	                		
	    
	            } else {
	            	throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PolicyNotFoundException("Error while retrieving policy with ID " + policyId);
	        }
	    }
	 public  Collection<Policy> getAllPolicies() throws PolicyNotFoundException  {
	        List<Policy> policies = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(connectionString);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM policy")) {

	            while (resultSet.next()) {
	            	int pid=resultSet.getInt("policyId");
	                String policyName=resultSet.getString("policyName");
	                String policyType=resultSet.getString("policyType");
	                double coverageAmount=resultSet.getDouble("coverageAmount");
	                Policy policy=new Policy(pid,policyName,policyType,coverageAmount);
	                policies.add(policy);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PolicyNotFoundException("Error while retrieving all policies");
	        }

	        return policies;
	    }
	 public  boolean updatePolicy(Policy policy) {
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "UPDATE policy SET policyName = ?, policyType = ?, coverageAmount = ? WHERE policyId = ?"
	             )) {
	            preparedStatement.setString(1, policy.getPolicyName());
	            preparedStatement.setString(2, policy.getPolicyType());
	            preparedStatement.setDouble(3, policy.getCoverageAmount());
	            preparedStatement.setInt(4, policy.getPolicyId());

	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 public  boolean deletePolicy(int policyId) throws PolicyNotFoundException  {
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "DELETE FROM policy WHERE policyId = ?"
	             )) {
	            preparedStatement.setInt(1, policyId);
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                return true;
	            } else {
	                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PolicyNotFoundException("Error while deleting policy with ID " + policyId);
	        }
	    }

}
