package views.doctor;

import model.dao.DoctorDao;
import model.entity.Doctor;
import views.appointment.AppointmentView;
import views.login.LoginView;

import static views.login.UserLogged.*;

import static views.MainView.*;

import static views.menus.Menus.*;

import static views.input.Input.*;

import java.util.LinkedHashMap;

public class DoctorView {
    private static int optionSelected = 0;

    public static void addDoctor() {
        LinkedHashMap<String, String> addDoctorTitle = createHashTitle();
        LinkedHashMap<String, String> addDoctorSubTitle = createHashSubTitle();
        do {
            createMenu(addDoctorTitle);
            insert();
            createMenu(addDoctorSubTitle);
            optionSelected = readNumber();
            goToOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 1);
    }

    private static LinkedHashMap<String, String> createHashTitle() {
        LinkedHashMap<String, String> addDoctorTitle = new LinkedHashMap<>();
        addDoctorTitle.put("title", "Add Doctor");
        addDoctorTitle.put("subtitle", "Enter doctor information.");

        return addDoctorTitle;
    }

    private static void insert() {
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor;
        String name = "";
        String email = "";

        System.out.print("Name: ");
        name = readText();

        System.out.print("Email: ");
        email = readText();

        doctor = new Doctor(name, email);
        doctorDao.create(doctor);
    }

    private static LinkedHashMap<String, String> createHashSubTitle() {
        LinkedHashMap<String, String> addDoctorSubTitle = new LinkedHashMap<>();
        addDoctorSubTitle.put("title", "Doctor successfully created");
        addDoctorSubTitle.put("subtitle", "Create a new doctor?");
        addDoctorSubTitle.put("1.", "Create");
        addDoctorSubTitle.put("0.", "Go back");

        return addDoctorSubTitle;
    }

    public static void goToOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                addDoctor();
                break;
            case 0:
                showMainView();
                break;
            default:
                break;
        }
    }

    public static void loginView() {
        LinkedHashMap<String, String> loginTitle = createHashLoginTitle();
        createMenu(loginTitle);
        verifyEmail();
    }

    private static LinkedHashMap<String, String> createHashLoginTitle() {
        LinkedHashMap<String, String> loginTitle = new LinkedHashMap<>();
        loginTitle.put("title", "Login Doctor");
        loginTitle.put("subtitle", "Enter your mail.");

        return loginTitle;
    }

    private static void verifyEmail() {
        DoctorDao doctorDao = new DoctorDao();
        String email = "";
        boolean isValid = false;

        email = readText();
        isValid = Doctor.validateDoctor(email);

        if (isValid) {
            doctorLogged = doctorDao.byEmail(email);
            showDoctorMenu();
        } else {
            System.out.println("\nEmail is not valid.");
            LoginView.showLoginMenu();
        }
    }

    public static void showDoctorMenu() {
        LinkedHashMap<String, String> doctorMenu = createHashDoctorMenu();
        do {
            createMenu(doctorMenu);
            optionSelected = readNumber();
            goToDoctorOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 2);
    }

    private static LinkedHashMap<String, String> createHashDoctorMenu() {
        LinkedHashMap<String, String> doctorMenu = new LinkedHashMap<>();
        doctorMenu.put("title", "Welcome Doctor " + doctorLogged.getName());
        doctorMenu.put("subtitle", "Choose an option from the menu.");
        doctorMenu.put("1.", "Add new appointment");
        doctorMenu.put("2.", "Show my appointments");
        doctorMenu.put("0.", "Exit");

        return doctorMenu;
    }

    public static void goToDoctorOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                AppointmentView.createByDoctor();
                break;
            case 2:
                System.out.println("\n¡Under Construction!");
            case 0:
                showMainView();
                break;
            default:
                break;
        }
    }
}
