package com.company;

import com.util.ConnectionConfiguration;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit;

import java.util.Vector;

/**
 * Created by Shubham Garg on 27-01-2017.
 */
public class ShowTable extends DefaultTableModel {
    JFrame f = new JFrame("Table");
    String[] columnNames = {"ID", "Name","Date of Birth","Contact","Address","Attendance (%)"};


    Connection connection = ConnectionConfiguration.getConnection();
ShowTable(){

      // f.setSize(200,200);
f.setResizable(true);
       f.setLayout(new BorderLayout());
     //  f.setVisible(true);


    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);

    JTable table = new JTable();
    table.setModel(model);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setFillsViewportHeight(true);
table.setBackground(new Color(250,250,255));
    table.setFont(new Font("Comic sans",Font.BOLD, 14));
    table.setRowHeight(35);


    JScrollPane scroll = new JScrollPane(table);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select* from student");
        int i = 0;
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String dob = rs.getString(3);
            String phone = rs.getString(4);
            String address = rs.getString(5);
            String attendance = rs.getString(6);

            model.addRow(new Object[]{id,name,dob,phone,address,attendance});
            i++;
        }
        if(i<1){
            JOptionPane.showMessageDialog(null,"No Record");
}
if(i==1){
    System.out.println(i+ " record found");
        }
        else{
    System.out.println(i+ " records found");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
f.add(scroll);
    f.setVisible(true);
    f.setSize(1200,400);
    //while (rs.next()) {
        //  System.out.println(rs.getString("id") + "----" + rs.getString("name"));


    }
}
