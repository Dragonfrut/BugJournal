package com.bugtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bugtracker.exception.BugNotFoundException;
import com.bugtracker.model.Bug;
import com.bugtracker.repository.BugRepository;

@Service
public class BugService {
	
	BugRepository bugRepo;

	/**
	 * @param bugRepo
	 */
	public BugService(BugRepository bugRepo) {
		super();
		this.bugRepo = bugRepo;
	}
	
	// gets a list of all bugs
	public List<Bug> getBugs(){
		return bugRepo.findAll();
	}
	
	// gets a specific bug by id
	public Bug getBug(Long id) {
		Optional<Bug> bugOpt = bugRepo.findById(id);
		if(!bugOpt.isPresent()) {
			throw new BugNotFoundException("GET:Bug with id " + id + " was not found");
		}
		return bugOpt.get();
	}
	
	// creates a new bug
	public Bug createBug(Bug bug) {
		return bugRepo.save(bug);
	}
	
	// updates a bug
		public Bug updateBug(Long id, Bug bug) {
			Optional<Bug> bugOpt = bugRepo.findById(id);
			if(!bugOpt.isPresent()) {
				throw new BugNotFoundException("UPDATE:Bug with id " + id + " was not found");
			}
			return bugRepo.save(bug);
		}
		
	// deletes a bug by id
		public void deleteBug(Long id) {
			Optional<Bug> bugOpt = bugRepo.findById(id);
			if(!bugOpt.isPresent()) {
				throw new BugNotFoundException("DELETE:Bug with id " + id + " was not found");
			}
			bugRepo.deleteById(id);
		}

}
