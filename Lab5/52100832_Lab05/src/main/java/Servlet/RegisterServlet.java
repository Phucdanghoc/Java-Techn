package Servlet;

import DAO.UserDAO;
import POJO.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    public static HttpSession httpSession(HttpServletRequest req, HttpServletResponse resp,String username,String password){
        HttpSession session = req.getSession();
        session.setAttribute("usernameSS",username);
        session.setAttribute("passwordSS",password);
        return  session;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("usernameSS")!=null){
            resp.sendRedirect("./");
            return;
        }
        req.getRequestDispatcher("views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password  = req.getParameter("password");
            String  passwordConfirm =  req.getParameter("password-confirm");

            if (!passwordConfirm.equals(password)){
                resp.sendRedirect("?pass-err");
            }else {
                if(UserDAO.getInstance().add(new User(0,username,email,password))){
                    httpSession(req,resp,username,password);
                    resp.sendRedirect("./login");

                }else {
                    resp.sendRedirect("?add=false");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
