package org.example.service;

import org.example.models.Patient;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class SignUpService {
    private PatientRepository patientRepository;
    private final HashPasswordService hashPasswordService;

    public SignUpService(PatientRepository patientRepository, HashPasswordService hashPasswordService) {
        this.patientRepository = patientRepository;
        this.hashPasswordService = hashPasswordService;
    }

    public void registration(HttpServletRequest req) {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Date dateOfBirth = Date.valueOf((req.getParameter("dateofbirth")));
        String password = req.getParameter("password");
        String passwordMD5 = hashPasswordService.encrypt(password);


        Patient patient = Patient.builder().
                name(name).
                surname(surname).
                email(email).
                dateOfBirth(dateOfBirth).
                password(passwordMD5).build();

        patientRepository.savePatient(patient);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("email", email);

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

