package com.bookzone;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BrowsingWindow extends frame implements ActionListener{
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Transaction> transactions = new ArrayList<>();
    User loggedInUser;

    private Color darkGreen = new Color(15, 196, 122);
    private Color lightGreen = new Color(171,212,182);
    private JPanel sortingOptions;
    private JScrollPane ordersPanelScroller;
    private JPanel ordersPanel;

    private JRadioButton buy;
    private JRadioButton sell;
    private ButtonGroup buySell;
    private JPanel buySellPanel;

    private JRadioButton sortByPrice;
    private JRadioButton sortByConScore;
    private JRadioButton sortByAdScore;
    private ButtonGroup sortingButtons;
    private JPanel sortTypePanel;

    private JRadioButton ascending;
    private JRadioButton descending;
    private ButtonGroup ascDesc;
    private JPanel ascDescPanel;

    private JComboBox selectDepartment;
    private JButton selectDepartmentButton;
    private JPanel selectDepartmentPanel;
    private String[] departments;

    private JComboBox selectSemester;
    private JButton selectSemesterButton;
    private JPanel selectSemesterPanel;
    private String[] semesters;

    private JComboBox selectCourse;
    private JButton selectCourseButton;
    private JPanel selectCoursePanel;
    private ArrayList<String> courses;

    private JComboBox selectedCourse;
    private JButton deselectCourseButton;
    private JPanel selectedCoursesPanel;
    private ArrayList<String> selectedCourses;

    private JPanel userPanel;
    private JButton profileButton;
    private JLabel userNameLabel;
    private JLabel coinsLabel;



    private JFrame topFrame;


    public BrowsingWindow(ArrayList<User> users , ArrayList<Order> orders , ArrayList<Transaction> transactions, User loggedInUser){
        this.users = users;
        this.orders = orders;
        this.transactions = transactions;
        this.loggedInUser = loggedInUser;

        setLayout(new BorderLayout());
        setSize(new Dimension(1000,700));

        sortingOptions = new JPanel();
        sortingOptions.setLayout(new GridLayout(7,1));
        sortingOptions.setBorder(new EtchedBorder());
        sortingOptions.setPreferredSize(new Dimension(250,750));

        buy = new JRadioButton("Buy");
        buy.setBackground(darkGreen);
        sell = new JRadioButton("Sell");
        sell.setSelected(true);
        sell.setBackground(darkGreen);
        buySell = new ButtonGroup();
        buySell.add(buy);
        buySell.add(sell);
        buySellPanel = new JPanel();
        buySellPanel.setBackground(lightGreen);
        buySellPanel.setBorder(new TitledBorder(new EtchedBorder(), "Type"));
        buySellPanel.add(buy);
        buySellPanel.add(sell);

        sortByPrice = new JRadioButton("Price");
        sortByPrice.setSelected(true);
        sortByPrice.setBackground(darkGreen);
        sortByConScore = new JRadioButton("Condition Score");
        sortByConScore.setBackground(darkGreen);
        sortByAdScore = new JRadioButton("Advertiser Score");
        sortByAdScore.setBackground(darkGreen);
        sortingButtons = new ButtonGroup();
        sortingButtons.add(sortByPrice);
        sortingButtons.add(sortByConScore);
        sortingButtons.add(sortByAdScore);
        sortTypePanel = new JPanel();
        sortTypePanel.setBackground(lightGreen);
        sortTypePanel.setLayout(new GridLayout(3,1));
        sortTypePanel.setBorder(new TitledBorder(new EtchedBorder(), "Sort by:"));
        sortTypePanel.add(sortByPrice);
        sortTypePanel.add(sortByConScore);
        sortTypePanel.add(sortByAdScore);

        ascending = new JRadioButton("Ascending");
        ascending.setSelected(true);
        ascending.setBackground(darkGreen);
        descending = new JRadioButton("Descending");
        descending.setBackground(darkGreen);
        ascDesc = new ButtonGroup();
        ascDesc.add(ascending);
        ascDesc.add(descending);
        ascDescPanel = new JPanel();
        ascDescPanel.setBackground(lightGreen);
        ascDescPanel.add(ascending);
        ascDescPanel.add(descending);

        selectDepartmentButton = new JButton("Select Department");
        selectDepartmentButton.setBackground(darkGreen);
        selectDepartmentButton.addActionListener(this);
        departments = new String[]{"CS", "EEE"};
        selectDepartment = new JComboBox(departments);
        selectDepartmentPanel = new JPanel();
        selectDepartmentPanel.setBackground(lightGreen);
        selectDepartmentPanel.add(selectDepartment);
        selectDepartmentPanel.add(selectDepartmentButton);

        selectSemesterButton = new JButton("Select Semester");
        selectSemesterButton.setBackground(darkGreen);
        selectSemesterButton.addActionListener(this);
        semesters = new String[]{"1", "2"};
        selectSemester = new JComboBox(semesters);
        selectSemesterPanel = new JPanel();
        selectSemesterPanel.setBackground(lightGreen);
        selectSemesterPanel.add(selectSemester);
        selectSemesterPanel.add(selectSemesterButton);

        selectCourseButton = new JButton("Select Course");
        selectCourseButton.setBackground(darkGreen);
        selectCourseButton.addActionListener(this);
        courses = new ArrayList<String>(Arrays.asList("CS102", "MATH102", "MATH132", "TURK102", "ENG102"));
        selectCourse = new JComboBox(courses.toArray());
        selectCoursePanel = new JPanel();
        selectCoursePanel.setBackground(lightGreen);
        selectCoursePanel.add(selectCourse);
        selectCoursePanel.add(selectCourseButton);

        deselectCourseButton = new JButton("Deselect Course");
        deselectCourseButton.setBackground(darkGreen);
        deselectCourseButton.addActionListener(this);
        selectedCourses = new ArrayList<String>();
        selectedCourse = new JComboBox(selectedCourses.toArray());
        selectedCoursesPanel = new JPanel();
        selectedCoursesPanel.setBackground(lightGreen);
        selectedCoursesPanel.add(selectedCourse);
        selectedCoursesPanel.add(deselectCourseButton);

        sortingOptions.add(buySellPanel);
        sortingOptions.add(sortTypePanel);
        sortingOptions.add(ascDescPanel);
        sortingOptions.add(selectDepartmentPanel);
        sortingOptions.add(selectSemesterPanel);
        sortingOptions.add(selectCoursePanel);
        sortingOptions.add(selectedCoursesPanel);

        add(sortingOptions,BorderLayout.WEST);

        userNameLabel = new JLabel("User: "+loggedInUser.getName());
        coinsLabel = new JLabel("Coins: "+loggedInUser.getCoins());
        profileButton = new JButton("Back to Profile");
        profileButton.setBackground(darkGreen);
        profileButton.addActionListener(this);
        userPanel = new JPanel(new GridLayout(1,6));
        userPanel.setBackground(lightGreen);
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(lightGreen);
        userPanel.add(emptyPanel);
        userPanel.add(userNameLabel);
        userPanel.add(coinsLabel);
        userPanel.add(profileButton);

        add(userPanel,BorderLayout.NORTH);

        ordersPanel = new JPanel();

        ordersPanel.setLayout(new GridLayout(orders.size(),1));
        ordersPanel.setPreferredSize(new Dimension(300,orders.size()*200));
        for (int i = 0; i < orders.size(); i++) {
            if(!orders.get(i).getAdvertiser().equals(loggedInUser))
                ordersPanel.add(new OrderPanel(orders.get(i),loggedInUser));
        }

        ordersPanelScroller = new JScrollPane(ordersPanel);

        ordersPanelScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ordersPanelScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ordersPanelScroller.getVerticalScrollBar().setUnitIncrement(16);

        add(ordersPanelScroller,BorderLayout.CENTER);



    }

    public void UpdateOrdersPanel(){
        System.out.println("Update orders");
        boolean type = sell.isSelected();

        ArrayList<Order> selectedOrders = new ArrayList<Order>();
        if(selectedCourses.isEmpty()){
            for (int j = 0; j < orders.size(); j++) {
                if (!selectedOrders.contains(orders.get(j)) && !orders.get(j).getAdvertiser().equals(loggedInUser)&&orders.get(j).isSellOrder()==type)
                    selectedOrders.add(orders.get(j));
            }
        }
        else{
            for (int i = 0; i < selectedCourses.size(); i++) {
                for (int j = 0; j < orders.size(); j++) {
                    if (orders.get(j).isRelated2Course(selectedCourses.get(i))&&!selectedOrders.contains(orders.get(j))&&!orders.get(j).getAdvertiser().equals(loggedInUser)&&orders.get(j).isSellOrder()==type)
                        selectedOrders.add(orders.get(j));
                }
            }
        }


        ordersPanel = new JPanel();

        ordersPanel.setLayout(new GridLayout(selectedOrders.size(),1));
        ordersPanel.setPreferredSize(new Dimension(300,selectedOrders.size()*200));
        for (int i = 0; i < selectedOrders.size(); i++) {
            ordersPanel.add(new OrderPanel(selectedOrders.get(i),loggedInUser));
        }

        remove(ordersPanelScroller);
        ordersPanelScroller = new JScrollPane(ordersPanel);
        ordersPanelScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ordersPanelScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ordersPanelScroller.getVerticalScrollBar().setUnitIncrement(16);

        add(ordersPanelScroller,BorderLayout.CENTER);
        setVisible(true);
        //repaint();
    }

    public void UpdateCourses(){
        String semester = (String) selectSemester.getItemAt(selectSemester.getSelectedIndex());
        String department = (String) selectDepartment.getItemAt(selectDepartment.getSelectedIndex());
        String[] tmp;
        if(semester.equals("1")&&department.equals("CS"))
            tmp = new String[]{"CS101", "ENG101","MATH101","MBG110","TURK101"};
        else if (semester.equals("1")&&department.equals("EEE"))
            tmp = new String[]{"CS115", "ENG101","MATH101","PHYS101","TURK101"};
        else if(semester.equals("2")&&department.equals("CS"))
            tmp = new String[]{"CS102", "ENG102","MATH102","MATH132","TURK102"};
        else
            tmp = new String[]{"ENG102", "MATH102","PHYS102","TURK102"};

       selectCourse.removeAllItems();

        for (int i = 0; i < tmp.length; i++) {
            selectCourse.addItem(tmp[i]);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectCourseButton){
            System.out.println("Select Button Pressed");

            String tmp = (String) selectCourse.getItemAt(selectCourse.getSelectedIndex());

            if(!selectedCourses.contains(tmp)) {
                selectedCourse.addItem(tmp);
                selectedCourses.add(tmp);
            }
            UpdateOrdersPanel();
        }
        else if(e.getSource()==deselectCourseButton){
            System.out.println("Deselect Button Pressed");
            String tmp = (String) selectedCourse.getItemAt(selectedCourse.getSelectedIndex());

            if(selectedCourses.contains(tmp)) {
                selectedCourses.remove(tmp);
                selectedCourse.removeItemAt(selectedCourse.getSelectedIndex());

            }
            UpdateOrdersPanel();
        }
        else if(e.getSource()==selectSemesterButton){
            UpdateCourses();
        }
        else if(e.getSource()==selectDepartmentButton){
            UpdateCourses();
        }
        else if (e.getSource()==profileButton){
            new UserProfile(users,orders,transactions,loggedInUser);
            setVisible(false);
        }
    }
}

