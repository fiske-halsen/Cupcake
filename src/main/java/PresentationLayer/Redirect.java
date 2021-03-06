package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String targetPage = request.getParameter("taget");

        switch (targetPage) {

            case "login":

                return "loginpage";

            case "galleri":
                return "galleripage";

            case "customer":

                return "customerpage";

            case "sekurv":

                return "kurvpage";

            case "seeorders":
                return "ordreroversigtpage";

            case "seecustomers":
                return "kundeoversigtpage";

            case "logout":
                return "index";

            default:
                return "index";

        }
    }
}
