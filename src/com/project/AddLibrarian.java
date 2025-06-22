package com.project;

//import javafx.application.Application;
//import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class AddLibrarian {
	
	public static JFrame frame3;
	public AddLibrarian() {
		frame3 = new JFrame("Add Librarian");
		JPanel panel3 = new JPanel();
		
		JLabel addlibrarian = new JLabel("Add Librarian");
		addlibrarian.setFont(new Font("tahoma", Font.BOLD, 32));
		
		JLabel idlabel = new JLabel("ID : ");
		final JTextField idinput = new JTextField(20);
		
		JLabel namelabel = new JLabel("Name : ");
		final JTextField nameinput = new JTextField(20);
		
		JLabel passwordlabel = new JLabel("Password : ");
		final JTextField passwordinput = new JTextField(20);
		
		JLabel addresslabel = new JLabel("Address : ");
		final JTextField addressinput = new JTextField(20);
		
		
		JLabel citylabel = new JLabel("City : ");
		final JTextField cityinput = new JTextField(20);
		
		
		JLabel contactlabel = new JLabel("Contact No. : ");
		final JTextField contactinput = new JTextField(20);
		
		
		JButton addlibrarianbtn = new JButton("Add Librarian");
		addlibrarianbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
				
				Statement statement = connection.createStatement();
				
				String InsertQuery = "INSERT INTO librarian (id ,name,password,address,city,contact) values(?,?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(InsertQuery);
				
				
					
				int newid =Integer.parseInt(idinput.getText());
				prepareStatement.setInt(1,newid);
				
				String newname = nameinput.getText();
				prepareStatement.setString(2, newname);
				
				String newpassword = passwordinput.getText();
				prepareStatement.setString(3, newpassword);
				
				String newaddress = addressinput.getText();
				prepareStatement.setString(4, newaddress);
				
				String newcity = cityinput.getText();
				prepareStatement.setString(5, newcity);
				
				String newcontact =contactinput.getText();
				prepareStatement.setString(6,newcontact);
				
				prepareStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(frame3, "New Librarian Added Successfully");
				
				AdminSection adminsection = new AdminSection();
				adminsection.frame2.setVisible(true);
				frame3.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame3, " ✖ Invalid ID or Contact no.");
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdminSection adminsection = new AdminSection();
				adminsection.frame2.setVisible(true);
				
			}
		});
		
		panel3.add(addlibrarian);
		panel3.add(idlabel);
		panel3.add(idinput);
		panel3.add(namelabel);
		panel3.add(nameinput);
		panel3.add(passwordlabel);
		panel3.add(passwordinput);
		panel3.add(addresslabel);
		panel3.add(addressinput);
		panel3.add(citylabel);
		panel3.add(cityinput);
		panel3.add(contactlabel);
		panel3.add(contactinput);
		panel3.add(addlibrarianbtn);
		panel3.add(backbtn);
		
		
		
		frame3.add(panel3);
		frame3.setSize(250,410);
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame3.setVisible(true);
	}

}
