package org.shoping_kart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shoping_kart.dao.UserDao;
import org.shoping_kart.dto.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			long phone=Long.parseLong(req.getParameter("ph"));
			String password=req.getParameter("pw");
			UserDao ud=new UserDao();
			    User user = ud.verifyUser(phone, password);
			   RequestDispatcher rd=null;
			   PrintWriter pw=resp.getWriter();
			   if(user!=null) {
				   HttpSession session=req.getSession();
				      session.setAttribute("user",user);
				      rd=req.getRequestDispatcher("Home.jsp");
				         rd.forward(req, resp);
			   }
			   else {
				   pw.println("<html><body><h1>Invalid Phone & Password</h1></body></html>");
				   rd=req.getRequestDispatcher("Login.jsp");
				   rd.include(req, resp);
			   }
			   
		}
}
