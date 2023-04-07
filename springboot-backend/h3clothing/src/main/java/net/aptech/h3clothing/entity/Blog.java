package net.aptech.h3clothing.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@Table(name = "blogs")

public class Blog extends DateAudit{ //Khong the extends dong thoi hai class Base va DateAudit
// Nen moi phai de DateAudit extend tu Base
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="userInfId")
    private User_Info user;

    @Column(name="published")
    private boolean isPublished;

    public Blog(){
        super();
    }
    public Blog(String title, String description, User_Info user, boolean isPublished, Instant createdAt, Instant updatedAt) {
        super(createdAt, updatedAt);
        this.title = title;
        this.description = description;
        this.user = user;
        this.isPublished = isPublished;

    }

    public LocalDateTime getCreatedLocalDateTime(){
        return LocalDateTime.ofInstant(getCreatedAt(), ZoneId.systemDefault());
    }

    public LocalDateTime getUpdatedLocalDateTime(){
        return LocalDateTime.ofInstant(getUpdatedAt(), ZoneId.systemDefault());
    }

}
