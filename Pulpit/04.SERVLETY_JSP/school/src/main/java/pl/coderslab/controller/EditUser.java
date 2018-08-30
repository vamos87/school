package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditUser", urlPatterns = "/EditUser")
public class EditUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("saveUser"));

        if (id == 0) {
            User user = new User(username,password,email);
            try {
                user.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (id != 0){
            try {
                User user = (User) User.loadUserById(DbUtil.getConn(),id);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.saveToDB(DbUtil.getConn());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/ListOfUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User user = User.loadUserById(DbUtil.getConn(),id);
            request.setAttribute("user",user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editUser.jsp").forward(request,response);
    }
}
