package security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AutentificationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getServletPath().equals("/usercheck")
            || httpServletRequest.getServletPath().equals("/regpage")
            || httpServletRequest.getServletPath().equals("/registration")
            || httpServletRequest.getServletPath().startsWith("/resources")
//            || httpServletRequest.getServletPath().equals("/services")
            || httpServletRequest.getServletPath().equals("/master")
            || httpServletRequest.getServletPath().equals("/login")
            || httpServletRequest.getServletPath().equals("/index")
            || httpServletRequest.getServletPath().equals("/aboutUs")
            || httpServletRequest.getServletPath().equals("/salon")
            || httpServletRequest.getServletPath().equals("/support")
        ) {
            System.out.println("usercheck");
            filterChain.doFilter(request, response);
        } else {

            System.out.println("not usercheck");

            HttpSession session = ((HttpServletRequest) request).getSession(false);


            if (session != null
                    && session.getAttribute("clientid") != null) {


                filterChain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/login").forward(request, response);

            }
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
