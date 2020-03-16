/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class SharedExperienceType
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   private Long createTime;
/*    */   
/*    */   public SharedExperienceType(Long createTime, String name) {
/* 17 */     this.createTime = createTime;
/* 18 */     this.name = name;
/*    */   } private String name;
/*    */   public SharedExperienceType() {}
/*    */   public Long getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public Long getCreateTime() {
/* 30 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 38 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Long createTime) {
/* 42 */     this.createTime = createTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\SharedExperienceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */