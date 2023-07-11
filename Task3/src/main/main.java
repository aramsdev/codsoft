package main;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Task3";
        String user = "root";
        String pass = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url, user, pass);
            
            Statement statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
}
