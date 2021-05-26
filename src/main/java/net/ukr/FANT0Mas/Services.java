package net.ukr.FANT0Mas;

import java.sql.*;
import java.util.Scanner;

public class Services {
    public static void initDB(Connection con) throws SQLException {
        try (Statement st = con.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE Flats (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, area VARCHAR(30) NOT NULL," +
                    " address VARCHAR(30) NOT NULL, square DOUBLE NOT NULL , numRooms INT NOT NULL, price DOUBLE NOT NULL )");
        }
    }

    public static void addFlat(Connection con, Scanner sc) throws SQLException {
        System.out.println("Please, enter your area: ");
        String area = sc.nextLine();
        System.out.println("Please, enter your address: ");
        String address = sc.nextLine();
        System.out.println("Please, enter your square: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Insert the number, please!");
            sc.nextLine();
        }
        double square = sc.nextDouble();
        System.out.println("Please, enter your numRooms: ");
        while (!sc.hasNextInt()) {
            System.out.println("Insert int, please!");
            sc.nextLine();
        }
        int numRooms = sc.nextInt();
        System.out.println("Please, enter your price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Insert the number, please!");
            sc.nextLine();
        }
        double price = sc.nextDouble();
        try (PreparedStatement pr = con.prepareStatement("INSERT INTO Flats(area,address,square,numRooms,price)" +
                "VALUES(?,?,?,?,?)")) {
            pr.setString(1, area);
            pr.setString(2, address);
            pr.setDouble(3, square);
            pr.setInt(4, numRooms);
            pr.setDouble(5, price);
            pr.executeUpdate();
        }
    }


    public static void deleteFlat(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter address to delete the flat: ");
        String address = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM Flats WHERE address=?")) {
            ps.setString(1, address);
            ps.executeUpdate();
        }
    }

    public static void showAll(Connection con) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT*FROM Flats")) {
            try (ResultSet res = ps.executeQuery()) {
                ResultSetMetaData resSet = res.getMetaData();

                for (int i = 1; i <= resSet.getColumnCount(); i++) {
                    System.out.print(resSet.getColumnName(i) + "\t\t");

                }
                System.out.println();
                while (res.next()) {
                    for (int i = 1; i <= resSet.getColumnCount(); i++) {
                        System.out.print(res.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

    }


    public static void findByArea(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter area, please: ");
        String area = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("SELECT *FROM Flats WHERE area=?")) {
            resultSet(area, ps);
        }
    }

    public static void findByAddress(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter address, please: ");
        String address = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("SELECT *FROM Flats WHERE =?")) {
            resultSet(address, ps);
        }
    }

    public static void findBySquare(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter square, please: ");
        String square = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("SELECT *FROM Flats WHERE square=?")) {
            resultSet(square, ps);
        }
    }

    public static void findByNumRooms(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter numRooms, please: ");
        String numRooms = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("SELECT *FROM Flats WHERE numRooms=?")) {
            resultSet(numRooms, ps);
        }
    }

    public static void findByPrice(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter price, please: ");
        String price = sc.nextLine();
        try (PreparedStatement ps = con.prepareStatement("SELECT *FROM Flats WHERE price=?")) {
            resultSet(price, ps);
        }
    }


    private static void resultSet(String name, PreparedStatement ps) throws SQLException {
        ps.setString(1, name);
        try (ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData rm = rs.getMetaData();
            for (int column = 1; column <= rm.getColumnCount(); column++) {
                System.out.print(rm.getColumnName(column) + "\t\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int column = 1; column <= rm.getColumnCount(); column++) {
                    System.out.print(rs.getString(column) + "\t\t");
                }
                System.out.println();
            }
        }
    }

}

