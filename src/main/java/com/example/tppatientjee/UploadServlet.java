package com.example.tppatientjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(
        //taille max d'un fichier (10 méga)
        maxFileSize = 1024*1024*10,
        //taille max d'une requete (100 méga)
        maxRequestSize = 1024*1024*100
)
public class UploadServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("form-upload.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        //Si un envoi est multiple

        //SI un envoie multiple
        for(Part part : request.getParts()) {
            String name = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + name);
        }

        request.getRequestDispatcher("form-upload.jsp").forward(request, response);
    }
}
