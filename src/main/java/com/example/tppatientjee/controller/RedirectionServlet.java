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
import java.util.List;

@WebServlet(name="redirection", value="/redirection-servlet")
public class RedirectionServlet extends HttpServlet {

    private static PatientService0 patientService0;

    public void init() {
        patientService0 = new PatientService0();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService0.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Definition.VIEW_PATH+"patientDetail.jsp").forward(request, response);
        } else {
            List<Patient> patientList = patientService0.findAll();
            request.setAttribute("patientList", patientList);
            request.getRequestDispatcher(Definition.VIEW_PATH+"patient.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("lastname") != null) {
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String email = request.getParameter("email");
            String tel = request.getParameter("tel");
            Patient patient = new Patient(lastname, firstname, email, tel);
            if(patientService0.create(patient)) {
                response.sendRedirect("patient");
            }
        }
    }
    public void destroy(){

    }
}