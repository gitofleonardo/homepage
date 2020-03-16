/*    */ package cn.huangchengxi.homepage.entity;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ public class ValidateCode {
/*    */   @Id
/*    */   private String code;
/*    */   
/*    */   public ValidateCode(String code) {
/* 11 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 15 */     return this.code;
/*    */   } public ValidateCode() {}
/*    */   public void setCode(String code) {
/* 18 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\ValidateCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */