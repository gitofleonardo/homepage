/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.security.web.authentication.AuthenticationFailureHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginFailureHandler
/*    */   implements AuthenticationFailureHandler
/*    */ {
/*    */   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
/* 17 */     response.sendRedirect("/");
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\LoginFailureHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */