package com.analyze.ko.framework.server.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by parkjaesung on 2016. 7. 22..
 */
public class TestJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestJsp doGet Method");
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/test.jsp");

        rd.forward(req,resp);
    }
}
