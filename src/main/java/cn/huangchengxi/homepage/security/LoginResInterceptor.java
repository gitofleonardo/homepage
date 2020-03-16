/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ 
/*    */ @Configuration
/*    */ public class LoginResInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/* 13 */     Boolean isLogin = (Boolean)request.getSession().getAttribute("isLogin");
/* 14 */     if (isLogin == null || !isLogin.booleanValue()) {
/* 15 */       response.sendRedirect("/login");
/* 16 */       return false;
/*    */     } 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\LoginResInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */