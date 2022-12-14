package com.hcmue.shop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
        
        // account admin/admin2022
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin")
     				.password("$2a$10$durSlu.dBqqMs1xMSE2Nn.09vcLBPYbD6/Q8OWScmkOMhh1sRX30q").roles("ADMIN");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//all request
//		http.authorizeRequests().anyRequest().permitAll();
		
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')");
		
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
		
		http.authorizeRequests().antMatchers("/static/**").permitAll();
		
		//Admin
		http.authorizeRequests()
    	.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.usernameParameter("TaiKhoan")
			.passwordParameter("MatKhau")
			.failureUrl("/login_error")
	        .defaultSuccessUrl("/processHome")
    	.permitAll()
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

		// C??c trang kh??ng y??u c???u login
//		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		// Trang /userInfo y??u c???u ph???i login v???i vai tr?? ROLE_USER ho???c ROLE_ADMIN.
		// N???u ch??a login, n?? s??? redirect t???i trang /login.
//		http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

//		// Trang ch??? d??nh cho ADMIN
//		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
//		// Khi ng?????i d??ng ???? login, v???i vai tr?? XX.
//		// Nh??ng truy c???p v??o trang y??u c???u vai tr?? YY,
//		// Ngo???i l??? AccessDeniedException s??? n??m ra.
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

//		// C???u h??nh cho Login Form.
//		http.authorizeRequests().and().formLogin()//
//				// Submit URL c???a trang login
//				.loginProcessingUrl("/j_spring_security_check") // Submit URL
//				.loginPage("/login")//
//				.defaultSuccessUrl("/userAccountInfo")//
//				.failureUrl("/login?error=true")//
//				.usernameParameter("username")//
//				.passwordParameter("password")
//				// C???u h??nh cho Logout Page.
//				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

//		// C???u h??nh Remember Me.
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
