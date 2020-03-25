package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

public class OrderFacade {

    public static void createOrder( String date, int customer_Id ) throws LoginSampleException {
        Order order = new Order(date, customer_Id);
        OrderMapper.createOrder(order);

    }
}
