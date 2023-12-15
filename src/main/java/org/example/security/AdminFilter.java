package org.example.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String userRole = (String) request.getSession().getAttribute("role");

        if (userRole != null && userRole.equals("admin")) {
            //передает управление следующему фильтру или сервлету для дальнейшей обработки запроса
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/SemestrWork1");

        }
    }

    @Override
    public void destroy() {

    }
}
