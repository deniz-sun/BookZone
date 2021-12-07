package com.bookzone;

import javax.swing.*;
import java.awt.*;

public class login_page extends JPanel {
    JLabel email_label;
    Font font = new Font("Arial", Font.PLAIN, 30);
    JLabel password_label;
    TextField email_entry = new TextField(30);
    TextField password_entry = new TextField(30);
    public login_page() {
        Frame frame = new frame();
        this.setBackground(Color.white);
      //  this.setPreferredSize(new Dimension(600,300));
        email_label = new JLabel("Username: ");
        password_label = new JLabel("Password: ");
        email_label.setFont(font);
        password_label.setFont(font);

        this.add(email_label);
        this.add(email_entry);
        this.add(password_label);
        this.add(password_entry);
        this.setMaximumSize(new Dimension(600,300));

        frame.add(this, BorderLayout.CENTER);

     //   this.setVisible(true);





    }

    public static void main(String[] args) {
      //  new frame();
        new login_page();
    }

}
