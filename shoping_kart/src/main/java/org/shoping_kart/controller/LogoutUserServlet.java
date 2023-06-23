package org.shoping_kart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.getSession().invalidate();
		 req.setAttribute("msg","Your account is logedout");
		 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		 rd.forward(req, resp);
	}
}
