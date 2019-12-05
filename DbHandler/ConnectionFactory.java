package DbHandler;
import java.sql.*;

public class ConnectionFactory {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "AGENCE";
    public static final String PASS = "123";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Statement pstmt = getConnection().createStatement();
        String sql ="SELECT * FROM AVION";
        ResultSet resultSet = pstmt.executeQuery(sql);
        resultSet.next();
        System.out.println(resultSet.getInt("id_avion"));

    }
}