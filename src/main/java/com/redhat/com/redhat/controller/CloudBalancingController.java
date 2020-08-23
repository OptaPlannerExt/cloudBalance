package com.redhat.com.redhat.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.redhat.com.redhat.domain.CloudBalance;

import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.score.ScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cloudBalance")
public class CloudBalancingController {

    @Autowired
    private SolverManager<CloudBalance, UUID> solverManager;
	
    @PostMapping(value = "/solve", produces = "application/json")
    //@RequestMapping(value = "/solve", produces = "application/json", method = RequestMethod.GET)
	public CloudBalance solve(@RequestBody CloudBalance cloudProb) {
		UUID id = UUID.randomUUID();
		SolverJob<CloudBalance, UUID> solverJob = solverManager.solve(id, cloudProb);
		CloudBalance sol;
		try {
			sol = solverJob.getFinalBestSolution();
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalStateException("Solving Exception - " + e);
		}
		//System.out.println(sol);
		return sol;
	}
    
    /*@RequestMapping(value = "/status", produces = "application/json", method = RequestMethod.GET)
	public Status status() {
		UUID id = UUID.randomUUID();
		SolverJob<CloudBalance, UUID> solverJob = solverManager.` solve(id, cloudProb);
		CloudBalance sol;
		try {
			sol = solverJob.getFinalBestSolution();
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalStateException("Solving Exception - " + e);
		}
		//System.out.println(sol);
		return sol;
	}*/
    
    
    
	
}
