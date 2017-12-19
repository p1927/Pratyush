package com.cg.airspacetelecomm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.exception.AirSpaceException;
import com.cg.airspacetelecomm.service.CustomerService;
import com.cg.airspacetelecomm.service.CustomerServiceImpl;
import com.cg.airspacetelecomm.service.CSI;

@WebServlet("*.obj")
public class ProcessUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Creating required objects and initializing(If required)

		HttpSession session = request.getSession(true);
		String path = request.getServletPath().trim();
			
			
		
		
		//Target Web Files are pre-declared to avoid confusion later in the code
		
		String target = "";
		String targetSuccess = "views/Success.jsp";
		String targetHome= "views/CustomerHome.jsp";
		String targetPay="views/PayBill.jsp";
		String targetError = "views/Error.jsp";
		String targetReg = "views/Register.jsp";
		String targetdata = "views/Data.jsp";
		UserBean user = new UserBean();
		CustomerService customerService = new CustomerServiceImpl();
		
		
		switch(path){
		case "/Reg.obj":
			{target=targetReg;
			break;}
//////////////////////////////////////////////		
		case "/Login.obj":
			{
			String uName = request.getParameter("uname");
			String pwd =  request.getParameter("pwd");
			System.out.println(uName);
			CSI datagetter = new CSI();
			int i=0;
			ArrayList<UserBean> udatalog;
			try {
				udatalog = datagetter.fakeget();
				UserBean currentf=null;
				for (UserBean current : udatalog)
				{
				if (uName.equals(current.getUserName()) && pwd.equals(current.getPwd()))
				{ currentf=current; 
				//
				System.out.println("i am in"+current.getUserName());
				System.out.println("i am in"+current.getPwd());
				//
				System.out.println(currentf.getUserName());
				session.setAttribute("user", currentf);
				session.setAttribute("info", "R");
				target = targetHome;i=1;
				break;
				}
				
				}
				if (i==0){target = targetReg;
				session.setAttribute("info", "NR");
				break;}
				
			} catch (AirSpaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			break;}
//////////////////////////////////////////////////////		
		case "/Getdata.obj":
			{CSI dataget = new CSI();
			try{
			ArrayList<UserBean> udata=dataget.fakeget();
			session.setAttribute("data", udata);
			session.setAttribute("length",udata.size() );
			target= targetdata;
			}
			catch (AirSpaceException e){}
			break;
			}
		
		case "/Register.obj":
			{String name  = request.getParameter("name");
			String uName = request.getParameter("uname");
			String mobileNo = request.getParameter("mobileno");
			String pwd =  request.getParameter("pwd");
			
			//User details are added to the bean object and then added to Database by calling Service Layer.
			
			user.setName(name);
			user.setUserName(uName);
			user.setPwd(pwd);
			user.setMobileNo(mobileNo);
			
			try {
				customerService.addUser(user);
				session.setAttribute("user", user);
			} catch (AirSpaceException e) {
				// TODO Auto-generated catch block
				session.setAttribute("error", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(targetError);
				dispatcher.forward(request, response);
				System.err.println(e.getMessage());
			}
			target = targetHome;
			break;}
		//Forwards to payment page
		case "/Payment.obj":
			/*String mobile = ((UserBean)session.getAttribute("user")).getMobileNo();
			session.setAttribute("mobileNo",mobile);*/			
			{target = targetPay;
			break;}
		
		//Success page is invoked
		case "/Result.obj":
			{Integer price = Integer.parseInt(request.getParameter("result"));
			Integer Balance = 750-price;
			session.setAttribute("balance", Balance);
			target = targetSuccess;
			break;}
		case "/Back.obj":
			{session.setAttribute("error", null);
			target = targetReg;
			break;}
		}
		
		//InterServlet Communication is done by using RequesDispatcher and then forwarding the response.
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	
}}
