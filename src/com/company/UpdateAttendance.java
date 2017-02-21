package com.company;

import com.util.ConnectionConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Shubham Garg on 27-01-2017.
 */
public class UpdateAttendance extends JFrame {
    JFrame f = new JFrame("UPDATE ATTENDANCE");
    JLabel label_id,label_attendance;
    JTextField textfield_attendance,textfield_id;
    JButton button_update;
    Connection connection = ConnectionConfiguration.getConnection();
    UpdateAttendance(){
        label_id = new JLabel("ID :");
        label_id.setVisible(true);
        label_id.setSize(100, 25);
        label_id.setLocation(100, 100);
        f.add(label_id);

        label_attendance = new JLabel("Attendance :");
        label_attendance.setVisible(true);
        label_attendance.setSize(100, 25);
        label_attendance.setLocation(100, 150);
        f.add(label_attendance);


        textfield_attendance = new JTextField(10);
        textfield_attendance.setSize(100,25);
        textfield_attendance.setVisible(true);
        textfield_attendance.setLocation(200,150);
        f.add(textfield_attendance);

        textfield_id = new JTextField(10);
        textfield_id.setSize(100,25);
        textfield_id.setVisible(true);
        textfield_id.setLocation(200,100);
        f.add(textfield_id);

        button_update = new JButton("UPDATE");
        button_update.setSize(100, 30);
        button_update.setLocation(150, 250);
        button_update.setVisible(true);
        f.add(button_update);

        button_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement statement = connection.createStatement();
                    String query = "update student set attendance = "+ textfield_attendance.getText() +" where id = "+ textfield_id.getText()+";";
            int count = statement.executeUpdate(query);
            System.out.println(count+ "rows affected");
            JOptionPane.showMessageDialog(null,"Attendance Updated");
                }
                catch (SQLException ek) {
                    ek.printStackTrace();
                }

            }
        });



        f.setLayout(null);
        f.setSize(400,400);

        f.setVisible(true);
    }
}
