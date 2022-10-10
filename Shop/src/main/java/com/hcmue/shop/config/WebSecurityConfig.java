package com.hcmue.shop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcmue.shop.services.TaiKhoanServices;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private AccountServicesImpl accountService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new TaiKhoanServices();
    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder  bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//all request
//		http.authorizeRequests().anyRequest().permitAll();
		
		//login
		http.authorizeRequests()
        .antMatchers("/admin/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin()
	        .loginPage("/login")
	        .permitAll()
	        .usernameParameter("TaiKhoan")
	        .passwordParameter("MatKhau")
	        .failureUrl("/login_error")
	        .defaultSuccessUrl("/")
        .and()
        .logout()
        	.logoutSuccessUrl("/").permitAll();
		
//		http.authorizeRequests()
//			.antMatchers("/","/home").access("hasRole('USER')")
//			.antMatchers("/admin/**").access("hasRole('ADMIN')")
//			.and().formLogin()
//							.usernameParameter("username")
//							.defaultSuccessUrl("/admin")
//							.permitAll()
//			.and()
//				.logout().logoutSuccessUrl("/").permitAll()
//			.and()
//			.csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
			
		
//		http.authorizeHttpRequests()
//			.antMatchers("/admin").hasAuthority("ADMIN")
//			.anyRequest().permitAll()
//			.and()
//			.formLogin()
//				.usernameParameter("username")
//				.defaultSuccessUrl("/")
//				.permitAll()
//			.and()
//			.logout().logoutSuccessUrl("/home").permitAll();
		
			
//		http.csrf().disable();

		// Các trang không yêu cầu login
//		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.
//		http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

//		// Trang chỉ dành cho ADMIN
//		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
//		// Khi người dùng đã login, với vai trò XX.
//		// Nhưng truy cập vào trang yêu cầu vai trò YY,
//		// Ngoại lệ AccessDeniedException sẽ ném ra.
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

//		// Cấu hình cho Login Form.
//		http.authorizeRequests().and().formLogin()//
//				// Submit URL của trang login
//				.loginProcessingUrl("/j_spring_security_check") // Submit URL
//				.loginPage("/login")//
//				.defaultSuccessUrl("/userAccountInfo")//
//				.failureUrl("/login?error=true")//
//				.usernameParameter("username")//
//				.passwordParameter("password")
//				// Cấu hình cho Logout Page.
//				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

//		// Cấu hình Remember Me.
//		http.authorizeRequests().and() //
//				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
//				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//		db.setDataSource(dataSource);
//		return db;
//	}
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
