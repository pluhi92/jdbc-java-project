package com.pluhi;

import java.sql.*;

public class MainClass extends DBConnection {
    public static void main(String[] args) {

        final Object[][] columns = new String[1][];
        final Object[][] table = new String[1][];


        columns[0] = new String[]{"First Name", "Surname", "Birthday", "Title", "Contact"};
        for (final Object[] column : columns) {
            System.out.printf("%-15s%-15s%-15s%-15s%n", column);
        }

        System.out.println("-------------------------------------------------------");

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {

                table[0] = new String[]{rs.getObject(1).toString(), rs.getObject(2).toString(),
                        rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString()
                };

                for (final Object[] row : table) {
                    System.out.format("%-15s%-15s%-15s%-15s%n", row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

