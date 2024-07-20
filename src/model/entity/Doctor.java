package model.entity;

import model.dao.DoctorDao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor extends User {
    private static DoctorDao doctorDao = new DoctorDao();
    private List<MedicalAppointment> availableAppointments;

    public Doctor(String name, String email) {
        super(name, email);
        availableAppointments = new ArrayList<>();
    }

    public Doctor(UUID id, String name, String email) {
        super(name, email);
        this.setId(id);
    }

    public Doctor() {}

    public void addAvailableAppointment(LocalDate date, LocalTime time) {
        availableAppointments.add(new MedicalAppointment(date, time, super.getId()));
    }

    public static boolean validateDoctor(String email) {
        List<Doctor> doctors = doctorDao.showAll();
        boolean isValid = false;

        for (Doctor doctor : doctors) {
            if (doctor.getEmail().equals(email)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }
}
