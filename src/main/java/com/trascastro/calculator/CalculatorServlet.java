package com.trascastro.calculator;

import com.trascastro.calculator.service.CalculatorService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CalculatorService c = new CalculatorService(2,3);

        String viewRoute = "/WEB-INF/view/";
        String title = "";
        String contentPage = "";

        if (action.equals("index")) {
            title = "Calculator - Home";
            contentPage = viewRoute + "calculator/index.jsp";
        } else if (action.equals("add")) {
            title = "Calculator - Add";
            contentPage = viewRoute + "calculator/add.jsp";
        }

        /*
        * when they say request.setAttribute(Object, Object) it is simply to imply that the scope
        * of the attribute is for that request only and the attribute will not exist
        * in subsequent requests.
        */
        request.setAttribute("title", title);
        request.setAttribute("contentPage", contentPage);

        request.getRequestDispatcher(viewRoute + "template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
