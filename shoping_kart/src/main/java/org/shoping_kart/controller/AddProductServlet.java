package org.shoping_kart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shoping_kart.dao.ProductDao;
import org.shoping_kart.dto.Product;
import org.shoping_kart.dto.User;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("desc");
		String brand = req.getParameter("brand");
		String catagory = req.getParameter("cat");
		String image = req.getParameter("image");
		double price = Double.parseDouble(req.getParameter("price"));
		Product p = new Product();
		p.setName(name);
		p.setDescription(description);
		p.setBrand(brand);
		p.setCatagory(catagory);
		p.setImage(image);
		p.setPrice(price);
		ProductDao pd = new ProductDao();
		User u = (User) req.getSession().getAttribute("user");
		pd.saveProduct(p, u.getId());

		PrintWriter pw = resp.getWriter();
		pw.println("<html><body><h1>Product added successfully in user Id: " + u.getId() + "</h1></body></html>");

	}
}
