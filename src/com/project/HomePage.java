package com.project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePage{
	public static JFrame frame;
	public static void main(String[] args) {
		
		frame = new JFrame("Library Management System");
		JPanel panel = new JPanel();
		
		JLabel LMS = new JLabel("LR Engineering & Technology Library");
		LMS.setFont(new Font("tahoma", Font.BOLD, 20));
		
		
		JButton adminlogin = new JButton("Admin Login");
		adminlogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminlogin1 = new AdminLogin(); 
				adminlogin1.frame1.setVisible(true);
				
			}
		});
		
		JButton librarianlogin = new JButton("Librarian Login");
		librarianlogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LibrarianLogin librarianlogin = new LibrarianLogin(); 
				librarianlogin.frame6.setVisible(true);
				
			}
		});
		
		
		panel.add(LMS);
		panel.add(adminlogin);
		panel.add(librarianlogin);
		
		frame.add(panel);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
		
		
		
}
}
