package com.example.opr323.Servlet;

import com.example.opr323.Model.Access;
import com.example.opr323.Model.Record;
import com.example.opr323.Service.DatabaseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetTextServlet", value = "/get-text")
public class LoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String pin = request.getParameter("pin");
        Record record = DatabaseService.getUserText(new Access(code, pin));
        if(record == null){
            System.out.println("sem to spadlo");
            request.setAttribute("code", code);
            request.setAttribute("pin", pin);
            request.setAttribute("invalidParameters", new Object());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            request.getSession().setAttribute("text", record.getText());
            request.getRequestDispatcher("getText.jsp").forward(request, response);
        }


    }
}
