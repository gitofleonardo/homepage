/*    */ package cn.huangchengxi.homepage.controller;
/*    */ 
/*    */ import cn.huangchengxi.homepage.repository.ImageRepository;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class ResourceController
/*    */ {
/*    */   @Autowired
/*    */   private ImageRepository imageRepository;
/*    */   
/*    */   @RequestMapping({"/getImageResource"})
/*    */   @ResponseBody
/*    */   public String getImageResource(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 21 */     response.sendRedirect("/images");
/* 22 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\controller\ResourceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */