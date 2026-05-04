package com.baby_naming_app.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.repositories.BabyNameRepository;

@Service
public class BabyNameServiceImpl implements BabyNameService {

    private BabyNameRepository babyNameRepository;

    @Autowired
    public BabyNameServiceImpl(BabyNameRepository babyNameRepository) {
        this.babyNameRepository = babyNameRepository;
    }

    public List<BabyName> findAll() {
        return babyNameRepository.findAll();
    }

    public BabyName save(BabyName babyName) {
        return babyNameRepository.save(babyName);
    }

}
