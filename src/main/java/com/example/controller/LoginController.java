//package com.example.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import com.example.domain.Login;
//import com.example.repository.TeacherRepository;
//
//@RestController  
//@RequestMapping("/login")
//public class LoginController {
//	@Autowired
//	private TeacherRepository loginRepository;
//	
//	/*
//	 * 从用户仓库中获取用户列表
//	 * */
//	private List<Login> getLoginlist(){
//		List<Login> logins = new ArrayList<>();
//		for(Login login : loginRepository.findAll()) {
//			logins.add(login);
//		}		
//		return logins;
//	}
//	
//	
//	@GetMapping
//	public ModelAndView createForm(Model model){
//		model.addAttribute("login", new Login());
//		model.addAttribute("title", "");
//		return new ModelAndView("/login","loginModel",model);
//	}
//	
//	@PostMapping
//	public ModelAndView login(Model model,Login login) {
//		model.addAttribute("loginList", getLoginlist());
//		model.addAttribute("title", "账号或密码错误");
//		List<Login> u = loginRepository.findAll();
//		for(int i = 0; i<u.size(); i++) {
//			if(u.get(i).getUid().equals(login.getUid()) && u.get(i).getPassword().equals(login.getPassword())){
//				return new ModelAndView("redirect:/student");
//			}
//		}
//		return new ModelAndView("/login","loginModel",model);
//	}
//	
////	@PostMapping
////	public ModelAndView create(Login login) {
////		//System.out.println(login.getPassword());
////		List<Login> u = loginRepository.findAll();
////		for(int i = 0; i<u.size(); i++) {
////			//System.out.println(u.get(i).getPassword());
////			if(u.get(i).getUid().equals(login.getUid()) && u.get(i).getPassword().equals(login.getPassword())){
////				return new ModelAndView("redirect:/register");
////			}
////		}
////		return new ModelAndView("redirect:/login");
////	}
//	
//
//}
