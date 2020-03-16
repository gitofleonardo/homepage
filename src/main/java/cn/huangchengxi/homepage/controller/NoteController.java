package cn.huangchengxi.homepage.controller;

import cn.huangchengxi.homepage.entity.SharedExperience;
import cn.huangchengxi.homepage.entity.SharedExperienceType;
import cn.huangchengxi.homepage.repository.ExpRepository;
import cn.huangchengxi.homepage.repository.ExpTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    ExpRepository expRepository;
    @Autowired
    ExpTypeRepository expTypeRepository;

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
        List<SharedExperienceType> types=expTypeRepository.findAll();
        List<SharedExperience> exps=expRepository.findAll();
        model.addAttribute("exps",exps);
        model.addAttribute("types",types);
        SharedExperience exp=experience.get();
        model.addAttribute("experience",exp);
        return "Note";
    }
}
