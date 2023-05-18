package APIResource.user;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DAO.UserDAO;
import DaoImpl.UserDAOImpl;
import Entity.User;
import Entity.api.APIResponse;

@WebServlet(urlPatterns = { "/api/v1/changePassword/*" })
public class ChangePasswordApi extends HttpServlet {

	/**
	 * 
	 */
	private final UserDAOImpl u = new UserDAOImpl();
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		
		String id = req.getParameter("id");
		
		//String user = req.getParameter(u.getUsernameById(id));		
		//String currentPass = req.getParameter(u.getPasswordById(id));
		String oldpass = req.getParameter("oldPass");
		String pass = req.getParameter("newPass");
		String repass = req.getParameter("repeatNewPass");
		
		
		
		try {
			if (!oldpass.equals(u.getPasswordById(id))){
				APIResponse<String> response = new APIResponse<>("Mật khẩu sai", true);
				OutputStream outputStream = resp.getOutputStream();
			    Gson gson = new Gson();
			    outputStream.write(gson.toJson(response).getBytes());
			    outputStream.flush();
				
			}else if (!pass.equals(repass)) {
				APIResponse<String> response = new APIResponse<>("Mật khẩu mới không trùng khớp", true);
				OutputStream outputStream = resp.getOutputStream();
			    Gson gson = new Gson();
			    outputStream.write(gson.toJson(response).getBytes());
			    outputStream.flush();
				
			}else{
				UserDAO dao = new UserDAOImpl();
				// dc signup
				String otp = dao.getRandom();
				System.out.print(otp);
				req.setAttribute("userId",id);
				req.setAttribute("pass", pass);
				req.setAttribute("email",u.getEmailById(id));
				req.setAttribute("otpSend", otp);
				//req.setAttribute("action", "verifyChangePass");
				//req.setAttribute("cancel", "/Web/profile");
				dao.sendEmail(u.getEmailById(id), otp);
				//req.getRequestDispatcher("/views/web/otp.jsp").forward(req, resp);
				
				APIResponse<String> response = new APIResponse<>("Đã gửi OTP thành công", false,"otp",otp);
				OutputStream outputStream = resp.getOutputStream();
			    Gson gson = new Gson();
			    outputStream.write(gson.toJson(response).getBytes());
			    outputStream.flush();
			}
		}catch(Exception e) {
		e.printStackTrace();
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Đã xảy ra lỗi khi xử lý request");
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