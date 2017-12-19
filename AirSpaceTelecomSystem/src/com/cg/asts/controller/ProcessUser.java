package com.cg.asts.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.asts.dto.UserBean;
import com.cg.asts.exception.AirSpaceException;
import com.cg.asts.service.CustomerServiceImpl;
import com.cg.asts.service.ICustomerService;

@WebServlet("*.obj")
public class ProcessUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ProcessUser() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ICustomerService custService = new CustomerServiceImpl();
		UserBean user = new UserBean();;
		String target  ="";
		
		String targetAdd= "view/CustomerHome.jsp";
		String targetPay="view/PayBill.jsp";
		String targetSuccess = "view/Success.jsp";
		String targetError = "view/Error.jsp";
		String targetHome = "view/Register.jsp";
		
		String path = request.getServletPath().trim();
		
		
		switch(path) {
		//Registration code
		case "/register.obj":
			String name  = request.getParameter("name");
			String userName = request.getParameter("uname");
			String mobNo = request.getParameter("mobileno");
			String password =  request.getParameter("pwd");
		
			user.setName(name);
			user.setUserName(userName);
			user.setPassword(password);
			user.setMobileNo(mobNo);	
			
			try {
				custService.addUser(user);
				session.setAttribute("user", user);
				target = targetAdd;
			} catch (AirSpaceException exp) {
				session.setAttribute("error", exp.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(targetError);
				dispatcher.forward(request, response);
			}
			break;
			
		//After Registration payment will happen
		case "/payment.do":
			String mobile = ((UserBean)session.getAttribute("user")).getMobileNo();
			session.setAttribute("mobileNo",mobile);
			target = targetPay;
			break;
			
		//Finally Result will be shown with balance amount
		case "/result.do":
			String  resultprice = request.getParameter("result");
			int price  = Integer.parseInt(resultprice);
			int Balance = 750-price;
			session.setAttribute("balance", Balance);
			target = targetSuccess;
			break;
			
		case "/back.do":
			session.setAttribute("error", null);
			target = targetHome;
			break;
	}
		//Sending the user to appropriate page using the target variable
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}
}
