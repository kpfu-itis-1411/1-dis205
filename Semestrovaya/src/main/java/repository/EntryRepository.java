package repository;

import model.Client;
import model.Entry;
import service.ClientService;
import service.MasterService;
import service.ServicesService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntryRepository {
    private ClientService clientService = new ClientService();
    private MasterService masterService = new MasterService();
    private ServicesService servicesService = new ServicesService();

    public List<Entry> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,services_id, masterlist_id,client_id from entry"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Entry> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Entry(
                        resultSet.getLong("id"),
                        servicesService.findById(resultSet.getLong("services_id")),
                        masterService.findById(resultSet.getLong("masterlist_id")),
                        clientService.findById(resultSet.getLong("client_id"))

                ));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Entry> findById(Long id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,services_id, masterlist_id,client_id from entry where client_id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            List<Entry> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Entry(
                        resultSet.getLong("id"),
                        servicesService.findById(resultSet.getLong("services_id")),
                        masterService.findById(resultSet.getLong("masterlist_id")),
                        clientService.findById(resultSet.getLong("client_id"))

                ));
            }
            DBConnection.getInstance().releaseConnection(connection);
            resultSet.close();
            statement.close();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Entry> findByIdMaster(Long id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,services_id, masterlist_id,client_id from entry where masterlist_id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            List<Entry> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Entry(
                        resultSet.getLong("id"),
                        servicesService.findById(resultSet.getLong("services_id")),
                        masterService.findById(resultSet.getLong("masterlist_id")),
                        clientService.findById(resultSet.getLong("client_id"))

                ));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void save(Entry entry) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into entry (services_id, masterlist_id,client_id) " +
                            "values ( ? , ? , ? ) returning id "
            );

            statement.setLong(1, entry.getServices().getId());
            statement.setLong(2, entry.getMaster().getId());
            statement.setLong(3, entry.getClient().getId());


            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                entry.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
