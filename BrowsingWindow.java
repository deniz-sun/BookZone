package com.bookzone;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BrowsingWindow extends frame implements ActionListener{
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



    private JFrame topFrame;


    public BrowsingWindow(){
        setSize(1000,700);
        setLayout(new BorderLayout());

        sortingOptions = new JPanel();
        sortingOptions.setLayout(new GridLayout(7,1));
        sortingOptions.setBorder(new EtchedBorder());
        sortingOptions.setPreferredSize(new Dimension(250,750));

        buy = new JRadioButton("Buy");
        buy.setSelected(true);
        buy.setBackground(darkGreen);
        sell = new JRadioButton("Sell");
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
        departments = new String[]{"CS", "EEE"};
        selectDepartment = new JComboBox(departments);
        selectDepartmentPanel = new JPanel();
        selectDepartmentPanel.setBackground(lightGreen);
        selectDepartmentPanel.add(selectDepartment);
        selectDepartmentPanel.add(selectDepartmentButton);

        selectSemesterButton = new JButton("Select Semester");
        selectSemesterButton.setBackground(darkGreen);
        semesters = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
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




        ordersPanel = new JPanel();

        ordersPanel.setLayout(new GridLayout(40,1));
        ordersPanel.setPreferredSize(new Dimension(300,7500));
        for (int i = 0; i < 40; i++) {
            ordersPanel.add(new OrderPanel(i));
        }

        ordersPanelScroller = new JScrollPane(ordersPanel);


        ordersPanelScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ordersPanelScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //ordersPanelScroller.setBounds(0,0,300,300);


        add(ordersPanelScroller,BorderLayout.CENTER);

        setVisible(true);

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
        }
        else if(e.getSource()==deselectCourseButton){
            System.out.println("Deselect Button Pressed");
            String tmp = (String) selectedCourse.getItemAt(selectedCourse.getSelectedIndex());

            if(selectedCourses.contains(tmp)) {
                selectedCourses.remove(tmp);
                selectedCourse.removeItemAt(selectedCourse.getSelectedIndex());

            }
        }
        else if(e.getSource()==selectSemesterButton){

        }
        else if(e.getSource()==selectDepartmentButton){

        }
    }
}

class OrderPanel extends JPanel{

    private Color darkGreen = new Color(15, 196, 122);
    private Color lightGreen = new Color(171,212,182);

    private JPanel picturePanel;
    private JPanel infoPanel1;
    private JPanel infoPanel2;
    private JButton priceButton;

    private JLabel picture;

    private JLabel nameLabel;
    private JLabel conditionLabel;
    private JLabel condition;
    private JLabel relatedLabel;

    private JLabel advertiserNameLabel;
    private JLabel advertiserScoreLabel;
    private JLabel advertiserScore;


    public OrderPanel(int i){
        setLayout(new GridLayout(1,4));
        setBorder(new EtchedBorder());
        picturePanel = new JPanel();
        picturePanel.setBackground(lightGreen);
        picture = new JLabel("Picture of "+i);
        picturePanel.add(picture);
        add(picturePanel);

        infoPanel1 = new JPanel(new GridLayout(4,1));
        infoPanel1.setBackground(lightGreen);
        nameLabel = new JLabel("Name of Material"+1);
        conditionLabel = new JLabel("Condition Score:");
        condition = new JLabel(""+(i%10)+"/10");
        relatedLabel = new JLabel("Related Courses");
        infoPanel1.add(nameLabel);
        infoPanel1.add(conditionLabel);
        infoPanel1.add(condition);
        infoPanel1.add(relatedLabel);
        add(infoPanel1);

        infoPanel2 = new JPanel((new GridLayout(3,1)));
        infoPanel2.setBackground(lightGreen);
        advertiserNameLabel = new JLabel("Name of Advertiser "+i);
        advertiserScoreLabel = new JLabel("Advertiser Score:");
        advertiserScore = new JLabel(""+(i+8)%10+"/10");
        infoPanel2.add(advertiserNameLabel);
        infoPanel2.add(advertiserScoreLabel);
        infoPanel2.add(advertiserScore);
        add(infoPanel2);

        priceButton = new JButton("Price of Material "+i);
        priceButton.setBackground(darkGreen);
        add(priceButton);



    }
}
