package com.example.tppatientjee.service;


import com.example.tppatientjee.Repository.SoinsRepository;
import com.example.tppatientjee.entity.FicheSoins;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FicheSoinsService {

    private ConsultationService consultationService;
    private FicheSoinsService ficheSoinsService;
    private SessionFactory _sessionFactory;
    private SoinsRepository soinsRepository;
    private Session session;

    public FicheSoinsService (SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
        consultationService = new ConsultationService(_sessionFactory);
    }

    public boolean createSoins (int consultationId, String content){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        soinsRepository = new SoinsRepository(session);
        FicheSoins ficheSoins = FicheSoins.builder().content(content).consultation(consultationService.getByIdConsultation(consultationId)).build();
        try{
            soinsRepository.create(ficheSoins);
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

    public FicheSoins getByIdFicheSoins (int id){
        FicheSoins ficheSoins = null ;
        session = _sessionFactory.openSession();
        soinsRepository = new SoinsRepository(session);
        try{
            ficheSoins = soinsRepository.findById(id);
        }catch (Exception e){

        }finally {
            session.close();
        }
        return ficheSoins;
    }
}
