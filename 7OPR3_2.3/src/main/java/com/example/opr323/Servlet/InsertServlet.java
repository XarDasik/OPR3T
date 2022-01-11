package com.example.opr323.Servlet;

import com.example.opr323.Model.Person;
import com.example.opr323.Service.DatabaseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/insert-person")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        DatabaseService insertService = new DatabaseService();
        insertService.insert(new Person(name, surname));

        response.sendRedirect("viewPage.jsp");

    }
}
