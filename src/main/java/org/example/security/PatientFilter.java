package org.example.security;

import org.example.exeptions.PatientNotFoundException;
import org.example.models.Patient;
import org.example.repositories.PatientRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/patient/*")
public class PatientFilter implements Filter {

    private PatientRepository patientRepository;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        patientRepository = (PatientRepository) context.getAttribute("patientRepository");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("role") != null && session.getAttribute("role").equals("patient")) {
            Patient patient = patientRepository.findPatientByEmail((String) session.getAttribute("email"))
                    .orElseThrow(PatientNotFoundException::new);
            if (patient != null) {
                request.setAttribute("name", patient.getName());
                request.setAttribute("patientid", patient.getId());
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect("http://localhost:8080/SemestrWork1");
            }
        } else {
            ((HttpServletResponse) response).sendRedirect("http://localhost:8080/SemestrWork1");
        }
    }

    @Override
    public void destroy() {

    }
}