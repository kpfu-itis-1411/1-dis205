package org.example.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.repositories.*;
import org.example.service.*;
import org.example.service.admin.appointment.CreateAppointmentAdminService;
import org.example.service.admin.appointment.DeleteAppointmentAdminService;
import org.example.service.admin.appointment.ShowAppointmentsAdminService;
import org.example.service.admin.appointment.UpdateAppointmentAdminService;
import org.example.service.admin.doctor.CreateDoctorAdminService;
import org.example.service.admin.doctor.DeleteDoctorAdminService;
import org.example.service.admin.doctor.ShowDoctorsAdminService;
import org.example.service.admin.doctor.UpdateDoctorAdminService;
import org.example.service.admin.patient.CreatePatientAdminService;
import org.example.service.admin.patient.DeletePatientAdminService;
import org.example.service.admin.patient.ShowPatientsAdminService;
import org.example.service.admin.patient.UpdatePatientAdminService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dentalclinic";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        try {
            Class.forName((DB_DRIVER));
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(DB_DRIVER);
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.setMaximumPoolSize(20);

        //Каждый репозиторий представляет собой объект,
        // который обеспечивает доступ к данным, хранящимся в базе данных
        DataSource dataSource = new HikariDataSource(config);
        DoctorRepository doctorRepository = new DoctorRepository(dataSource);
        PatientRepository patientRepository = new PatientRepository(dataSource);
        HashPasswordService hashPasswordService = new HashPasswordService();
        ProcedureRepository procedureRepository = new ProcedureRepository(dataSource);
        AppointmentRepository appointmentRepository = new AppointmentRepository(dataSource);
        TimeSlotRepository timeSlotRepository = new TimeSlotRepository(dataSource);

        //устанавливаем атрибуты контекста сервлета(параметры веб приложения),
        //которые связывают репозитории с соответствующими именами
        context.setAttribute("appointmentRepository", appointmentRepository);
        context.setAttribute("doctorRepository", doctorRepository);
        context.setAttribute("patientRepository", patientRepository);
        context.setAttribute("procedureRepository", procedureRepository);
        context.setAttribute("timeSlotRepository", timeSlotRepository);


        context.setAttribute("signInService",
                new SingInService(doctorRepository, patientRepository, hashPasswordService));

        context.setAttribute("singUpService", new SignUpService(patientRepository, hashPasswordService));

        context.setAttribute("personalAccountService", new PersonalAccountService(doctorRepository, patientRepository));

        context.setAttribute("createAppointmentService", new CreateAppointmentService(procedureRepository));

        context.setAttribute("selectDateService",
                new SelectDateService(appointmentRepository, procedureRepository, patientRepository, timeSlotRepository));

        context.setAttribute("doctorAccountService", new DoctorAccountService(doctorRepository, appointmentRepository));

        context.setAttribute("patientAppointmentsListService",
                new PatientAppointmentsListService(patientRepository, appointmentRepository));


        context.setAttribute("createAppointmentAdminService", new CreateAppointmentAdminService(appointmentRepository));

        context.setAttribute("showAppointmentsAdminService", new ShowAppointmentsAdminService(appointmentRepository));

        context.setAttribute("updateAppointmentAdminService", new UpdateAppointmentAdminService(appointmentRepository));

        context.setAttribute("deleteAppointmentAdminService", new DeleteAppointmentAdminService(appointmentRepository));


        context.setAttribute("createPatientAdminService", new CreatePatientAdminService(patientRepository,hashPasswordService));

        context.setAttribute("showPatientsAdminService", new ShowPatientsAdminService(patientRepository));

        context.setAttribute("updatePatientAdminService", new UpdatePatientAdminService(patientRepository, hashPasswordService));

        context.setAttribute("deletePatientAdminService", new DeletePatientAdminService(patientRepository));


        context.setAttribute("createDoctorAdminService", new CreateDoctorAdminService(doctorRepository, hashPasswordService));

        context.setAttribute("showDoctorsAdminService", new ShowDoctorsAdminService(doctorRepository));

        context.setAttribute("updateDoctorAdminService", new UpdateDoctorAdminService(doctorRepository, hashPasswordService));

        context.setAttribute("deleteDoctorAdminService", new DeleteDoctorAdminService(doctorRepository));

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
