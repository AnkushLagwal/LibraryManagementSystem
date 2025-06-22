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


public class IssueBook {
	
	public static JFrame frame10;
	public IssueBook() {
		frame10 = new JFrame("Add Books");
		JPanel panel10 = new JPanel();
		
		JLabel issuebook = new JLabel("Issue Book..");
		issuebook.setFont(new Font("tahoma", Font.BOLD, 32));
		
		JLabel bookidlabel = new JLabel("Book ID : ");
		final JTextField bookidinput = new JTextField(20);
		
		JLabel booknamelabel = new JLabel("Book Name : ");
		final JTextField booknameinput = new JTextField(20);
		
		JLabel studentidlabel = new JLabel("Student Id : ");
		final JTextField studentidinput = new JTextField(20);
		
		JLabel studentnamelabel = new JLabel("Student Name : ");
		final JTextField studentnameinput = new JTextField(20);
		
		JLabel studentbranchlabel = new JLabel("Student Branch : ");
		final JTextField studentbranchinput = new JTextField(20);
		
		
		JLabel studentcontactlabel = new JLabel("Student Contact : ");
		final JTextField studentcontactinput = new JTextField(20);
		
		JLabel issueddatelabel = new JLabel("Issued Date : ");
		final JTextField issueddateinput = new JTextField(20);
		
		
		JButton issuebookbtn = new JButton("Issue Book ://yyyymmdd");
		issuebookbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");
				
				Statement statement = connection.createStatement();
				
				String InsertQuery = "INSERT INTO issuedbooks (bookid ,bookname,studentid,studentname,studentbranch,studentcontact,issueddate) values(?,?,?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(InsertQuery);
						
					
				int issuedbookid =Integer.parseInt(bookidinput.getText());
				prepareStatement.setInt(1,issuedbookid);
				
				String issuedbookname = booknameinput.getText();
				prepareStatement.setString(2, issuedbookname);
				
				String studentid = studentidinput.getText();
				prepareStatement.setString(3, studentid);
				
				String studentname = studentnameinput.getText();
				prepareStatement.setString(4, studentname);
				
				String studentbranch =studentbranchinput.getText();
				prepareStatement.setString(5,studentbranch);
				
				String studentcontact =studentcontactinput.getText();
				prepareStatement.setString(6,studentcontact);
				
				int issueddate =Integer.parseInt(issueddateinput.getText());
				prepareStatement.setInt(7,issueddate);
				
				prepareStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(frame10, "Book Issued Successfully...   REMEMBER: Return thr book within a week otherwise 10/- per day will be fined");
				
				LibrarianSection librariansection = new LibrarianSection();
				librariansection.frame7.setVisible(true);
				frame10.setVisible(false);
				
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
				
			}
		});
		
		panel10.add(issuebook);
		panel10.add(bookidlabel);
		panel10.add(bookidinput);
		panel10.add(booknamelabel);
		panel10.add(booknameinput);
		panel10.add(studentidlabel);
		panel10.add(studentidinput);
		panel10.add(studentnamelabel);
		panel10.add(studentnameinput);
		panel10.add(studentbranchlabel);
		panel10.add(studentbranchinput);
		panel10.add(studentcontactlabel);
		panel10.add(studentcontactinput);
		panel10.add(issueddatelabel);
		panel10.add(issueddateinput);
		panel10.add(issuebookbtn);
		panel10.add(backbtn);
		
		
		
		frame10.add(panel10);
		frame10.setSize(250,450);
		frame10.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame10.setVisible(true);
	}

}