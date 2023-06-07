package com.example.tppatientjee.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String medicine;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne()
    private Consultation consultation;

    public Prescription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", medicine='" + medicine + '\'' +
                ", date=" + date +
                ", consultation=" + consultation +
                '}';
    }
}
