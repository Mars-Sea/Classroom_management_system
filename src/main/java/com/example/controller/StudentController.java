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

import com.example.domain.Student;
import com.example.repository.StudentRepository;



@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	private List<Student> getStudentlist(){
		List<Student> students = new ArrayList<Student>();
		for (Student student : studentRepository.findAll()) {
			students.add(student);
		}
		return students;
	}
	
	//查询所有信息
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("studentlist",getStudentlist());
		model.addAttribute("title","班级信息");
		return new ModelAndView("/student","studentModel",model);
	}
	
	@GetMapping("/import")
	public ModelAndView createForm(Model model){
		model.addAttribute("student", new Student());
		return new ModelAndView("/import","studentModel",model);
	}
	
	@PostMapping("/import")
	public ModelAndView create(Student student) {
		//System.out.println("111");
		//System.out.println(student.getSno());
		
		//创建需要切割的字符串
				String sno=student.getSno();
				String sname=student.getSname();
				String sex=student.getSex();
//				String sabsent=student.getSabsent();
//				String slate=student.getSlate();
//				String sleave=student.getSleave();
//				String speacetime=student.getSpeacetime();
//				String sterminal = student.getSterminal();
//				String sclassname = student.getSclassname();
		//存储切割完毕的字符串
				String[] snoArray = sno.split("##");
				String[] snameArray = sname.split("##");
				String[] sexArray = sex.split("##");
//				String[] sabsentArray = sabsent.split("##");
//				String[] slateArray = slate.split("##");
//				String[] sleaveArray = sleave.split("##");
//				String[] speacetimeArray = speacetime.split("##");
//				String[] sterminalArray = sterminal.split("##");
//				String[] sclassnameArray = sclassname.split("##");
				
		//循环存储学生信息
				//System.out.println(sexArray[3].replace(",", ""));
				for(int i=0;i<snoArray.length;i++) {
					Student s = new Student();
					s.setSno(snoArray[i].replace(",", ""));
					s.setSname(snameArray[i].replace(",", ""));
					s.setSex(sexArray[i].replace(",", ""));
//					s.setSabsent(sabsentArray[i].replace(",", ""));
//					s.setSlate(slateArray[i].replace(",", ""));
//					s.setSleave(sleaveArray[i].replace(",", ""));
//					s.setSpeacetime(speacetimeArray[i].replace(",", ""));
//					s.setSterminal(sterminalArray[i].replace(",", ""));
//					s.setSclassname(sclassnameArray[i].replace(",", ""));
					studentRepository.save(s);
				}
				return new ModelAndView("redirect:/student");
	}
	
	
	
}
