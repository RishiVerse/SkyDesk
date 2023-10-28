package com.example.JDeskUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertPDFIntoSQLite {

        public void test() {
            String databaseURL = "jdbc:sqlite:src/main/java/com/example/JDeskUI/userDetail.db";
            String pdfFilePath = "src/main/resources/testfile.pdf"; // Replace with the path to your PDF file

            try {
                // Load the SQLite JDBC driver
                Class.forName("org.sqlite.JDBC");

                // Establish a database connection
                Connection connection = DriverManager.getConnection(databaseURL);

                // Prepare an SQL statement to insert the PDF data
                String sql = "INSERT INTO pdf_documents (filename, description, pdf_data) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                // Read the PDF file as binary data
                File pdfFile = new File(pdfFilePath);
                FileInputStream fis = new FileInputStream(pdfFile);
                byte[] pdfData = new byte[(int) pdfFile.length()];
                fis.read(pdfData);
                fis.close();

                // Set the parameters for the SQL statement
                preparedStatement.setString(1, pdfFile.getName());
                preparedStatement.setString(2, "Sample PDF document");
                preparedStatement.setBytes(3, pdfData);

                // Execute the SQL statement to insert the PDF data
                preparedStatement.executeUpdate();

                // Close the database connection
                connection.close();

                System.out.println("PDF document inserted successfully.");

            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


