package DbHandler;

import Classes.Address;
import Classes.Avion;
import Classes.Train;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AvionDao extends CentralDao<Avion> {


    public AvionDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Avion obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps1 = connection.prepareStatement("INSERT INTO TRENSPORT VALUES (?,?,?,?,?,?,?) ");
        ps1.setInt(1,obj.getId_transport());
        ps1.setDate(2,java.sql.Date.valueOf(obj.getDateArrive()));
        ps1.setDate(3,java.sql.Date.valueOf(obj.getDateDepar()));
        ps1.setInt(4,obj.getNbrsiegesOccupés());
        ps1.setInt(5,obj.getNbrsiegesTotale());
        ps1.setFloat(6,obj.getPrix());
        ps1.setString(7,"Avion");
        int g = ps1.executeUpdate();
        ps1 = connection.prepareStatement("INSERT INTO AVION VALUES (?,?,?)");
        ps1.setString(2,obj.getCompagnie());
        ps1.setString(3,obj.getTypeAppareil());
        ps1.setInt(1,obj.getId_transport());
        int i = ps1.executeUpdate();
        if(i == 1 && g == 1) {
            ps1.close();
            ps1.close();
            connection.close();
            return true;
        }
        ps1.close();
        ps1.close();
        connection.close();
        return false;
    }

    @Override
    public boolean update(Avion obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps1 = connection.prepareStatement("UPDATE TRENSPORT SET DATAARRIVE = ?,DATEDEPART= ?,NBSIEGEDSP= ?,NBSIEGETTL= ?,PRIX= ?,TYPE= ? WHERE ID_TRENSPORT=? ");
        ps1.setDate(1,java.sql.Date.valueOf(obj.getDateArrive()));
        ps1.setDate(2,java.sql.Date.valueOf(obj.getDateDepar()));
        ps1.setInt(3,obj.getNbrsiegesOccupés());
        ps1.setInt(4,obj.getNbrsiegesTotale());
        ps1.setFloat(5,obj.getPrix());
        ps1.setString(6,"Avion");
        ps1.setInt(7,obj.getId_transport());
        int g = ps1.executeUpdate();
        ps1 = connection.prepareStatement("UPDATE AVION SET COMPANIES = ?, TYPE_APPAREIL = ? WHERE ID_AVION = ?");
        ps1.setString(1,obj.getCompagnie());
        ps1.setString(2,obj.getTypeAppareil());
        ps1.setInt(3,obj.getId_transport());
        int i = ps1.executeUpdate();

        if(i == 1 && g == 1) {
            ps1.close();
            ps1.close();
            connection.close();
            return true;
        }
        ps1.close();
        ps1.close();
        connection.close();
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate("DELETE FROM AVION WHERE ID_AVION=" + id);
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
    public Avion find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM AVION , TRENSPORT WHERE AVION.ID_AVION=TRENSPORT.ID_TRENSPORT AND ID_AVION="+id);
        if(resultSet.next()){
            int id_avion = resultSet.getInt("ID_AVION");
            String companies = resultSet.getString("COMPANIES");
            String type = resultSet.getString("TYPE_APPAREIL");
            java.sql.Timestamp dataarrive = resultSet.getTimestamp("DATAARRIVE");
            java.sql.Timestamp datedepart = resultSet.getTimestamp("DATEDEPART");
            int nbrdsp = resultSet.getInt("NBSIEGEDSP");
            int nbrtotale = resultSet.getInt("NBSIEGETTL");
            float prix = resultSet.getFloat("PRIX");
            String typeTrensprot = resultSet.getString("TYPE");
            stmt.close();
            connection.close();
            return new Avion(id_avion,datedepart.toLocalDateTime().toLocalDate(),dataarrive.toLocalDateTime().toLocalDate(),nbrdsp,nbrtotale,prix,companies,type);
        }
        stmt.close();
        connection.close();
        return null;
    }

    @Override
    public List<Avion> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Avion> avions = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM AVION , TRENSPORT WHERE AVION.ID_AVION=TRENSPORT.ID_TRENSPORT");
        while(resultSet.next()){
            int id = resultSet.getInt("ID_AVION");
            String companies = resultSet.getString("COMPANIES");
            String type = resultSet.getString("TYPE_APPAREIL");
            java.sql.Timestamp dataarrive = resultSet.getTimestamp("DATAARRIVE");
            java.sql.Timestamp datedepart = resultSet.getTimestamp("DATEDEPART");
            int nbrdsp = resultSet.getInt("NBSIEGEDSP");
            int nbrtotale = resultSet.getInt("NBSIEGETTL");
            float prix = resultSet.getFloat("PRIX");
            String typeTrensprot = "Avion";
            Avion avion = new Avion(id,datedepart.toLocalDateTime().toLocalDate(),dataarrive.toLocalDateTime().toLocalDate(),nbrdsp,nbrtotale,prix,companies,type);
            avions.add(avion);
            System.out.println(avion.getId_transport());
        }
        stmt.close();
        connection.close();
        return avions;
    }

    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        AvionDao avionDao = new AvionDao(connectionFactory.getConnection());
        /*Avion avion = new Avion(20, LocalDate.now(), LocalDate.now(),15,20,1500,"gel","trr");

        //System.out.println(trainDao.create(train));
        avion.setId_transport(10);
        avion.setCompagnie("brrrrrrrrrrr");
        System.out.println(avionDao.update(avion));*/
        List<Avion> avions = avionDao.findAll();
        for (int i = 0; i <avions.size() ; i++) {
            System.out.println(avions.get(i).getDateArrive());
        }

        System.out.println(""+avionDao.find(0).getDateArrive());
        Avion avion = new Avion(120, LocalDate.now(), LocalDate.now(),15,20,1500,"gel","trr");
        System.out.println(avionDao.create(avion));
    }
    }
