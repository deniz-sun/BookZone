
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame implements ActionListener {

    //Properties
    JPanel panel;
    JLabel userProfile,books,buyOrders,sellOrders, recommended;
    JLabel name,surname,department,totalCoin,contact;
    JLabel emptyLabel1, emptyLabel2;
    JButton browse, logOff, plusOrder, plusSell;
    GridBagConstraints gbc;


    //Constructor
    public UserProfile(){
        //JFrame
        setTitle("User Profile");
        setSize(1100,750);
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
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(books,gbc);

        buyOrders = new JLabel("Buy Orders: ");
        buyOrders.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(buyOrders,gbc);

        sellOrders = new JLabel("Sell Orders: ");
        sellOrders.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(sellOrders,gbc);

        recommended = new JLabel("Recommended: ");
        recommended.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(recommended,gbc);

        name = new JLabel("Name: ");
        name.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(name,gbc);


        surname = new JLabel("Surname: ");
        surname.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(surname,gbc);


        department = new JLabel("Department: ");
        department.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(department,gbc);

        totalCoin = new JLabel("Total coin: ");
        totalCoin.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(totalCoin,gbc);

        contact = new JLabel("Contact: ");
        contact.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(contact,gbc);

        emptyLabel1 = new JLabel("");
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 7;
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
        plusOrder = new JButton("+");
        plusOrder.setPreferredSize(new Dimension(40,60));
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;

        panel.add(plusOrder,gbc);

        plusSell = new JButton("+");
        plusSell.setPreferredSize(new Dimension(40,60));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(plusSell,gbc);

        browse = new JButton("Browse");
        browse.setPreferredSize(new Dimension(40,40));
        browse.setBackground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(browse,gbc);

        logOff = new JButton("Log Off");
        logOff.setPreferredSize(new Dimension(40,40));
        logOff.setBackground(Color.GREEN);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(logOff,gbc);

    }

    //Main
    public static void main(String[] args) {
        new UserProfile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    /*	if(e.getSource() == browse ){
    		BrowsingPage();
    	}
    	else if(e.getSource() == logOff){
    		LoginFrame();
    	}*/

    }
}