package com.miTrabajo.mt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	   @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	            .ignoring()
	            .antMatchers("/h2-console/**");
	    }
	
	
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		
			.withUser("ztonaz")
				.password("1234")
					.roles("USER")
					
			.and()
			.withUser("laura")
				.password("123")
					.roles("USER")
			.and()
			.withUser("admin")
				.password("1234")
					.roles("ADMIN")
					
			
		;
	}
	
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	
}
