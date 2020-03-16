/*    */ package cn.huangchengxi.homepage.entity;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*    */
/*    */ @Entity
/*    */ public class Image {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   private String url;
/*    */   private String description;
/*    */   private Long time;
/*    */   
/*    */   public Image() {}
/*    */   
/*    */   public Image(String url, String description, Long time) {
/* 17 */     this.url = url;
/* 18 */     this.description = description;
/* 19 */     this.time = time;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 23 */     return this.description;
/*    */   }
/*    */   public Long getId() {
/* 26 */     return this.id;
/*    */   }
/*    */   public Long getTime() {
/* 29 */     return this.time;
/*    */   }
/*    */   public String getUrl() {
/* 32 */     return this.url;
/*    */   }
/*    */   public void setDescription(String description) {
/* 35 */     this.description = description;
/*    */   }
/*    */   public void setId(Long id) {
/* 38 */     this.id = id;
/*    */   }
/*    */   public void setTime(Long time) {
/* 41 */     this.time = time;
/*    */   }
/*    */   public void setUrl(String url) {
/* 44 */     this.url = url;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\Image.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */