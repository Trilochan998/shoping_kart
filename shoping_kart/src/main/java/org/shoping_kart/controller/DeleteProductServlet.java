package org.shoping_kart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shoping_kart.dao.ProductDao;
import org.shoping_kart.dto.User;

@WebServlet("/deleteproduct")
public class DeleteProductServlet  extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				User u= (User)req.getSession().getAttribute("user");
	
				if(u!=null) {
					Integer pid=Integer.parseInt(req.getParameter("pid"));
					ProductDao pd=new ProductDao();
					pd.deleteProduct(pid);
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}else {
					resp.sendRedirect("Login.jsp");
				}
			}
}
