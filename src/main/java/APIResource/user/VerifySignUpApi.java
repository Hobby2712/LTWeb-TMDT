package APIResource.user;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DAO.UserDAO;
import DaoImpl.UserDAOImpl;
import Entity.User;
import Entity.api.APIResponse;

@WebServlet(urlPatterns = {"/api/v1/verifySignUp/*"})
public class VerifySignUpApi extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		String otp = req.getParameter("otp");
		String otp_send = req.getParameter("otpSend");
		
		if (!otp.equals(otp_send)) {
			APIResponse<String> response1 = new APIResponse<>("OPT không trùng khớp", true);
			OutputStream outputStream = resp.getOutputStream();
		    Gson gson = new Gson();
		    outputStream.write(gson.toJson(response1).getBytes());
		    outputStream.flush();
		    
			//req.setAttribute("mess", "Mã OTP sai!");
			req.setAttribute("user", user);
        	req.setAttribute("pass", pass);
        	req.setAttribute("email", email);
        	req.setAttribute("otpSend", otp_send);
        	//req.setAttribute("action", "verify");
        	//req.setAttribute("cancel", "/Web/loginAccount");
			//req.getRequestDispatcher("/views/web/otp.jsp").forward(req, resp);
			
			
		    
		} else {
			UserDAO dao = new UserDAOImpl();
			dao.singup(user, pass, email);
			User u = dao.login(user, pass);
			HttpSession session = req.getSession();
			session.setAttribute("acc", u);
			session.setMaxInactiveInterval(1000);
			resp.sendRedirect("home");
			
			APIResponse<User> response = new APIResponse<>("Đăng kí thành công", false, "user", u);
			OutputStream outputStream = resp.getOutputStream();
		    Gson gson = new Gson();
		    outputStream.write(gson.toJson(response).getBytes());
		    outputStream.flush();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
	