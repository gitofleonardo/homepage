/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import org.springframework.security.access.ConfigAttribute;
/*    */ import org.springframework.security.access.SecurityConfig;
/*    */ import org.springframework.security.web.FilterInvocation;
/*    */ import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/*    */ import org.springframework.util.AntPathMatcher;
/*    */ 
/*    */ public class FilterSecurityMetaDatasource
/*    */   implements FilterInvocationSecurityMetadataSource
/*    */ {
/* 14 */   private AntPathMatcher antPathMatcher = new AntPathMatcher();
/*    */   private List<String> auths;
/*    */   private List<String> ant;
/*    */   
/*    */   public FilterSecurityMetaDatasource(List<String> auths, List<String> antMatcherPath) {
/* 19 */     this.auths = auths;
/* 20 */     this.ant = antMatcherPath;
/*    */   }
/*    */ 
/*    */   
/*    */   public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
/* 25 */     String url = ((FilterInvocation)object).getRequestUrl();
/* 26 */     for (String path : this.ant) {
/*    */       
/* 28 */       if (this.antPathMatcher.match(path, url)) {
/* 29 */         List<String> authNeeded = this.auths;
/* 30 */         String[] values = new String[authNeeded.size()];
/* 31 */         for (int i = 0; i < authNeeded.size(); i++) {
/* 32 */           values[i] = authNeeded.get(i);
/*    */         }
/* 34 */         return SecurityConfig.createList(values);
/*    */       } 
/*    */     } 
/* 37 */     return SecurityConfig.createList(new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public Collection<ConfigAttribute> getAllConfigAttributes() {
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean supports(Class<?> clazz) {
/* 47 */     return FilterInvocation.class.isAssignableFrom(clazz);
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\FilterSecurityMetaDatasource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */