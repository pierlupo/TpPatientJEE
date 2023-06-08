package com.example.tppatientjee.Repository;

import com.example.tppatientjee.entity.Consultation;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ConsultationRepository extends Repository<Consultation> {
    public ConsultationRepository(Session session) {
        super(session);
    }





    @Override
    public Consultation findById(int id) {
        return _session.get(Consultation.class, id);
    }

    @Override
    public List<Consultation> findAll() {
        return _session.createQuery("from Consultation ").list();
    }

    public List<Consultation> findAllByPatientId(int patientId) {
        Query<Consultation> query = _session.createQuery("from Consultation  where patient.id = :id");
        query.setParameter("id", patientId);
        return query.list();
    }
}
