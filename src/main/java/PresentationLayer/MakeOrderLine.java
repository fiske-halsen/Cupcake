package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MakeOrderLine extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = String.valueOf(request.getSession().getAttribute("email"));

        // få customer id ud fra emailen
        int customerId = CustomerMapper.getCustomerId(email);
        int buttomId = Integer.parseInt(request.getParameter("buttomchoice"));
        int toppingId = Integer.parseInt(request.getParameter("toppingchoice"));
        int antal = Integer.parseInt(request.getParameter("antal"));

        // nu vil vi have fat i prisen for denne ordrelinje og udregnede den samlede pris

        int antalOrdre = ProductMapper.checkKurv(customerId);

        double orderLinePrice = (ProductMapper.getButtomPrice(buttomId) + ProductMapper.getToppingPrice(toppingId)) * antal;



        if (antalOrdre > 0) {
            request.getSession().setAttribute("orderlineprice", orderLinePrice);
            request.getSession().setAttribute("TotalPrice", null);
        } else{
            OrderMapper.insertOrderline(customerId, buttomId, toppingId, antal, orderLinePrice);

            double totalPrice = ProductMapper.getTotalPrice(customerId);
            request.getSession().setAttribute("TotalPrice", totalPrice);

        }

        return "customerpage";

    }
}
