package com.example.tppatientjee.service;


import com.example.tppatientjee._interface.Repository;
import com.example.tppatientjee.entity.Consultation;
import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.entity.Prescription;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService0 extends BaseService implements Repository<Patient> {

    public PatientService0(){
        super();
    }
    @Override
    public boolean create(Patient element) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }
    public boolean create(Consultation element) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }
    public boolean create(Prescription element) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Patient element) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Patient element) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }

    public List<Patient> findAll(){
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> productQuery = session.createQuery("from Patient");
        patientList = productQuery.list();
        session.close();
        return patientList;
    }

    public Patient findBylastName(List<String> lastNames)throws Exception {
        if (lastNames.size() > 0) {
            session = sessionFactory.openSession();
            Query<Patient> patientQuery = session.createQuery("from Patient where lastName in :lastNames");
            patientQuery.setParameter("lastNames", lastNames);
            List<Patient> patientList = patientQuery.list();
            session.getTransaction().commit();
            session.close();
            return (Patient) patientList;
        }
        throw new Exception("error");
    }

    public void begin(){

        session = sessionFactory.openSession();

    }

    public void end(){
        //session.close();
        sessionFactory.close();
    }
}