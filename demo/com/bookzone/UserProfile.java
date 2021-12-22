package com.bookzone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserProfile extends JFrame implements ActionListener {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Transaction> transactions = new ArrayList<>();
    User loggedInUser;

    //Properties
    JPanel panel,buy,sell,ongoings;
    JScrollPane buyScroller,sellScroller,ongoingsScroller;
    JLabel userProfile,books,buyOrders,sellOrders, recommended;
    JLabel name,surname,department,totalCoin,contact;
    JLabel emptyLabel1, emptyLabel2;
    JButton browse, logOff, plusOrder, plusSell;
    GridBagConstraints gbc;


    //Constructor
    public UserProfile(ArrayList<User> users , ArrayList<Order> orders , ArrayList<Transaction> transactions, User loggedInUser){
        this.users = users;
        this.orders = orders;
        this.transactions = transactions;
        this.loggedInUser = loggedInUser;

        //JFrame
        setTitle("User Profile");
        setSize(1000,700);
        getContentPane().setBackground(new Color(171,212,182));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //JPanel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1000,1200);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,100,10,120);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //JLabel
        userProfile = new JLabel("USER PROFILE");
        userProfile.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(userProfile,gbc);

        books = new JLabel("Books: ");
        books.setFont(new Font("Arial",Font.PLAIN,16));
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(books,gbc);

        buyOrders = new JLabel("Buy Orders: ");
        buyOrders.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buyOrders,gbc);

        sellOrders = new JLabel("Sell Orders: ");
        sellOrders.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(sellOrders,gbc);

        recommended = new JLabel("Ongoing: ");
        recommended.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(recommended,gbc);

        name = new JLabel("Name: "+loggedInUser.getName());
        name.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name,gbc);


        surname = new JLabel("Score: "+loggedInUser.getScore()+"/10");
        surname.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(surname,gbc);




        department = new JLabel("Department: "+loggedInUser.getDepartment());
        department.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(department,gbc);



        totalCoin = new JLabel("Total coin: "+loggedInUser.getCoins());
        totalCoin.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(totalCoin,gbc);

        contact = new JLabel("Contact: "+loggedInUser.getEmail());
        contact.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(contact,gbc);



        emptyLabel1 = new JLabel("");
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(emptyLabel1,gbc);

        emptyLabel2 = new JLabel("");
        gbc.weighty = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(emptyLabel2,gbc);


        //JButton
        buy=new JPanel(new GridLayout(1,loggedInUser.getBuyOrders().size()+1));
        buy.setPreferredSize(new Dimension(80*(loggedInUser.getBuyOrders().size()+1),100));
        for (int i = 0; i < loggedInUser.getBuyOrders().size(); i++) {
            buy.add(new MyOrderButton(loggedInUser.getBuyOrders().get(i),loggedInUser,orders));
        }
        plusOrder = new JButton("+");
        plusOrder.setPreferredSize(new Dimension(80,100));
        buy.add(plusOrder);
        buyScroller=new JScrollPane(buy);
        buyScroller.setPreferredSize(new Dimension(120,100));
        buyScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        buyScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(buyScroller,gbc);


        sell=new JPanel(new GridLayout(1,loggedInUser.getSellOrders().size()+1));
        sell.setPreferredSize(new Dimension(80*(loggedInUser.getSellOrders().size()+1),100));
        for (int i = 0; i < loggedInUser.getSellOrders().size(); i++) {
            sell.add(new MyOrderButton(loggedInUser.getSellOrders().get(i),loggedInUser,orders));
        }
        plusSell = new JButton("+");
        plusSell.setPreferredSize(new Dimension(80,100));
        sell.add(plusSell);
        sellScroller=new JScrollPane(sell);
        sellScroller.setPreferredSize(new Dimension(120,100));
        sellScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sellScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(sellScroller,gbc);

        ongoings=new JPanel(new GridLayout(1,loggedInUser.getOngoings().size()));
        ongoings.setPreferredSize(new Dimension(80*loggedInUser.getOngoings().size(),100));
        for (int i = 0; i < loggedInUser.getOngoings().size(); i++) {
            ongoings.add(new MyOrderButton(loggedInUser.getOngoings().get(i),loggedInUser,orders));
        }
        ongoingsScroller=new JScrollPane(ongoings);
        ongoingsScroller.setPreferredSize(new Dimension(120,100));
        ongoingsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ongoingsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(ongoingsScroller,gbc);

        browse = new JButton("Browse");
        browse.setPreferredSize(new Dimension(40,40));
        browse.setBackground(new Color(15, 196, 122));
        browse.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(browse,gbc);

        logOff = new JButton("Log Off");
        logOff.setPreferredSize(new Dimension(40,40));
        logOff.setBackground(new Color(15, 196, 122));
        logOff.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(logOff,gbc);

    }

    //Main

    public static void main(String[] args) {
        new UserProfile(new ArrayList<User>(),new ArrayList<Order>(),new ArrayList<Transaction>(),new User("Barış Kıcıman","EEE","baris.kiciman@ug.bilkent.edu.tr","k1ngp1n"));
    }




    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == browse ){
    		this.setVisible(false);
    		new BrowsingWindow(users,orders,transactions,loggedInUser);
    	}
    	else if(e.getSource() == logOff){
    		this.setVisible(false);
    		new login_page(users,orders,transactions);
    	}
        //else if (e.getSource()==)

    }
}

class MyOrderButton extends  JButton implements ActionListener{
    User loggedInUser;
    Order order;
    ArrayList<Order> orders;
    public MyOrderButton(Order order,User loggedInUser,ArrayList<Order> orders){
        super(order.getName());
        this.order = order;
        this.loggedInUser = loggedInUser;
        this.orders = orders;
        setBackground(new Color(15, 196, 122));
        setPreferredSize(new Dimension(80,100));
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(loggedInUser.isMyOrder(order))
            new MyOrder(order,loggedInUser,orders);
        else
            new OngoingOrder(order,loggedInUser,orders);
    }
}