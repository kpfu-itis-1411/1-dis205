package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Records;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordsRepository {
    public Records save(Records record) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO records (service_id,client_id, purchase_date) VALUES (?, ?, ?) RETURNING id"
            );


            statement.setLong(1, record.getService_id().getId());
            statement.setLong(2, record.getClient_id().getId());
            statement.setDate(3, new java.sql.Date(record.getPurchaseDate().getTime()));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                record.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();

            return record;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}