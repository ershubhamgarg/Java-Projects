package com.company;

import com.util.ConnectionConfiguration;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Shubham Garg on 27-01-2017.
 */
public class LoginPage {
static JLabel label_id,label_password;
static JTextField textfield_id;
static JPasswordField textfield_password;
static JButton button_login;
static JPanel panel;
static JRadioButton radio1,radio2;
//static Connection connection = ConnectionConfiguration.getConnection();
    public static void main(String args[]){

        JFrame f = new JFrame("LOGIN");
        f.setLayout(null);
        f.setSize(400,400);
panel = new JPanel();
panel.setVisible(true);
panel.setSize(400,100);
panel.setBackground(Color.white);
f.add(panel);
        radio1 = new JRadioButton("Teacher");
       // radio1.setLocation(50,50);
        radio1.setVisible(true);
        radio1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    System.out.println("Teacher selected");
                }
            }
        });

        radio2 = new JRadioButton("Student");
       // radio2.setLocation(150,50);
        radio2.setVisible(true);
        radio2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    System.out.println("Student selected");
                }
            }
        });

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        panel.add(radio1);
        panel.add(radio2);

        label_id = new JLabel("ID :");
        label_id.setVisible(true);
        label_id.setSize(100, 25);
        label_id.setLocation(100, 150);
        f.add(label_id);

        label_password = new JLabel("Password :");
        label_password.setVisible(true);
        label_password.setSize(100, 25);
        label_password.setLocation(100, 200);
        f.add(label_password);


        textfield_password = new JPasswordField(10);
        textfield_password.setSize(100,25);
        textfield_password.setVisible(true);
        textfield_password.setLocation(200,200);
        f.add(textfield_password);

        textfield_id = new JTextField(10);
        textfield_id.setSize(100,25);
        textfield_id.setVisible(true);
        textfield_id.setLocation(200,150);
        f.add(textfield_id);

        button_login = new JButton("Login");
        button_login.setSize(100, 30);
        button_login.setLocation(150, 300);
        button_login.setVisible(true);
        f.add(button_login);

       // int userid = Integer.parseInt(textfield_id.getText());
      //  String userpass = textfield_password.getText();

        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               /* try {
                    Statement statement = connection.createStatement();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

*/

         new App();
         System.out.println("Logged in !");
            f.setVisible(false);}

        });


        f.setVisible(true);
    }
}
