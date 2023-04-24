package net.aptech.h3clothing.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Base {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

//    @Column(name = "createdAt")
//    private Timestamp createdAt;
//
//    @Column(name = "updateAt")
//    private Timestamp updateAt;
//
//    @PrePersist
//    public void prePersist(){
//        this.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.setUpdateAt(Timestamp.valueOf(LocalDateTime.now()));
//    }




}
