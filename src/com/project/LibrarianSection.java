package com.project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibrarianSection {
	public  JFrame frame7;
	public  LibrarianSection() {
		frame7 = new JFrame("Librarian Section");
		JPanel panel7 = new JPanel();
		
		JLabel librariansection = new JLabel("Librarian Section");
		librariansection.setFont(new Font("tahoma", Font.BOLD, 24));
		
		JButton addbooksbtn = new JButton("Add Books");
		addbooksbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddBooks addbooks = new AddBooks();
				addbooks.frame8.setVisible(true);
//				frame2.setVisible(true);
				
				
			}
		});
		
		
		JButton viewbooksbtn = new JButton("View Books");
		viewbooksbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewBooks viewbooks = new ViewBooks();
				viewbooks.frame9.setVisible(true);
				
			}
		});
		
		
		
		JButton issuebookbtn = new JButton("Issue Book");
		issuebookbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				IssueBook issuebook = new IssueBook();
				issuebook.frame10.setVisible(true);
				
			}
		});
		
		
		JButton viewissuedbooksbtn = new JButton("View Issued Books");
		viewissuedbooksbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ViewIssuedBooks viewissuedbooks = new ViewIssuedBooks();
				viewissuedbooks.frame11.setVisible(true);
				
			}
		});
		
		JButton returnbookbtn = new JButton("Return Book");
		returnbookbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ReturnBook returnbook = new ReturnBook();
				returnbook.frame12.setVisible(true);
				
			}
		});
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HomePage homepage = new HomePage();
				homepage.frame.setVisible(true);
				
			}
		});
		
		panel7.add(librariansection);
		panel7.add(addbooksbtn);
		panel7.add(viewbooksbtn);
		panel7.add(issuebookbtn);
		panel7.add(viewissuedbooksbtn);
		panel7.add(returnbookbtn);
		panel7.add(logoutbtn);
		
		frame7.add(panel7);
		frame7.setSize(300,400);
		frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame7.setVisible(true);
	}


}
