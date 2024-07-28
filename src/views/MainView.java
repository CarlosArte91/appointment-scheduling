package views;

import static views.patient.PatientView.*;

import static views.doctor.DoctorView.*;

import static views.login.LoginView.*;

import static views.input.Input.*;

import static views.menus.Menus.*;

import java.util.LinkedHashMap;

public class MainView {
    private static int optionSelected = 0;

    public static void showMainView() {
        LinkedHashMap<String, String> mainMenu = createHash();
        do {
            createMenu(mainMenu);
            optionSelected = readNumber();
            goToOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 3);
    }

    private static LinkedHashMap<String, String> createHash() {
        LinkedHashMap<String, String> mainMenu = new LinkedHashMap<>();
        mainMenu.put("title", "Main Menu");
        mainMenu.put("subtitle", "Choose an option from the menu.");
        mainMenu.put("1.", "Login");
        mainMenu.put("2.", "Add doctor");
        mainMenu.put("3.", "Add patient");
        mainMenu.put("0.", "Exit");

        return mainMenu;
    }

    public static void goToOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                addDoctor();
                break;
            case 3:
                addPatient();
                break;
            case 0:
                System.out.println("¡Bye Bye! =)");
                break;
            default:
                break;
        }
    }
}
