package com.project;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class ReturnBook {
	
	public static JFrame frame12;
	public ReturnBook() {
		
		frame12 = new JFrame("Return Book");
		JPanel panel12 = new JPanel();
		
		JLabel returnbook = new JLabel("Return Book..");
		returnbook.setFont(new Font("tahoma", Font.BOLD, 26));
		panel12.add(returnbook);
		
		JLabel bookid = new JLabel("Book ID : ");
		final JTextField bookidinput = new JTextField(20);
		
		JLabel studentid = new JLabel("Student ID : ");
		final JTextField studentidinput = new JTextField(20);
		
		JButton returnbookbtn = new JButton("Return Book");
		returnbookbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
				
				Statement statement = connection.createStatement();
				
				String deleteQuery = "DELETE FROM issuedbooks WHERE bookid = ? and studentid = ?";
				PreparedStatement prepareStatement = connection.prepareStatement(deleteQuery);

				int deletebookid = Integer.parseInt(bookidinput.getText());
				prepareStatement.setInt(1,deletebookid);
				
				String deletestudentid = studentidinput.getText();
				prepareStatement.setString(2,deletestudentid);
				
//				System.out.println(deleteStatement);
				
				prepareStatement.executeUpdate();
				
				
				JOptionPane.showMessageDialog(frame12, "Book Returned Successfully");
				
				
				LibrarianSection librariansection = new LibrarianSection();
				librariansection.frame7.setVisible(true);
				frame12.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					
					e1.printStackTrace();
				}
			}
		});
		
		JButton backbtn2 = new JButton("Back");
		backbtn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LibrarianSection librariansection = new LibrarianSection();
				librariansection.frame7.setVisible(true);
				
			}
		});
		
		
		
		panel12.add(returnbook);
		panel12.add(bookid);
		panel12.add(bookidinput);
		panel12.add(studentid);
		panel12.add(studentidinput);
		panel12.add(returnbookbtn);
		panel12.add(backbtn2);
		
		frame12.add(panel12);
		frame12.setSize(250,350);
		frame12.setDefaultCloseOperation(frame12.DISPOSE_ON_CLOSE);
		frame12.setVisible(true);
		
	
	}

}
