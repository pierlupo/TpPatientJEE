package com.example.tppatientjee.controller;



import com.example.tppatientjee.entity.Consultation;
import com.example.tppatientjee.entity.Prescription;
import com.example.tppatientjee.entity.Patient;
import com.example.tppatientjee.service.PatientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private static PatientService patientService;
    private static Scanner scanner;

    public IHM() {
        scanner = new Scanner(System.in);
        patientService = new PatientService();
    }


    public void start() throws ParseException {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addPatient();
                case "2" -> updatePatient();
                case "3" -> getPatientById();
                case "4" -> getAllPatients();
                case "5" -> deletePatientById();
            }
        } while (!choice.equals("0"));
        patientService.end();
    }

    private void menu() {
        System.out.println("----------------");
        System.out.println("EXO HIBERNATE");
        System.out.println("----------------");
        System.out.println("******************");
        System.out.println("Choose an option :");
        System.out.println("******************");
        System.out.println(".1  -- Add a new patient Patient List --");
        System.out.println(".2  -- Update a patient--");
        System.out.println(".3  -- Get a patient (by id) -- ");
        System.out.println(".4  -- Patient's List --");
        System.out.println(".5  -- Delete a patient (by id) --");
        System.out.println(".0  -- Quit ");
    }

    private void addPatient(){
        System.out.println("Please enter the patient's lastname : ");
        String lastname = scanner.nextLine();
        System.out.println("Please enter the patient's firstname : ");
        String firstname = scanner.nextLine();
        System.out.println("Please enter the patient's email : ");
        String email = scanner.nextLine();
        System.out.println("Please enter the patient's tel : ");
        String tel = scanner.nextLine();
        patientService.create(new Patient(lastname,firstname,email,tel));
    }

    private void updatePatient(){
        System.out.println("Please enter the id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Patient p = patientService.findById(id);
        System.out.println("Please enter the lastname : ");
        String lastname = scanner.nextLine();
        p.setLastName(lastname);
        System.out.println("Please enter the firstname : ");
        String firstname = scanner.nextLine();
        p.setFirstName(firstname);
        System.out.println("Please enter the email : ");
        String email = scanner.nextLine();
        p.setEmail(email);
        System.out.println("Please enter the tel : ");
        String tel = scanner.nextLine();
        p.setTel(tel);
        patientService.update(p);

    }

    private void getPatientById(){
        System.out.println("Please enter the id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Patient p = patientService.findById(id);
        System.out.println(p);
    }

       private static void getAllPatients(){
       System.out.println("###################");
       System.out.println("List of patients : ");
       System.out.println("###################");
           List<Patient> patients = patientService.findAll();
        for (Patient pa: patients) {
            System.out.println(pa);
        }
    }

    private void deletePatientById(){
        System.out.println("Please enter the id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Patient p = patientService.findById(id);
        patientService.delete(p);
    }


}
