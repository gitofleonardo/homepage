/*    */ package cn.huangchengxi.homepage.entity;
/*    */ import com.fasterxml.jackson.annotation.JsonInclude;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ public class RecommendedBook {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   @JsonInclude
/*    */   private Long id;
/*    */   private String bookName;
/*    */   private String bookDescription;
/*    */   private String bookUrl;
/*    */   private String bookMessage;
/*    */   
/*    */   public RecommendedBook() {}
/*    */   
/*    */   public RecommendedBook(String bookName, String bookDescription, String bookUrl, String message) {
/* 21 */     this.bookName = bookName;
/* 22 */     this.bookDescription = bookDescription;
/* 23 */     this.bookUrl = bookUrl;
/* 24 */     this.bookMessage = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBookDescription(String bookDescription) {
/* 29 */     this.bookDescription = bookDescription;
/*    */   }
/*    */   public void setBookMessage(String bookMessage) {
/* 32 */     this.bookMessage = bookMessage;
/*    */   }
/*    */   public String getBookMessage() {
/* 35 */     return this.bookMessage;
/*    */   }
/*    */   public void setBookName(String bookName) {
/* 38 */     this.bookName = bookName;
/*    */   }
/*    */   public void setBookUrl(String bookUrl) {
/* 41 */     this.bookUrl = bookUrl;
/*    */   }
/*    */   public String getBookDescription() {
/* 44 */     return this.bookDescription;
/*    */   }
/*    */   public String getBookName() {
/* 47 */     return this.bookName;
/*    */   }
/*    */   public String getBookUrl() {
/* 50 */     return this.bookUrl;
/*    */   }
/*    */   public void setId(Long id) {
/* 53 */     this.id = id;
/*    */   }
/*    */   public Long getId() {
/* 56 */     return this.id;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\RecommendedBook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */