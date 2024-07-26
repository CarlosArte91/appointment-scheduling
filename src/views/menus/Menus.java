package views.menus;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Menus {
    public static void createMenu(LinkedHashMap<String, String> menu) {
        Iterator<String> it = menu.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();

            if (key.equals("title")) {
                createTitle(menu.get(key));
            } else if (key.equals("subtitle")) {
                System.out.println(menu.get(key));
            } else {
                System.out.println(key + " " + menu.get(key));
            }
        }
    }

    private static void createTitle(String title) {
        String line = "*****";
        String spaces = "";
        String meddle = "";

        for (int i = 0; i < title.length(); i++) {
            line += "**";
            if (i % 2 == 0) {
                spaces += " ";
            }
        }

        meddle = "**" + spaces + title + spaces + "**";

        System.out.println("\n");
        System.out.println(line);
        System.out.println(meddle);
        System.out.println(line);
    }
}
