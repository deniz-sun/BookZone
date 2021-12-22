package com.bookzone;
import com.bookzone.ApproveWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRequest extends JFrame implements ActionListener{

    //properties
    Container container = getContentPane();
    Color color =  new Color(171,212,182);
    Font font = new Font("Arial", Font.PLAIN, 20);

    JLabel bookRequest = new JLabel("BOOK REQUEST");
    JLabel name = new JLabel("ALPER BOZKURT");
    JLabel bookPhoto = new JLabel("*Photo of the book*");
    JLabel requestMessage = new JLabel("'Calculus' wanted by Alper.");

    JButton accept = new JButton("ACCEPT");
    JButton refuse = new JButton("REFUSE");

    //constructor
    public BookRequest(){
        setTitle("Book Request");
        setVisible(true);
        setSize(1000, 700);
        getContentPane().setBackground(color);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container.setLayout(null);

        setContents();
        addComponentsToContainer();
    }

    //main
    public static void main(String[] args) {
        new BookRequest();
    }

    //methods
    public void setContents(){
        bookRequest.setBounds(400,30,500,50);
        name.setBounds(60,80,300,50);
        bookPhoto.setBounds(40,100,250,350);
        requestMessage.setBounds(370,250,500,30);

        accept.setBounds(200,550,200,50);
        refuse.setBounds(600,550,200,50);

        accept.addActionListener(this);
        refuse.addActionListener(this);

        bookRequest.setFont(font);
        name.setFont(font);
        bookPhoto.setFont(font);
        requestMessage.setFont(font);

        accept.setBackground(Color.gray.brighter());
        accept.setFont(font);
        refuse.setBackground(Color.gray.brighter());
        refuse.setFont(font);
    }

    public void addComponentsToContainer(){
        container.add(bookRequest);
        container.add(name);
        container.add(bookPhoto);
        container.add(requestMessage);
        container.add(accept);
        container.add(refuse);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accept){
            this.setVisible(false);
            new ApproveWindow();
        }
        else if(e.getSource() == refuse){
            this.setVisible(false);
            new MySellOrder();
        }
    }
}

