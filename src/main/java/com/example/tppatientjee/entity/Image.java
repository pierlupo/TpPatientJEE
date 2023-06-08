package com.example.tppatientjee.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String uri;

    @ManyToOne()
    private Patient patient;
}
