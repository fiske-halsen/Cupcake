package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kurv extends Command {
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

        // nu har vi lavet en ordre, nu kan vi lave mange ordrelinier til denne
        OrderMapper.InsertOrder(date, customerId);

        // få session id, og bruge det som orderid
        int orderId = OrderMapper.getOrderId(customerId);

        OrderMapper.updateOrderId(customerId, orderId);
        // nu laver vi en ordrelinie

        // vi får fat i attributerne så vi kan lave en orderlinje

        int buttomId = Integer.parseInt(request.getParameter("buttomchoice"));
        int toppingId = Integer.parseInt(request.getParameter("toppingchoice"));
        int antal = Integer.parseInt(request.getParameter("antal"));

        // nu vil vi have fat i prisen for denne ordrelinje og udregnede den samlede pris

        int totalPrice = (int) ((ProductMapper.getButtomPrice(buttomId) + ProductMapper.getToppingPrice(toppingId)) * antal);


        CustomerMapper.updateSaldo(customerId, totalPrice);
        double saldo = CustomerMapper.getCustomerSaldo(customerId);
        request.getSession().setAttribute("saldo", saldo);

        return "customerpage";


    }
}
