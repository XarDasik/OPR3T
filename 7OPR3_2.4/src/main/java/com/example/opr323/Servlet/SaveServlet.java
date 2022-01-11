package com.example.opr323.Servlet;

import com.example.opr323.Model.Access;
import com.example.opr323.Service.DatabaseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.opr323.Model.Record;
import com.example.opr323.Service.WordService;

@WebServlet(name = "SaveServlet", value = "/save-servlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("shareText.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String pin;
        try {
            pin = request.getParameter("pin");
        }
        catch(Exception e){
            pin = "";
        }
        
        String code = WordService.generateCode();
        while(code == null){
            code = WordService.generateCode();
        }
        if(DatabaseService.insertToUserText(new Record(text, new Access(code, pin)))){
            request.getSession().setAttribute("code", code);
            request.getRequestDispatcher("successPage.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "error");
            request.setAttribute("pin", pin);
            request.setAttribute("text", text);
            request.getRequestDispatcher("shareText.jsp").forward(request, response);
        }
    }
}
