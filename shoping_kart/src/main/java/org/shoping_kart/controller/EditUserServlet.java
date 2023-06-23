package org.shoping_kart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shoping_kart.dao.UserDao;
import org.shoping_kart.dto.User;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		 int age=Integer.parseInt(req.getParameter("age"));
		String password = req.getParameter("pswd");
		String gender = req.getParameter("gen");
		String email = req.getParameter("email");
		Long phone = Long.parseLong(req.getParameter("phone"));
	
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setAge(age);
		u.setEmail(email);
		u.setGender(gender);
		u.setPassword(password);
		u.setPhone(phone);

		UserDao ud = new UserDao();
		  u=ud.updataUser(u);
		// this session for updated data will be store in current session otherwise the
		// previous data will be shown
		HttpSession session = req.getSession();
		session.setAttribute("user", u);
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body><h1>User will be updated</h1></body></html>");

	}
}
