package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "loginuser", new Login() );
        commands.put( "register", new Register() );
        commands.put( "login", new Redirect() );
        commands.put("galleri", new Redirect());
        commands.put("logout", new LogOut());
        commands.put("customer", new Redirect());
        commands.put("makeorder", new MakeOrder());
        commands.put("sekurv", new Redirect());
        commands.put("makeorderline", new MakeOrderLine());
        commands.put("removeorderline", new RemoveOrderLine());
        commands.put("seeorders", new Redirect());
        commands.put("seecustomers", new Redirect());
    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
