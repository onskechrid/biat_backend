package tn.biat.biat.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        if(req.getServletPath().equals(SecurityConstants.LOGIN_URL)){
            log.info("No checks needed it is in a permit-All path");
            chain.doFilter(req,res);
            return;
        }
        String header = req.getHeader(SecurityConstants.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            log.info("Header is either null or doesn't start with the token header prefix");
            chain.doFilter(req, res);
            return;
        }

        try {
            String token = header.substring(SecurityConstants.TOKEN_PREFIX.length());
            Algorithm algo = Algorithm.HMAC256(SecurityConstants.SECRET.getBytes());
            JWTVerifier verifier = JWT.require(algo).build();
            DecodedJWT dJWT = verifier.verify(token);
            String username = dJWT.getSubject();
            if(username == null){
                log.info("The access token provided does not grant any user, it is neither signed nor valid");//TODO check if the user is the same in database as in the token
            }
            String [] roles = dJWT.getClaim("roles").asArray(String.class);
            Collection<SimpleGrantedAuthority> auths = new ArrayList<>();
            //we should make the conversion bellow to SimpleGrantedAuthority just for Spring Security
            stream(roles).forEach(role -> {
                auths.add(new SimpleGrantedAuthority(role));
            });
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, auths);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            chain.doFilter(req,res);
        }catch (Exception ex){
            log.info("Error logging in "+ ex.getMessage());
            res.sendError(403);
            Map<String, String> err = new HashMap<>();
            err.put("error", ex.getMessage());
            res.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(res.getOutputStream(), err);
        }

    }
}