package gui;

import javax.swing.*;
import java.sql.*;

public class MySQLConnection extends JFrame {

    static final String username="jhenri5";
    static final String password= "Cosc*6ayh";
    static final String dbPath = "jdbc:mysql://triton.towson.edu:3360/";
    static Connection connection = null;




    /**
     * If in testMode, connections to the appropriate student DB for login information. Otherwise uses path supplied by the constructor
     * @return connection to DB
     * @throws SQLException - this means either a bad database or bad login information.
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     *
     */
    public static Connection connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Object newInstance = Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/jhenri5db", username, password);
        //connection.prepareStatement("show tables");
        return connection;
    }




    /**
     * Gets the ResultSet. You might want this and I need it
     * @param query the query sent in
     * @return the ResultSet
     * @throws SQLException - means bad connection or bad sql
     */
    public ResultSet doQueryResultSet(String query) throws SQLException
    {
        Statement queryStatement = connection.createStatement();
        return queryStatement.executeQuery(query);
    }


    public void printQuery(String query) throws SQLException
    {
        ResultSet rs =  doQueryResultSet(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("querying SELECT * FROM XXX");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    /**
     * Constructor for if/when we get a real db that people really use
     * Sets path to that, and shuts off the test mode path assist
     * @param path
     */


    /**
     * for while we're using student DBs.
     */
    public MySQLConnection()
    {

    }


}
