package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderMapper {

    public static void insertOrderline(int order_id, int customer_id, int buttom_id, int topping_id, int quantity, double price){

        try {
            Connection connection= Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orderline (order_id, customer_id , buttom_id, topping_id, quantity, price)\n" +
                    "VALUES (?, ?, ?,?,?,?);");

            statement.setInt(1,order_id);
            statement.setInt(2, customer_id);
            statement.setInt(3,buttom_id);
            statement.setInt(4,topping_id);
            statement.setInt(5,quantity);
            statement.setDouble(6, price);


            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public static void InsertOrder(int order_id, String date, int customer_id){
        try {
            Connection connection= Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (order_id, date, customer_id)\n" +
                    "VALUES (?, ?, ?,);");
            statement.setInt(1,order_id);
            statement.setString(2, date);
            statement.setInt(3,customer_id);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
