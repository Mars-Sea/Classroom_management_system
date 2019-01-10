package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Attendance;
import com.example.domain.Student;
import com.example.repository.AttendanceRepository;
import com.example.repository.StudentRepository;



@RestController
@RequestMapping
public class StudentController {

	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	public List<Attendance> getAttendancelist(String classname,String coursename) {
		List<Attendance> att = new ArrayList<Attendance>();
		for (Attendance attendance : attendanceRepository.findByClassNameAndCourseName(classname, coursename)) {
			System.out.println(attendance.getSno()+"\t"+attendance.getSname());
			att.add(attendance);
		}
		return att;
	}
	
	
	private List<Student> getStudentlist(){
		List<Student> students = new ArrayList<Student>();
		for (Student student : studentRepository.findAll()) {
			students.add(student);
		}
		return students;
	}
	
	
	//查询所有信息
	@GetMapping("/student{className}{courseName}")
	public ModelAndView list(@PathVariable("className") String className,@PathVariable("courseName") String courseName,Model model) {
		String[] cnameArray = className.split("SCITC");
		model.addAttribute("attlist",getAttendancelist(cnameArray[0], cnameArray[1]));
		model.addAttribute("classname",cnameArray[0]);
		model.addAttribute("coursename",cnameArray[1]);
		model.addAttribute("title","班级信息");
		return new ModelAndView("/student","studentModel",model);
	}
	
	
	
	@GetMapping("/Export{className}{courseName}")
	public ModelAndView List(@PathVariable("className") String className,Model model) {
		String[] cnameArray = className.split("SCITC");
		model.addAttribute("attlist",getAttendancelist(cnameArray[0], cnameArray[1]));
		model.addAttribute("title","班级信息");
		return new ModelAndView("/Export","studentModel",model);
	}
	
	
	@GetMapping("/import")
	public ModelAndView createForm(Model model){
		model.addAttribute("student", new Student());
		return new ModelAndView("/import","studentModel",model);
	}
	
	
	
	@PostMapping("/import")
	public ModelAndView create(Student student) {
		
		//创建需要切割的字符串
				String sno=student.getSno();
				String sname=student.getSname();
				String sex=student.getSex();
				String sclassname = student.getClassName();
		//存储切割完毕的字符串
				String[] snoArray = sno.split("##");
				String[] snameArray = sname.split("##");
				String[] sexArray = sex.split("##");
				String[] sclassnameArray = sclassname.split("##");
				
		//循环存储学生信息
				for(int i=0;i<snoArray.length;i++) {
					Student s = new Student();
					s.setSno(snoArray[i].replace(",", ""));
					s.setSname(snameArray[i].replace(",", ""));
					s.setSex(sexArray[i].replace(",", ""));
					s.setClassName(sclassnameArray[i].replace(",", ""));
					studentRepository.save(s);
				}
				
				return new ModelAndView("redirect:/login");
	}
	
	
	//删除学生
	@RequestMapping(value="delete",method =RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam(value = "stuno", defaultValue = "") Long id) {
		studentRepository.deleteById(id);
	}
	
}
