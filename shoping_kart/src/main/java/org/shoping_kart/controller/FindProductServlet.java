package org.shoping_kart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shoping_kart.dao.ProductDao;
import org.shoping_kart.dto.Product;

@WebServlet("/find")
public class FindProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		ProductDao pd = new ProductDao();
		Product p = pd.findProductById(pid);
		if (p != null) {
			RequestDispatcher rd = req.getRequestDispatcher("editProduct.jsp");
			req.setAttribute("products", p);
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("Login.jsp");
		}
	}
}
