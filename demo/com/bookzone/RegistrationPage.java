package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationPage extends JFrame implements ActionListener {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    Container container = getContentPane();
    Color color = new Color(171, 212, 182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    String[] courses = {"courses", "math", "cs", "physics", "english"};

    JLabel message = new JLabel("BookZone account registration");
    JLabel nameLabel = new JLabel("Name and surname: ");
    JLabel phoneLabel = new JLabel("Phone number: ");
    JLabel emailLabel = new JLabel("Bilkent email: ");
    JLabel department = new JLabel("Department: ");
    JLabel classes = new JLabel("Current classes: ");
    JLabel passwordLabel = new JLabel("Password: ");

    JButton registration = new JButton("Register!");

    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField departmentField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JComboBox classesField = new JComboBox(courses);
    JCheckBox showPassword = new JCheckBox("Show Password");

    //Firestore db;

    String email, phone, name, password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
/*
    public static void main(String[] args) {
        new login_page(users,orders,transactions);

    }

 */


    public void setContents() {
        message.setBounds(100, 90, 500, 35);
        nameLabel.setBounds(100, 160, 250, 30);
        phoneLabel.setBounds(100, 220, 250, 30);
        emailLabel.setBounds(100, 280, 250, 30);
        department.setBounds(100, 340, 250, 30);
        classes.setBounds(100, 400, 250, 30);
        passwordLabel.setBounds(100, 460, 250, 30);
        showPassword.setBounds(350, 500, 150, 30);

        nameField.setBounds(350, 160, 140, 30);
        surnameField.setBounds(510, 160, 140, 30);
        phoneField.setBounds(350, 220, 300, 30);
        emailField.setBounds(350, 280, 300, 30);
        departmentField.setBounds(350, 340, 300, 30);
        classesField.setBounds(350, 400, 300, 30);
        passwordField.setBounds(350, 460, 300, 30);
        registration.setBounds(450, 550, 200, 30);

        registration.addActionListener(this);
        registration.setBackground(Color.gray.brighter());
        registration.setFont(font);
        showPassword.addActionListener(this);
        showPassword.setBackground(color);

        message.setFont(new Font("Arial", Font.BOLD, 32));
        nameLabel.setFont(font);
        emailLabel.setFont(font);
        phoneLabel.setFont(font);
        department.setFont(font);
        classes.setFont(font);
        passwordLabel.setFont(font);
        showPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    }

    public void addComponentsToContainer() {
        container.add(message);
        container.add(nameLabel);
        container.add(phoneLabel);
        container.add(emailLabel);
        container.add(department);
        container.add(classes);
        container.add(passwordLabel);
        container.add(nameField);
        container.add(surnameField);
        container.add(phoneField);
        container.add(emailField);
        container.add(departmentField);
        container.add(passwordField);
        container.add(classesField);
        container.add(registration);
        container.add(showPassword);
    }

    public RegistrationPage(ArrayList<User> users , ArrayList<Order> orders , ArrayList<Transaction> transactions ) {
        this.users = users;
        this.orders = orders;
        this.transactions = transactions;

        setTitle("BookZone registration page");
        setVisible(true);
        setSize(1000, 700);
        getContentPane().setBackground(color);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        container.setLayout(null);

        setContents();
        addComponentsToContainer();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registration){

            try {
                initializeDatabase();

                ManageData data = new ManageData(db, name, email, phone, password);
                data.addUserDocsAsMap();

            } catch (FirebaseAuthException | IOException | ExecutionException | InterruptedException firebaseAuthException) {
                firebaseAuthException.printStackTrace();
            }
            this.setVisible(false);
            new UserProfile();

 
        }
        if (e.getSource() == showPassword) {
            
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

             

        }

    }
}
