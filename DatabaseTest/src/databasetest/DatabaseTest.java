package databasetest;

import java.sql.*;
import java.util.Scanner;

public class DatabaseTest {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String userInput = scn.nextLine();     
        selectData(userInput);
        
        
       

    }

    private static void addData(String nameStd, String lastnameStd, float scoreStd) {
        try {
            Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetest?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement ps = cnt.prepareStatement("INSERT INTO STUDENT (nameStd,lastnameStd,scoreStd) VALUES (?,?,?)");
            ps.setString(1, nameStd);
            ps.setString(2, lastnameStd);
            ps.setFloat(3, scoreStd);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void selectData(String idStd) {
        try {
            Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetest?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement ps = cnt.prepareStatement("SELECT * FROM STUDENT WHERE idStd = ?");
            ps.setString(1, idStd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nameStd")+" "+rs.getString("lastnameStd")+" "+rs.getFloat("scoreStd"));
                
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }

}
