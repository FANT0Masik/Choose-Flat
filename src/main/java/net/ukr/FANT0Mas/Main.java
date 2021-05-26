package net.ukr.FANT0Mas;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        DbProperties dbProp = new DbProperties();

        try (Connection con = DriverManager.getConnection(dbProp.getUrl(), dbProp.getUser(), dbProp.getPassword())) {
            Services.initDB(con);
            while (true) {
                System.out.println("1. Add new Flat\n2. Delete Flat\n3. Find by area\n" +
                        "4. Find by address\n5. Find by square\n6. Find by number of rooms\n" +
                        "7. Find by price\n8. View all flats\n9. Enought for me, exit\n->");
                String comand = sc.nextLine();

                switch (comand) {
                    case "1":
                        Services.addFlat(con, sc);
                        break;
                    case "2":
                        Services.deleteFlat(con, sc);
                        break;
                    case "3":
                        Services.findByArea(con, sc);
                        break;
                    case "4":
                        Services.findByAddress(con, sc);
                        break;
                    case "5":
                        Services.findBySquare(con, sc);
                        break;
                    case "6":
                        Services.findByNumRooms(con, sc);
                        break;
                    case "7":
                        Services.findByPrice(con, sc);
                        break;
                    case "8":
                        Services.showAll(con);
                        break;
                    case "9":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("One more try, please");
                        System.out.println();
                }


            }
        }

    }
}
