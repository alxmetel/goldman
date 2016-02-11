/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metel.goldman.gui;

import com.metel.goldman.validators.NameValidator;
import com.metel.goldman.validators.StringValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Metel
 */
public class CustomDialog extends javax.swing.JDialog implements ActionListener, PropertyChangeListener {

    private StringValidator nameValidator = new NameValidator();
    private String typedText = null;
    private JTextField textField;
    private JOptionPane optionPane;
    private static final String OK_BUTTON = "OK";
    private static final String CANCEL_BUTTON = "Cancel";

    public String getValidatedText() {
        return typedText;
    }

    public void setUsername(String username) {
        textField.setText(username);
        textField.selectAll();
        textField.requestFocus();
    }

    public CustomDialog(java.awt.Frame parent, String title, String message, boolean modal) {
        super(parent, modal);
        initComponents();


        textField = new JTextField(10);
        setTitle(title);

        Object[] array = {message, textField};


        Object[] options = {OK_BUTTON, CANCEL_BUTTON};


        optionPane = new JOptionPane(array,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);


        setContentPane(optionPane);


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                optionPane.setValue(new Integer(
                        JOptionPane.CLOSED_OPTION));
            }
        });


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });


        textField.addActionListener(this);
        optionPane.addPropertyChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(OK_BUTTON);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (isVisible()
                && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop)
                || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }

            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            if (OK_BUTTON.equals(value)) {
                typedText = textField.getText();
                if (nameValidator.isValid(typedText.toUpperCase())) {

                    clearAndHide();
                } else {

                    textField.selectAll();
                    JOptionPane.showMessageDialog(
                            CustomDialog.this,
                            "Name \"" + typedText + "\" cannot be used. Please enter other name.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else {
                typedText = null;
                clearAndHide();
            }
        }
    }

    public void clearAndHide() {
        textField.setText(null);
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("dialog0"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(375, 181));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
