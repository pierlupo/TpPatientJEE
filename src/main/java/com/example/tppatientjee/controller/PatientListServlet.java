package com.example.tppatientjee.controller;

import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.service.PatientService0;
import com.example.tppatientjee.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "patientlist", value="/patientlist")
public class PatientListServlet extends HttpServlet {

    private static PatientService0 patientService0;

    public void init() {
        patientService0 = new PatientService0();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("search") != null) {
            String lastnames = request.getParameter("search");
            List<Patient> patientList = null;
            try {
                patientList = Collections.singletonList(patientService0.findBylastName(Collections.singletonList(lastnames)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("patientList", patientList);
        } else {
            List<Patient> patientList = patientService0.findAll();
            request.setAttribute("patientList", patientList);
        } request.getRequestDispatcher(Definition.VIEW_PATH + "listePatients.jsp").forward(request, response);
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

