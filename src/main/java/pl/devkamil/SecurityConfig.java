package pl.devkamil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {



		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer=
				auth.inMemoryAuthentication();
		
		authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer
				.withUser("devkamil")
				.password("password")
				.roles("USER", "ADMIN");
		
		authenticationManagerBuilderInMemoryUserDetailsManagerConfigurer
				.withUser("kamildev")
				.password("password")
				.roles("USER", "ADMIN");
	
		
//		auth.inMemoryAuthentication()
//		.withUser("devkamil")
//		.password("password")
//		.roles("USER", "ADMIN");
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/loggeduser").authenticated()
				.and().formLogin();
	}

}
