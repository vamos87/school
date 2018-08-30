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

@WebServlet(name = "Solutions", urlPatterns = "/Solutions")
public class Solutions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Solution solution = null;
        try {
            solution = Solution.loadSolutionById(DbUtil.getConn(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("solution",solution.getDescription());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/solutions.jsp").forward(request,response);
    }
}
