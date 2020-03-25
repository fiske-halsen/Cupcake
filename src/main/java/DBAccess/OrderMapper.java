package DBAccess;

import FunctionLayer.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {


    public static void createOrder(Order order) {
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders " +
                    "(date, Customer_ID) VALUES (?, ?);");
            statement.setString(1, order.getDate());
            statement.setInt(2, order.getCustomer_Id());

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getOrderId(int customer_id) {
        int Order_ID = 0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT Order_ID FROM Orders WHERE Customer_ID = ? AND Is_Active = TRUE");
            statement.setInt(1, customer_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Order_ID = resultSet.getInt("Order_ID");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Order_ID;
    }


    public static int checkIfOrderExist(int orderId) {

        int order_id = 0;
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Order_ID from Orders where Order_ID= ?");
            statement.setInt(1, orderId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                orderId = resultSet.getInt("Order_ID");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }

    public static void makeOrderInActive(int order_id) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Orders set Is_Active=FALSE where Order_ID = ?");

            statement.setInt(1, order_id);
            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
