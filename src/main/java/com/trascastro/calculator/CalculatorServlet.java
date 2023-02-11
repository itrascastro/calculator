package com.trascastro.calculator;

import com.trascastro.calculator.service.CalculatorService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private ServletContext context;

    public void init() {
        this.context = getServletContext();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CalculatorService c = new CalculatorService(2,3);

        String viewPath = context.getInitParameter("viewPath");
        String title = "";
        String contentPage = "";

        if (action.equals("index")) {
            title = "Calculator - Home";
            contentPage = viewPath + "calculator/index.jsp";
        } else if (action.equals("add")) {
            title = "Calculator - Add";
            contentPage = viewPath + "calculator/add.jsp";
        }

        request.setAttribute("title", title);
        request.setAttribute("contentPage", contentPage);

        request.getRequestDispatcher(viewPath + "template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
