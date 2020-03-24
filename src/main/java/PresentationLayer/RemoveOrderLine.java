package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import DBAccess.ProductMapper;
import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveOrderLine extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            String email = String.valueOf(request.getSession().getAttribute("email"));

            int customerId = CustomerMapper.getCustomerId(email);


            int orderline_id = Integer.parseInt(request.getParameter("orderline_id"));
            OrderMapper.removeOrderLine(orderline_id);
            double totalPrice = ProductMapper.getTotalPrice(customerId);
            request.getSession().setAttribute("Error", null);

            if (totalPrice > 0.0) {
                request.getSession().setAttribute("TotalPrice", totalPrice);
            } else {
                request.getSession().setAttribute("TotalPrice", null);
            }

            request.getSession().setAttribute("Error3", null);

        } catch(Exception e){

            request.getSession().setAttribute("Error3", e.getMessage());

        }
        return "kurvpage";
    }
}
