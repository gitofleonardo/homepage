/*    */ package cn.huangchengxi.homepage.config;
/*    */ import cn.huangchengxi.homepage.security.*;
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
import java.util.List;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
/*    */ import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/*    */
/*    */ @Configuration
/*    */ public class BeanConfig {
/*    */   @Bean
/*    */   public LoginAuthenticationFilter loginAuthenticationFilter(@Autowired ProviderManager providerManager, @Autowired LoginSuccessHandler loginSuccessHandler, @Autowired LoginFailureHandler loginFailureHandler) {
/* 20 */     LoginAuthenticationFilter filter = new LoginAuthenticationFilter();
/* 21 */     filter.setAuthenticationManager((AuthenticationManager)providerManager);
/* 22 */     filter.setAuthenticationSuccessHandler((AuthenticationSuccessHandler)loginSuccessHandler);
/* 23 */     filter.setAuthenticationFailureHandler((AuthenticationFailureHandler)loginFailureHandler);
/* 24 */     return filter;
/*    */   }
/*    */   @Bean
/*    */   public ProviderManager providerManager(@Autowired UsernamePasswordProvider myUsernamePasswordProvider) {
/* 28 */     ProviderManager manager = new ProviderManager(Arrays.asList(new AuthenticationProvider[] { (AuthenticationProvider)myUsernamePasswordProvider }));
/* 29 */     return manager;
/*    */   }
/*    */   @Bean
/*    */   public LoginSuccessHandler loginSuccessHandler() {
/* 33 */     return new LoginSuccessHandler();
/*    */   }
/*    */   @Bean
/*    */   public LoginFailureHandler loginFailureHandler() {
/* 37 */     return new LoginFailureHandler();
/*    */   }
/*    */   @Bean
/*    */   public UsernamePasswordProvider myUsernamePasswordProvider() {
/* 41 */     return new UsernamePasswordProvider();
/*    */   }
/*    */   @Bean
/*    */   public MyUserDetailservice mUserDetailsService() {
/* 45 */     return new MyUserDetailservice();
/*    */   }
/*    */   @Bean
/*    */   public FilterSecurityMetaDatasource filterSecurityMetaDatasource(@Autowired List<String> antPathMat, @Autowired List<String> neededAuth) {
/* 49 */     return new FilterSecurityMetaDatasource(neededAuth, antPathMat);
/*    */   }
/*    */   @Bean
/*    */   public MyAccessDecisionManager accessDecisionManager() {
/* 53 */     return new MyAccessDecisionManager();
/*    */   }
/*    */   @Bean
/*    */   public MyAccessDeniedHandler accessDeniedHandler() {
/* 57 */     return new MyAccessDeniedHandler();
/*    */   }
/*    */   @Bean
/*    */   public List<String> antPathMat() {
/* 61 */     List<String> list = new ArrayList<>();
/* 62 */     list.add("/images");
/* 63 */     return list;
/*    */   }
/*    */   @Bean
/*    */   public List<String> neededAuth() {
/* 67 */     List<String> list = new ArrayList<>();
/* 68 */     list.add("role_admin");
/* 69 */     return list;
/*    */   }
/*    */   @Bean
/*    */   public AdminResInterceptor imageResInterceptor() {
/* 73 */     return new AdminResInterceptor();
/*    */   }
/*    */   @Bean
/*    */   public ObjectMapper objectMapper() {
/* 77 */     return new ObjectMapper();
/*    */   }
@Bean
    public SecurityFireWall firewall(){
    SecurityFireWall fireWall=new SecurityFireWall();
    fireWall.setThisAllowUrlEncodeDoubleSlash(true);
    return fireWall;
}
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\config\BeanConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */