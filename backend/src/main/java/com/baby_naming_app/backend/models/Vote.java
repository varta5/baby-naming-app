package com.baby_naming_app.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import com.baby_naming_app.backend.models.BabyName;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "baby_name_id", nullable = false)
    private BabyName babyName;

    private Date timestamp;

    public BabyName getBabyName() {
        return this.babyName;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setBabyName(BabyName babyName) {
        this.babyName = babyName;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
