package com.baby_naming_app.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteDto {

    @JsonProperty("name_id")
    private Long nameId;

    public Long getNameId() {
        return this.nameId;
    }

}
