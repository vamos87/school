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

@WebServlet(name = "EditExcercise", urlPatterns = "/EditExcercise")
public class EditExcercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("saveExcercise"));

        if (id == 0) {
            Exercise exercise = new Exercise(title,description);
            try {
                exercise.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (id != 0){
            try {
                Exercise exercise = (Exercise) Exercise.loadExerciseById(DbUtil.getConn(),id);
                exercise.setTitle(title);
                exercise.setDescription(description);
                exercise.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/ListOfExcercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Exercise exercise = Exercise.loadExerciseById(DbUtil.getConn(),id);
            request.setAttribute("excercise",exercise);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editExcercise.jsp").forward(request,response);
    }
}
