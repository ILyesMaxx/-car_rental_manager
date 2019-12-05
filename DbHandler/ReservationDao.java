package DbHandler;

import Classes.Address;
import Classes.Facture;
import Classes.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao extends CentralDao<Reservation> {


    public ReservationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Reservation obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO RESERVATION VALUES (?,?,?,?,?)");
        ps.setDate(2,java.sql.Date.valueOf(obj.getDateResservation()));
        ps.setString(3,obj.getAddress().getRue());
        ps.setString(4,obj.getAddress().getCodePostal());
        ps.setString(5,obj.getAddress().getVille());
        ps.setInt(1,obj.getId_resarvation());
        int i = ps.executeUpdate();
        if(i == 1) {
            ps.close();
            connection.close();
            return true;
        }
        ps.close();
        connection.close();
        return false;
    }

    @Override
    public boolean update(Reservation obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE RESERVATION SET DATARESS = ?, RUE = ?, ZIPCODE = ?,VILLE = ?  WHERE ID_RESERVATION = ?");
        ps.setDate(1,java.sql.Date.valueOf(obj.getDateResservation()));
        ps.setString(2,obj.getAddress().getRue());
        ps.setString(3,obj.getAddress().getCodePostal());
        ps.setString(4,obj.getAddress().getVille());
        ps.setInt(5,obj.getId_resarvation());
        int i = ps.executeUpdate();
        if(i == 1) {
            ps.close();
            connection.close();
            return true;
        }
        ps.close();
        connection.close();
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM RESERVATION WHERE ID_RESERVATION=" + id);
        if(i == 1) {
            stmt.close();
            connection.close();
            return true;
        }
        stmt.close();
        connection.close();
        return false;
    }

    @Override
    public Reservation find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM RESERVATION WHERE ID_RESERVATION="+id);
        if(resultSet.next()){
            int id_reservation = resultSet.getInt("ID_RESERVATION");
            java.sql.Timestamp date = resultSet.getTimestamp("DATARESS");
            Address address = new Address(resultSet.getString("RUE"),resultSet.getString("ZIPCODE"),
                    resultSet.getString("VILLE"));
            Reservation reservation = new Reservation(id_reservation,date.toLocalDateTime().toLocalDate());
            reservation.addAddress(address);
            stmt.close();
            connection.close();
            return reservation;
        }
        stmt.close();
        connection.close();

        return null;
    }

    @Override
    public List<Reservation> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Reservation> reservations = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM RESERVATION");
        while(resultSet.next()){
            int id = resultSet.getInt("ID_RESERVATION");
            java.sql.Timestamp date = resultSet.getTimestamp("DATARESS");
            Address address = new Address(resultSet.getString("RUE"),resultSet.getString("ZIPCODE"),
                    resultSet.getString("VILLE"));
            Reservation reservation = new Reservation(id,date.toLocalDateTime().toLocalDate());
            reservation.addAddress(address);
            reservations.add(reservation);
        }
        stmt.close();
        connection.close();

        return reservations;
    }
}
