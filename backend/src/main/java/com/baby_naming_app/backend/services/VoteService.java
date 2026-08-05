package com.baby_naming_app.backend.services;

import java.util.List;

import com.baby_naming_app.backend.dtos.VoteDto;
import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.models.User;
import com.baby_naming_app.backend.models.Vote;

public interface VoteService {

    List<Vote> findAll();

    Vote save(VoteDto voteDto, User user, BabyName babyName);

}
