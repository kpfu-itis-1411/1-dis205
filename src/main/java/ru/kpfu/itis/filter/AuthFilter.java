package ru.kpfu.itis.filter;

import ru.kpfu.itis.service.ViewerService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    private ViewerService viewerService = new ViewerService();


    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getServletPath().equals("/")
                || httpServletRequest.getServletPath().equals("/usercheck")
                || httpServletRequest.getServletPath().equals("/signIn")
                || httpServletRequest.getServletPath().equals("/cinema/new")
                || httpServletRequest.getServletPath().startsWith("/movies")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = ((HttpServletRequest) request).getSession(false);

            if (session != null && session.getAttribute("user") != null) {
                filterChain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/signIn").forward(request, response);
            }
        }
    }
}
