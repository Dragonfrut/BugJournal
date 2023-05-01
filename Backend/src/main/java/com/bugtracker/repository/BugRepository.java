package com.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracker.model.Bug;

public interface BugRepository extends JpaRepository<Bug, Long> {

}
