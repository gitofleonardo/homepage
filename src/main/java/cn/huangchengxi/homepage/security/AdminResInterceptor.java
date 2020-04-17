/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ 
/*    */ @Component
/*    */ public class AdminResInterceptor
/*    */   implements HandlerInterceptor {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/* 14 */     System.out.println("enter admin interceptor");
/* 15 */     System.out.println("request url" + request.getRequestURI());
/* 16 */     System.out.println("rquest method" + request.getMethod());
/* 17 */     Collection<? extends GrantedAuthority> auths = (Collection<? extends GrantedAuthority>)request.getSession().getAttribute("auths");
/* 18 */     if (auths == null || !checkAuths(auths)) {
/* 19 */       response.setStatus(403);
/* 20 */       return false;
/*    */     } 
/* 22 */     return true;
/*    */   }
/*    */   private boolean checkAuths(Collection<? extends GrantedAuthority> authorities) {
/* 25 */     for (GrantedAuthority grantedAuthority : authorities) {
/* 26 */       if (grantedAuthority.getAuthority().equals("role_admin")) {
/* 27 */         return true;
/*    */       }
/*    */     } 
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\AdminResInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */