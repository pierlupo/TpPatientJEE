package com.example.tppatientjee.Repository;

import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.entity.Prescription;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository(Session session) {
        super(session);
    }





    @Override
    public Patient findById(int id) {
        return (Patient) _session.get(Patient.class, id);
    }

    @Override
    public List<Patient> findAll() {
        return _session.createQuery("from Patient ").list();
    }

    public List<Patient> findAllByName(String search) {
        Query<Patient> query = _session.createQuery("from Patient where lastName like :search");
        query.setParameter("search", search + "%");
        return query.list();
    }
}
