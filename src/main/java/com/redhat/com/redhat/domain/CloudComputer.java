package com.redhat.com.redhat.domain;

public class CloudComputer {

	private long id;
	private int cpuCapacity; // in cores
	private int memCapacity; // in GB
	private int nwCapacity;  // GB per hr
	private int cost;		 // in USD
	

	public int getCpuCapacity() {
		return cpuCapacity;
	}


	public void setCpuCapacity(int cpuCapacity) {
		this.cpuCapacity = cpuCapacity;
	}


	public int getMemCapacity() {
		return memCapacity;
	}


	public void setMemCapacity(int memCapacity) {
		this.memCapacity = memCapacity;
	}


	public int getNwCapacity() {
		return nwCapacity;
	}


	public void setNwCapacity(int nwCapacity) {
		this.nwCapacity = nwCapacity;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
}
