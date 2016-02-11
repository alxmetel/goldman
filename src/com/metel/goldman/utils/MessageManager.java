/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Metel
 */
public class MessageManager {

    public static void showInformMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    public static int showYesNoMessage(Component comp, String message) {
        return JOptionPane.showConfirmDialog(comp, message, "Confirmation", JOptionPane.YES_NO_OPTION);
    }

    public static int showYesNoCancelMessage(Component comp, String message) {
        return JOptionPane.showConfirmDialog(comp, message, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static void showErrorMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
