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

            int customerId = CustomerMapper.getCustomerId(email);


            // parser vores parametre, da vi altid får et objekt ud af getparameter metoden

            int buttomId = Integer.parseInt(request.getParameter("buttomchoice"));
            int toppingId = Integer.parseInt(request.getParameter("toppingchoice"));
            int antal = Integer.parseInt(request.getParameter("antal"));

            // Vi udregner prisen på en orderline
            double orderLinePrice = (ProductMapper.getButtomPrice(buttomId) + ProductMapper.getToppingPrice(toppingId)) * antal;

            // Vi laver en Orderline
            OrderLineFacade.createOrderLine(customerId,buttomId,toppingId,orderLinePrice,antal);

            // Vi trækker den samlede pris for hele kurven ud (alle orderlines)
            double totalPrice = OrderLineMapper.getTotalPrice(customerId);
            request.getSession().setAttribute("TotalPrice", totalPrice);

            request.getSession().setAttribute("Error2", null);


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
