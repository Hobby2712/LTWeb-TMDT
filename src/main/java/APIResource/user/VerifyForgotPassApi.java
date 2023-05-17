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

@WebServlet(urlPatterns = {"/api/v1/verifyForgotPass/*"})
public class VerifyForgotPassApi extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO u = new UserDAOImpl();
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		String email = req.getParameter("email");
		String newpass = req.getParameter("newpass");
		//String pass = req.getParameter("pass");
		String otp = req.getParameter("otp");
		String otp_send = req.getParameter("otpSend");
		
		if (!otp.equals(otp_send)) {
			//req.setAttribute("mess", "Mã OTP sai!");
			APIResponse<String> response1 = new APIResponse<>("OPT không trùng khớp", true);
			OutputStream outputStream = resp.getOutputStream();
		    Gson gson = new Gson();
		    outputStream.write(gson.toJson(response1).getBytes());
		    outputStream.flush();    
		   // req.setAttribute("id", id);
        	req.setAttribute("newpass", newpass);
        	req.setAttribute("email", email);
        	req.setAttribute("otpSend", otp_send);
        	//req.setAttribute("action", "verify");
        	//req.setAttribute("cancel", "/Web/loginAccount");
			//req.getRequestDispatcher("/views/web/otp.jsp").forward(req, resp);
		    
		} else {
			u.changPass(email,newpass);
			APIResponse<String> response = new APIResponse<>("OTP trùng khớp, đã đổi mật khẩu", false);
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
	