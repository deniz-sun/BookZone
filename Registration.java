package com.bookzone;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.*;
import com.google.firebase.auth.*;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class register_page extends JFrame implements ActionListener {

    Container container = getContentPane();
    Color color = new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    String[] courses = {"courses", "math", "cs", "physics", "english"};

    JLabel message = new JLabel("BookZone account registration");
    JLabel name = new JLabel("Name and surname: ");
    JLabel phone = new JLabel("Phone number: ");
    JLabel email = new JLabel("Bilkent email: ");
    JLabel department = new JLabel("Department: ");
    JLabel classes = new JLabel("Current classes: ");
    JLabel password = new JLabel("Password: ");

    JButton registration = new JButton("Register!");

    static JTextField nameField = new JTextField();
    static JTextField surnameField = new JTextField();
    static JTextField phoneField = new JTextField();
    static JTextField emailField = new JTextField();
    static JTextField departmentField = new JTextField();
    static JTextField passwordField = new JTextField();
    JComboBox classesField = new JComboBox(courses);

    public static void main(String[] args) throws IOException, FirebaseAuthException {
        FileInputStream serviceAccount = new FileInputStream("./ServiceAccountKey.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bookzone.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(emailField.getText());
        // See the UserRecord reference doc for the contents of userRecord.


        System.out.println("Successfully fetched user data: " + userRecord.getEmail());




    }


    public void setContents(){
        message.setBounds(100,90,500,35);
        name.setBounds(100,160,250,30);
        phone.setBounds(100,220,250,30);
        email.setBounds(100,280,250,30);
        department.setBounds(100,340,250,30);
        classes.setBounds(100,400,250,30);
        password.setBounds(100,460,250,30);

        nameField.setBounds(350,160,140,30);
        surnameField.setBounds(510,160,140,30);
        phoneField.setBounds(350,220,300,30);
        emailField.setBounds(350,280,300,30);
        departmentField.setBounds(350,340,300,30);
        classesField.setBounds(350,400,300,30);
        passwordField.setBounds(350,460,300,30);
        registration.setBounds(450,550,200,30);

        registration.addActionListener(this);
        registration.setBackground(Color.gray.brighter());
        registration.setFont(font);

        message.setFont(new Font("Arial", Font.BOLD, 32));
        name.setFont(font);
        email.setFont(font);
        phone.setFont(font);
        department.setFont(font);
        classes.setFont(font);
        password.setFont(font);
    }

    public void addComponentsToContainer() {
        container.add(message);
        container.add(name);
        container.add(phone);
        container.add(email);
        container.add(department);
        container.add(classes);
        container.add(password);
        container.add(nameField);
        container.add(surnameField);
        container.add(phoneField);
        container.add(emailField);
        container.add(departmentField);
        container.add(passwordField);
        container.add(classesField);
        container.add(registration);

    }

    public register_page(){
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

            //creates an account and adds it to the database
            this.setVisible(false);
            new UserProfile();
        }

    }
}

