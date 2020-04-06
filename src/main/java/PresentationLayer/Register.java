package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());


            request.setAttribute("register", "Du er nu oprettet, og kan nu foretage en ordre!");

            int customer_Id = CustomerMapper.getCustomerId(email);
            // sætter customerid som attribut til at få fat i det på jsp siden til at udskrive kurven fra databasen
            request.getSession().setAttribute("customer_id", customer_Id);
            double saldo = CustomerMapper.getCustomerSaldo(customer_Id);
            request.getSession().setAttribute("saldo", saldo);


            return "customerpage";
        } else {
            throw new LoginSampleException("De to kodeord matchede ikke!");
        }
    }

}
