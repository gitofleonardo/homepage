/*    */ package cn.huangchengxi.homepage.security;
/*    */ 

/*    */ import cn.huangchengxi.homepage.repository.UserRepository;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ 
/*    */ public class MyUserDetailservice
/*    */   implements UserDetailsService {
/*    */   @Autowired
/*    */   UserRepository repository;
/*    */   
/*    */   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/* 17 */     System.out.println(username);
/* 18 */     cn.huangchengxi.homepage.entity.User user = this.repository.findByUsername(username);
/* 19 */     if (user == null) {
/* 20 */       throw new UsernameNotFoundException("用户ID不存在");
/*    */     }
/* 22 */     return (UserDetails)new User(user.getUsername(), user.getPassword(), user.getAuthorities());
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\security\MyUserDetailservice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */