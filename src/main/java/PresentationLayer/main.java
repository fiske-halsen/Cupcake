package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class main {
    public static void main(String[] args) {

        OrderMapper.insertOrderline(8,1,1,1, 2, 10);

    }
}
