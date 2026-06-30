package com.baby_naming_app.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baby_naming_app.backend.models.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {}
