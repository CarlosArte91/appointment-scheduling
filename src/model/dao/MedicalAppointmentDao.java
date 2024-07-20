package model.dao;

import enums.AppointmentState;
import model.entity.MedicalAppointment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MedicalAppointmentDao {
    private final String medicalAppointmentsData = "./src/data/medicalAppointmentsData.csv";

    public void create(MedicalAppointment medicalAppointment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(medicalAppointmentsData, true))) {
            writer.write(medicalAppointment.toCSV());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public List<MedicalAppointment> showAll() {
        List<MedicalAppointment> medicalAppointments = new ArrayList<>();
        MedicalAppointment medicalAppointment;
        String[] lineReaded = new String[5];
        String line = "";
        String spliter = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(medicalAppointmentsData))) {
            while ((line = reader.readLine()) != null) {
                lineReaded = line.split(spliter);
                medicalAppointment = new MedicalAppointment(
                        UUID.fromString(lineReaded[0]),
                        LocalDate.parse(lineReaded[1]),
                        LocalTime.parse(lineReaded[2]),
                        UUID.fromString(lineReaded[3]),
                        AppointmentState.valueOf(lineReaded[4])
                );

                medicalAppointments.add(medicalAppointment);
            }
        } catch (Exception e) {
            System.out.println("An error ocurred " + e.getMessage());
        }

        return medicalAppointments;
    }
}