class OrderPanel extends JPanel{

    private Color darkGreen = new Color(15, 196, 122);
    private Color lightGreen = new Color(171,212,182);

    private JPanel picturePanel;
    private JPanel infoPanel1;
    private JPanel infoPanel2;
    private OrderButton priceButton;

    private JLabel picture;

    private JLabel nameLabel;
    private JLabel conditionLabel;
    private JLabel condition;
    private JLabel relatedLabel;
    private JLabel related;

    private JLabel advertiserNameLabel;
    private JLabel advertiserScoreLabel;
    private JLabel advertiserScore;


    public OrderPanel(Order order,User loggedInUser){
        setLayout(new GridLayout(1,4));
        setBorder(new EtchedBorder());
        picturePanel = new JPanel();
        picturePanel.setBackground(lightGreen);
        picture = new JLabel("Picture of Order");
        picturePanel.add(picture);
        //add(picturePanel);

        infoPanel1 = new JPanel(new GridLayout(5,1));
        infoPanel1.setBackground(lightGreen);
        nameLabel = new JLabel(order.getName());
        conditionLabel = new JLabel("Condition Score:");
        condition = new JLabel(""+order.getConditionScore()+"/10");
        relatedLabel = new JLabel("Related Courses: ");
        related = new JLabel(""+order.getRelatedCourses());
        infoPanel1.add(nameLabel);
        infoPanel1.add(conditionLabel);
        infoPanel1.add(condition);
        infoPanel1.add(relatedLabel);
        infoPanel1.add(related);
        add(infoPanel1);

        infoPanel2 = new JPanel((new GridLayout(3,1)));
        infoPanel2.setBackground(lightGreen);
        advertiserNameLabel = new JLabel("Advertiser: "+order.getAdvertiser().getName());
        advertiserScoreLabel = new JLabel("Advertiser Score:");
        advertiserScore = new JLabel(""+order.getAdvertiser().getScore()+"/10");
        infoPanel2.add(advertiserNameLabel);
        infoPanel2.add(advertiserScoreLabel);
        infoPanel2.add(advertiserScore);
        add(infoPanel2);

        priceButton = new OrderButton(order,loggedInUser);
        priceButton.setBackground(darkGreen);
        add(priceButton);



    }
}
class OrderButton extends JButton implements ActionListener{
    Order order;
    User loggedInUser;

    public OrderButton(Order order,User loggedInUser){
        super("Price: "+order.getPrice());
        this.order = order;
        this.loggedInUser = loggedInUser;
        setBackground(new Color(15, 196, 122));
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(order.isSellOrder())
            new SellOrder(order,loggedInUser);
        else
            new BuyOrder(order,loggedInUser);
    }
}
