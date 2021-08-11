package com.example.student.resource;

import com.example.student.model.User;
import com.example.student.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/gocorona")
public class MyController {

    @GetMapping(value = "/")
    public String getHome(){ return "index"; }

    @GetMapping(value = "/getlog")
    public String getLogin(){ return "login"; }

    @GetMapping(value = "/getreg")
    public String getRegister(){
        return "register";
    }

    @GetMapping(value = "/getdel")
    public String getDelete() {
        return "delete";
    }

    @Autowired
    UserRepo ur;

    @PostMapping(value = "/doregister")
    public String doRegister(@Param("email")String email, @Param("pass")String pass, @Param("name")String name, @Param("age")String age, @Param("phone")String phone){
        User u1 = new User(email, pass, name, Integer.parseInt(age), phone);

        ur.save(u1);

        System.out.println("\n\n RECORD INSERTED SUCCESSFULLY");

        return "login";
    }

    @PostMapping(value = "/dologin")
    public String doLogin(@Param("ema")String ema,@Param("pass")String pass){

        User u1 = ur.findByEmailAndPassword(ema, pass);
        String file="";

        if (u1==null){
            System.out.println("\n USER UNAUTHORIZED!");
            file="login";
        }else {
            System.out.println("\n USER AUTHORIZED..");
            file="index";
        }

        return file;
    }

    @PostMapping(value = "/dodelete")
    public String doDelete(@Param("uid")int uid){
        try {
            ur.deleteById(uid);
            System.out.println("\n\n User Removed!");
        }catch (Exception e){
            System.out.println("\n\n Error in Delete: "+e.getMessage());
        }
        return "index";
    }

    // if client is required to send view(html) with data then ModelAndView must be called
    @GetMapping(value = "/doshow")
    public ModelAndView show(Model mod){

        List<User> list = ur.findAll();

        mod.addAttribute("userlist",list);

        ModelAndView model = new ModelAndView();

        model.addObject(mod);

        model.setViewName("show");  // it finds show.html file in template

        return model;
    }

}
