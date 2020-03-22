package PresentationLayer;

import DBAccess.AdminMapper;
import DBAccess.CustomerMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCustomer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        try {

            String email = String.valueOf(request.getSession().getAttribute("email"));

            int customerId = Integer.parseInt(request.getParameter("customerId"));
            int tempCustomerId = CustomerMapper.checkIfCustomerExist(customerId);


            if (tempCustomerId == 0) {

                request.getSession().setAttribute("Error4", "Ugyldigt kundeId");


            } else {


                AdminMapper.removeCustomer(customerId);
                request.getSession().setAttribute("Error4", null);

            }

        } catch(Exception e){

            request.getSession().setAttribute("Error4", e.getMessage());

        }

        return "kundeoversigtpage";



    }
}
