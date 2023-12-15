package org.example.servlets;

import org.example.service.SignUpService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private SignUpService signUpService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        signUpService = (SignUpService) context.getAttribute("singUpService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sign_up.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        signUpService.registration(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}




//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String email = req.getParameter("email");
//        Date dateOfBirth = Date.valueOf((req.getParameter("dateofbirth")));
//        String password = req.getParameter("password");
//
//        HashPasswordService hashPasswordService = new HashPasswordService();
//        String passwordMD5 = hashPasswordService.encrypt(password);
//
//
//        try {
//            Connection connection = ConnectionContainer.getConnection();
//            PreparedStatement statement =
//                    connection.prepareStatement
//                            ("INSERT INTO patient (name, surname, email, dateofbirth, password) VALUES (?, ?, ?, ?, ?)");
//
//            statement.setString(1, name);
//            statement.setString(2, surname);
//            statement.setString(3, email);
//            statement.setDate(4, new java.sql.Date((new SimpleDateFormat( "yyyy-MM-dd" ).
//                    parse(String.valueOf(dateOfBirth))).getTime()));
//            statement.setString(5, passwordMD5);
//
//            statement.executeUpdate();
//            connection.close();
//
//            resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }



//        Connection connection = ConnectionContainer.getConnection();

//
//        Patient patient = new Patient().builder().
//                name(name).
//                surname(surname).
//                email(email).
//                dateOfBirth(dateOfBirth).
//                password(passwordMD5).build();
//
//        PatientRepository patientRepository = new PatientRepository();
//        patientRepository.save(patient);
//
//        resp.sendRedirect("personal_account.jsp");
//
//
