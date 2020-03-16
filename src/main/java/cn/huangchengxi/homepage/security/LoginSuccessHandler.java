/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginSuccessHandler
/*    */   implements AuthenticationSuccessHandler
/*    */ {
/*    */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
/* 18 */     request.getSession().setAttribute("isLogin", authentication.isAuthenticated());
/* 19 */     request.getSession().setAttribute("username", authentication.getPrincipal());
/* 20 */     request.getSession().setAttribute("auths", authentication.getAuthorities());
/* 21 */     response.sendRedirect("/");
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\LoginSuccessHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */