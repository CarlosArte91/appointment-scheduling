package views.doctor;

import model.dao.DoctorDao;
import model.entity.Doctor;
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

    }

    private static LinkedHashMap<String, String> createHashLoginTitle() {
        LinkedHashMap<String, String> loginTitle = new LinkedHashMap<>();
        loginTitle.put("title", "Login Doctor");
        loginTitle.put("subtitle", "Enter your mail.");

        return loginTitle;
    }

    private static void verifyEmail() {
        String email = "";
        boolean isValid = false;

        email = readText();
        isValid = Doctor.validateDoctor(email);

        if (isValid) {
            // logged and continue
        } else {
            System.out.println("Email is not valid.");
        }
    }
}
