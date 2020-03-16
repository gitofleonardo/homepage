/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.util.Collection;
/*    */
/*    */ import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
/*    */ import org.springframework.security.access.ConfigAttribute;
/*    */ import org.springframework.security.authentication.InsufficientAuthenticationException;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyAccessDecisionManager
/*    */   implements AccessDecisionManager
/*    */ {
/*    */   public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
/* 17 */     for (ConfigAttribute attr : configAttributes) {
/* 18 */       System.out.println("Enter auth");
/* 19 */       System.out.println("Now auth:" + attr.getAttribute());
/* 20 */       boolean hasAuth = false;
/* 21 */       System.out.println("total auths:" + authentication.getAuthorities().size());
/* 22 */       for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
/* 23 */         System.out.println(grantedAuthority.getAuthority());
/* 24 */         if (grantedAuthority.getAuthority().equals(attr.getAttribute())) {
/* 25 */           System.out.println("hasAuth");
/* 26 */           hasAuth = true;
/*    */         } 
/*    */       } 
/* 29 */       if (!hasAuth) {
/* 30 */         throw new AccessDeniedException("权限不足");
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean supports(ConfigAttribute attribute) {
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean supports(Class<?> clazz) {
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\AccessDecisionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */