package views.appointment;

import model.dao.MedicalAppointmentDao;
import model.entity.MedicalAppointment;
import views.doctor.DoctorView;
import views.input.Input;
import views.login.UserLogged;
import views.menus.Menus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class AppointmentView {
    private static int optionSelected = 0;
    private static MedicalAppointmentDao appointmentDao = new MedicalAppointmentDao();
    private static MedicalAppointment medicalAppointment;
    private static LocalDate date;
    private static LocalTime time;

    public static void createByDoctor() {
        LinkedHashMap<String, String> hashTitle = createHashTitle();

        do {
            Menus.createMenu(hashTitle);
            date = Input.readDate();
            createSubtitle();
            time = Input.readTime();
            confirmAppointment();
            optionSelected = Input.readNumber();

            if (optionSelected == 1) {
                saveAppointment();
                otherAppointment();
            }
        } while (optionSelected != 1);
    }

    private static LinkedHashMap<String, String> createHashTitle() {
        LinkedHashMap<String, String> hashTitle = new LinkedHashMap<>();
        hashTitle.put("title", "New Appointment");
        hashTitle.put("subtitle", "Enter the appointment date in yyyy-mm-dd format.");

        return hashTitle;
    }

    private static void createSubtitle() {
        System.out.println("Enter the time for the appointment on " + date + " in hh:mm format");
    }

    private static void confirmAppointment() {
        System.out.println("\nConfirm appointment details on " + date + " " + time);
        System.out.println("1. Save");
        System.out.println("2. Change");
    }

    private static void saveAppointment() {
        medicalAppointment = new MedicalAppointment(date, time, UserLogged.doctorLogged.getId());
        appointmentDao.create(medicalAppointment);
    }

    private static void otherAppointment() {
        LinkedHashMap<String, String> otherAppointmentMenu = otherAppointmentHash();
        do {
            Menus.createMenu(otherAppointmentMenu);
            optionSelected = Input.readNumber();
            otherOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 1);
    }

    private static LinkedHashMap<String, String> otherAppointmentHash() {
        LinkedHashMap<String, String> otherAppointmentMenu = new LinkedHashMap<>();
        otherAppointmentMenu.put("title", "Appointment successfully created");
        otherAppointmentMenu.put("subtitle", "Create a new appointment?");
        otherAppointmentMenu.put("1.", "Create");
        otherAppointmentMenu.put("0.", "Go back");

        return otherAppointmentMenu;
    }

    private static void otherOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                createByDoctor();
                break;
            case 0:
                DoctorView.showDoctorMenu();
            default:
                break;

        }
    }
}
