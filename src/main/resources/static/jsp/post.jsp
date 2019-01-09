<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@ page import="java.io.*" %>
	

<%
    String string ="";
%>

<%
	request.setCharacterEncoding("utf-8");
	//String info = request.getParameter("path");
	//写文件
	String str = "创建方法：var ajaxobj=new AJAX;，如果创建失败则返回false";
	String filename = request.getRealPath("123.txt");
	java.io.File f = new java.io.File(filename);
	if(!f.exists())//如果文件不存，则建立
	{
		f.createNewFile();
	}
	try
	{
		PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
		pw.println(request.getParameter("path"));//写内容
		pw.close();
	} catch(IOException e) {
		out.println(e.getMessage());
	}
	
	try {
		FileReader read=new FileReader(f);
		BufferedReader buffread=new BufferedReader(read);
		String linetxt=null;
		
		while((linetxt=buffread.readLine())!= null) {
			string+=linetxt+"\n";
		}
		
		//out.write(string);
		read.close();
		
	}
	catch (Exception e) {
		out.write("2321");
	}
%>

<img src=<%=string%> width="200px"  alt="23216545"/>


