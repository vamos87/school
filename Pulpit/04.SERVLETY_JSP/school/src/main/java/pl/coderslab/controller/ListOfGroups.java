package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListOfGroups", urlPatterns = "/ListOfGroups")
public class ListOfGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editGroup.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Group> groups = Group.loadAllGroup(DbUtil.getConn());
            request.setAttribute("groups",groups);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/listOfGroups.jsp").forward(request,response);
    }
}
