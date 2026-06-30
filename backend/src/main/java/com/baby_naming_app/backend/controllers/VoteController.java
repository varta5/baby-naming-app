package com.baby_naming_app.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baby_naming_app.backend.dtos.VoteDto;
import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.models.Vote;
import com.baby_naming_app.backend.services.BabyNameService;
import com.baby_naming_app.backend.services.VoteService;

@RestController
public class VoteController {

    private BabyNameService babyNameService;
    private VoteService voteService;

    @Autowired
    public VoteController(BabyNameService babyNameService, VoteService voteService) {
        this.babyNameService = babyNameService;
        this.voteService = voteService;
    }

    @GetMapping("/api/v1/votes")
    public ResponseEntity<List<Vote>> findVotes() {
        return ResponseEntity.ok(voteService.findAll());
    }

    @PostMapping("/api/v1/votes")
    public ResponseEntity<Vote> createVote(@RequestBody VoteDto voteDto) throws Exception {
        BabyName babyName = babyNameService.findById(voteDto.getNameId());
        return ResponseEntity.ok(voteService.save(voteDto, babyName));
    }

}
