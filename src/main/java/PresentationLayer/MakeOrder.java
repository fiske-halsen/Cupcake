package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MakeOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        // få email ud ved, at trække den ud fra sessionen
        String email = String.valueOf(request.getSession().getAttribute("email"));
        System.out.println(email);
        // få customer id ud fra emailen
        int customerId = CustomerMapper.getCustomerId(email);

        // får datoen nu til for at anvende den som parameter til en order
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        // nu har vi lavet en ordre, nu kan vi lave mange ordrelinier til denne
        OrderMapper.InsertOrder(date, customerId);

        // få session id, og bruge det som orderid
        int orderId = OrderMapper.getOrderId(customerId);

        double totalPrice = (double) request.getSession().getAttribute("orderlineprice");

        CustomerMapper.updateSaldo(customerId, totalPrice);
        double saldo = CustomerMapper.getCustomerSaldo(customerId);
        request.getSession().setAttribute("saldo", saldo);
        ProductMapper.makeInactive(customerId);
        return "customerpage";
    }
}
