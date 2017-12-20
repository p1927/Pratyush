<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AirSpace Telecomm</title>
<!-- <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"> -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<link rel='stylesheet' type='text/css' href='views/css/stylelogin.css'>

</head>

<body>
	<div >
	<h1 class="myHeader" align="center">AirSpace Telecomm</h1>
	</div>
	<c:url var="myAction" value="${sessionScope.curlval}"></c:url>
	<form id="form" action="${myAction}"  method="post" > 
	
	<div class="box">
      <h1 id="logintoregister">Login</h1>
    <div class="group">      
      <input id="una" class="inputMaterial" type="text" name="uname" oninput="dbcheck(this.value);" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Username</label>
      </div>
	  <div class="group">      
      <input class="inputMaterial" type="password" name="pwd" id="password" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Password</label>
      </div>
        	  <div class="group show">      
      <input class="inputMaterial" type="password" id="confirmPassword"  disabled required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Confirm Password</label>
      </div>
	  <div class="group show">      
      <input class="inputMaterial" type="text" name="name" id="name" oninput="validatePassword();" pattern="[A-Za-z][A-Za-z ]*" disabled required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Name</label>
      </div>
	  <div class="group show">      
      <input class="inputMaterial" type="text" pattern="[1-9][0-9]{9}" name="mobileno" id="mbno" disabled required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Mobile No.</label>
      </div>
      
      <button id="buttonlogintoregister" type="submit">Login</button>
      </form>
      <p id="plogintoregister">Not a registered user? </p>
      <p id="textchange" onclick="register();" > Register Here</p>
    </div>
    
      

	
	
	<%-- <div id="box" align="center">
	
			
			
			
			
			
	<div class="box1">	
		
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
				<tr>
				<td>
				<p id="forgpass"></p> 
			  	</td>
			  	</tr>
			 </table>
			 </div>
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
		</div> --%>
		<script>
		////////////////////////
		
		$('una').removeAttr('oninput');
			
		<% if(session.getAttribute("info")=="NR"){%>
		document.querySelector("#plogintoregister").innerHTML="You are not registered with us. Please Register.";
		<%}%>
		////////////////////////
		<% if(session.getAttribute("info")=="WRONG PASS"){%>
		document.querySelector("#plogintoregister").innerHTML="The Password in incorrect. Please try again.";
		document.querySelector("#una").value=session.getAttribute("unret");
		<%}%>
		/////////////////
		var cont = 0;

function register(){
console.log("inside");
     cont++;
		
		if(cont==1){
		 	$('.box').animate({height:'595px'}, 550);
			$('.show').css('display','block');
			$('#logintoregister').text('Registration');
			$('#buttonlogintoregister').text('Register');
			$('#plogintoregister').text("Already registered?");
			$('#textchange').text('Login');
			/* <c:set var="myAction" value="Register.obj"/> 
			document.querySelector('#form').onSubmit="validatePassword();";
			document.querySelector('#una').oninput="dbcheck(this.value);"; */
			document.querySelector('#name').disabled=false;
			document.querySelector('#mbno').disabled=false;
			document.querySelector('#confirmPassword').disabled=false;
			
			$('#una').attr('oninput', 'test');

			/////////////////
			
			
			$.ajax({
				type: "POST",
				url:  'Reg.obj',
				success: function(resp){
				}
				}); 
			///////////////////
			
			
		}
		else
		{
			$('.show').css('display','none');
			$('.box').animate({height:'365px'}, 550);
			$('#logintoregister').text('Login');
			$('#buttonlogintoregister').text('Login');
			$('#plogintoregister').text("Not a registered User?");
			$('#textchange').text('Register');
			
			cont = 0;
		}
}
		
		function validatePassword(){
			var a=document.querySelector('#password').value;
			var b=document.querySelector('#confirmPassword').value;
			if (a!=b){ $('#plogintoregister').text("Passwords do not match. Try Again"); }
			document.querySelector('#password').value="";
			document.querySelector('#confirmPassword').value='';
		}
		
		function dbcheck(uname)
		{ 
		   $.ajax({
				type: "POST",
				url:  'valid.obj',
				data: {userN:uname},
				success: function(resp) {
				if(resp=='1')
					$('#plogintoregister').text("The Username already exists. Try Again.");  
				else  $('#plogintoregister').text("Pretty Good."); 
				
						}
				}); 
			};
		</script>
</body>
</html>