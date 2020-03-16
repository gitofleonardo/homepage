/*    */ package cn.huangchengxi.homepage.security;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.authentication.AuthenticationProvider;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.AuthenticationException;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class UsernamePasswordProvider
/*    */   implements AuthenticationProvider
/*    */ {
/*    */   @Autowired
/*    */   MyUserDetailservice mUserDetailsService;
/*    */   
/*    */   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
/* 20 */     UserDetails user = this.mUserDetailsService.loadUserByUsername((String)authentication.getPrincipal());
/* 21 */     String password = (String)authentication.getCredentials();
/* 22 */     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
/* 23 */     if (!encoder.matches(password, user.getPassword())) {
/* 24 */       throw new UsernameNotFoundException("密码不正确");
/*    */     }
/* 26 */     UsernamePasswordAuthToken token = new UsernamePasswordAuthToken(user.getUsername(), user.getPassword(), user.getAuthorities());
/* 27 */     token.setAuthenticated(true);
/* 28 */     return token;
/*    */   }
/*    */   
/*    */   public boolean supports(Class<?> authentication) {
/* 32 */     if (authentication == UsernamePasswordAuthToken.class) {
/* 33 */       return true;
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\UsernamePasswordProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */