package com.example.tppatientjee.controller;

import com.example.tppatientjee.Repository.ConsultationRepository;
import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.service.PatientService;
import com.example.tppatientjee.service.PatientService0;
import com.example.tppatientjee.util.Definition;
import com.example.tppatientjee.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "patientlist", value="/patientlist")
public class PatientListServlet extends HttpServlet {
    private PatientService patientService;
    private SessionFactory _sessionFactory;
    private ConsultationRepository consultationRepository;
    private Session session;

    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            List<Patient> patientList = patientService.getPatients(null);
            request.setAttribute("patientList", patientList);
            request.getRequestDispatcher(Definition.VIEW_PATH + "listePatients.jsp").forward(request, response);
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("search") != null) {
            String lastname = request.getParameter("search");
            request.setAttribute("lastname", lastname);
            request.getRequestDispatcher(Definition.VIEW_PATH+"listePatients.jsp").forward(request, response);
        }

    }


        public void destroy() {

        }
    }

