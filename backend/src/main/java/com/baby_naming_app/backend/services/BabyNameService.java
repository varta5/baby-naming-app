package com.baby_naming_app.backend.services;

import java.util.List;

import com.baby_naming_app.backend.models.BabyName;

public interface BabyNameService {

    List<BabyName> findAll();

    BabyName save(BabyName babyName);

}
