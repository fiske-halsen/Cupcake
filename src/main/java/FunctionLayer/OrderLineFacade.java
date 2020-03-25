package FunctionLayer;

import DBAccess.OrderLineMapper;
import DBAccess.OrderMapper;

public class OrderLineFacade {

    public static void createOrderLine( int customer_Id, int buttom_Id, int topping_Id, double totalPrice, int quantity) throws LoginSampleException {
        OrderLine orderLine = new OrderLine(customer_Id, buttom_Id, topping_Id, totalPrice, quantity);
        OrderLineMapper.createOrderLine(orderLine);

    }
}
