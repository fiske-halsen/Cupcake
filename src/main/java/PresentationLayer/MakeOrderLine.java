package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderLineMapper;
import DBAccess.OrderMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderLineFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeOrderLine extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try {
            String email = String.valueOf(request.getSession().getAttribute("email"));

            // få customer id ud fra emailen
            int customerId = CustomerMapper.getCustomerId(email);

            int buttomId = Integer.parseInt(request.getParameter("buttomchoice"));
            int toppingId = Integer.parseInt(request.getParameter("toppingchoice"));
            int antal = Integer.parseInt(request.getParameter("antal"));

            double orderLinePrice = (ProductMapper.getButtomPrice(buttomId) + ProductMapper.getToppingPrice(toppingId)) * antal;

            OrderLineFacade.createOrderLine(customerId,buttomId,toppingId,orderLinePrice,antal);

            double totalPrice = OrderLineMapper.getTotalPrice(customerId);
            request.getSession().setAttribute("TotalPrice", totalPrice);

            request.getSession().setAttribute("Error2", null);

            int orderId = OrderMapper.getOrderId(customerId);

            OrderLineMapper.updateOrderlineId(customerId,orderId);


        } catch( Exception ex ){

            request.getSession().setAttribute("Error2", ex.getMessage());
            try {
                request.getRequestDispatcher( "/WEB-INF/customerpage.jsp" ).forward( request, response );
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        // nu vil vi have fat i prisen for denne ordrelinje og udregnede den samlede pris

        return "customerpage";

    }
}
