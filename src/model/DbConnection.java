package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static Connection con;
    public static Connection createDbConnetion()
    {

        try{
            //load driver
            Class.forName("com.mysql.jdbc.Driver");
            //get connection with mysql
            String url="jdbc:mysql://localhost:3316/employee_db";
            String username="root";
            String password="arvind";
            con= DriverManager.getConnection(url,username,password);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
