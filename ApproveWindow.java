import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApproveWindow extends JFrame implements ActionListener {
    //properties
    JPanel panel;
    JLabel approveWindow,confirmMessage;
    JButton userProfile;
    GridBagConstraints gbc;


    public ApproveWindow(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Approve Window");
        setSize(1000,1000);
        setVisible(true);

        //panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(1000,1000);
        panel.setBackground(new Color(171,212,182));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(50,50,50,50);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(panel);

        //label
        approveWindow= new JLabel("APPROVE WINDOW");
        approveWindow.setFont(new Font("Arial",Font.PLAIN,21));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(approveWindow,gbc);

        confirmMessage = new JLabel(" => Exchange has been done!");
        confirmMessage.setFont(new Font("Arial",Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(confirmMessage,gbc);


        //button
        userProfile = new JButton("User Profile");
        userProfile.setPreferredSize(new Dimension(40,60));
        userProfile.setBackground(Color.GREEN);
        userProfile.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;
        panel.add(userProfile,gbc);
    }

    public static void main(String[] args) {
        new ApproveWindow();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == userProfile){
            this.setVisible(false);
            new UserProfile();
        }

    }
}
