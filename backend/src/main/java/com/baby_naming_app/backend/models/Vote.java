package com.baby_naming_app.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

import com.baby_naming_app.backend.enums.Choice;
import com.baby_naming_app.backend.models.BabyName;
import com.baby_naming_app.backend.models.User;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "baby_name_id", nullable = false)
    private BabyName babyName;

    @Enumerated(EnumType.STRING)
    private Choice choice;

    private Date timestamp;

    public User getUser() {
        return this.user;
    }

    public BabyName getBabyName() {
        return this.babyName;
    }

    public Choice getChoice() {
        return this.choice;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBabyName(BabyName babyName) {
        this.babyName = babyName;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
