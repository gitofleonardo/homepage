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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class NoteController {
    @Autowired
    ExpRepository expRepository;
    @Autowired
    ExpTypeRepository expTypeRepository;
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
