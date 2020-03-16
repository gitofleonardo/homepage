/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ 
/*    */ public class UsernamePasswordAuthToken
/*    */   implements Authentication
/*    */ {
/*    */   private String username;
/*    */   private String password;
/*    */   private Collection<? extends GrantedAuthority> authorities;
/*    */   private Object details;
/* 14 */   private Boolean authenticated = Boolean.valueOf(false);
/*    */   
/*    */   public UsernamePasswordAuthToken(String principal, String credentials, Collection<? extends GrantedAuthority> auths) {
/* 17 */     this.username = principal;
/* 18 */     this.password = credentials;
/* 19 */     this.authorities = auths;
/*    */   }
/*    */   public UsernamePasswordAuthToken(String principal, String credentials) {
/* 22 */     this.username = principal;
/* 23 */     this.password = credentials;
/*    */   }
/*    */   
/*    */   public UsernamePasswordAuthToken() {}
/*    */   
/*    */   public Collection<? extends GrantedAuthority> getAuthorities() {
/* 29 */     return this.authorities;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCredentials() {
/* 34 */     return this.password;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getDetails() {
/* 39 */     return this.details;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getPrincipal() {
/* 44 */     return this.username;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAuthenticated() {
/* 49 */     return this.authenticated.booleanValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
/* 54 */     this.authenticated = Boolean.valueOf(isAuthenticated);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 59 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\UsernamePasswordAuthToken.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */