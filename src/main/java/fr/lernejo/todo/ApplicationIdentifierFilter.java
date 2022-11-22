package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApplicationIdentifierFilter implements Filter {
    String uuid = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        res.addHeader("Instance-Id", uuid);
        try {
            chain.doFilter(req, res);
        } finally {
           // System.out.println("in");
            res.addHeader("Instance-Id", uuid);
        }
       // chain.doFilter(req, res);

    }

}
