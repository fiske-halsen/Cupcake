package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper {


    public static void removeCustomer(int customer_id) {
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM User WHERE Customer_ID=? AND Role='customer'");
            statement.setInt(1, customer_id);

            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertMoney(int customer_id, double saldo) {
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET Saldo=? WHERE Customer_ID=?");
            statement.setDouble(1, saldo);
            statement.setInt(2, customer_id);

            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void removeOrderWithOrderId(int order_id) {
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE Order_ID=?");
            statement.setInt(1, order_id);

            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCustomerIdFromOrderId(int orderId) {
        int customerId = 0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Customer_ID from Orderline where Order_ID = ?");

            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customerId = resultSet.getInt("Customer_ID");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerId;
    }
    public static void removeOrderLineWithCustomerId(int customerId) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Delete from Orderline where Customer_ID = ?");

            statement.setInt(1, customerId);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void removeOrderWithCustomerId(int customerId) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders where Customer_ID = ?");

            statement.setInt(1, customerId);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}

