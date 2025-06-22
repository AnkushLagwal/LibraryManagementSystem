package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class AddBooks {
	
	public static JFrame frame8;
	public AddBooks() {
		frame8 = new JFrame("Add Books");
		JPanel panel8 = new JPanel();
		
		JLabel addbooks = new JLabel("Add Books..");
		addbooks.setFont(new Font("tahoma", Font.BOLD, 32));
		
		JLabel bidlabel = new JLabel("Book ID : ");
		final JTextField bidinput = new JTextField(20);
		
		JLabel bnamelabel = new JLabel("Book Name : ");
		final JTextField bnameinput = new JTextField(20);
		
		JLabel authorlabel = new JLabel("Author : ");
		final JTextField authorinput = new JTextField(20);
		
		JLabel publisherlabel = new JLabel("Publisher : ");
		final JTextField publisherinput = new JTextField(20);
		
		
		JLabel quantitylabel = new JLabel("Quantity : ");
		final JTextField quantityinput = new JTextField(20);
		
		JLabel addeddatelabel = new JLabel("Added Date ://yyyymmdd ");
		final JTextField addeddateinput = new JTextField(20);
		
		
		JButton addbooksbtn = new JButton("Add Books");
		addbooksbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
				
				Statement statement = connection.createStatement();
				
				String InsertQuery = "INSERT INTO books (bookid ,bookname,author,publisher,quantity,addeddate) values(?,?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(InsertQuery);
				
				
					
				int newid =Integer.parseInt(bidinput.getText());
				prepareStatement.setInt(1,newid);
				
				String newname = bnameinput.getText();
				prepareStatement.setString(2, newname);
				
				String newauthor = authorinput.getText();
				prepareStatement.setString(3, newauthor);
				
				String newpublisher = publisherinput.getText();
				prepareStatement.setString(4, newpublisher);
				
				String quantity =quantityinput.getText();
				prepareStatement.setString(5,quantity);
				
				int addeddate =Integer.parseInt(addeddateinput.getText());
				prepareStatement.setInt(6,addeddate);
				
				prepareStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(frame8, "New Book Added Successfully");
				
				LibrarianSection librariansection = new LibrarianSection();
				librariansection.frame7.setVisible(true);
				frame8.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LibrarianSection librariansection = new LibrarianSection();
				librariansection.frame7.setVisible(true);
				frame8.setVisible(false);
			}
		});
		
		panel8.add(addbooks);
		panel8.add(bidlabel);
		panel8.add(bidinput);
		panel8.add(bnamelabel);
		panel8.add(bnameinput);
		panel8.add(authorlabel);
		panel8.add(authorinput);
		panel8.add(publisherlabel);
		panel8.add(publisherinput);
		panel8.add(quantitylabel);
		panel8.add(quantityinput);
		panel8.add(addeddatelabel);
		panel8.add(addeddateinput);
		panel8.add(addbooksbtn);
		panel8.add(backbtn);
		
		
		
		frame8.add(panel8);
		frame8.setSize(250,410);
		frame8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame8.setVisible(true);
	}

}
