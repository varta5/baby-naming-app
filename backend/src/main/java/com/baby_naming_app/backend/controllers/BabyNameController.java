package com.baby_naming_app.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.services.BabyNameService;

@RestController
public class BabyNameController {

    private BabyNameService babyNameService;

    @Autowired
    public BabyNameController(BabyNameService babyNameService) {
        this.babyNameService = babyNameService;
    }

    @GetMapping("/api/v1/names")
    public ResponseEntity<List<BabyName>> findNames() {
        return ResponseEntity.ok(babyNameService.findAll());
    }

    @PostMapping("/api/v1/names")
    public ResponseEntity<BabyName> createName(@RequestBody BabyName babyName) {
        return ResponseEntity.ok(babyNameService.save(babyName));
    }

}
