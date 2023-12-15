package org.example.security;

import org.example.exeptions.DoctorOrAdminNotFoundException;
import org.example.models.Doctor;
import org.example.repositories.DoctorRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/doctor/*")
public class DoctorFilter implements Filter {
    private DoctorRepository doctorRepository;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        doctorRepository = (DoctorRepository) context.getAttribute("doctorRepository");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null && (session.getAttribute("role").equals("doctor"))) {
            Doctor doctor = doctorRepository.findDoctorByEmail((String) session.getAttribute("email"))
                    .orElseThrow(DoctorOrAdminNotFoundException::new);
            if (doctor != null) {
                request.setAttribute("doctorid", doctor.getId());
                request.setAttribute("post", doctor.getPost());
            }

            //передает управление следующему фильтру или сервлету для дальнейшей обработки запроса.
            filterChain.doFilter(request, servletResponse);
        }
        else {
            ((HttpServletResponse) servletResponse).sendRedirect("http://localhost:8080/SemestrWork1");
        }
    }

    @Override
    public void destroy() {

    }
}
