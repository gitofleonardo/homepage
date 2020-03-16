/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
/*    */

/*    */
/*    */ public class MyAccessDeniedHandler implements AccessDeniedHandler
        /*    */ {
/*    */   public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
/* 13 */     response.setStatus(403);
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\AccessDeniedHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */