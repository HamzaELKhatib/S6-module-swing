package db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

    public static Connection getConnection() {

        Connection cn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exam", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return cn;
    }

    public static int mise_ajour(String sql) {

        int t = 0;
        try {

            Connection cn = getConnection();
            Statement st = cn.createStatement();
            t = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return t;
    }

    public static ResultSet selection(String sql) {
        ResultSet rs = null;

        try{

            Connection cn = getConnection();
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }

    public static int rechercher(String req, String cond) {
        int i = 0;
        try{
            ResultSet rs = selection(req);
            while(rs.next()){
                if (rs.getString(1).equals(cond)){
                    i = 1;
                    return i;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }

    public static void main(String[] args) {

        // Testing mise_ajour() method :
        String queryInsert = "INSERT INTO produit VALUES ('54', 'aziz', 'aaaaaaaa', '111')";
        int excecuteQuery1 = TestConnection.mise_ajour(queryInsert);
        if( excecuteQuery1 != 0){
            JOptionPane.showMessageDialog(null, "INSERT SUCCESS");
        }else{
            JOptionPane.showMessageDialog(null, "INSERT FAILURE");
        }

        // Testing selection() method :
        String querySelect = "SELECT * FROM produit";
        ResultSet result = TestConnection.selection(querySelect);
        try{
            while(result.next()){
                System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // Testing rechercher() method :
        /*String queryrechercher = "SELECT * FROM produit";
        int result = rechercher(queryrechercher, "aziz");
        if(result == 1){
            JOptionPane.showMessageDialog(null, "rechercher SUCCESS");
        }else{
            JOptionPane.showMessageDialog(null, "rechercher FAILURE");
        }*/

    }
}
