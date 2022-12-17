package com.example.footballapp.security.filter;

import com.example.footballapp.exception.ResourceNotFoundException;
import com.example.footballapp.security.data.dto.Payload;
import com.example.footballapp.entity.UsersEntity;
import com.example.footballapp.repository.UsersRepository;
import com.example.footballapp.security.config.JwtConfig;
import com.example.footballapp.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

@RequiredArgsConstructor
public class CustomAuthFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;
    private final UsersRepository usersRepository;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try{
            String authHeader = request.getHeader(AUTHORIZATION);
            if(authHeader !=null && authHeader.startsWith(jwtConfig.getTokenPrefix())){
                String token = authHeader.substring(jwtConfig.getTokenPrefix().length());

                Payload payloadFromToken = tokenService.getPayloadFromToken(token);

                UsersEntity user = usersRepository.findByIdAndSecretKey(
                        payloadFromToken.getId(),
                        payloadFromToken.getSecret())
                        .orElseThrow(ResourceNotFoundException::new);

                Collection<SimpleGrantedAuthority> authorities = user.getTypeUser()
                        .getGrantedAuthorities();

                authorities.add(new SimpleGrantedAuthority(jwtConfig.getTokenUserAuth()+user.getIdUser()));


                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                user.getLogin(),
                                user.getPassword(),
                                authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }catch (Exception exception){

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(APPLICATION_JSON_VALUE);

            return;
        }

        filterChain.doFilter(request,response);

    }
}
