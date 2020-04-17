/*    */ package cn.huangchengxi.homepage.config;
/*    */ 
/*    */ import cn.huangchengxi.homepage.security.AdminResInterceptor;
/*    */ import cn.huangchengxi.homepage.security.LoginResInterceptor;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ 
/*    */ @Configuration
/*    */ public class WebMvcConfig
/*    */   implements WebMvcConfigurer {
/*    */   @Autowired
/*    */   AdminResInterceptor adminResInterceptor;
/*    */   
/*    */   public void addViewControllers(ViewControllerRegistry registry) {
/* 20 */     registry.addViewController("/dengyanqing").setViewName("/dengyanqing/index");
/* 21 */     registry.addViewController("/xujinhua").setViewName("/xujinhua/index");
/* 22 */     registry.addViewController("/bookManage/postBook").setViewName("postBook");
/* 23 */     registry.addViewController("/bookManage").setViewName("manageBook");
/*    */   } @Autowired
/*    */   LoginResInterceptor loginResInterceptor;
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry) {
/* 27 */     registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
/* 28 */     registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/templates/pages/");
/* 29 */     registry.addResourceHandler("/xujinhua/**").addResourceLocations("classpath:/templates/xujinhua/");
/* 30 */     registry.addResourceHandler("/dengyanqing/**").addResourceLocations("classpath:/templates/dengyanqing/");
/* 31 */     registry.addResourceHandler("/imageResource/**").addResourceLocations("file:C:/server-images-protected/");
/* 32 */     registry.addResourceHandler("/img/**").addResourceLocations("file:C:/server-images/");
/*    */   }
/*    */ 
/*    */   
/*    */   public void addInterceptors(InterceptorRegistry registry) {
/* 37 */     registry.addInterceptor((HandlerInterceptor)this.adminResInterceptor).addPathPatterns("/imageResource/**", "/bookManage/**", "/bookManage","/modification","/modification/**","/postNote","/publication","/avatar");
/* 38 */     registry.addInterceptor((HandlerInterceptor)this.loginResInterceptor).addPathPatterns("/center", "/infos", "/modifyinfos", "/modifyinfos-processing");
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\config\WebMvcConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */