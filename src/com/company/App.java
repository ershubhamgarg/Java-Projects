package com.company;
import com.util.ConnectionConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 * Created by Shubham Garg on 25-01-2017.
 */
public class App {
    static JFrame f;
    static JLabel label_id, label_name,label_main,label_dob,label_phone,label_address;
    static JTextField textfield_id, textfield_name,textfield_dob,textfield_phone,textfield_address;
    static JButton button_submit, button_delete,button_view,button_attendance,button_view_attendance;
    static Connection connection = null;


    App(){

        try {
            connection = ConnectionConfiguration.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
            }

/*================================================selecting table from database======================*/

            //Statement s = connection.createStatement();
            //ResultSet rs = s.executeQuery("select * from student");
            //while (rs.next()) {
            //  System.out.println(rs.getString("id") + "----" + rs.getString("name"));
            //}


/*=================================================================================================*/
            //s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        f = new JFrame("Form");
        f.setLayout(null);
        f.setSize(600, 700);
        f.getContentPane().setBackground(Color.WHITE);


        label_main = new JLabel("APPLICATION FORM");
        label_main.setVisible(true);
        label_main.setSize(200, 25);
        label_main.setLocation(100, 10);
        f.add(label_main);
        label_id = new JLabel("ID :");
        label_id.setVisible(true);
        label_id.setSize(100, 25);
        label_id.setLocation(100, 100);
        f.add(label_id);

        label_name = new JLabel("NAME :");
        label_name.setVisible(true);
        label_name.setSize(100, 25);
        label_name.setLocation(100, 150);
        f.add(label_name);

        label_dob = new JLabel("Date Of Birth :");
        label_dob.setVisible(true);
        label_dob.setSize(100, 25);
        label_dob.setLocation(100, 200);
        f.add(label_dob);

        label_phone = new JLabel("Contact no. :");
        label_phone.setVisible(true);
        label_phone.setSize(100, 25);
        label_phone.setLocation(100, 250);
        f.add(label_phone);

        label_address = new JLabel("Address :");
        label_address.setVisible(true);
        label_address.setSize(100, 25);
        label_address.setLocation(100, 300);
        f.add(label_address);

        textfield_id = new JTextField(10);
        textfield_id.setVisible(true);
        textfield_id.setSize(150, 25);
        textfield_id.setLocation(250, 100);
        f.add(textfield_id);

        textfield_name = new JTextField(10);
        textfield_name.setVisible(true);
        textfield_name.setSize(150, 25);
        textfield_name.setLocation(250, 150);
        f.add(textfield_name);

        textfield_dob = new JTextField(10);
        textfield_dob.setVisible(true);
        textfield_dob.setSize(150, 25);
        textfield_dob.setLocation(250, 200);
        f.add(textfield_dob);

        textfield_phone = new JTextField(10);
        textfield_phone.setVisible(true);
        textfield_phone.setSize(150, 25);
        textfield_phone.setLocation(250, 250);
        f.add(textfield_phone);

        textfield_address = new JTextField(10);
        textfield_address.setVisible(true);
        textfield_address.setSize(150, 25);
        textfield_address.setLocation(250, 300);
        f.add(textfield_address);

        button_submit = new JButton("SUBMIT");
        button_submit.setSize(100, 30);
        button_submit.setLocation(120, 400);
        button_submit.setBackground(new Color(160,160,200));
        button_submit.setVisible(true);
f.add(button_submit);

     button_delete = new JButton("DELETE");
       button_delete.setSize(100, 30);
        button_delete.setLocation(450, 250);
        button_delete.setVisible(true);
        f.add(button_delete);

      button_view = new JButton("Show Table");
        button_view.setSize(100, 30);
       button_view.setLocation(450, 200);
        button_view.setVisible(true);
       f.add(button_view);

        button_attendance = new JButton("Update Attendance");
        button_attendance.setSize(150, 30);
        button_attendance.setLocation(400, 50);
        button_attendance.setVisible(true);
        f.add(button_attendance);

        button_view_attendance = new JButton("Show Attendance");
        button_view_attendance.setSize(150, 30);
        button_view_attendance.setLocation(400, 500);
        button_view_attendance.setVisible(true);
        f.add(button_view_attendance);

        button_view_attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowAttendance();

            }
        });

        f.setVisible(true);


        button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(textfield_id.getText());
                String name = textfield_name.getText();
                String dob = textfield_dob.getText();
                String phone = textfield_phone.getText();
                String address = textfield_address.getText();

                String query1 = "insert into student values(?,?,?,?,?,?);";

                try {
                    PreparedStatement ps = connection.prepareStatement(query1);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, dob);
                    ps.setString(4, phone);
                    ps.setString(5, address);
                    ps.setString(6,null);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(f, "Values added");
                    ps.close();
/*===================================================================================================================================*/
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select* from student");

                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "---" + rs.getString(2)+ "---" + rs.getString(3)+ "---" + rs.getString(4)+ "---" + rs.getString(5));
   /*==============================================================================================================================*/
                    }

                    // connection.close();
                } catch (Exception el) {
                    el.printStackTrace();

                        JOptionPane.showMessageDialog(null, "duplicate");



                }


            }
        });
button_delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        new DeleteWindow();
    }
});

button_view.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        new ShowTable();
    }
});

button_attendance.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new UpdateAttendance();
    }
});
    }

}