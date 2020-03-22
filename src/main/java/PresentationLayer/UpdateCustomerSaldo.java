package PresentationLayer;

import DBAccess.AdminMapper;
import DBAccess.CustomerMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCustomerSaldo extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        try {


            int customerId = Integer.parseInt(request.getParameter("customerId"));
            int tempCustomerId = CustomerMapper.checkIfCustomerExist(customerId);

            if (tempCustomerId == 0) {

                request.getSession().setAttribute("Error5", "Kunden findes ikke");

            } else {

                double customerSaldo = Double.parseDouble((request.getParameter("customerSaldo")));

                AdminMapper.insertMoney(customerId, customerSaldo);
                request.getSession().setAttribute("Error5", null);

            }
        }catch(Exception e){
            request.getSession().setAttribute("Error5", "Kunden findes ikke");
        }

        return "kundeoversigtpage";
    }
}
