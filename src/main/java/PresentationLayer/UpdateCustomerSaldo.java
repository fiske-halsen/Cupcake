package PresentationLayer;

import DBAccess.AdminMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCustomerSaldo extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        double customerSaldo = Double.parseDouble((request.getParameter("customerSaldo")));

        AdminMapper.insertMoney(customerId, customerSaldo);

        return "kundeoversigtpage";
    }
}
