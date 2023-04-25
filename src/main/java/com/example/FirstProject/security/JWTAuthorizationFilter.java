package com.example.FirstProject.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
    response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
    response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");

    if(request.getMethod().equals("OPTIONS")){
        response.setStatus(HttpServletResponse.SC_OK);
    }
    else if(request.getRequestURI().equals("/user")) {
        filterChain.doFilter(request, response);
        return; }


    else if(request.getRequestURI().equals("/login")) {
        filterChain.doFilter(request, response);
        return;
    }

    else if (request.getRequestURI().matches("^/absencemaladie/(.*)$")) {
        String req = request.getRequestURI().replaceAll("^/absencemaladie/", "");
        filterChain.doFilter(request, response);
        return;
    }

    else if (request.getRequestURI().matches("^/agentAdmin/(.*)$")) {
        String cat = request.getRequestURI().replaceAll("^/agentAdmin/", "");
        filterChain.doFilter(request, response);
        return;
    }
    else if (request.getRequestURI().matches("^/documents/(.*)$")) {
        String cat = request.getRequestURI().replaceAll("^/documents/", "");
        filterChain.doFilter(request, response);
        return;
    }
    else if (request.getRequestURI().matches("^/collaborateur/(.*)$")) {
        String cat = request.getRequestURI().replaceAll("^/collaborateur/", "");
        filterChain.doFilter(request, response);
        return;
    }
    else if(request.getRequestURI().equals("/users")) {
        filterChain.doFilter(request, response);
        return; }
    else {

        String authorizationToken = request.getHeader("Authorization");
        if(authorizationToken!=null && authorizationToken.startsWith("Bearer ")) {

            try {
                String Jwt = authorizationToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("mySecret1234");
                JWTVerifier jWTverifier = JWT.require(algorithm).build();
                DecodedJWT decodeJWT = jWTverifier.verify(Jwt);
                String username = decodeJWT.getSubject();
                String [] roles = decodeJWT.getClaim("roles").asArray(String.class);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                for (String r:roles) {
                    authorities.add(new SimpleGrantedAuthority(r));
                }

                UsernamePasswordAuthenticationToken authenticationToken=
                        new UsernamePasswordAuthenticationToken(username,null,authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);

            }
            catch(Exception e) {
                response.setHeader("error-message", e.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }
    }
}
