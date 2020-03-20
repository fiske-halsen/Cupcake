package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {

    public static void updateSaldo(int customer_id, double orderPrice) {
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Update User SET Saldo = ? where Customer_ID = ? ");

            double newSaldo = getCustomerSaldo(customer_id) - orderPrice;
            statement.setDouble(1, newSaldo);
            statement.setInt(2, customer_id);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static double getCustomerSaldo(int customer_id) {
        double saldo = 0.0;
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Saldo from User where Customer_ID = ?");
            statement.setInt(1, customer_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                saldo = resultSet.getDouble("Saldo");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saldo;
    }

    public static int getCustomerId(String email) {

        int customer_id = 0;
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Customer_ID from User where Email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customer_id = resultSet.getInt("Customer_ID");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer_id;
    }

    public static int checkSaldo(int customer_id) {
        int saldo = 0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Saldo from User where Customer_ID = ?");
            statement.setInt(1, customer_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                saldo = resultSet.getInt("Saldo");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return saldo;
    }


}






