package com.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewLibrarian {

    public static JFrame frame4;
    public JTable table;
    public DefaultTableModel model;

    public ViewLibrarian() {
        frame4 = new JFrame("Librarian Table");

        JPanel panel = new JPanel(new BorderLayout());

        // Table model with columns
        String[] columns = {"ID","Name", "Password", "Address", "City", "Contact No."};
        model = new DefaultTableModel(columns, 0); // 0 is initial row count

        // Populate table with data from database
        fetchLibrarians();

        // Create JTable with the model
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame4.add(panel);
        frame4.setSize(600, 400);
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame4.setVisible(true);
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
            String query = "SELECT id, name, password, address, city, contact FROM librarian";
            preparedStatement = connection.prepareStatement(query);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Clear existing rows from the table model
            model.setRowCount(0);

            // Iterate through result set and add rows to table model
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String contact = resultSet.getString("contact");

                // Add row to table model
                model.addRow(new Object[]{id,name, password, address, city, contact});
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
       new ViewLibrarian();
    }
}
