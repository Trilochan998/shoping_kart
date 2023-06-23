package org.shoping_kart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shoping_kart.dao.ProductDao;
import org.shoping_kart.dto.Product;
import org.shoping_kart.dto.User;

@WebServlet("/cart")
public class ViewProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		ProductDao pd = new ProductDao();
		List<Product> products = pd.findProductByUserId(u.getId());
		req.setAttribute("products", products);
		RequestDispatcher rd = req.getRequestDispatcher("fetchProduct.jsp");
		rd.forward(req, resp);
	}
}
