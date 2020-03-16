/*    */ package cn.huangchengxi.homepage.results;
/*    */ 
/*    */ public class LoginMessage {
/*    */   private boolean success;
/*    */   
/*    */   public LoginMessage(boolean success, String message) {
/*  7 */     this.success = success;
/*  8 */     this.message = message;
/*    */   } private String message;
/*    */   public String getMessage() {
/* 11 */     return this.message;
/*    */   }
/*    */   public void setMessage(String message) {
/* 14 */     this.message = message;
/*    */   }
/*    */   public void setSuccess(boolean success) {
/* 17 */     this.success = success;
/*    */   }
/*    */   public boolean isSuccess() {
/* 20 */     return this.success;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\results\LoginMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */