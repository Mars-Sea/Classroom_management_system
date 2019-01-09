//package com.example.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.*;
//import com.example.domain.Register;
//import com.example.repository.RegisterRepository;
//
//@RestController  
//@RequestMapping("/register")
//public class RegisterController {
//	
//	@Autowired
//	private RegisterRepository registerRepository;
//	
//	@GetMapping
//	public ModelAndView createForm(Model model){
//		model.addAttribute("register", new Register());
//		return new ModelAndView("/register","registerModel",model);
//	}
//	
//	@PostMapping
//	public ModelAndView create(Register register) {
//		//System.out.println(register.getImg());
//		
//		File filename = new File(register.getJob_number()+".txt");
//		if (!filename.exists()) {
//			try {
//				filename.createNewFile();
//				FileInputStream fis = null;
//				InputStreamReader isr = null;
//				BufferedReader br = null;
//		 
//				FileOutputStream fos = null;
//				PrintWriter pw = null;
//				try {
//					// 文件路径
//					File file = new File(register.getJob_number()+".txt");
//					// 将文件读入输入流
//					fis = new FileInputStream(file);
//					isr = new InputStreamReader(fis);
//					br = new BufferedReader(isr);
//					StringBuffer buf = new StringBuffer();
//					fos = new FileOutputStream(file);
//					pw = new PrintWriter(fos);
//					pw.write(register.getImg());
//					pw.flush();
//					register.setImg(file.getName());
//				} catch (IOException e1) {
//					// TODO 自动生成 catch 块
//					throw e1;
//				} finally {
//					if (pw != null) {
//						pw.close();
//					}
//					if (fos != null) {
//						fos.close();
//					}
//					if (br != null) {
//						br.close();
//					}
//					if (isr != null) {
//						isr.close();
//					}
//					if (fis != null) {
//						fis.close();
//					}
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		register = registerRepository.save(register);
//		return new ModelAndView("redirect:/login");
//	}
//
//}
