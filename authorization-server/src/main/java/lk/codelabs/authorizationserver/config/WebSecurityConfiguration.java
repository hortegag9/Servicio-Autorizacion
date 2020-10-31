package lk.codelabs.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	protected AuthenticationManager getAuthenticationManager() throws Exception{
		System.out.println("---> AuthenticationManager getAuthenticationManager(): "+authenticationManagerBean());
		return super.authenticationManagerBean();		
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() throws Exception{
		System.out.println("---> PasswordEncoder passwordEncoder(): "+PasswordEncoderFactories.createDelegatingPasswordEncoder());
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("---> configure(AuthenticationManagerBuilder auth)"+auth);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	

}
