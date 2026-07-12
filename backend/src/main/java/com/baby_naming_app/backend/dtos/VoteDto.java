package com.baby_naming_app.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.baby_naming_app.backend.enums.Choice;

public class VoteDto {

    @JsonProperty("name_id")
    private Long nameId;

    private Choice choice;

    public Long getNameId() {
        return this.nameId;
    }

    public Choice getChoice() {
        return this.choice;
    }

}
