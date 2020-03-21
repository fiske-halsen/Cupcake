package PresentationLayer;

import DBAccess.AdminMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCustomer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));

        AdminMapper.removeCustomer(customerId);

        return "kundeoversigtpage";
    }
}
