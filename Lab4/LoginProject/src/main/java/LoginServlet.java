import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        HashMap<String,String> Account = new HashMap<String,String>();
        Account.put("Admin","Admin");

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        boolean flag = false;
        for (String name:
                Account.keySet()) {
            if (username.equals(name) && password.equals(Account.get(name))){
                pw.println(String.format("%s / %s match .",username,password));
                flag = true;
                break;
            }
        }
        if (!flag){
            pw.println(String.format("%s / %s does not match.",username,password));
        }
        pw.close();
    }
}
