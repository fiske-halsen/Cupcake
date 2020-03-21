package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOut extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = String.valueOf(request.getSession().getAttribute("email"));
        int customer_id = CustomerMapper.getCustomerId(email);
        ProductMapper.makeInactive(customer_id);


        request.getSession().invalidate();

        return "index";
    }
}
