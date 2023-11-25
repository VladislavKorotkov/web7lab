package com.bsuir.web7lab.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoginRequiredFilter", urlPatterns = "/GroupListServlet")
public class LoginRequiredFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if ("admin".equals(request.getSession().getAttribute("name"))) {
            chain.doFilter(req, resp);
        } else {
            request.getSession().invalidate();
            request.getRequestDispatcher("LoginServlet").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
