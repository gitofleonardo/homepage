/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.ForeignKey;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.OneToOne;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ public class UserProperties
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   private int gender;
/*    */   private String country;
/*    */   private Date birthday;
/*    */   
/*    */   public UserProperties(int gender, String country, Date birthday, String nickname) {
/* 23 */     this.birthday = birthday;
/* 24 */     this.country = country;
/* 25 */     this.gender = gender;
/* 26 */     this.nickname = nickname;
/*    */   } private String nickname; private String portraitUrl; private Long countryId; @OneToOne
/*    */   @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
/*    */   private User user; public UserProperties() {}
/*    */   public String getPortraitUrl() {
/* 31 */     return this.portraitUrl;
/*    */   }
/*    */   
/*    */   public Long getCountryId() {
/* 35 */     return this.countryId;
/*    */   }
/*    */   
/*    */   public void setCountryId(Long countryId) {
/* 39 */     this.countryId = countryId;
/*    */   }
/*    */   
/*    */   public void setPortraitUrl(String portraitUrl) {
/* 43 */     this.portraitUrl = portraitUrl;
/*    */   }
/*    */   
/*    */   public String getNickname() {
/* 47 */     return this.nickname;
/*    */   }
/*    */   
/*    */   public void setNickname(String nickname) {
/* 51 */     this.nickname = nickname;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 55 */     return this.id;
/*    */   }
/*    */   
/*    */   public Date getBirthday() {
/* 59 */     return this.birthday;
/*    */   }
/*    */   
/*    */   public int getGender() {
/* 63 */     return this.gender;
/*    */   }
/*    */   
/*    */   public String getCountry() {
/* 67 */     return this.country;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 71 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 75 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setBirthday(Date birthday) {
/* 79 */     this.birthday = birthday;
/*    */   }
/*    */   
/*    */   public void setCountry(String country) {
/* 83 */     this.country = country;
/*    */   }
/*    */   
/*    */   public void setGender(int gender) {
/* 87 */     this.gender = gender;
/*    */   }
/*    */   
/*    */   public void setUser(User user) {
/* 91 */     this.user = user;
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\UserProperties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */