/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import javax.servlet.Filter;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */
/*    */ import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.config.annotation.web.builders.WebSecurity;
/*    */ import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*    */ import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
/*    */ import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
/*    */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*    */ import org.springframework.security.crypto.password.PasswordEncoder;
/*    */ import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*    */ 
/*    */ @Configuration
/*    */ public class WebSystemSecurityConfig extends WebSecurityConfigurerAdapter {
/*    */   @Autowired
/*    */   MyUserDetailservice mUserDetailsService;
/*    */   @Autowired
/*    */   LoginAuthenticationFilter loginAuthenticationFilter;
/*    */   @Autowired
/*    */ MyAccessDeniedHandler myAccessDeniedHandler;
/*    */   @Autowired
/*    */   FilterSecurityMetaDatasource filterSecurityMetaDatasource;
/*    */   @Autowired
/*    */ MyAccessDecisionManager myAccessDecisionManager;
/*    */   
/*    */   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/* 31 */     auth.userDetailsService(this.mUserDetailsService).passwordEncoder((PasswordEncoder)new BCryptPasswordEncoder());
/*    */   }
/*    */   
/*    */   protected void configure(HttpSecurity http) throws Exception {
/* 35 */     ((HttpSecurity)((FormLoginConfigurer)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http
/* 36 */       .authorizeRequests()
/* 37 */       .antMatchers(new String[] { "/**"
/* 38 */         })).permitAll()
/* 39 */       .anyRequest())
/* 40 */       .authenticated()
/* 41 */       .and())
/* 42 */       .formLogin()
/* 43 */       .loginPage("/login")
/* 44 */       .loginProcessingUrl("login-processing"))
/* 45 */       .and())
/* 46 */       .addFilterBefore((Filter)this.loginAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
/* 47 */       .csrf().disable();
/* 48 */     http.headers().frameOptions().sameOrigin();
/*    */   }
/*    */   
/*    */   public void configure(WebSecurity web) throws Exception {
/* 52 */     web.ignoring().antMatchers(new String[] { "/", "/index", "/login", "/login-processing", "/error" });
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\WebSystemSecurityConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */