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

        // Vi får den totale pris ud fra de orderlines der er i kurven
        double totalPrice = OrderLineMapper.getTotalPrice(customerId);

        int customerSaldo = CustomerMapper.checkSaldo(customerId);


        // Her oprettes en Order, dog kun, hvis customer har penge nok på saldoen
        if (customerSaldo > totalPrice) {

            OrderFacade.createOrder(date, customerId);

            int orderId = OrderMapper.getOrderId(customerId);

            // Først når selve ordren bliver lavet, får hver orderline tiknyttet et OrderID
            OrderLineMapper.updateOrderId(customerId, orderId);

            // Når kunden laver ordren bliver kundesaldoen opdateret på siden
            CustomerMapper.updateSaldo(customerId, totalPrice);

            double saldo = CustomerMapper.getCustomerSaldo(customerId);

            request.getSession().setAttribute("saldo", saldo);

            // Her "tømmer" vi indkøbskurven, ved at gøre orderlines false
            OrderLineMapper.makeOrderLineInActive(customerId);

            OrderMapper.makeOrderInActive(orderId);

            // Vi sætter dem null, for at forhindre dem i at blive printet ud på vores jsp sider, fordi ordren bliver gennemført
            request.getSession().setAttribute("TotalPrice", null);
            request.getSession().setAttribute("Error", null);
            return "customerpage";

        } else {
            request.getSession().setAttribute("Error", "Du har ikke nok penge på din saldo");
            return "kurvpage";
        }

    }

}
