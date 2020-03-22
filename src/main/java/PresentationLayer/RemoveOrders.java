package PresentationLayer;

import DBAccess.AdminMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        AdminMapper.removeOrder(orderId);

        return "ordreroversigtpage";
    }
}
