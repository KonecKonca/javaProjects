package com.kozitski.pufar.filter.login;

import com.kozitski.pufar.entity.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@WebFilter("/*")
public class LoginFilter implements Filter {
    private static final Set<String> ONLY_FOR_AUTHORIZED_USER = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/chat", "/dialog", "/speaker")));
    private static final String CURRENT_USER = "currentUser";
    private static final String FORWARD_PATH = "index.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");

        if(!ONLY_FOR_AUTHORIZED_USER.contains(path)){
            filterChain.doFilter(req, resp);
        }
        else if(ONLY_FOR_AUTHORIZED_USER.contains(path) && ((User) req.getServletContext().getAttribute(CURRENT_USER)).getStatus() != null){
            filterChain.doFilter(req, resp);
        }
        else {
            req.setAttribute("accessRight", "You try to get access on page, witch defined only for logined users");
            req.getRequestDispatcher(FORWARD_PATH).forward(req, resp);
        }

    }

    @Override
    public void destroy() {

    }

}
