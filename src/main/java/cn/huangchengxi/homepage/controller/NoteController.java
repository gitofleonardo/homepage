package cn.huangchengxi.homepage.controller;

import cn.huangchengxi.homepage.entity.SharedExperience;
import cn.huangchengxi.homepage.entity.SharedExperienceType;
import cn.huangchengxi.homepage.repository.ExpRepository;
import cn.huangchengxi.homepage.repository.ExpTypeRepository;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class NoteController {
    @Autowired
    ExpRepository expRepository;
    @Autowired
    ExpTypeRepository expTypeRepository;
    private static final String path="C:/server-images/";

    @RequestMapping("/avatar")
    @ResponseBody
    public String avatar(@PathParam("id") String id, @RequestParam("avatar") MultipartFile file){
        SharedExperienceType type=expTypeRepository.findById(Long.parseLong(id)).get();
        Date d=new Date();
        String filename=file.getOriginalFilename();
        String suffix=filename.substring(filename.lastIndexOf("."));
        String name=path+type.getId()+ d.getTime() +""+suffix;
        System.out.println(name);
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(name);
            fos.write(file.getBytes());
            String origin=type.getLogoUrl();
            type.setLogoUrl("/img/"+type.getId()+d.getTime()+""+suffix);
            expTypeRepository.save(type);
            //delete the origin
            if (origin!=null){
                String local=getLocalPath(origin);
                if (local!=null){
                    System.out.println("local path:"+local);
                    File f=new File(local);
                    if (f.exists()){
                        f.delete();
                    }
                }
            }
            return "{\"success\":true}";
        }catch (Exception e){
            return "{\"success\":false}";
        }finally {
            try{
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static String getLocalPath(String url){
        Pattern p=Pattern.compile("^/img/(.+)$");
        Matcher m=p.matcher(url);
        if (m.find()){
            return path+m.group(1);
        }
        return null;
    }
    @RequestMapping("/notes")
    @ResponseBody
    public List<Experiences> notes(){
        List<Experiences> exps=new ArrayList<>();
        List<SharedExperienceType> types=expTypeRepository.findAll();
        for (SharedExperienceType type:types){
            Experiences experiences=new Experiences();
            experiences.id=type.getId();
            experiences.name=type.getName();
            experiences.logoUrl=type.getLogoUrl();
            List<SharedExperience> se=expRepository.findAllBySharedExperienceType(type);
            System.out.println(se.size());
            for (SharedExperience s:se){
                Experience experience=new Experience();
                experience.id=s.getId();
                experience.title=s.getTitle();
                experiences.experiences.add(experience);
            }
            exps.add(experiences);
        }
        return exps;
    }
    static class Experiences{
        public String logoUrl;
        public Long id;
        public String name;
        public List<Experience> experiences=new ArrayList<>();
    }
    static class Experience{
        public Long id;
        public String title;
    }
    @RequestMapping("/note/{id}")
    public String note(@PathVariable Long id, Model model, HttpSession session){
        Optional<SharedExperience> experience=expRepository.findById(id);
        if (!experience.isPresent()){
            return "error";
        }
        if (session.getAttribute("isLogin") == null) {
            model.addAttribute("login", Boolean.FALSE);
        } else {
            model.addAttribute("login", Boolean.TRUE);
        }
        Collection<? extends GrantedAuthority> auths=(Collection<? extends GrantedAuthority>) session.getAttribute("auths");
        if (auths!=null){
            model.addAttribute("isAdmin",false);
            for (GrantedAuthority auth:auths){
                if (auth.getAuthority().equals("role_admin")){
                    System.out.println("set is admin");
                    model.addAttribute("isAdmin",true);
                    break;
                }
            }
        }else{
            model.addAttribute("isAdmin",false);
        }
        List<SharedExperienceType> types=expTypeRepository.findAll();
        List<SharedExperience> exps=expRepository.findAll();
        model.addAttribute("exps",exps);
        model.addAttribute("types",types);
        SharedExperience exp=experience.get();
        model.addAttribute("experience",exp);
        return "Note";
    }
    @RequestMapping("/modification/{id}")
    public String modification(@PathVariable Long id,Model model,HttpSession session){
        Optional<SharedExperience> exp=expRepository.findById(id);
        List<SharedExperienceType> types=expTypeRepository.findAll();
        if (!exp.isPresent()){
            return "/error";
        }
        SharedExperience experience=exp.get();
        experience.getSharedExperienceType().getId();
        model.addAttribute("experience",experience);
        model.addAttribute("types",types);
        return "ModifyNote";
    }
    @RequestMapping("/publication")
    public String publication(Model model){
        List<SharedExperienceType> types=expTypeRepository.findAll();
        model.addAttribute("types",types);
        return "ModifyNote";
    }
    @RequestMapping("/postNote")
    @ResponseBody
    public String postNote(@RequestBody String json){
        JSONObject object= JSONObject.parseObject(json);
        String title=object.getString("title");
        String content=object.getString("content");
        Long type=object.getLong("type");
        Long id=object.getLong("id");
        Optional<SharedExperienceType> t=expTypeRepository.findById(type);
        if (!t.isPresent()){
            return "{\"success\":false}";
        }
        SharedExperience experience=new SharedExperience(t.get(),title,content);
        if (id!=null){
            experience.setId(id);
        }
        expRepository.save(experience);
        return "{\"success\":true}";
    }
    @RequestMapping("/postExpType")
    @ResponseBody
    public String postExpType(@RequestBody String json){
        JSONObject object=JSONObject.parseObject(json);
        String name=object.getString("name");
        if (name==null || name.equals("")){
            return "{\"success\":false}";
        }
        SharedExperienceType type=new SharedExperienceType(new Date().getTime(),name);
        expTypeRepository.save(type);
        return "{\"success\":true}";
    }
}
