package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private List<MedicalAppointment> assignedAppointments;

    public Patient(String name, String email) {
        super(name, email);
        assignedAppointments = new ArrayList<>();
    }
}
