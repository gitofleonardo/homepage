/*    */ package cn.huangchengxi.homepage.controller;
/*    */ 
/*    */ import cn.huangchengxi.homepage.entity.*;
/*    */
/*    */
/*    */
/*    */
/*    */ import cn.huangchengxi.homepage.repository.*;
/*    */
/*    */
/*    */
/*    */ import cn.huangchengxi.homepage.results.LoginMessage;
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class LoginController {
/*    */   @Autowired
/*    */   UserRepository repository;
/*    */   @Autowired
/*    */   CodeRepository codeRepository;
/*    */   @Autowired
/*    */   RecommendedBookRepository bookRepository;
/*    */   @Autowired
/*    */   UserPropertiesRepository userPropertiesRepository;
           @Autowired
            ExpTypeRepository expTypeRepository;
           @Autowired
           ExpRepository expRepository;
/*    */   
/*    */   @RequestMapping({"/index"})
/*    */   public String index(Model model, HttpSession session) {
/* 41 */     List<RecommendedBook> books = this.bookRepository.findAll();
                List<SharedExperienceType> types=expTypeRepository.findAll();
                List<SharedExperience> exps=expRepository.findAll();
/* 42 */     if (session.getAttribute("isLogin") == null) {
/* 43 */       model.addAttribute("login", Boolean.FALSE);
/*    */     } else {
/* 45 */       model.addAttribute("login", Boolean.TRUE);
/*    */     }
                model.addAttribute("exps",exps);
            model.addAttribute("types",types);
/* 47 */     model.addAttribute("books", books);
/* 48 */     return "index";
/*    */   }
/*    */   @RequestMapping({"/"})
/*    */   public String i(Model model, HttpSession session) {
/* 52 */     return index(model, session);
/*    */   }
/*    */   @RequestMapping({"/login"})
/*    */   public String login(Model model, HttpSession session) {
/* 56 */     return "login";
/*    */   }
/*    */   @RequestMapping({"/signon"})
/*    */   public String signon(Model model) {
/* 60 */     return "signon";
/*    */   }
/*    */   @RequestMapping({"/loginProcessing"})
/*    */   public String doLogin() {
/* 64 */     return "fuck you spring";
/*    */   }
/*    */   @RequestMapping({"/doSignOn"})
/*    */   @ResponseBody
/*    */   @Transactional
/*    */   public String doSignOn(@RequestBody String data) throws Exception {
/*    */     try {
/* 71 */       System.out.println(data);
/* 72 */       JSONObject object = JSON.parseObject(data);
/* 73 */       String email = object.getString("email");
/* 74 */       String password = object.getString("password");
/* 75 */       String validate = object.getString("validate");
/* 76 */       ValidateCode code = this.codeRepository.findByCode(validate);
/* 77 */       if (code == null) {
/* 78 */         ObjectMapper objectMapper = new ObjectMapper();
/* 79 */         return objectMapper.writeValueAsString(new LoginMessage(false, "验证码错误"));
/*    */       } 
/* 81 */       User user = this.repository.findByUsername(email);
/* 82 */       if (user != null) {
/* 83 */         ObjectMapper objectMapper = new ObjectMapper();
/* 84 */         return objectMapper.writeValueAsString(new LoginMessage(false, "账号已经注册"));
/*    */       } 
/*    */       
/* 87 */       user = new User((new BCryptPasswordEncoder()).encode(password), email);
/* 88 */       user.setRoles(Arrays.asList(new SysRole[] { new SysRole(Long.valueOf(1L)) }));
/* 89 */       UserProperties userProperties = new UserProperties(0, "暂未设置", null, null);
/* 90 */       userProperties.setUser(user);
/* 91 */       this.repository.save(user);
/* 92 */       this.userPropertiesRepository.save(userProperties);
/* 93 */       ObjectMapper mapper = new ObjectMapper();
/* 94 */       return mapper.writeValueAsString(new LoginMessage(true, "注册成功"));
/* 95 */     } catch (Exception e) {
/* 96 */       e.printStackTrace();
/* 97 */       ObjectMapper mapper = new ObjectMapper();
/* 98 */       return mapper.writeValueAsString(new LoginMessage(false, "未知数据"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\controller\LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */