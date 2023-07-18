package db;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database{
    protected Connection connection;
    private final String url = "jdbc:mysql://127.0.0.1:3306/school";
    private final String user = "root";
    private final String pass = "";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public void Connect() throws ClassNotFoundException {
            Class.forName(driver);
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
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
