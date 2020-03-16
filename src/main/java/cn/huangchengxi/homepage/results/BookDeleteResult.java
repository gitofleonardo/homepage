/*    */ package cn.huangchengxi.homepage.results;
/*    */ 
/*    */ public class BookDeleteResult {
/*    */   private Boolean success;
/*    */   private String message;
/*    */   
/*    */   public BookDeleteResult(Boolean success, String message) {
/*  8 */     this.success = success;
/*  9 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 13 */     return this.message;
/*    */   }
/*    */   
/*    */   public Boolean getSuccess() {
/* 17 */     return this.success;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 21 */     this.message = message;
/*    */   }
/*    */   
/*    */   public void setSuccess(Boolean success) {
/* 25 */     this.success = success;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\results\BookDeleteResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */