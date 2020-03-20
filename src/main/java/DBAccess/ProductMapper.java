package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static double getButtomPrice(int buttom_id) {
        double price = 0.0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select price from Buttom where Buttom_id = ?");
            statement.setInt(1, buttom_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                price = resultSet.getDouble("price");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }


    public static double getToppingPrice(int topping_id) {
        double price = 0.0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select Price from Topping where Topping_id = ?");
            statement.setInt(1, topping_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                price = resultSet.getDouble("Price");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;

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

    public static void makeInactive(int customer_id) {


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

}
