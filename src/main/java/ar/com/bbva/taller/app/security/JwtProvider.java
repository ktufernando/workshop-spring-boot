package ar.com.bbva.taller.app.security;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fer on 11/04/19.
 */
@Component
public class JwtProvider {

    public boolean validateToken(String token) {
        if (token.equals("ABC")) {
            return true;
        }
        return false;
    }

    public String getTokenHeader(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public String generateToken(String username) {
        return "ABC";
    }

}
