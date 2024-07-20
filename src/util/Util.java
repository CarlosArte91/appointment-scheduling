package util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Util {
    public static void clearConsole() {
        try {
            Robot captureKey = new Robot();
            captureKey.keyPress(KeyEvent.VK_CONTROL);
            captureKey.keyPress(KeyEvent.VK_H);
            captureKey.keyRelease(KeyEvent.VK_CONTROL);
            captureKey.keyRelease(KeyEvent.VK_H);
        } catch (AWTException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void activeCursor() {
        try {
            Robot captureKey = new Robot();
            captureKey.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            captureKey.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
