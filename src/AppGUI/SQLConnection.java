package AppGUI;

import java.sql.*;

public class SQLConnection {

    public Connection dbLink;

    public Connection getDBConnection(){
        String url = "jdbc:sqlserver://PY-MASTER-RACE\\SQLEXPRESS;database=Peliculas_DB;Trusted_Connection=No;";
        String username = "sa";
        String password = "admin123";

        try{
            dbLink = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
        }


        return dbLink;
    }

    public static boolean checkUserInSQL(String username, String password){
        String url = "jdbc:sqlserver://PY-MASTER-RACE\\SQLEXPRESS;database=Peliculas_DB;Trusted_Connection=No;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("We could actually sign in!");


            return true;

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


}
