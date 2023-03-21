package Servlet;

import DAO.ProductDAO;
import POJO.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns =  {"/"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String logout = req.getParameter("logout");
            if(logout!=null){
                req.getSession().invalidate();
                resp.sendRedirect("./login");
                return;
            }
            String mode = req.getParameter("mode");
            if (mode!=null && mode.contains("delete")){
                String id = req.getParameter("id");
                if (ProductDAO.getInstance().remove(Integer.parseInt(id))){
                    resp.sendRedirect("./?delete=true");
                }
                else {
                    resp.sendRedirect("./?delete=false");
                }
                return;
            }
            req.setAttribute("list", ProductDAO.getInstance().getAll());
            req.getRequestDispatcher("views/index.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String price = req.getParameter("price");
            if (name == null || price == null) {
                resp.sendRedirect("?name-or-price-not-null");
            } else {
                if (ProductDAO.getInstance().add(new Product(0, name, Integer.parseInt(price)))) {
                    resp.sendRedirect("./");
                } else {
                    resp.sendRedirect("?add=false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
