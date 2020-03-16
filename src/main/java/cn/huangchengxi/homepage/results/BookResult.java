/*    */ package cn.huangchengxi.homepage.results;
/*    */ 
/*    */ public class BookResult {
/*    */   private boolean success;
/*    */   private String bookName;
/*    */   private Long id;
/*    */   private String bookDescription;
/*    */   private String message;
/*    */   private String bookUrl;
/*    */   
/*    */   public BookResult(boolean success, Long id, String bookName, String bookDescription, String bookUrl, String message) {
/* 12 */     this.success = success;
/* 13 */     this.bookDescription = bookDescription;
/* 14 */     this.bookName = bookName;
/* 15 */     this.id = id;
/* 16 */     this.message = message;
/* 17 */     this.bookUrl = bookUrl;
/*    */   }
/*    */   public BookResult(boolean success) {
/* 20 */     this.success = success;
/*    */   }
/*    */   
/*    */   public String getBookDescription() {
/* 24 */     return this.bookDescription;
/*    */   } public BookResult() {}
/*    */   public String getBookUrl() {
/* 27 */     return this.bookUrl;
/*    */   }
/*    */   public void setBookUrl(String bookUrl) {
/* 30 */     this.bookUrl = bookUrl;
/*    */   }
/*    */   public void setMessage(String message) {
/* 33 */     this.message = message;
/*    */   }
/*    */   public String getMessage() {
/* 36 */     return this.message;
/*    */   }
/*    */   public String getBookName() {
/* 39 */     return this.bookName;
/*    */   }
/*    */   public Long getId() {
/* 42 */     return this.id;
/*    */   }
/*    */   public boolean isSuccess() {
/* 45 */     return this.success;
/*    */   }
/*    */   public void setBookDescription(String bookDescription) {
/* 48 */     this.bookDescription = bookDescription;
/*    */   }
/*    */   public void setBookName(String bookName) {
/* 51 */     this.bookName = bookName;
/*    */   }
/*    */   public void setId(Long id) {
/* 54 */     this.id = id;
/*    */   }
/*    */   public void setSuccess(boolean success) {
/* 57 */     this.success = success;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\results\BookResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */