package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductMapper {

    /**
     * Phillip, Sebastian, Lukas, Christoffer og Sumit
     * Return price
     * throws ClassNotFoundException
     * Phillip, Sebastian, Lukas, Christoffer og Sumit
     */

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

    public static int checkKurv(int customer_id) {
        int sum = 0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select count(Is_Active) as sum from Orderline where Customer_ID = ? AND Is_Active=TRUE");
            statement.setInt(1, customer_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sum = resultSet.getInt("sum");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return sum;
    }

}
