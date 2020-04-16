/*    */ package cn.huangchengxi.homepage.config;
/*    */ 
/*    */ import cn.huangchengxi.homepage.entity.Country;
/*    */ import cn.huangchengxi.homepage.entity.RecommendedBook;
/*    */ import cn.huangchengxi.homepage.entity.SharedExperience;
import cn.huangchengxi.homepage.entity.SharedExperienceType;
import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
/*    */ import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
/*    */ import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
/*    */ 
/*    */ @Configuration
/*    */ public class RestResConfig
/*    */   implements RepositoryRestConfigurer {
/*    */   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
/* 14 */     config.setRepositoryDetectionStrategy((RepositoryDetectionStrategy)RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
/* 15 */     config.exposeIdsFor(RecommendedBook.class,Country.class, SharedExperienceType.class, SharedExperience.class);
/* 16 */
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\config\RestResConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */