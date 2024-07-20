package model.entity;

import enums.AppointmentState;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class MedicalAppointment {
    private UUID id;
    private LocalDate date;
    private LocalTime time;
    private UUID doctorId;
    private AppointmentState state;

    public MedicalAppointment(LocalDate date, LocalTime time, UUID doctorId) {
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;

        id = UUID.randomUUID();
        state = AppointmentState.AVAILABLE;
    }

    public MedicalAppointment(UUID id, LocalDate date, LocalTime time, UUID doctorId, AppointmentState state) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
        this.state = state;
    }

    public void setState(AppointmentState state) {
        this.state = state;
    }

    public String toCSV() {
        return id + "," + date + "," + time + "," + doctorId + "," + state;
    }
}
