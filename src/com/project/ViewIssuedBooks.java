package com.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewIssuedBooks{

    public static JFrame frame11;
    public JTable table;
    public DefaultTableModel model;

    public ViewIssuedBooks() {
        frame11 = new JFrame("Issued Books Table");

        JPanel panel = new JPanel(new BorderLayout());

        // Table model with columns
        String[] columns = {"B_ID","B_Name", "Stu_ID", "Stu_Name",  "Stu_Branch" , "Stu_Contact" ,  "Issued Date"};
        model = new DefaultTableModel(columns, 0); // 0 is initial row count

        // Populate table with data from database
        fetchLibrarians();

        // Create JTable with the model
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame11.add(panel);
        frame11.setSize(600, 400);
        frame11.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame11.setVisible(true);
    }

    // Method to fetch librarian data from database
    private void fetchLibrarians() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "ankushlagwal2003");

            // SQL query to select all librarians
            String query = "SELECT bookid, bookname, studentid, studentname, studentbranch, studentcontact , issueddate FROM issuedbooks";
            preparedStatement = connection.prepareStatement(query);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Clear existing rows from the table model
            model.setRowCount(0);

            // Iterate through result set and add rows to table model
            while (resultSet.next()) {
                String bookid = resultSet.getString("bookid");
                String bookname = resultSet.getString("bookname");
                String studentid = resultSet.getString("studentid");
                String studentname = resultSet.getString("studentname");
                String studentbranch = resultSet.getString("studentbranch");
                String studentcontact = resultSet.getString("studentcontact");
                String issueddate = resultSet.getString("issueddate");

                // Add row to table model
                model.addRow(new Object[]{bookid,bookname,studentid, studentname, studentbranch , studentcontact , issueddate});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
       new ViewIssuedBooks();
    }
}
