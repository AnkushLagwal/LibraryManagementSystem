package com.project;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class DeleteLibrarian {
	
	public static JFrame frame5;
	public DeleteLibrarian() {
		
		frame5 = new JFrame("Delete Librarian");
		JPanel panel5 = new JPanel();
		
		JLabel deletelibrarian = new JLabel("Delete Librarian");
		deletelibrarian.setFont(new Font("tahoma", Font.BOLD, 26));
		panel5.add(deletelibrarian);
		
		JLabel librarianid = new JLabel("ID : ");
		final JTextField librarianidinput = new JTextField(20);
		
		JLabel librarianname = new JLabel("Name : ");
		final JTextField librariannameninput = new JTextField(20);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
				
				Statement statement = connection.createStatement();
				
				String deleteQuery = "DELETE FROM librarian WHERE id = ? and name = ?";
				PreparedStatement prepareStatement = connection.prepareStatement(deleteQuery);

				int deleteid = Integer.parseInt(librarianidinput.getText());
				prepareStatement.setInt(1,deleteid);
				
				String deletename = librariannameninput.getText();
				prepareStatement.setString(2,deletename);
				
//				System.out.println(deleteStatement);
				
				prepareStatement.executeUpdate();
				
				
				JOptionPane.showMessageDialog(frame5, "Librarian Deleted Successfully");
				
				
				AdminSection adminsection = new AdminSection();
				adminsection.frame2.setVisible(true);
				frame5.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					
					e1.printStackTrace();
				}
			}
		});
		
		JButton backbtn2 = new JButton("Back");
		backbtn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdminSection adminsection = new AdminSection();
				adminsection.frame2.setVisible(true);
				
			}
		});
		
		
		
		panel5.add(deletelibrarian);
		panel5.add(librarianid);
		panel5.add(librarianidinput);
		panel5.add(librarianname);
		panel5.add(librariannameninput);
		panel5.add(deletebtn);
		panel5.add(backbtn2);
		
		frame5.add(panel5);
		frame5.setSize(250,350);
		frame5.setDefaultCloseOperation(frame5.DISPOSE_ON_CLOSE);
		frame5.setVisible(true);
		
	
	}

}
