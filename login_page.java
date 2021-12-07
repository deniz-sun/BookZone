package com.bookzone;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_page extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("Email: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    Font font = new Font("Arial", Font.PLAIN, 30);


    public login_page() {
        setTitle("Book Zone Login Page");
        setVisible(true);
        setSize(1000,700);
        getContentPane().setBackground(new Color(171,212,182));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        container.setLayout(null);
        setContents();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setContents() {
        showPassword.setBackground(new Color(171,212,182));
        userLabel.setFont(font);
        passwordLabel.setFont(font);
        userLabel.setBounds(250, 250, 150, 30);
        passwordLabel.setBounds(250, 320, 150, 30);
        userTextField.setBounds(500, 250, 200, 30);
        passwordField.setBounds(500, 320, 200, 30);
        showPassword.setBounds(500, 350, 150, 30);
        loginButton.setBounds(250, 400, 100, 30);
        resetButton.setBounds(600, 400, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("denizsun") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
 public static void main(String[] args){

         new LoginFrame();
    }
}
