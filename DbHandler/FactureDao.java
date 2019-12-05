package DbHandler;

import Classes.Address;
import Classes.Avion;
import Classes.Facture;
import Classes.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FactureDao extends CentralDao<Facture> {

    public FactureDao(Connection connection) {
        super(connection);
    }


    @Override
    public boolean create(Facture obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO FACTURE VALUES (?,?,?,?,?)");
        ps.setInt(1,obj.getId_facture());
        ps.setInt(2,obj.getReservation().getId_resarvation());
        ps.setDate(3,java.sql.Date.valueOf(obj.getDateEmission()));
        ps.setFloat(4,obj.getTotal());
        if(obj.isReglee())
            ps.setInt(5,1);
        else
            ps.setInt(5,0);


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
    public boolean update(Facture obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE FACTURE SET REGLEE=? ,ID_RESERVATIOO=?,DATEIME=?,TOTALE=? WHERE ID_FACTURE=?");
        ps.setInt(5,obj.getId_facture());
        ps.setInt(2,obj.getReservation().getId_resarvation());
        ps.setDate(3,java.sql.Date.valueOf(obj.getDateEmission()));
        ps.setFloat(4,obj.getTotal());
        if(obj.isReglee())
            ps.setInt(1,1);
        else
            ps.setInt(1,0);


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
        int i = stmt.executeUpdate("DELETE FROM FACTURE WHERE ID_FACTURE=" + id);
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
    public Facture find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM FACTURE WHERE ID_FACTURE="+id);
        if(resultSet.next()){
            int id_facture = resultSet.getInt("ID_FACTURE");
            int id_reservation = resultSet.getInt("ID_RESERVATIOO");
            // ajoutéé findReservation(id) puis ajouté avec addReservation ez
            java.sql.Timestamp date = resultSet.getTimestamp("DATEIME");
            float totale = resultSet.getFloat("TOTALE");
            int reg = resultSet.getInt("REGLEE");
            boolean reglee = (reg == 0) ? false : true;
            stmt.close();
            connection.close();
            return new Facture(id_facture,date.toLocalDateTime().toLocalDate(),totale,reglee,id_reservation);
        }
        stmt.close();
        connection.close();

        return null;
    }

    @Override
    public List<Facture> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Facture> factures = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM FACTURE");
        while(resultSet.next()){
            int id = resultSet.getInt("ID_FACTURE");
            int id_reservation = resultSet.getInt("ID_RESERVATIOO");
            // ajoutéé findReservation(id) puis ajouté avec addReservation ez
            java.sql.Timestamp date = resultSet.getTimestamp("DATEIME");
            float totale = resultSet.getFloat("TOTALE");
            int reg = resultSet.getInt("REGLEE");
            boolean reglee = (reg == 0) ? false : true;
            factures.add(new Facture(id,date.toLocalDateTime().toLocalDate(),totale,reglee,id_reservation));
        }
        stmt.close();
        connection.close();

        return factures;
    }
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        System.out.println(LocalDate.now());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FactureDao factureDao = new FactureDao(connectionFactory.getConnection());
        /*Reservation reservation = new Reservation(0,LocalDate.now());
        Facture facture = new Facture(0,LocalDate.now(),1200,true);
        facture.addReservation(reservation);
        System.out.println( factureDao.create(facture));
        System.out.println(java.sql.Timestamp.valueOf("\""+LocalDate.now()+"\""));*/
        Reservation reservation = new Reservation(0,LocalDate.now());
        Facture facture = new Facture(5,LocalDate.now(),844,true);
        facture.addReservation(reservation);
        List<Facture> factures = factureDao.findAll();
        for (int i = 0; i <factures.size() ; i++) {
            System.out.println(factures.get(i).getId_facture());
        }
       // System.out.println(factureDao.update(facture));
        /*ReservationDao reservationDao = new ReservationDao(connectionFactory.getConnection());
        Address address = new Address("zz","0500","bb");
        Reservation reservation1 = new Reservation(15,LocalDate.now());
        reservation1.addAddress(address);
        reservationDao.create(reservation1);*/
}
}
