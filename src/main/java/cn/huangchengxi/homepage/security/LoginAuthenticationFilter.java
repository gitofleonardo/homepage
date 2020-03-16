/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
/*    */ import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/*    */ import org.springframework.security.web.util.matcher.RequestMatcher;
/*    */ 
/*    */ public class LoginAuthenticationFilter
/*    */   extends AbstractAuthenticationProcessingFilter {
/*    */   public LoginAuthenticationFilter() {
/* 16 */     super((RequestMatcher)new AntPathRequestMatcher("/login-processing", "POST"));
/*    */   }
/*    */ 
/*    */   
/*    */   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
/* 21 */     String username = obtainUsername(request);
/* 22 */     String password = obtainPassword(request);
/* 23 */     UsernamePasswordAuthToken token = new UsernamePasswordAuthToken(username, password);
/* 24 */     return getAuthenticationManager().authenticate(token);
/*    */   }
/*    */   private String obtainUsername(HttpServletRequest request) {
/* 27 */     String username = request.getParameter("username");
/* 28 */     return (username == null) ? "" : username;
/*    */   }
/*    */   private String obtainPassword(HttpServletRequest request) {
/* 31 */     String password = request.getParameter("password");
/* 32 */     return (password == null) ? "" : password;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\LoginAuthenticationFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */