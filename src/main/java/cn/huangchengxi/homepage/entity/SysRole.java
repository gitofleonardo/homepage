/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ public class SysRole
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   
/*    */   public SysRole(Long id) {
/* 15 */     this.id = id;
/*    */   } private String name; public SysRole() {}
/*    */   public void setId(Long id) {
/* 18 */     this.id = id;
/*    */   }
/*    */   public void setName(String name) {
/* 21 */     this.name = name;
/*    */   }
/*    */   public Long getId() {
/* 24 */     return this.id;
/*    */   }
/*    */   public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\SysRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */