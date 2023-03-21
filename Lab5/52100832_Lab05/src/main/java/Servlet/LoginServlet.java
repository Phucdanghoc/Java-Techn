package Servlet;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public static HttpSession httpSession(HttpServletRequest req, HttpServletResponse resp,String username,String password){
        HttpSession session = req.getSession();
        session.setAttribute("usernameSS",username);
        session.setAttribute("passwordSS",password);
        return  session;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            Check Session
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String checked = req.getParameter("remember");
            if(!UserDAO.getInstance().CheckLogin(username,password)){
                httpSession(req,resp,username,password);
                if (checked!=null){
                    Cookie usernameCk = new Cookie("username",username);
                    Cookie passwordCk = new Cookie("password",password);
                    usernameCk.setMaxAge(60*60);
                    passwordCk.setMaxAge(60*60);
                    resp.addCookie(usernameCk);
                    resp.addCookie(passwordCk);
                }
                resp.sendRedirect("./");
            }else {
                resp.sendRedirect("./register");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("usernameSS")!=null){
            resp.sendRedirect("./");
            return;
        }
        req.getRequestDispatcher("views/login.jsp").forward(req,resp);
    }
}
