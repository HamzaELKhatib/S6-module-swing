package db.db_testing;



import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Controle4 {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String BD_NAME = "ebook";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connect;

    public static Connection GetConnection(){
        try{
            connect = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, BD_NAME), USERNAME, PASSWORD);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally{
            try {
                connect.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return connect;
    }

    public static int miseAjour(String sql){
        int count = 0;
        try {
            connect = GetConnection();
            Statement stat = connect.createStatement();
            count = stat.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                connect.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return count;
    }

    public static ResultSet select(String sql){
        ResultSet result = null;
        try {
            connect = GetConnection();
            Statement stat = connect.createStatement();
            result = stat.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                connect.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return result;
    }

    public static int recherche(String sql, String cond){
        int count = 0;
        List<String> elements = new LinkedList<>();
        try {
            connect = GetConnection();
            Statement stat = connect.createStatement();
            ResultSet result = stat.executeQuery(sql+" WHERE "+cond);
            while (result.next()) {
                elements.add((String)result.getObject(0));
            }
            count = elements.size();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                connect.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return count;
    }
}
