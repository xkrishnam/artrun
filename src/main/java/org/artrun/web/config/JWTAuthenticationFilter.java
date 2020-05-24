// package org.artrun.web.config;

// import java.io.IOException;
// import java.sql.Date;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.auth0.jwt.JWT;
// import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

// public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
// 	 private AuthenticationManager authenticationManager;

// 	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
// 		 this.authenticationManager=authenticationManager;
// 	    }
	
// 	@Override
// 	protected AuthenticationManager getAuthenticationManager() {
		
// 		return this.authenticationManager;
// 	}
	
// 	@Override
// 	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
// 			Authentication auth) throws IOException, ServletException {
// 		String token = JWT.create().withSubject(((User) auth.getPrincipal()).getUsername())
// 				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
// 				.sign(HMAC512(SecurityConstants.SECRET.getBytes()));
// 		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
// 		super.successfulAuthentication(request, response, chain, auth);
// 	}

// }
