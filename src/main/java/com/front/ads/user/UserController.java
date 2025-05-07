package com.front.ads.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;


  @GetMapping("/create")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("create");
    mv.addObject("userModel", new UserModel());
    return mv;
  }

  @PostMapping("/create")
  public void create(UserModel userModel) {


    System.out.println("TESTE O SISTEMA CHEGOU AQUI");
        var criadoUser = this.userRepository.save(userModel);

        System.out.println("salvou os dados");
        System.out.println(criadoUser);
       
  }

  @GetMapping("/list")
  public ModelAndView list() {
    ModelAndView mv = new ModelAndView("list");
    UserModel userModel = null;
    mv.addObject("userModel", userModel);
    return mv;
  }

    
}
