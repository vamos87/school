package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomePage", urlPatterns = "/")
public class HomePage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Solution solution = new Solution();
        int numberSolutions = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        try {
            List<Solution> solutions = solution.loadAllSolutions(DbUtil.getConn(),numberSolutions);
            request.setAttribute("loadAllSolutions",solutions);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").
                forward(request,response);
    }
}
