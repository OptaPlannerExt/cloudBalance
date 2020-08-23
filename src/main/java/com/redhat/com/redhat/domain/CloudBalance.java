package com.redhat.com.redhat.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

/**
 * CloudBalancingSolution
 */
@PlanningSolution
public class CloudBalance {
	
	@PlanningEntityCollectionProperty
	private List<CloudProcesses> cloudProcesses;	

	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "computerRange")
	private List<CloudComputer> cloudComputer;
	
	@PlanningScore
	private HardSoftScore score;
	
	public CloudBalance() {
	}

	public CloudBalance(List<CloudComputer> cloudComputer, List<CloudProcesses> cloudProcesses) {
		this.cloudComputer = cloudComputer;
		this.cloudProcesses = cloudProcesses;
	}

	public List<CloudComputer> getCloudComputer() {
		return cloudComputer;
	}

	public void setCloudComputer(List<CloudComputer> cloudComputer) {
		this.cloudComputer = cloudComputer;
	}

	public List<CloudProcesses> getCloudProcesses() {
		return cloudProcesses;
	}

	public void setCloudProcesses(List<CloudProcesses> cloudProcesses) {
		this.cloudProcesses = cloudProcesses;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}
	
}
