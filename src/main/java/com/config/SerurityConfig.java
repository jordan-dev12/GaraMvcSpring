package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.AuthTokenFilter;

@Configuration
@EnableWebSecurity
public class SerurityConfig extends WebSecurityConfigurerAdapter {
	
	    @Autowired
	    private UserDetailsService userDetailsService;
	    

	    @Override
	    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    	 authenticationManagerBuilder
             .userDetailsService(this.userDetailsService)
             .passwordEncoder(passwordEncoder());
	    }
	    
	    @Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
	    

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
		public AuthTokenFilter authenticationJwtTokenFilter() {
			return new AuthTokenFilter();
		}

        @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity
	        
	                 // we don't need CSRF because our token is invulnerable
	                .csrf().disable()
	                
	                // don't create session
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	                .cors().and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET,"/","/registra")
	                .permitAll()
	                .antMatchers(HttpMethod.POST, "/part/add","/login")
	                .permitAll()
	                .anyRequest().authenticated();
	        httpSecurity
	          .formLogin()  // se l'utente non è authentificato redirecta su questa pagina
	          .loginPage("/");
	        
	        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }

		

}
