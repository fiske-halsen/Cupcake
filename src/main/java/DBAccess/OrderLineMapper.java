package DBAccess;

import FunctionLayer.OrderLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderLineMapper {

    public static void createOrderLine(OrderLine orderLine) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orderline (Customer_ID , Buttom_ID, " +
                    "Topping_ID, Total_Price, Quantity) VALUES (?, ?,?,?,?);");

            statement.setInt(1, orderLine.getCustomer_Id());
            statement.setInt(2, orderLine.getButtom_Id());
            statement.setInt(3, orderLine.getTopping_Id());
            statement.setDouble(4, orderLine.getTotal_Price());
            statement.setInt(5, orderLine.getQuantity());

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateOrderlineId(int customer_id, int order_id) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Orderline SET Order_ID=? WHERE Customer_ID=? AND Is_Active=TRUE");

            statement.setInt(1, order_id);
            statement.setInt(2, customer_id);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void removeOrderLine(int orderLine_ID) {

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Orderline SET Is_Active=false WHERE Orderline_ID=?");

            statement.setInt(1, orderLine_ID);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void makeOrderLineInActive(int customer_id) {


        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Orderline set Is_Active=FALSE where Customer_ID = ?");

            statement.setInt(1, customer_id);
            statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double getTotalPrice(int customer_id) {
        double sum = 0.0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Total_Price from Orderline where Customer_ID = ? AND Is_Active=TRUE");

            statement.setInt(1, customer_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sum += resultSet.getDouble("Total_Price");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sum;
    }


}
