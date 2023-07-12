package db;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class database{
    protected Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/Task3";
    private final String user = "root";
    private final String pass = "";
    
    public void Connect() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        }catch (SQLException e){
            System.out.println(e);
        }    
    }
    
    public void Close() throws SQLException{
        if (connection != null) {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }
}
