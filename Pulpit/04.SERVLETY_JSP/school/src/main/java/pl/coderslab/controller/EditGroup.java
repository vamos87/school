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

@WebServlet(name = "EditGroup", urlPatterns = "/EditGroup")
public class EditGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nazwa = request.getParameter("nazwa");
        int id = Integer.parseInt(request.getParameter("saveGroup"));

        if (id == 0) {
            Group group = new Group(nazwa);
            try {
                group.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (id != 0){
            try {
                Group group = (Group) Group.loadGroupById(DbUtil.getConn(),id);
                group.setName(nazwa);
                group.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/ListOfGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Group group = Group.loadGroupById(DbUtil.getConn(),id);
            request.setAttribute("group",group);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editGroup.jsp").forward(request,response);
    }
}
