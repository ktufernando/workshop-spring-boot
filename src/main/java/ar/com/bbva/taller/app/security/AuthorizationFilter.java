package ar.com.bbva.taller.app.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by fer on 11/04/19.
 */
public class AuthorizationFilter extends GenericFilterBean {


    private JwtProvider jwtProvider;

    public AuthorizationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtProvider.getTokenHeader((HttpServletRequest) servletRequest);

        if (token != null && jwtProvider.validateToken(token)) {

            SecurityContextHolder.getContext().setAuthentication(
                    jwtProvider.getAuthentication(token)
            );

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
