package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.ProductMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();


        // få customer id ud fra emailen
        int customerId = CustomerMapper.getCustomerId(email);
        request.getSession().setAttribute("customer_id", customerId);
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);

        // Vi sætter saldoen så snart man logger ind
        double saldo = CustomerMapper.getCustomerSaldo(customerId);
        request.getSession().setAttribute("saldo", saldo);

        return user.getRole() + "page";
    }

}
