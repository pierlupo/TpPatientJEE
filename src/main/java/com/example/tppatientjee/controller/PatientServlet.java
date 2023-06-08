package com.example.tppatientjee.controller;

import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.service.PatientService;
import com.example.tppatientjee.service.UploadService;
import com.example.tppatientjee.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@WebServlet(name="patient", value="")
@MultipartConfig( //taille max d'un fichier (10 méga)
        maxFileSize = 1024*1024*10,
        //taille max d'une requete (100 méga)
        maxRequestSize = 1024*1024*100)
public class PatientServlet extends HttpServlet {

    private static PatientService patientService;
    private UploadService uploadService;
    public void init() {
        patientService = new PatientService();
//        uploadService = new UploadService(getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Definition.VIEW_PATH+"patientDetail.jsp").forward(request, response);
        } else {
            List<Patient> patientList = patientService.findAll();
            request.setAttribute("patientList", patientList);
            request.getRequestDispatcher(Definition.VIEW_PATH+"patient.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("lastname") != null) {
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String email = request.getParameter("email");
            String tel = request.getParameter("tel");
            Patient patient = new Patient(lastname, firstname, email, tel);

            //Le fichier envoyé par le client
            Part image = request.getPart("image");
            //On peut récupérer le nom du fichier par exemple
            String fileName = image.getSubmittedFileName();
            //Le dossier où sera envoyé le fichier getServletContext => permet de récupérer le dossier où est déployé des servlet
            String uploadPath =  getServletContext().getRealPath("/") + "images";


            //Créé le dossier d'upload si il n'existe pas
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            //On crée notre fichier dans le dossier upload à partir du fichier récupéré
            image.write(uploadPath + File.separator + fileName);

            //SI un envoi multiple
//            for(Part part : request.getParts()) {
//                String name = part.getSubmittedFileName();
//                part.write(uploadPath + File.separator + name);
//            }
            if(patientService.create(patient)) {
                response.sendRedirect("patient");
            }
        }
    }
    public void destroy(){

    }
}

