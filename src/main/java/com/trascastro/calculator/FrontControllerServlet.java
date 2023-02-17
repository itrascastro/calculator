package com.trascastro.calculator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "FrontControllerServlet", value = "/*/")
public class FrontControllerServlet extends HttpServlet {
    private ServletContext context;

    public void init() {
        this.context = getServletContext();
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            request.getRequestDispatcher("template.jsp").forward(request, response);
        }

        String[] parts = pathInfo.split("/");
        if (parts.length < 2) {
            // No se especificaron los dos parámetros requeridos (nombre y accion)
            // Aquí puedes generar una respuesta de error
            return;
        }

        // comment
        String controllerName = parts[1];
        String actionName = parts[2];

        try {
            Class<?> controllerClass = Class.forName("controllerName");
            Constructor<?> constructor = controllerClass.getDeclaredConstructor();
            Object controllerInstance = constructor.newInstance();
            Method actionMethod = controllerClass.getMethod("actionName");

            Object result = actionMethod.invoke(controllerInstance);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            // maneja la excepción aquí
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
 */
}
