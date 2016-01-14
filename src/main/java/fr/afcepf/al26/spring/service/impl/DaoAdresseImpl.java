package fr.afcepf.al26.spring.service.impl;

import fr.afcepf.al26.spring.entity.Adresse;
import fr.afcepf.al26.spring.service.api.IDaoAdresse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAdresseImpl implements IDaoAdresse{
    private final String requeteGetAll = "SELECT * FROM adresse";
    private final String requeteInsert = "INSERT INTO adresse(num, rue, ville, cp, pays) VALUES (?, ?, ?, ?, ?)";
    private Connection connection;
    private DataSource ds;

    @Override
    public List<Adresse> getAll() {
        List<Adresse>adresses =new ArrayList<>();
        try {
            connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(requeteGetAll);
            while (resultSet.next()){
                adresses.add(rsToAddresse(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresses;
    }

    private Adresse rsToAddresse(ResultSet resultSet) throws SQLException {
        return new Adresse(
                resultSet.getInt("id"),
                resultSet.getString("num"),
                resultSet.getString("rue"),
                resultSet.getString("ville"),
                resultSet.getString("cp"),
                resultSet.getString("pays")
        );
    }

    @Override
    public Adresse insert(Adresse adresse) {
        try {
            connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requeteInsert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,adresse.getNum());
            preparedStatement.setString(2,adresse.getRue());
            preparedStatement.setString(3,adresse.getVille());
            preparedStatement.setString(4,adresse.getCp());
            preparedStatement.setString(5,adresse.getPays());
            int nombre = preparedStatement.executeUpdate();
            if (nombre==1){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int idAdresse = resultSet.getInt(1);
                adresse.setId(idAdresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresse;
    }

    @Autowired
    public void setDs(DataSource dataSource) {
        this.ds = dataSource;
    }
}