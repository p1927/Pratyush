<%@ page language="java" import="java.util.*, com.cg.airspacetelecomm.bean.UserBean, com.cg.airspacetelecomm.service.CSI" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/style.css'>

</head>
<body>

	<h1 class="myHeader" align="center">AirSpace Telecomm</h1>
	<div id='box' align="center">
	
   
    <label for='search'>Search here:</label>
    <input id='search' type='text' oninput="compareValues(this)" placeholder="First Last">
    <input id='notFound' type='text' readonly>
    <p></p>
    <hr>
    <p></p>
  </div>

  <div align="center" id='tableDiv' class="overflow-scroll">
    <table id="myTable" style="width:100%;" class="boxin">
      <h4 style="font-size: 20px;" class="myHeader">Registered Users Database</h4>
      <thead>
      
        <tr>
          <th scope="col">Name</th>
          <th scope="col">User Name</th>
          <th scope="col">Password</th>
          <th scope="col">Mobile No</th>
           <th scope="col">Amount Due</th>
        </tr>
      </thead>

      <tbody>
        
      <%CSI dataget = new CSI();
     // List<UserBean> udata=dataget.fakeget();
   List<UserBean> udata=dataget.get();
     
for (UserBean U: udata)
	
{ %> <tr>
	<td>  <%=U.getName()%> </td>
	<td> <%=U.getUserName() %></td>
	<td> <%=U.getPwd() %></td>
	<td> <%=U.getMobileNo()%> </td>
	<td> <%=U.getBill()%> </td>
	</tr> <%}%>
        
          
      </tbody>
    </table>
  </div> 
  
    <script >
  
    

    function compareValues(input) {

        let myTable = document.querySelector('#myTable');
        // console.log(myTable);
        let inputLength = input.value.length;
        input = input.value.toLowerCase();//lower case for comparison

        let countMatch = 0;
        let feedBack = document.querySelector('#notFound');
        //start loop at 1 to skip header
        for (var i = 1; i < myTable.rows.length; ++i) {
            //a - first and second cell of each row 
            //b -slice name to match lengh of input
            //c -set all tables to default color
            //d - if input matches, change color and input is not empty
            //e - change the color

            let name = myTable.rows[i].cells[0].innerText;//a
            //let lastName = myTable.rows[i].cells[1].innerText;
            let fullName = name ;//+ " " + lastName;

            fullName = fullName.slice(0, inputLength);//b
            fullName = fullName.toLowerCase();

            //myTable.rows[i].style.backgroundColor = '#ffffff';//c

            if ((input === fullName) && (inputLength !== 0)) {//d
                myTable.rows[i].style.backgroundColor = '#7a7a7a';//e
                countMatch++;
            }
        }

        //display message if there is a match or not
        if (countMatch === 0) {
            feedBack.value = 'Sorry, no contact found.';
        } else {
            feedBack.value = countMatch + ' ' + 'contacts match.';
        }
    }


    </script>

</body>
</html>

