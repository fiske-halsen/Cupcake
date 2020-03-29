package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderLineMapper;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        // få email ud ved, at trække den ud fra sessionen
        String email = String.valueOf(request.getSession().getAttribute("email"));

        // få customer id ud fra emailen
        int customerId = CustomerMapper.getCustomerId(email);

        // får datoen nu til for at anvende den som parameter til en order
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        double totalPrice = OrderLineMapper.getTotalPrice(customerId);

        int customerSaldo = CustomerMapper.checkSaldo(customerId);


        if (customerSaldo > totalPrice) {
            // nu har vi lavet en ordre, nu kan vi lave mange ordrelinier til denne
            OrderFacade.createOrder(date, customerId);
            int orderId = OrderMapper.getOrderId(customerId);
            request.getSession().setAttribute("orderid", orderId);

            OrderLineMapper.updateOrderId(customerId, orderId);
            CustomerMapper.updateSaldo(customerId, totalPrice);
            double saldo = CustomerMapper.getCustomerSaldo(customerId);
            request.getSession().setAttribute("saldo", saldo);
            OrderLineMapper.makeOrderLineInActive(customerId);

            OrderMapper.makeOrderInActive(orderId);

            request.getSession().setAttribute("TotalPrice", null);
            request.getSession().setAttribute("Error", null);
            return "customerpage";
            
        } else {
            request.getSession().setAttribute("Error", "Du har ikke nok penge på din saldo");
            return "kurvpage";
        }

    }

}
