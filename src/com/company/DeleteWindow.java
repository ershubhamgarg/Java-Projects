package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.ConnectionConfiguration;
import java.sql.Connection;

/**
 * Created by Shubham Garg on 26-01-2017.
 */
public class DeleteWindow{

DeleteWindow(){

    JFrame f = new JFrame("Delete");
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

JButton button_delete;
    button_delete = new JButton("DELETE");
    button_delete.setSize(100, 25);
    button_delete.setLocation(130, 140);
    button_delete.setVisible(true);
    f.add(button_delete);

    f.setVisible(true);

    button_delete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(f,"Deleted");

            int id = Integer.parseInt(textfield_id.getText());

            try {
                Statement s = connection.createStatement();
                String query = "delete from student where id ="+ id;
                s.executeUpdate(query);
                s.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    });
}

}
