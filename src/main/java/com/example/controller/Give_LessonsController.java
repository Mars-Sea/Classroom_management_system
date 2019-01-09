package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Give_lessons;
import com.example.domain.Teacher;
import com.example.repository.Give_lessonsRepository;


@RestController  
@RequestMapping
public class Give_LessonsController {
	
	@Autowired
	private Give_lessonsRepository give_lessonsRepository;
	
	/*
	 * 从用户仓库中获取用户列表
	 * */
	private List<Give_lessons> getGive_lessonslist(){
		List<Give_lessons> give_lessonss = new ArrayList<>();
		for(Give_lessons give_lessons : give_lessonsRepository.findAll()) {
			give_lessonss.add(give_lessons);
		}		
		return give_lessonss;
	}
	
	@GetMapping
	public ModelAndView index(Model model){
		model.addAttribute("give_lessonslist", getGive_lessonslist() );
		return new ModelAndView("/index","give_lessonsModel",model);
	}
	
	@PostMapping("/give_lessons")
	public ModelAndView create(Give_lessons give_lessons) {
		give_lessons = give_lessonsRepository.save(give_lessons);
		return new ModelAndView("redirect:/index");
	}

}
