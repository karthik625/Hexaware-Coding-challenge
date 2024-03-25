package com.hexaware.entity;

public class Policy {
	private int policyId;
	 private String policyName;
	 private String policyType;
	 private double coverageAmount;
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(int policyId, String policyName, String policyType, double coverageAmount) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyType = policyType;
		this.coverageAmount = coverageAmount;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", coverageAmount=" + coverageAmount + "]";
	}
	
}
