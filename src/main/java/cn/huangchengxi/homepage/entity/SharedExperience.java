/*    */ package cn.huangchengxi.homepage.entity;
/*    */ import javax.persistence.*;
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ @Entity
/*    */ public class SharedExperience {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private String id;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "fk_type_exp"))
/*    */   private SharedExperienceType sharedExperienceType;
/*    */   
/*    */   public SharedExperience(SharedExperienceType type, String title, String content) {
/* 18 */     this.sharedExperienceType = type;
/* 19 */     this.title = title;
/* 20 */     this.content = content;
/*    */   } private String title; private String content;
/*    */   public SharedExperience() {}
/*    */   public String getId() {
/* 24 */     return this.id;
/*    */   }
/*    */   
/*    */   public SharedExperienceType getSharedExperienceType() {
/* 28 */     return this.sharedExperienceType;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 32 */     return this.content;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 36 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 44 */     this.content = content;
/*    */   }
/*    */   
/*    */   public void setSharedExperienceType(SharedExperienceType sharedExperienceType) {
/* 48 */     this.sharedExperienceType = sharedExperienceType;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 52 */     this.title = title;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\SharedExperience.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */