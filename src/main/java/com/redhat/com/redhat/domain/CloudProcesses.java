package com.redhat.com.redhat.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class CloudProcesses {

	private long id;
	private int reqCpuCapacity; // in cores
	private int reqMemCapacity; // in GB
	private int reqNwCapacity;  // GB per hr
	
	@PlanningVariable(valueRangeProviderRefs = "computerRange")
	private CloudComputer computer;
	
	
	public CloudComputer getComputer() {
		return computer;
	}


	public void setComputer(CloudComputer computer) {
		this.computer = computer;
	}

	public int getReqCpuCapacity() {
		return reqCpuCapacity;
	}


	public void setReqCpuCapacity(int reqCpuCapacity) {
		this.reqCpuCapacity = reqCpuCapacity;
	}


	public int getReqMemCapacity() {
		return reqMemCapacity;
	}


	public void setReqMemCapacity(int reqMemCapacity) {
		this.reqMemCapacity = reqMemCapacity;
	}


	public int getReqNwCapacity() {
		return reqNwCapacity;
	}


	public void setReqNwCapacity(int reqNwCapacity) {
		this.reqNwCapacity = reqNwCapacity;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
