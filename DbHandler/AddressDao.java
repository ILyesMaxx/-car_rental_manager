package DbHandler;

import Classes.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressDao extends CentralDao<Address> {


    public AddressDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Address obj) {
        return false;
    }

    @Override
    public boolean update(Address obj) throws SQLException, ClassNotFoundException {
        /*ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE RESERVATION SET  RUE = ?, ZIPCODE = ?,VILLE = ?  WHERE ID_VOYAGEUR = ?");
        ps.setString(1,obj.getRue());
        ps.setString(2,obj.getCodePostal());
        ps.setString(3,obj.getVille());
        //ps.setInt(4,obj.resarv);
        int i = ps.executeUpdate();
        if(i == 1) {
            return true;
        }*/
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Address find(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT RUE,ZIPCODE,VILLE FROM RESERVATION WHERE ID_RESERVATION ="+id);
        if(resultSet.next()){
            String rue = resultSet.getString("RUE");
            String zipcode = resultSet.getString("ZIPCODE");
            String ville = resultSet.getString("VILLE");
            stmt.close();
            connection.close();
            return new Address(rue,zipcode,ville);
        }
        stmt.close();
        connection.close();
        return null;
    }

    @Override
    public List<Address> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        List<Address> addresses = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery("SELECT RUE,ZIPCODE,VILLE FROM RESERVATION");
        while(resultSet.next()){
            String rue = resultSet.getString("RUE");
            String zipcode = resultSet.getString("ZIPCODE");
            String ville = resultSet.getString("VILLE");
            addresses.add(new Address(rue,zipcode,ville));
        }
        stmt.close();
        connection.close();

        return addresses;
    }


}
