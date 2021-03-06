package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderLineMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOut extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        String email = String.valueOf(request.getSession().getAttribute("email"));

        int customer_id = CustomerMapper.getCustomerId(email);

        // Når man logger ud sørger vi for at alle orderlines bliver false
        OrderLineMapper.makeOrderLineInActive(customer_id);
        request.getSession().setAttribute("email", null);

        request.getSession().invalidate();


        return "index";
    }
}
