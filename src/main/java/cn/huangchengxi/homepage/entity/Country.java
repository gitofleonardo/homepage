/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ 
/*    */ @Entity
/*    */ public class Country {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   private Integer contentId;
/*    */   private String code;
/*    */   private String name;
/*    */   private String fullName;
/*    */   private String cname;
/*    */   private String fullCname;
/*    */   private String lowerName;
/*    */   private String remark;
/*    */   
/*    */   public Long getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 30 */     return this.code;
/*    */   }
/*    */   
/*    */   public Integer getContentId() {
/* 34 */     return this.contentId;
/*    */   }
/*    */   
/*    */   public String getFullName() {
/* 38 */     return this.fullName;
/*    */   }
/*    */   
/*    */   public String getCname() {
/* 42 */     return this.cname;
/*    */   }
/*    */   
/*    */   public String getFullCname() {
/* 46 */     return this.fullCname;
/*    */   }
/*    */   
/*    */   public String getLowerName() {
/* 50 */     return this.lowerName;
/*    */   }
/*    */   
/*    */   public String getRemark() {
/* 54 */     return this.remark;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 58 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setContentId(Integer contentId) {
/* 62 */     this.contentId = contentId;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 66 */     this.code = code;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 70 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setFullName(String fullName) {
/* 74 */     this.fullName = fullName;
/*    */   }
/*    */   
/*    */   public void setCname(String cname) {
/* 78 */     this.cname = cname;
/*    */   }
/*    */   
/*    */   public void setFullCname(String fullCname) {
/* 82 */     this.fullCname = fullCname;
/*    */   }
/*    */   
/*    */   public void setLowerName(String lowerName) {
/* 86 */     this.lowerName = lowerName;
/*    */   }
/*    */   
/*    */   public void setRemark(String remark) {
/* 90 */     this.remark = remark;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\Country.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */