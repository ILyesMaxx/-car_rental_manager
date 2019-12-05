package DbHandler;

import Classes.Address;
import Classes.Reservation;
import Classes.Train;
import Classes.Transport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TransportDao extends CentralDao<Transport> {

    public TransportDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Transport obj) {
        return false;
    }

    @Override
    public boolean update(Transport obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Transport find(int id) {
        return null;
    }

    @Override
    public List<Transport> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Transport> transports = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM TRENSPORT");
        while (resultSet.next()) {
            int id = resultSet.getInt("ID_TRENSPORT");
            java.sql.Timestamp dateArive = resultSet.getTimestamp("DATAARRIVE");
            java.sql.Timestamp datedepart = resultSet.getTimestamp("DATEDEPART");
            int nbsiegedsp = resultSet.getInt("NBSIEGEDSP");
            int nbsiegettl = resultSet.getInt("NBSIEGETTL");
            float prix = resultSet.getFloat("PRIX");
            String type = resultSet.getString("TYPE");
        }
        stmt.close();
        connection.close();
        return  null;
    }
}
