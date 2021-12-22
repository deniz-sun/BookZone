package com.bookzone;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyOrder extends JFrame implements ActionListener{

    Order order;
    ArrayList<Order> orders;
    User loggedInUser;
    //properties
    JPanel panel,offersPanel;
    JScrollPane offersScroller;

    JLabel mySellOrder,conditionScore,offers,name1,name2,bookType,addRelatedCourse,bookName,bookPrice;
    JButton confirm,remove,accept1,accept2;
    GridBagConstraints gbc;

    //constructor
    public MyOrder(Order order, User loggedInUser,ArrayList<Order> orders){
        //frame
        this.order = order;
        this.loggedInUser = loggedInUser;
        this.orders = orders;
        setTitle("My Order");
        setSize(1000,700);
        setBackground(new Color(70, 213, 105));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1100,750);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,60,10,60);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //textfield
        bookName = new JLabel("Name: "+order.getName());
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookName,gbc);

        //String[] arr = {"Big Java Late Object","Calculus"};
        bookType = new JLabel("Type: "+order.getType());
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookType,gbc);

        bookPrice = new JLabel("Price: "+order.getPrice());
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(bookPrice,gbc);

        String[] arr2 = {"CS 102","CS 201"};
        addRelatedCourse = new JLabel("Related Courses: "+order.getRelatedCourses());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(addRelatedCourse,gbc);

        //label
        mySellOrder = new JLabel("My Order");
        mySellOrder.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(mySellOrder,gbc);

        conditionScore = new JLabel("Condition Score: "+order.getConditionScore()+"/10");
        conditionScore.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridheight = 1;
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(conditionScore,gbc);

        offers = new JLabel("Offers:");
        offers.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(offers,gbc);
/*
        name1= new JLabel("Alper Bozkurt");
        name1.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name1,gbc);

        name2 = new JLabel("Deniz Sun");
        name2.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name2,gbc);


 */
        /*
        //button
        courses = new JButton("CS 102");
        courses.setPreferredSize(new Dimension(80,60));
        courses.setBackground(Color.GREEN);
        courses.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(courses,gbc);


         */
        remove = new JButton("REMOVE");
        remove.setPreferredSize(new Dimension(120,60));
        remove.setBackground(new Color(15, 196, 122));
        remove.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(remove,gbc);

        if(order.getTransaction()==null) {
            offersPanel = new JPanel(new GridLayout(order.getCandidates().size(), 1));
            offersPanel.setBorder(new EtchedBorder());
            offersPanel.setPreferredSize(new Dimension(1000, order.getCandidates().size() * 200));
            for (int i = 0; i < order.getCandidates().size(); i++) {
                offersPanel.add(new OfferPanel(order, loggedInUser, order.getCandidates().get(i)));
            }
            offersScroller = new JScrollPane(offersPanel);
            offersScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            offersScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            offersScroller.setPreferredSize(new Dimension(1000, 400));


        }
        else{
            offersPanel = new JPanel(new GridLayout(1,3));
            offersPanel.setBorder(new EtchedBorder());
            offersPanel.setPreferredSize(new Dimension(1000, 200));
            offersPanel.setBackground(new Color(171,212,182));
            if (order.isSellOrder()) {
                offersPanel.add(new JLabel(order.getTransaction().getBuyer().getName()));
                offersPanel.add(new JLabel("Score: "+order.getTransaction().getBuyer().getScore()+"/10"));
                confirm = new JButton("Confirm");
                confirm.setBackground(new Color(15, 196, 122));
                confirm.addActionListener(this);
                offersPanel.add(confirm);
            }else{
                offersPanel.add(new JLabel(order.getTransaction().getSeller().getName()));
                offersPanel.add(new JLabel("Score: "+order.getTransaction().getSeller().getScore()+"/10"));
                confirm = new JButton("Confirm");
                confirm.setBackground(new Color(15, 196, 122));
                confirm.addActionListener(this);
                offersPanel.add(confirm);
            }

        }

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(offersPanel, gbc);






/*

        accept1= new JButton("ACCEPT");
        accept1.setPreferredSize(new Dimension(120,60));
        accept1.setBackground(Color.GREEN);
        accept1.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(accept1,gbc);

        accept2 = new JButton("ACCEPT");
        accept2.setPreferredSize(new Dimension(120,60));
        accept2.setBackground(Color.GREEN);
        accept2.addActionListener(this);
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(accept2,gbc);

 */
    }
/*
    public static void main(String[] args) {
        new MySellOrder();
    }
*/
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirm){
            if(order.isSellOrder())
                order.getTransaction().sellerConfirm();
            else
                order.getTransaction().buyerConfirm();
            System.out.println("Transaction confirmed");

            if (order.getTransaction().getConfirmation()) {
                order.getTransaction().enactTransaction();
                orders.remove(order);
                System.out.println("Transaction done");
                JOptionPane.showMessageDialog(this, "Transaction Done!");
            }
            else
                JOptionPane.showMessageDialog(this, "Transaction confirmed!");
        }
        else if(e.getSource() == remove){
            JOptionPane.showMessageDialog(this, "Order removed!");
            order.removeOrder();

        }

    }
}

class OfferPanel extends JPanel{
    Order order;
    User loggedInUser,candidate;
    JLabel candidateName,score;
    OfferButton button;
    public OfferPanel(Order order, User loggedInUser,User candidate){
        this.loggedInUser = loggedInUser;
        this.candidate = candidate;
        this.order = order;
        setBackground(new Color(171,212,182));
        setLayout(new GridLayout(1,3));
        setBorder(new EtchedBorder());
        candidateName = new JLabel(candidate.getName());
        add(candidateName);
        score = new JLabel("User score: "+candidate.getScore()+"/10");
        add(score);
        button = new OfferButton(order,loggedInUser,candidate);
        add(button);
    }
}

class OfferButton extends JButton implements ActionListener{
    Order order;
    User loggedInUser,candidate;
    public OfferButton(Order order, User loggedInUser,User candidate){
        super("Accept");
        this.loggedInUser = loggedInUser;
        this.order = order;
        this.candidate = candidate;
        setBackground(new Color(15, 196, 122));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        order.createTransaction(candidate);
        JOptionPane.showMessageDialog(this, "Transaction started!");

    }
}
