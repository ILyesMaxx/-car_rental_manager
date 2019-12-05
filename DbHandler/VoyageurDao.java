package DbHandler;

import Classes.Transport;
import Classes.Voyageur;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoyageurDao extends CentralDao<Voyageur> {

    public VoyageurDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Voyageur obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO VOYAGEUR VALUES (?,?,?,?,?)");
        ps.setString(3,obj.getNom());
        ps.setString(4,obj.getPrenom());
        LocalDate localDate = obj.getDate_nessence();
        ps.setDate(5,java.sql.Date.valueOf(localDate));
        ps.setInt(2,obj.getId_resarvation());
        ps.setInt(1,obj.getId_voyageur());
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
    public boolean update(Voyageur obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE VOYAGEUR SET NOM = ?, PRENOM = ?, DATANESS = ?,ID_RESERVATION = ?  WHERE ID_VOYAGEUR = ?");
        ps.setString(1,obj.getNom());
        ps.setString(2,obj.getPrenom());
        LocalDate localDate = obj.getDate_nessence();
        ps.setDate(3,java.sql.Date.valueOf(localDate));
        ps.setInt(4,obj.getId_resarvation());
        ps.setInt(5,obj.getId_voyageur());
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
        int i = stmt.executeUpdate("DELETE FROM VOYAGEUR WHERE ID_VOYAGEUR=" + id);
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
    public Voyageur find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM VOYAGEUR WHERE ID_VOYAGEUR="+id);
        if (resultSet.next()) {
            int id_voyageur = resultSet.getInt("ID_VOYAGEUR");
            int id_reservation = resultSet.getInt("ID_RESERVATION");
            String nom = resultSet.getString("NOM");
            String prenom = resultSet.getString("PRENOM");
            java.sql.Timestamp dateness = resultSet.getTimestamp("DATANESS");
            stmt.close();
            connection.close();
            return (new Voyageur(id_voyageur,nom,prenom,dateness.toLocalDateTime().toLocalDate(),id_reservation));
        }
        stmt.close();
        connection.close();
        return null;
    }

    @Override
    public List<Voyageur> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Voyageur> voyageurs = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM VOYAGEUR");
        while (resultSet.next()) {
            int id = resultSet.getInt("ID_VOYAGEUR");
            int id_reservation = resultSet.getInt("ID_RESERVATION");
            String nom = resultSet.getString("NOM");
            String prenom = resultSet.getString("PRENOM");
            java.sql.Timestamp dateness = resultSet.getTimestamp("DATANESS");
            voyageurs.add(new Voyageur(id,nom,prenom,dateness.toLocalDateTime().toLocalDate(),id_reservation));
        }
        stmt.close();
        connection.close();
        return voyageurs;
    }


    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        VoyageurDao voyageurDao = new VoyageurDao(connectionFactory.getConnection());
        Voyageur voyageur = new Voyageur(1,"hessa","home",LocalDate.now(),0);
        voyageur.setNom("ho");
        System.out.println(voyageurDao.update(voyageur));
    }
}
