package com.example.tppatientjee.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateConsultation;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Prescription prescription;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FicheSoins ficheSoins;

    public Consultation() {
    }

    public Consultation(Date dateConsultation, Patient patient, Prescription prescription, FicheSoins ficheSoins) {
        this.dateConsultation = dateConsultation;
        this.patient = patient;
        this.prescription = prescription;
        this.ficheSoins = ficheSoins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public FicheSoins getFicheSoins() {
        return ficheSoins;
    }

    public void setFicheSoins(FicheSoins ficheSoins) {
        this.ficheSoins = ficheSoins;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", patient=" + patient +
                ", prescription=" + prescription +
                ", ficheSoins=" + ficheSoins +
                '}';
    }
}
