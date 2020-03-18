package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static double getButtomPrice(int buttom_id){
        double price = 0.0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select price from buttom where buttom_id = ?");
            statement.setInt(1, buttom_id);

            ResultSet resultSet = statement.executeQuery();

            price = resultSet.getDouble("price");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }



    public static double getToppingPrice(int topping_id){
        double price = 0.0;

        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("Select price from topping where topping_id = ?");
            statement.setInt(1, topping_id);

            ResultSet resultSet = statement.executeQuery();

            price = resultSet.getDouble("price");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;

    }


}
