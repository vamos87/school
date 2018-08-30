package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListOfExcercises", urlPatterns = "/ListOfExcercises")
public class ListOfExcercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editExcercise.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Exercise> excercises = Exercise.loadAllExercises(DbUtil.getConn());
            request.setAttribute("excercises",excercises);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/listOfExcercises.jsp").forward(request,response);
    }
}
