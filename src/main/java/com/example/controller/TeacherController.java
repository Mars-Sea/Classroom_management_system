package com.example.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.repository.ClassesRepository;
import com.example.repository.CourseRepository;
import com.example.repository.Give_lessonsRepository;
import com.example.repository.TeacherRepository;
import com.example.domain.*;

@RestController  
@RequestMapping("/login")
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ClassesRepository classisRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private Give_lessonsRepository give_lessonsRepository;
	
	/*
	 * 从用户仓库中获取用户列表
	 * */
	private List<Teacher> getTeacherlist(){
		List<Teacher> teachers = new ArrayList<>();
		for(Teacher teacher : teacherRepository.findAll()) {
			teachers.add(teacher);
		}		
		return teachers;
	}
	
	@GetMapping
	public ModelAndView login(Model model){
		model.addAttribute("teacher", new Teacher());
		model.addAttribute("title", "");
		return new ModelAndView("/login","teacherModel",model);
	}

	//登录
	@PostMapping() 
	public ModelAndView login(Model model,Teacher teacher) {
		model.addAttribute("teacherList", getTeacherlist());
		model.addAttribute("title", "账号或密码错误");
		List<Teacher> u = teacherRepository.findAll();
		List<Classes> c = classisRepository.findAll();
		List<Course> k = courseRepository.findAll();
		List<Give_lessons> g = give_lessonsRepository.findAll();
		//System.out.println("123");
		
		for(int i = 0; i<u.size(); i++) {
			if(u.get(i).getUid().equals(teacher.getUid()) && u.get(i).getPassword().equals(teacher.getPassword()) && teacher.getPower() == 0){
				//System.out.println("123");
					model.addAttribute("tname", u.get(i).getName());
					model.addAttribute("classname", c);
					model.addAttribute("coursename", k);
					model.addAttribute("give", g);
					return new ModelAndView("/index","teacherModel",model);

			}
		}
		return new ModelAndView("/login","teacherModel",model);
	}
	
	@GetMapping("/register")
	public ModelAndView register(Model model){
		model.addAttribute("teacher", new Teacher());
		model.addAttribute("title", "");
		return new ModelAndView("/register","teacherModel",model);
	}
	
	//注册教师
	@PostMapping("/register")
	public ModelAndView create(Teacher teacher) {
		//System.out.println(teacher.getEmail());
		
		File filename = new File(teacher.getJob_no()+".txt");
		
		if (!filename.exists()) {
			try {
				filename.createNewFile();
				FileInputStream fis = null;
				InputStreamReader isr = null;
				BufferedReader br = null;
		 
				FileOutputStream fos = null;
				PrintWriter pw = null;
				try {
					// 文件路径
					File file = new File(teacher.getJob_no()+".txt");
					//System.out.println(teacher.getJob_no());
					// 将文件读入输入流
					fis = new FileInputStream(file);
					isr = new InputStreamReader(fis);
					br = new BufferedReader(isr);
					StringBuffer buf = new StringBuffer();
					fos = new FileOutputStream(file);
					pw = new PrintWriter(fos);
					pw.write(teacher.getImg());
					pw.flush();
					teacher.setImg(file.getName());
				} catch (IOException e1) {
					// TODO 自动生成 catch 块
					throw e1;
				} finally {
					if (pw != null) {
						pw.close();
					}
					if (fos != null) {
						fos.close();
					}
					if (br != null) {
						br.close();
					}
					if (isr != null) {
						isr.close();
					}
					if (fis != null) {
						fis.close();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		teacher = teacherRepository.save(teacher);
		return new ModelAndView("redirect:/login");
	}
	
	
	
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
	
	@GetMapping("/give_lessons")
	public ModelAndView index(Model model){
		model.addAttribute("give_lessonslist", getGive_lessonslist() );
		return new ModelAndView("/index","give_lessonsModel",model);
	}
	
	@PostMapping("/give_lessons")
	public ModelAndView give(Give_lessons give_lessons) {
		System.out.println("123");
		System.out.println(give_lessons.getClassName());
		give_lessons = give_lessonsRepository.save(give_lessons);
		return new ModelAndView("redirect:/login");
	}

}
