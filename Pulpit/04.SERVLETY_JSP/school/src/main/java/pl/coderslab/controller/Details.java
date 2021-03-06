package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Details", urlPatterns = "/Details")
public class Details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            ArrayList<Solution> solutions = Solution.loadAllByUserId(DbUtil.getConn(),id);
            User user = User.loadUserById(DbUtil.getConn(),id);
            request.setAttribute("solutions",solutions);
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/details.jsp").forward(request,response);

    }
}
