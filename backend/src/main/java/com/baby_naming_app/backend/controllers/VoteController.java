package com.baby_naming_app.backend.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.baby_naming_app.backend.dtos.VoteDto;
import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.models.User;
import com.baby_naming_app.backend.models.Vote;
import com.baby_naming_app.backend.services.BabyNameService;
import com.baby_naming_app.backend.services.UserService;
import com.baby_naming_app.backend.services.VoteService;

@RestController
public class VoteController {

    private BabyNameService babyNameService;
    private UserService userService;
    private VoteService voteService;

    @Autowired
    public VoteController(BabyNameService babyNameService, UserService userService, VoteService voteService) {
        this.babyNameService = babyNameService;
        this.userService = userService;
        this.voteService = voteService;
    }

    @GetMapping("/api/v1/votes")
    public ResponseEntity<List<Vote>> findVotes() {
        return ResponseEntity.ok(voteService.findAll());
    }

    @PostMapping("/api/v1/votes")
    public ResponseEntity<Vote> createVote(
            @RequestHeader("Current-User-Id") UUID currentUserId, @RequestBody VoteDto voteDto) throws Exception {
        User user = userService.findById(currentUserId);
        BabyName babyName = babyNameService.findById(voteDto.getNameId());
        return ResponseEntity.ok(voteService.save(voteDto, user, babyName));
    }

}
