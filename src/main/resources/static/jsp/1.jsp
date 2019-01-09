<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 String message = "Th\r\nis is </script> a \"test\" St\nring.";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>java变量赋值给javascript变量</title>
</head>
<body>
 <script type="text/javascript">
  var jsStr = "<%=message.replace("\"", "\\\"").replace("</script>", "<\"+\"/script>").replace("\r", "").replace("\n", "\\\n")%>";
 
  alert(jsStr);
 </script>
</body>
</html>
