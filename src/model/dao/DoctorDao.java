package model.dao;

import model.entity.Doctor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoctorDao {
    private final String doctorsData = "./src/data/doctorsData.csv";

    public void create(Doctor doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(doctorsData, true))) {
            writer.write(doctor.toCSV());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public Doctor byEmail(String email) {
        List<Doctor> doctors = showAll();
        Doctor doctorByEmail = new Doctor();

        for (Doctor doctor : doctors) {
            if (doctor.getEmail().equals(email)) {
                doctorByEmail = doctor;
                break;
            }
        }

        return doctorByEmail;
    }

    public List<Doctor> showAll() {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor;
        String[] lineReaded = new String[3];
        String line = "";
        String spliter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(doctorsData))) {
            while ((line = reader.readLine()) != null) {
                lineReaded = line.split(spliter);
                doctor = new Doctor(
                        UUID.fromString(lineReaded[0]),
                        lineReaded[1],
                        lineReaded[2]
                );

                doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("An error ocurred " + e.getMessage());
        }

        return doctors;
    }
}
