package com.example.tppatientjee.entity;


import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastName;

    private String firstName;

    private String email;

    private String tel;

//    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
//    List<Image> images;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    List<Consultation> consultations;

    public Patient(){

    }

    public Patient(int id, String lastName, String firstName, String email, String tel, List<Image> images, List<Consultation> consultations) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.tel = tel;
        //this.images = images;
        this.consultations = consultations;
    }

    public Patient(String lastName, String firstName, String email, String tel, List<Consultation> consultations) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.tel = tel;
        this.consultations = consultations;
    }

    public Patient(int id, String lastName, String firstName, String email, String tel, List<Consultation> consultations) {
        this(lastName, firstName, email, tel, consultations);
        this.id = id;
    }

    public Patient(String lastName, String firstName, String email, String tel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", consultations=" + consultations +
                '}';
    }
}