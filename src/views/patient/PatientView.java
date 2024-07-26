package views.patient;

import model.dao.PatientDao;
import model.entity.Patient;
import static views.menus.Menus.*;

import java.util.LinkedHashMap;

import static views.MainView.showMainView;
import static views.input.Input.*;

public class PatientView {
    private static int optionSelected = 0;

    public static void addPatient() {
        LinkedHashMap<String, String> addPatientTitle = createHashTitle();
        LinkedHashMap<String, String> addPatientSubTitle = createHashSubTitle();
        do {
            createMenu(addPatientTitle);
            insert();
            createMenu(addPatientSubTitle);
            optionSelected = readNumber();
            goToOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 1);
    }

    private static LinkedHashMap<String, String> createHashTitle() {
        LinkedHashMap<String, String> addPatientTitle = new LinkedHashMap<>();
        addPatientTitle.put("title", "Add Patient");
        addPatientTitle.put("subtitle", "Enter patient information.");

        return addPatientTitle;
    }

    private static void insert() {
        PatientDao patientDao = new PatientDao();
        Patient patient;
        String name = "";
        String email = "";

        System.out.print("Name: ");
        name = readText();

        System.out.print("Email: ");
        email = readText();

        patient = new Patient(name, email);
        patientDao.create(patient);
    }

    private static LinkedHashMap<String, String> createHashSubTitle() {
        LinkedHashMap<String, String> addPatientSubTitle = new LinkedHashMap<>();
        addPatientSubTitle.put("title", "Patient successfully created");
        addPatientSubTitle.put("subtitle", "Create a new patient?");
        addPatientSubTitle.put("1.", "Create");
        addPatientSubTitle.put("0.", "Go back");

        return addPatientSubTitle;
    }

    public static void goToOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                addPatient();
                break;
            case 0:
                showMainView();
                break;
            default:
                break;
        }
    }
}
