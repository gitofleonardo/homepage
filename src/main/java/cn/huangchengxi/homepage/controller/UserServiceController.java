/*     */ package cn.huangchengxi.homepage.controller;
/*     */ 
/*     */ import cn.huangchengxi.homepage.entity.Country;
/*     */ import cn.huangchengxi.homepage.entity.User;
/*     */ import cn.huangchengxi.homepage.entity.UserProperties;
/*     */ import cn.huangchengxi.homepage.repository.CountryRepository;
/*     */ import cn.huangchengxi.homepage.repository.UserPropertiesRepository;
/*     */ import cn.huangchengxi.homepage.repository.UserRepository;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.transaction.Transactional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class UserServiceController
/*     */ {
/*     */   @Autowired
/*     */   UserRepository userRepository;
/*     */   @Autowired
/*     */   UserPropertiesRepository userPropertiesRepository;
/*     */   @Autowired
/*     */   CountryRepository countryRepository;
/*     */   
/*     */   @RequestMapping({"/center"})
/*     */   public String center(Model model, HttpSession session) throws Exception {
/*  34 */     String username = (String)session.getAttribute("username");
/*  35 */     User user = this.userRepository.findByUsername(username);
/*  36 */     UserProperties properties = this.userPropertiesRepository.findByUser(user);
/*  37 */     String portraitUrl = properties.getPortraitUrl();
/*  38 */     String nickname = properties.getNickname();
/*  39 */     if (nickname == null) nickname = username; 
/*  40 */     model.addAttribute("portraitUrl", portraitUrl);
/*  41 */     model.addAttribute("nickname", nickname);
/*  42 */     return "center";
/*     */   }
/*     */   @RequestMapping({"/infos"})
/*     */   public String infos(Model model, HttpSession session, HttpServletResponse response) {
/*  46 */     String username = (String)session.getAttribute("username");
/*  47 */     User user = this.userRepository.findByUsername(username);
/*  48 */     UserProperties userProperties = this.userPropertiesRepository.findByUser(user);
/*  49 */     String nickname = userProperties.getNickname();
/*  50 */     if (nickname == null) nickname = username; 
/*  51 */     String country = userProperties.getCountry();
/*  52 */     int gender = userProperties.getGender();
/*  53 */     Date birth = userProperties.getBirthday();
/*  54 */     String birthStr = "";
/*     */     try {
/*  56 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  57 */       birthStr = sdf.format(birth);
/*  58 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  61 */     model.addAttribute("nickname", nickname);
/*  62 */     model.addAttribute("country", (country == null) ? "暂未设置" : country);
/*  63 */     model.addAttribute("gender", (gender == 0) ? "未设置" : ((gender == 1) ? "男" : "女"));
/*  64 */     model.addAttribute("birthday", birthStr);
/*  65 */     response.setHeader("X-Frame-Options", "SAMEORIGIN");
/*  66 */     return "myinfo";
/*     */   }
/*     */   @RequestMapping({"/modifyinfos"})
/*     */   public String modifyInfos(Model model, HttpSession session) {
/*  70 */     String username = (String)session.getAttribute("username");
/*  71 */     User user = this.userRepository.findByUsername(username);
/*  72 */     UserProperties userProperties = this.userPropertiesRepository.findByUser(user);
/*  73 */     String nickname = userProperties.getNickname();
/*  74 */     if (nickname == null) nickname = username; 
/*  75 */     String country = userProperties.getCountry();
/*  76 */     Long countryId = userProperties.getCountryId();
/*  77 */     int gender = userProperties.getGender();
/*  78 */     Date birth = userProperties.getBirthday();
/*  79 */     String birthStr = "";
/*     */     try {
/*  81 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  82 */       birthStr = sdf.format(birth);
/*  83 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  86 */     model.addAttribute("nickname", nickname);
/*  87 */     model.addAttribute("countryId", countryId);
/*  88 */     model.addAttribute("gender", Integer.valueOf(gender));
/*  89 */     model.addAttribute("birthday", birthStr);
/*  90 */     return "modifyinfos";
/*     */   }
/*     */   @RequestMapping({"/modifyinfos-processing"})
/*     */   @ResponseBody
/*     */   @Transactional
/*     */   public String modifyInfoProcessing(@RequestBody String newInfos, HttpSession session) {
/*  96 */     System.out.println(newInfos);
/*  97 */     String username = (String)session.getAttribute("username");
/*  98 */     JSONObject object = JSONObject.parseObject(newInfos);
/*  99 */     String nickname = object.getString("nickname");
/* 100 */     Long country = object.getLong("country");
/* 101 */     int gender = object.getInteger("gender").intValue();
/* 102 */     String birthday = object.getString("birthday");
/* 103 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 104 */     Date birthStr = null;
/*     */     
/*     */     try {
/* 107 */       birthStr = sdf.parse(birthday);
/* 108 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 112 */     User user = this.userRepository.findByUsername(username);
/* 113 */     UserProperties properties = this.userPropertiesRepository.findByUser(user);
/* 114 */     properties.setCountryId(country);
/* 115 */     properties.setCountry(((Country)this.countryRepository.findById(country).get()).getCname());
/* 116 */     properties.setGender(gender);
/* 117 */     properties.setNickname(nickname);
/* 118 */     properties.setBirthday(birthStr);
/* 119 */     this.userPropertiesRepository.saveAndFlush(properties);
/* 120 */     return "{\"success\":true}";
/*     */   }
/*     */ }


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\controller\UserServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */