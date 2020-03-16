/*    */ package cn.huangchengxi.homepage.results;
/*    */ 
/*    */ import cn.huangchengxi.homepage.entity.Image;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ImageRequestResult
/*    */ {
/*    */   private boolean success;
/*    */   private String message;
/*    */   private List<Image> images;
/*    */   
/*    */   public ImageRequestResult(boolean success, String message, List<Image> images) {
/* 13 */     this.success = success;
/* 14 */     this.message = message;
/* 15 */     this.images = images;
/*    */   }
/*    */   public List<Image> getImages() {
/* 18 */     return this.images;
/*    */   }
/*    */   public String getMessage() {
/* 21 */     return this.message;
/*    */   }
/*    */   public boolean isSuccess() {
/* 24 */     return this.success;
/*    */   }
/*    */   public void setImages(List<Image> images) {
/* 27 */     this.images = images;
/*    */   }
/*    */   public void setMessage(String message) {
/* 30 */     this.message = message;
/*    */   }
/*    */   public void setSuccess(boolean success) {
/* 33 */     this.success = success;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\results\ImageRequestResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */