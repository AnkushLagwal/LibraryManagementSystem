package com.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBooks{

    public static JFrame frame9;
    public JTable table;
    public DefaultTableModel model;

    public ViewBooks() {
        frame9 = new JFrame("Books Table");

        JPanel panel = new JPanel(new BorderLayout());

        // Table model with columns
        String[] columns = {"B_ID","B_Name", "Author", "Publisher",  "Quantity" , "Added Date"};
        model = new DefaultTableModel(columns, 0); // 0 is initial row count

        // Populate table with data from database
        fetchLibrarians();

        // Create JTable with the model
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame9.add(panel);
        frame9.setSize(600, 400);
        frame9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame9.setVisible(true);
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
            String query = "SELECT bookid, bookname, author, publisher, quantity , addeddate FROM books";
            preparedStatement = connection.prepareStatement(query);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Clear existing rows from the table model
            model.setRowCount(0);

            // Iterate through result set and add rows to table model
            while (resultSet.next()) {
                String bookid = resultSet.getString("bookid");
                String bookname = resultSet.getString("bookname");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String quantity = resultSet.getString("quantity");
                String addeddate = resultSet.getString("addeddate");

                // Add row to table model
                model.addRow(new Object[]{bookid,bookname,author, publisher, quantity , addeddate});
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
       new ViewBooks();
    }
}
