package repository;

import model.MasterListAndServices;
import service.MasterService;
import service.ServicesService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MasterListAndServicesRepository {

    private MasterService masterService = new MasterService();
    private ServicesService servicesService = new ServicesService();

    public List<MasterListAndServices> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,services_id,masterlist_id from masterlistAndServices"
            );

            ResultSet resultSet = statement.executeQuery();

            List<MasterListAndServices> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new MasterListAndServices(
                        resultSet.getLong("id"),
                        masterService.findById(resultSet.getLong("masterlist_id")),
                        servicesService.findById(resultSet.getLong("services_id"))

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

    public List<MasterListAndServices> findMastersByService(Long id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,services_id, masterlist_id from masterlistAndServices where services_id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

             List<MasterListAndServices> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new MasterListAndServices(
                        resultSet.getLong("id"),
                        masterService.findById(resultSet.getLong("masterlist_id")),
                        servicesService.findById(resultSet.getLong("services_id"))
                ));
            }
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MasterListAndServices save(MasterListAndServices masterListAndServices) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into masterlistAndServices (services_id,masterlist_id) " +
                            "values ( ? , ? ) returning id "
            );

            statement.setLong(1, masterListAndServices.getServices().getId());
            statement.setLong(2, masterListAndServices.getMaster().getId());


            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                masterListAndServices.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return masterListAndServices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
