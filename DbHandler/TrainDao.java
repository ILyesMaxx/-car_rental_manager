package DbHandler;

import Classes.Avion;
import Classes.Train;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrainDao extends CentralDao<Train> {


    public TrainDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Train obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps1 = connection.prepareStatement("INSERT INTO TRENSPORT VALUES (?,?,?,?,?,?,?) ");
        ps1.setInt(1,obj.getId_transport());
        ps1.setDate(2,java.sql.Date.valueOf(obj.getDateArrive()));
        ps1.setDate(3,java.sql.Date.valueOf(obj.getDateDepar()));
        ps1.setInt(4,obj.getNbrsiegesOccupés());
        ps1.setInt(5,obj.getNbrsiegesTotale());
        ps1.setFloat(6,obj.getPrix());
        ps1.setString(7,"train");
        int g = ps1.executeUpdate();
        ps1 = connection.prepareStatement("INSERT INTO TRAIN VALUES (?,?,?)");
        ps1.setInt(2,obj.getNbrWagons());
        if(obj.isVoiturCaffe())
            ps1.setInt(3,1);
        else
            ps1.setInt(3,0);
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
    public boolean update(Train obj) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps1 = connection.prepareStatement("UPDATE TRENSPORT SET DATAARRIVE = ?,DATEDEPART= ?,NBSIEGEDSP= ?,NBSIEGETTL= ?,PRIX= ?,TYPE= ? WHERE ID_TRENSPORT=? ");
        ps1.setDate(1,java.sql.Date.valueOf(obj.getDateArrive()));
        ps1.setDate(2,java.sql.Date.valueOf(obj.getDateDepar()));
        ps1.setInt(3,obj.getNbrsiegesOccupés());
        ps1.setInt(4,obj.getNbrsiegesTotale());
        ps1.setFloat(5,obj.getPrix());
        ps1.setString(6,"train");
        ps1.setInt(7,obj.getId_transport());
        int g = ps1.executeUpdate();
        ps1 = connection.prepareStatement("UPDATE TRAIN SET NBRWAGION = ?, VOITURCAFFE = ? WHERE ID_TRAIN = ?");
        ps1.setInt(1,obj.getNbrWagons());
        if(obj.isVoiturCaffe())
            ps1.setInt(2,1);
        else
            ps1.setInt(2,0);
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
    public boolean delete(int id ) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
       // int g = stmt.executeUpdate("DELETE FROM TRENSPORT WHERE ID_TRENSPORT ="+id);
        int i = stmt.executeUpdate("DELETE FROM TRAIN WHERE ID_TRAIN=" + id);
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
    public Train find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM TRAIN , TRENSPORT WHERE TRAIN.ID_TRAIN=TRENSPORT.ID_TRENSPORT AND ID_TRAIN="+id);
        if(resultSet.next()){
            int id_train = resultSet.getInt("ID_TRAIN");
            java.sql.Timestamp dataarrive = resultSet.getTimestamp("DATAARRIVE");
            java.sql.Timestamp datedepart = resultSet.getTimestamp("DATEDEPART");
            int nbrdsp = resultSet.getInt("NBSIEGEDSP");
            int nbrtotale = resultSet.getInt("NBSIEGEDTTL");
            float prix = resultSet.getFloat("PRIX");
            int nbrw = resultSet.getInt("NBRWAGION");
            int voiturCaff = resultSet.getInt("VOITURCAFFE");
            boolean voiturCaffe = (voiturCaff == 0) ? false : true;
            stmt.close();
            connection.close();
            return new Train(id_train,datedepart.toLocalDateTime().toLocalDate(),dataarrive.toLocalDateTime().toLocalDate(),nbrdsp,nbrtotale,prix,nbrw,voiturCaffe);
        }
        stmt.close();
        connection.close();
        return null;
    }

    @Override
    public List<Train> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Train> trains = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM TRAIN , TRENSPORT WHERE TRAIN.ID_TRAIN=TRENSPORT.ID_TRENSPORT");
        while(resultSet.next()){
            int id = resultSet.getInt("ID_TRAIN");
            java.sql.Timestamp dataarrive = resultSet.getTimestamp("DATAARRIVE");
            java.sql.Timestamp datedepart = resultSet.getTimestamp("DATEDEPART");
            int nbrdsp = resultSet.getInt("NBSIEGEDSP");
            int nbrtotale = resultSet.getInt("NBSIEGETTL");
            float prix = resultSet.getFloat("PRIX");
            int nbrw = resultSet.getInt("NBRWAGION");
            int voiturCaff = resultSet.getInt("VOITURCAFFE");
            boolean voiturCaffe = (voiturCaff == 0) ? false : true;
            trains.add(new Train(id,datedepart.toLocalDateTime().toLocalDate(),dataarrive.toLocalDateTime().toLocalDate(),nbrdsp,nbrtotale,prix,nbrw,voiturCaffe));
        }
        stmt.close();
        connection.close();
        return trains;
    }

    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        System.out.println(LocalDateTime.now().toLocalDate());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        TrainDao trainDao = new TrainDao(connectionFactory.getConnection());
        Train train = new Train(16, LocalDateTime.now().toLocalDate(),LocalDate.now(),15,20,300,10,true);

        //System.out.println(trainDao.create(train));
        train.setId_transport(11);
        System.out.println(trainDao.create(train));


    }}
