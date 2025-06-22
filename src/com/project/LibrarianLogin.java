package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.cj.xdevapi.Result;


public class LibrarianLogin {
	public JFrame frame6;
	
	public LibrarianLogin() {
		frame6 = new JFrame("Librarian Login");
		final JPanel panel6= new JPanel();
		
		JLabel librarianloginform = new JLabel("Librarian Login Form");
		librarianloginform.setFont(new Font("tahoma", Font.BOLD, 24));
		
		final JLabel librarianname = new JLabel("Enter Name : ");
		final JTextField nameinput = new JTextField(20);
		
		final JLabel librarianpassword = new JLabel("Enter Password : ");
		final JTextField passwordinput = new JTextField(20);
		
		 JButton librarianloginbtn = new JButton("Login");
		 librarianloginbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nameoflibrarian = nameinput.getText();
				String passwordoflibrarian = passwordinput.getText();
				
				
					Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
					Statement statement = connection.createStatement();
					
					
					String LoginQuery = "SELECT name,password from librarian WHERE (name='" + nameoflibrarian +"' and password = '" + passwordoflibrarian +"')";
//					System.out.println(LoginQuery);
					
					ResultSet resultset = statement.executeQuery(LoginQuery);
					if(resultset.next()) {
						JOptionPane.showMessageDialog(frame6, "You are logged-in");
						LibrarianSection librarianlogin = new LibrarianSection();
						librarianlogin.frame7.setVisible(true);
						frame6.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame6, "Invalid Name or Password");
					}
					
				}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		
		
		JButton librariancancelbtn = new JButton("Cancel");
		librariancancelbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomePage homepage = new HomePage();
				homepage.frame.setVisible(true);
				
			}
		});
		
		panel6.add(librarianloginform);
		panel6.add(librarianname);
		panel6.add(nameinput);
		panel6.add(librarianpassword);
		panel6.add(passwordinput);
		panel6.add(librarianloginbtn);
		panel6.add(librariancancelbtn);
	
		
		frame6.add(panel6);
		frame6.setSize(280,300);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame6.setVisible(true);
	}
		
	}



