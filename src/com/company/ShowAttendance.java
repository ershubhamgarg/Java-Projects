package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.ConnectionConfiguration;
import java.sql.Connection;

/**
 * Created by Shubham Garg on 26-01-2017.
 */
public class ShowAttendance{

    ShowAttendance(){

        JFrame f = new JFrame("Attendance");
        f.setLayout(null);
        f.setSize(400, 400);
        f.setResizable(false);

        Connection connection = ConnectionConfiguration.getConnection();
        JLabel label_id;
        label_id = new JLabel("ID :");
        label_id.setVisible(true);
        label_id.setSize(100, 25);
        label_id.setLocation(100, 100);
        f.add(label_id);

        JTextField textfield_id;
        textfield_id = new JTextField();
        textfield_id.setVisible(true);
        textfield_id.setSize(100, 25);
        textfield_id.setLocation(130, 100);
        f.add(textfield_id);

        JButton button_show;
        button_show = new JButton("SHOW");
        button_show.setSize(100, 25);
        button_show.setLocation(130, 140);
        button_show.setVisible(true);
        f.add(button_show);

        JLabel label_att;
        label_att = new JLabel();
        label_att.setBackground(Color.white);
        label_att.setVisible(true);
        label_att.setSize(70, 50);
        label_att.setLocation(150, 200);
        label_att.setFont(new Font("Comic sans",Font.BOLD,30));
        f.add(label_att);

        f.setVisible(true);

        button_show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  JOptionPane.showMessageDialog(f,"Deleted");

                int id = Integer.parseInt(textfield_id.getText());

                try {
                    Statement s = connection.createStatement();
                    String query = "select attendance from student where id ="+ id;
                   ResultSet rs =  s.executeQuery(query);
                   rs.next();
                   String att = rs.getString(1);
                   label_att.setText(att);
                   System.out.println("Attendance for id = "+ id + " is "+  att);
                    s.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

}
