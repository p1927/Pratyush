<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c" %>    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validatePassword(){
		var pass = document.getElementById("password").value;
		var confirmpass = document.getElementById("confirmPassword").value;
		
		if(pass === confirmpass)
			return true;
		else{
			alert("Password and confirm password are not same");
			return false;
		}		
	}
</script>

</head>
<body>
	<div class="content">
	<h1 align="center">AirSpace Telecomm</h1>
	<div align="center">
		<form action="register.do" method="post"  onSubmit="return validatePassword();">
			<table>
				<h2 align="center">New User Registration Form</h2>
				<tr>
					<td align="right">Enter Your name</td>
					<td><input type="text" name="name" pattern="[A-Za-z][A-Za-z ]*" required/></td>
				</tr>

				<tr>
					<td align="right">Mobile Number</td>
					<td><input type="text" pattern="[1-9][0-9]{9}" name="mobileno" required/></td> 
				</tr>
		
				<tr>
					<td align="right">Username</td>
					<td><input type="text" name="uname" required/></td>
				</tr>

				<tr>
					<td align="right">Password</td>
					<td><input type="password" id="password" name="pwd" required/></td> 
				</tr>
		
				<tr>
					<td align="right">Reenter Password</td>
					<td><input type="password" id="confirmPassword" required/></td> 
				</tr>
		
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" class="button"></input></td>
				</tr>
			</table>
		</form>
		<div id="msg" ></div>
	</div>
	</div>
</body>
</html>