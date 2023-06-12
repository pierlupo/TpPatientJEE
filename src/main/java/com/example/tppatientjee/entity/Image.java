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

    public Image(){

    }

    public Image(int id, String uri, Patient patient) {
        this.id = id;
        this.uri = uri;
        this.patient = patient;
    }
}
