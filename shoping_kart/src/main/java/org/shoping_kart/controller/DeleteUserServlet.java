package org.shoping_kart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shoping_kart.dao.UserDao;
import org.shoping_kart.dto.User;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
			User u = (User)session.getAttribute("user");
			if(u!=null) {
				int id=u.getId();
				UserDao ud=new UserDao();
				ud.deleteUser(id);
				session.invalidate();
				req.setAttribute("msg","Your Account is deleted");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				   rd.forward(req, resp);
			}else {
				resp.sendRedirect("Login.jsp");
			}
			
		}
}
