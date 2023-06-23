package org.shoping_kart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shoping_kart.dao.UserDao;
import org.shoping_kart.dto.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("pswd");
		String name=req.getParameter("name");
		String gender=req.getParameter("gen");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		  User u=new User();
		    u.setName(name);
		    u.setAge(age);
		    u.setEmail(email);
		    u.setGender(gender);
		    u.setPassword(password);
		    u.setPhone(phone);
		    
		    UserDao dao=new UserDao();
		    u=dao.saveUser(u);
		    PrintWriter pw=resp.getWriter();
		    pw.println("<html><body><h1>User Registered with Id:"+u.getId()+"</h1></body></html>");
		
	}
}
