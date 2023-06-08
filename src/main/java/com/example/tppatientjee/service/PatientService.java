package com.example.tppatientjee.service;

import java.util.List;

import com.example.tppatientjee.Repository.PatientRepository;
import com.example.tppatientjee.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PatientService {

        private SessionFactory _sessionFactory;
        private PatientRepository patientRepository;
        private Session session;

        public PatientService (SessionFactory sessionFactory){
            _sessionFactory = sessionFactory;
        }

        public boolean createPatient (String lastName, String firstName, String email, String tel){
            boolean result = false;
            session = _sessionFactory.openSession();
            session.beginTransaction();
            patientRepository = new PatientRepository(session);
            Patient patient = Patient.builder().lastName(lastName).firstName(firstName).email(email).tel(tel).build();
            try{
                patientRepository.create(patient);
                session.getTransaction().commit();
                result = true;
            }catch (Exception e){
                try{
                    session.getTransaction().rollback();
                }catch (Exception except){
                    System.out.println(except.getMessage());
                }
            }finally {
                session.close();
            }
            return result;
        }

        public Patient getByIdPatient (int id){
            Patient patient = null ;
            session = _sessionFactory.openSession();
            patientRepository = new PatientRepository(session);
            try{
                patient = patientRepository.findById(id);
            }catch (Exception e){

            }finally {
                session.close();
            }
            return patient;
        }

        public List<Patient> getPatients(String name){
            List<Patient> patients = null;
            session = _sessionFactory.openSession();
            patientRepository = new PatientRepository(session);
            try{
                if(name == null){
                    patients = patientRepository.findAll();
                }else{
                    patients = patientRepository.findAllByName(name);
                }
            }catch (Exception e){

            }finally {
                session.close();
            }
            return patients;
        }
    }
