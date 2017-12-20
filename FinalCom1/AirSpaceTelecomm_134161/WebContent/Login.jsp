<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AirSpace Telecomm</title>
<link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href='css/style1.css'>
</head>

<body>
	<div >
	<h1 class="myHeader" align="center">AirSpace Telecomm</h1>
	<div id="box" align="center">
	
<c:url var="myAction" value="Login.obj"></c:url>
	<form action="${myAction}" method="post" > 
		<div class="box1">	
		<script>
		
		<% if(session.getAttribute("info")=="WRONG PASS"){%>
		document.querySelector("#forgpass").innerHTML="The Password in incorrect. Please try again.";
		document.querySelector("#una").value=session.getAttribute("unret");
		<%}%>
		
		</script>
<table >
				<h2 align="center">Enter Login Details</h2>
<tr>
					
					<td align="left">Username</td>
					<td><input id="una" type="text" name="uname" required/></td>
				</tr>

				<tr>
					<td align="left">Password</td>
					<td><input type="password" id="password" name="pwd" required/></td> 
				</tr>
		
					
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" class="text-center btn-block btn btn-info text-right"></input></td>
				</tr>
				<tr><td>
				
			<p id="forgpass"></p> 
			  
			</td></tr>
			 </table></div>
		</form>
		</div>
		<br>
		<hr>
		<p> Not a registered user?</p><br>
		
		<div align="center"><c:url var="doAction" value="Reg.obj"></c:url>
	             <form action="${doAction}" method="post">
				<button type="submit" class="text-center btn-block btn btn-info text-right">Register Here</button>
				</form></div>
<div id="msg" ></div>
<hr><br>
<div align="center"><c:url var="doon" value="Getdata.obj"></c:url>
	             <form action="${doon}" method="post">
				<button type="submit" class="text-center btn-block btn btn-info text-right">Get Users</button>
				</form></div>
		</div>
</body>
</html>