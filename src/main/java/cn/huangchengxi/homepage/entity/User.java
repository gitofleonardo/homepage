/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import javax.persistence.CascadeType;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.ManyToMany;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class User
/*    */   implements UserDetails, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long uid;
/*    */   private String username;
/*    */   private String password;
/*    */   @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
/*    */   private List<SysRole> roles;
/*    */   
/*    */   public User() {}
/*    */   
/*    */   public User(String password, String email) {
/* 37 */     this.username = email;
/* 38 */     this.password = password;
/*    */   }
/*    */   public String getPassword() {
/* 41 */     return this.password;
/*    */   }
/*    */   public Long getUid() {
/* 44 */     return this.uid;
/*    */   }
/*    */   public void setPassword(String password) {
/* 47 */     this.password = password;
/*    */   }
/*    */   public void setUid(Long uid) {
/* 50 */     this.uid = uid;
/*    */   }
/*    */   
/*    */   public Collection<? extends GrantedAuthority> getAuthorities() {
/* 54 */     List<GrantedAuthority> auths = new ArrayList<>();
/* 55 */     List<SysRole> roles = getRoles();
/* 56 */     for (SysRole role : roles) {
/* 57 */       auths.add(new SimpleGrantedAuthority(role.getName()));
/*    */     }
/* 59 */     System.out.println("sizeofauth" + auths.size());
/* 60 */     for (GrantedAuthority auth : auths) {
/* 61 */       System.out.println(auth.getAuthority());
/*    */     }
/* 63 */     return auths;
/*    */   }
/*    */   public List<SysRole> getRoles() {
/* 66 */     return this.roles;
/*    */   }
/*    */   
/*    */   public void setRoles(List<SysRole> roles) {
/* 70 */     this.roles = roles;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 76 */     return this.username;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAccountNonExpired() {
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAccountNonLocked() {
/* 86 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCredentialsNonExpired() {
/* 91 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */