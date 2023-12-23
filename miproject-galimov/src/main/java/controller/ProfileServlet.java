package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.ProfileDao;
import java.io.IOException;
/*
* Сервлет нужен для отображения страницы профиля а также
* для смены пароля пользователя , при смене пароля перенаправляет
* на страницу аутентификации, чтобы пользователь снова залогинился
* */
public class ProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String new_password = request.getParameter("newPassword");

        HttpSession session = request.getSession(false);
        String userLogin = (String)session.getAttribute("userlogin");

        ProfileDao profileDao = new ProfileDao();
        profileDao.updatePassword(userLogin,new_password);


        request.setAttribute("message","Пожалуйста,войдите заново");
        request.getRequestDispatcher("login.ftl").forward(request, response);

    }
}
