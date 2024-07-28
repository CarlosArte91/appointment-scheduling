package views.login;

import views.doctor.DoctorView;

import static views.MainView.*;

import static views.input.Input.*;

import static views.menus.Menus.*;

import java.util.LinkedHashMap;

public class LoginView {
    private static int optionSelected = 0;

    public static void showLoginMenu() {
        LinkedHashMap<String, String> loginMenu = createHash();
        do {
            createMenu(loginMenu);
            optionSelected = readNumber();
            goToOption(optionSelected);
        } while (optionSelected < 0 || optionSelected > 2);
    }

    private static LinkedHashMap<String, String> createHash() {
        LinkedHashMap<String, String> loginMenu = new LinkedHashMap<>();
        loginMenu.put("title", "Login");
        loginMenu.put("subtitle", "Log in as.");
        loginMenu.put("1.", "Doctor");
        loginMenu.put("2.", "Patient");
        loginMenu.put("0.", "Go back");

        return loginMenu;
    }

    public static void goToOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                DoctorView.loginView();
                break;
            case 2:
                System.out.println("\n¡Under Construction!");
                break;
            case 0:
                showMainView();
                break;
            default:
                break;
        }
    }
}
