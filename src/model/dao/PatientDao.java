package model.dao;

import model.entity.Patient;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PatientDao {
    private final String patientsData = "./src/data/patientsData.csv";

    public void create(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientsData, true))) {
            writer.write(patient.toCSV());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("An error ocurred " + e.getMessage());
        }
    }
}
