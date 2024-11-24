package hospital.management.system;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.*;

public class New_patient extends JFrame implements ActionListener {

    JRadioButton r1, r2;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JLabel date;
    Choice c1;
    JButton b1, b2;
    JComboBox comboBox;

    New_patient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 490);
        panel.setBackground(new Color(232	,74	,95));
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(new Color(42,54, 59));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Aadhar Card", "VoterID", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(42,54, 59));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(42,54, 59));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(42,54, 59));
        r2.setBounds(350, 191, 80, 15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        //Room Choice//
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(42,54, 59));
        panel.add(c1);

        JLabel labelTime = new JLabel("Time :");
        labelTime.setBounds(35, 316, 200, 14);
        labelTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTime.setForeground(Color.WHITE);
        panel.add(labelTime);

        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(271, 316, 250, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 17);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);

        b1 = new JButton("Add");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(42,54, 59));
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(42,54, 59));
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850, 500);
        setLayout(null);
        setLocation(400, 210);
        setVisible(true);


    }

    public static void main(String[] args) {
        new New_patient();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textName.getText();
            String s3 = textFieldNumber.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try {
                String q = "insert into patient_info values('"+s1 +"','"+s2 +"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no =" + s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");

            }
            catch (Exception E)
            {
                E.printStackTrace();
            }


        }
        else {
            setVisible(false);
        }
    }
}