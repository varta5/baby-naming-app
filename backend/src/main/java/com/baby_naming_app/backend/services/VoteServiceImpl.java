package com.baby_naming_app.backend.services;

import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baby_naming_app.backend.dtos.VoteDto;
import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.models.Vote;
import com.baby_naming_app.backend.repositories.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

    private ModelMapper modelMapper;
    private VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(ModelMapper modelMapper, VoteRepository voteRepository) {
        this.modelMapper = modelMapper;
        this.voteRepository = voteRepository;
    }

    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    public Vote save(VoteDto voteDto, BabyName babyName) {
        Vote vote = convertToVote(voteDto, babyName);
        return voteRepository.save(vote);
    }

    private Vote convertToVote(VoteDto voteDto, BabyName babyName) {
        Vote vote = this.modelMapper.map(voteDto, Vote.class);
        vote.setBabyName(babyName);
        vote.setTimestamp(new Date());
        return vote;
    }

}
