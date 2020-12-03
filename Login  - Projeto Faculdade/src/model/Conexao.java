package test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String user = "root";
    private static String password = "";
    private static String servidor = "localhost:3306";
    private static String database = "test2";
    private static String timeZone = "?useTimezone=true&serverTimezone=UTC";
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://"+servidor+"/"+database+timeZone;
    private static Connection coon;

    public Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName(driver);
        coon = DriverManager.getConnection(url, user, password);

        return coon;
    }
}