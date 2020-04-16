/*    */ package cn.huangchengxi.homepage.entity;
/*    */ 
/*    */ import cn.huangchengxi.homepage.repository.ExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
/*    */
/*    */
import java.util.List;

/*    */
/*    */ @Entity
/*    */ public class SharedExperienceType
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue
/*    */   private Long id;
/*    */   private Long createTime;
/*    */   private String name;
private String logoUrl;
@OneToMany(mappedBy = "sharedExperienceType",cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
private List<SharedExperience> experiences;
/*    */   public SharedExperienceType(Long createTime, String name) {
/* 17 */     this.createTime = createTime;
/* 18 */     this.name = name;
//experiences=repository.findAllById(id);
/*    */   }
/*    */   public SharedExperienceType() {}
/*    */   public Long getId() {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 26 */     return this.name;
/*    */   }
/*    */   
/*    */   public Long getCreateTime() {
/* 30 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 38 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Long createTime) {
/* 42 */     this.createTime = createTime;
/*    */   }

    public List<SharedExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<SharedExperience> experiences) {
        this.experiences = experiences;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    /*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\entity\SharedExperienceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */