package com.redhat.com.redhat.solver;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.sum;
import static org.optaplanner.core.api.score.stream.Joiners.equal;

import java.util.function.Function;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

import com.redhat.com.redhat.domain.CloudComputer;
import com.redhat.com.redhat.domain.CloudProcesses;

public class CloudBalanceConstraintProvider implements ConstraintProvider {

	
	@Override
	public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
		// TODO Auto-generated method stub
		return new Constraint[] {
				requiredCPUPowerTotal(constraintFactory),
				requiredMemoryPowerTotal(constraintFactory),
				requiredNetworkBandwidthTotal(constraintFactory),
				requiredCost(constraintFactory)
				
		};
	}

	/* **************** Hard Constraints **************** */

	private Constraint requiredCPUPowerTotal(ConstraintFactory constraintFactory) {
		// TODO Auto-generated method stub
		return constraintFactory.from(CloudProcesses.class)
			.groupBy(CloudProcesses::getComputer, sum(CloudProcesses::getReqCpuCapacity))
			.filter((computer, reqCpuPower) -> reqCpuPower > computer.getCpuCapacity())
			//.penalize("reqCPUTotal",HardSoftScore.ONE_HARD)
			.penalize("reqCPUTotal",
					  HardSoftScore.ONE_HARD, 
					  (computer, reqCpuPower) -> reqCpuPower - computer.getCpuCapacity());
	}

	private Constraint requiredMemoryPowerTotal(ConstraintFactory constraintFactory) {
		return constraintFactory.from(CloudProcesses.class)
		.groupBy(CloudProcesses::getComputer, sum(CloudProcesses::getReqMemCapacity))
		.filter((computer, reqMemPower) -> reqMemPower > computer.getMemCapacity())
		//.penalize("reqMemoryTotal",HardSoftScore.ONE_HARD)
		.penalize("reqMemoryTotal",
				  HardSoftScore.ONE_HARD, 
				  (computer, reqCpuPower) -> reqCpuPower - computer.getMemCapacity());
		
	}

	private Constraint requiredNetworkBandwidthTotal(ConstraintFactory constraintFactory) {
		return constraintFactory.from(CloudProcesses.class)
		.groupBy(CloudProcesses::getComputer, sum(CloudProcesses::getReqNwCapacity))
		.filter((computer, reqMemPower) -> reqMemPower > computer.getNwCapacity())
		//.penalize("reqNBTotal",HardSoftScore.ONE_HARD)
		.penalize("reqNBTotal",
				  HardSoftScore.ONE_HARD, 
				  (computer, reqCpuPower) -> reqCpuPower - computer.getNwCapacity());
		
	}	
	
	
	/* **************** Soft Constraints **************** */
	private Constraint requiredCost(ConstraintFactory constraintFactory) {
        return constraintFactory.from(CloudComputer.class)
                .ifExists(CloudProcesses.class, equal(Function.identity(), CloudProcesses::getComputer))
                .penalize("computerCost",
                        HardSoftScore.ONE_SOFT,
                        CloudComputer::getCost);
		
	}

	
	
	
	
}
