<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/style.css'>
<link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">

</head>
<body>
<div >
	<h1 class="myHeader box1" align="center">Welcome to AirSpace Telecomm</h1>
</div>
	<div align="center"><input type="submit"  onclick="ab();" value="Register" class="text-center btn-block btn btn-info text-right"></input>
<%response.sendRedirect("view/Register.jsp");%>
</div>
</body>
</html>