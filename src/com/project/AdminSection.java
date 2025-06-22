package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminSection {
	public static JFrame frame2;
	public  AdminSection() {
		frame2 = new JFrame("Admin Section");
		JPanel panel2 = new JPanel();
		
		JLabel adminsection = new JLabel("Admin Section");
		adminsection.setFont(new Font("tahoma", Font.BOLD, 24));
		
		JButton addlibrarianbtn = new JButton("Add Librarian");
		addlibrarianbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddLibrarian addlibrarian = new AddLibrarian();
				addlibrarian.frame3.setVisible(true);
//				frame2.setVisible(true);
				
				
			}
		});
		
		
		JButton viewlibrarianbtn = new JButton("View Librarian");
		viewlibrarianbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewLibrarian viewlibrarian = new ViewLibrarian();
				viewlibrarian.frame4.setVisible(true);
				
			}
		});
		
		
		
		JButton deletelibrarianbtn = new JButton("Delete Librarian");
		deletelibrarianbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DeleteLibrarian deletelibrarian = new DeleteLibrarian();
				deletelibrarian.frame5.setVisible(true);
				
				
				
				
			}
		});
		
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomePage homepage = new HomePage();
				homepage.frame.setVisible(true);
				
			}
		});
		
		panel2.add(adminsection);
		panel2.add(addlibrarianbtn);
		panel2.add(viewlibrarianbtn);
		panel2.add(deletelibrarianbtn);
		panel2.add(logoutbtn);
		
		frame2.add(panel2);
		frame2.setSize(300,400);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame2.setVisible(true);
	}

}
