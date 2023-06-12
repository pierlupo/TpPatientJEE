package com.example.tppatientjee.controller;

import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.service.*;
import com.example.tppatientjee.util.Definition;
import com.example.tppatientjee.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

import static com.example.tppatientjee.util.Definition.VIEW_PATH;


@WebServlet(name = "patient", value = "")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private List<Patient> patients;
    private LoginService loginService;
    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory());

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String messageError = null;
        if(request.getParameter("action")!= null && request.getParameter("action").equals("search")) {
            patients = patientService.getPatients(request.getParameter("search"));
        }
        else {
            patients = patientService.getPatients(null);
            if(request.getParameter("lastName") != null
                && request.getParameter("firstName") != null
                && request.getParameter("email") != null
                && request.getParameter("tel") != null
                && !request.getParameter("lastName").equals("")
                && !request.getParameter("firstName").equals("")
                && !request.getParameter("email").equals("")
                && !request.getParameter("tel").equals("")){
                String lastName= request.getParameter("lastName");
                String firstName = request.getParameter("firstName");
                String email = request.getParameter("email");
                String tel = request.getParameter("tel");
                if(patientService.createPatient(lastName, firstName, email, tel)) {
                    response.sendRedirect("");
                }else {
                    messageError = "Error while adding a patient";
                }
            } else {
                messageError = "fill up all fields please";
            }
        }
        if(messageError != null || request.getParameter("action").equals("search")) {
            request.setAttribute("patientList", patients);
            request.setAttribute("messageError", messageError);
            request.getRequestDispatcher(VIEW_PATH + "/patient.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginService = new LoginImpl(request.getSession());
        request.setAttribute("isLogged", loginService.isLogged());
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.getByIdPatient(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Definition.VIEW_PATH+"patientDetail.jsp").forward(request, response);
        }else {
        patients = patientService.getPatients(null);
        request.setAttribute("patientList", patients);
        request.getRequestDispatcher(VIEW_PATH + "/patient.jsp").forward(request, response);
    }

    }
}