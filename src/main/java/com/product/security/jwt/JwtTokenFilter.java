package com.product.security.jwt;

import com.product.security.auth.ApplicationUserDetails;
import com.product.security.auth.ApplicationUserDetailsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Log
public class JwtTokenFilter extends GenericFilterBean {

  public static final String AUTHORIZATION = "Authorization";

  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  @Autowired
  private ApplicationUserDetailsService detailsService;

//  public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
//    this.jwtTokenProvider = jwtTokenProvider;
//  }
//
//  public void setDetailsService(ApplicationUserDetailsService detailsService) {
//    this.detailsService = detailsService;
//  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String token = getTokenFromRequest((HttpServletRequest) request);
    if (StringUtils.isEmpty(token) && jwtTokenProvider.validateToken(token)) {
      String userLogin = jwtTokenProvider.getLogin(token);
      ApplicationUserDetails userDetails = detailsService.loadUserByUsername(userLogin);
      UsernamePasswordAuthenticationToken auth =
          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(auth);
    }
    chain.doFilter(request, response);
  }

  private String getTokenFromRequest(HttpServletRequest request) {
    String bearer = request.getHeader(AUTHORIZATION);
    if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
      return bearer.substring(7);
    }
    return null;
  }
}
