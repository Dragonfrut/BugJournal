package com.bugtracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.model.Bug;
import com.bugtracker.service.BugService;

@RestController
@CrossOrigin(origins = "*")
public class BugController {
	
	BugService bugService;

	/**
	 * @param bugService
	 */
	public BugController(BugService bugService) {
		super();
		this.bugService = bugService;
	}
	
	@GetMapping("bugs")
	public List<Bug> getAllBugs(){
		System.out.println("GET bugs");
		List<Bug> bugs = bugService.getBugs();
		return bugs;
	}
	
	@GetMapping("bugs/{id}")
	public ResponseEntity<Bug> getBug(@PathVariable Long id){
		System.out.println("GET bug with id " + id);
		Bug bug = bugService.getBug(id);
		return ResponseEntity.ok(bug);
	}
	
	@PostMapping("bugs")
	public void createBug(@RequestBody Bug bug){
		System.out.println("POST bug");
		System.out.println("creating bug");
		bugService.createBug(bug);
	}
	
	@PostMapping("bugs/{id}")
	public void createBug(@PathVariable Long id, @RequestBody Bug bug){
		System.out.println("POST UPDATE bug");
		System.out.println("UPDATE bug");
		bugService.updateBug(id,bug);
	}
	
	
	@DeleteMapping("bugs/{id}")
	public void deleteBug(@PathVariable Long id) {
		System.out.println("DELETE bug");
		bugService.deleteBug(id);
	}

}
