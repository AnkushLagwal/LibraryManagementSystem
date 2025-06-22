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


public class AdminLogin {
	final JFrame frame1;
	
	public AdminLogin() {
		frame1 = new JFrame("Admin Login");
		JPanel panel1= new JPanel();
		
		JLabel adminloginform = new JLabel("Admin Login Form");
		adminloginform.setFont(new Font("tahoma", Font.BOLD, 24));
		
		JLabel adminname = new JLabel("Enter Name : ");
		final JTextField nameinput = new JTextField(20);
		
		JLabel adminpassword = new JLabel("Enter Password : ");
		final JTextField passwordinput = new JTextField(20);
		
		JButton adminloginbtn = new JButton("Login");
		adminloginbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nameofadmin = nameinput.getText();
				String passwordofadmin = passwordinput.getText();
				
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
					System.out.println("Database connected");
					Statement statement = connection.createStatement();
					
					String LoginQuery = "SELECT name,password from admin WHERE (name='" + nameofadmin +"' and password = '" + passwordofadmin +"')";
					System.out.println(LoginQuery);
					
					ResultSet resultset = statement.executeQuery(LoginQuery);
					if(resultset.next()) {
						JOptionPane.showMessageDialog(frame1, "You are logged-in");
						AdminSection adminlogin = new AdminSection();
						adminlogin.frame2.setVisible(true);
						frame1.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame1, "Invalid Name and Password");
					}
					
				}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton admincancelbtn = new JButton("Cancel");
		admincancelbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomePage homepage = new HomePage();
				homepage.frame.setVisible(true);
				
			}
		});
		
		panel1.add(adminloginform);
		panel1.add(adminname);
		panel1.add(nameinput);
		panel1.add(adminpassword);
		panel1.add(passwordinput);
		panel1.add(adminloginbtn);
		panel1.add(admincancelbtn);
		
		frame1.add(panel1);
		frame1.setSize(280,300);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame1.setVisible(true);
	}
	public static void main(String[] args) {
		new AdminLogin();
	}
}
