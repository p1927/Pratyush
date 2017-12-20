<%@ page language="java" import="java.util.*, com.cg.airspacetelecomm.bean.UserBean, com.cg.airspacetelecomm.service.CSI" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='views/css/style.css'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
</head>

<body>

		<h1 class="myHeader" align="center">AirSpace Telecomm</h1>
    
	    <div class="boxsearch" align="center">
        <h3>Welcome Administrator</h3>
      <div class="row searchpos" >
    <div class="column">
             Search here:</div>
            
     <div class="column"><input id='search' class="inputMaterial1" type='text' oninput="compareValues(this)" placeholder="First Last"></div>
       <div class="column"><input id='notFound' class="inputMaterial1" type='text' style="border-bottom:0px;" readonly> </div></div></div>

  <div  class="overflow-scroll">
    
       <h4 style="font-size: 20px;" align="center" class="myHeader">Registered Users Database</h4>
    <div class="row">
    <div class="boxadd">
          <h3 id="logintoregister"align="center">Add Account</h3>
    <div class="group">      
      <input id="una" class="inputMaterial" type="text" name="uname"  required>
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
        	 
	  <div class="group">      
      <input class="inputMaterial" type="text" name="name" id="name"  pattern="[A-Za-z][A-Za-z ]*"  required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Name</label>
      </div>
	  <div class="group">      
      <input class="inputMaterial" type="text" pattern="[1-9][0-9]{9}" name="mobileno" id="mbno"  required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Mobile No.</label>
      </div>
      <div class="group">      
      <input class="inputMaterial" type="text" pattern="[1-9][0-9]{9}" name="bill" id="bill" required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Bill</label>
        
      </div>
      <button id="buttonlogintoregister" type="submit">Add Account</button>
      
    </div>
    <div class="boxtab">
    <table id="myTable"  class="table table-bordered table-striped"">
      
      <thead>
      
        <tr>
          <th class="" scope="col">Name</th>
          <th class="" scope="col">User Name</th>
          <th class="" scope="col">Password</th>
          <th class="" scope="col">Mobile No</th>
           <th class="" scope="col">Amount Due</th>
            <th class="" scope="col"></th>
        </tr>
      </thead>

      <tbody>
        
      <%CSI dataget = new CSI();
      List<UserBean> udata=dataget.fakeget();
   //List<UserBean> udata=dataget.get();
     
for (UserBean U: udata)
	
{ %> <tr>
	<td class="">  <%=U.getName()%> </td>
	<td class=""> <%=U.getUserName() %></td>
	<td class=""> <%=U.getPwd() %></td>
	<td class=""> <%=U.getMobileNo()%> </td>
	<td class=""> <%=U.getBill()%> </td>
	<td class=""> <button class="btn btn-success" data-toggle="modal" data-target="#myModal" contenteditable="false">Edit</button></td>
	</tr> <%}%>
        
          
      </tbody>
    </table>
    
 <!-- //////////////////////////////////   --> 
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content"></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content"></div>
    </div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true" class="">�   </span><span class="sr-only">Close</span>

                </button>
                 <h4 class="modal-title" id="myModalLabel">Modal title</h4>

            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
 <!-- /////////////////////    -->
    </div>
  </div> 
  
    <script >
/////////////////////////
$(".btn[data-target='#myModal']").click(function() {
       var columnHeadings = $("thead th").map(function() {
                 return $(this).text();
              }).get();
       columnHeadings.pop();
       var columnValues = $(this).parent().siblings().map(function() {
                 return $(this).text();
       }).get();
  var modalBody = $('<div id="modalContent"></div>');
  var modalForm = $('<form role="form" name="modalForm" action="putYourPHPActionHere.php" method="post"></form>');
  $.each(columnHeadings, function(i, columnHeader) {
       var formGroup = $('<div class="form-group"></div>');
       formGroup.append('<label for="'+columnHeader+'">'+columnHeader+'</label>');
       formGroup.append('<input class="form-control" name="'+columnHeader+i+'" id="'+columnHeader+i+'" value="'+columnValues[i]+'" />'); 
       modalForm.append(formGroup);
  });
  modalBody.append(modalForm);
  $('.modal-body').html(modalBody);
});
$('.modal-footer .btn-primary').click(function() {
   $('form[name="modalForm"]').submit();
});
////////////////////////
    
    

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

