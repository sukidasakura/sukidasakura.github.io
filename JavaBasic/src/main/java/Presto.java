import java.sql.*;
import java.util.Properties;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年11月20日 14:36
 */
public class Presto {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:presto//10.10.99.37:8900/mysql/xxl-job";


        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "supconit");
//        properties.setProperty("SSL", "true");
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SHOW TABLES");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {

        }

    }
}
