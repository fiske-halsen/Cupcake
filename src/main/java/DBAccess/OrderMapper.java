package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {

    public static void insertOrderline(int order_id, int customer_id, int buttom_id, int topping_id, int quantity, double price){

        try {
            Connection connection= Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orderline (Customer_ID , Buttom_ID, " +
                    "Topping_ID, Total_Price, Order_ID, Quantity) VALUES (?, ?, ?,?,?,?);");

            statement.setInt(1, customer_id);
            statement.setInt(2, buttom_id);
            statement.setInt(3, topping_id);
            statement.setDouble(4,price);
            statement.setInt(5, order_id);
            statement.setInt(6, quantity);


            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public static void InsertOrder(String date, int customer_id){
        try {
            Connection connection = Connector.connection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders " +
                    "(date, Customer_ID) VALUES (?, ?);");
            statement.setString(1, date);
            statement.setInt(2,customer_id);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getOrderId(int customer_id){
        int Order_ID = 0;

        try {
            Connection connection= Connector.connection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT Order_ID FROM Orders WHERE Customer_ID = ?");
            statement.setInt(1,customer_id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Order_ID = resultSet.getInt("Order_ID");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Order_ID;
    }

}
