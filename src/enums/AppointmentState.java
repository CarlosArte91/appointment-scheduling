package enums;

public enum AppointmentState {
    SCHEDULED("scheduled appointment."),
    AVAILABLE("available appointment.");

    private final String description;

    AppointmentState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
