package PresentationLayer;

import DBAccess.AdminMapper;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int tempOrderId = OrderMapper.checkIfOrderExist(orderId);

            if (orderId == 0) {

                request.getSession().setAttribute("Error6", "Ordren findes ikke.");

            } else {

                AdminMapper.removeOrder(orderId);
                request.getSession().setAttribute("Error6", null);

            }

        } catch(Exception ex){

            request.getSession().setAttribute("Error6", ex.getMessage());

        }


        return "ordreroversigtpage";
    }
}
