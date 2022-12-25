package Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DaoImpl.CategoryDAOImpl;
import Entity.Category;

@WebServlet(urlPatterns = { "/verifyForgot" })
public class VerifyAccountForgotPass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryDAO category = new CategoryDAOImpl();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username_email = request.getParameter("user");
		String otp = request.getParameter("otp");
		String otp_send = request.getParameter("otpSend");

		// Category(Header)
		List<Category> clist = category.getAllCategory1();
		request.setAttribute("cList", clist);
		List<Category> clist2 = category.getAllCategory2();
		request.setAttribute("cList2", clist2);

		if (!otp.equals(otp_send)) {
			request.setAttribute("mess", "Mã OTP sai!");
			request.setAttribute("user", username_email);
			request.setAttribute("otpSend", otp_send);
			request.setAttribute("action", "verifyForgot");
			request.setAttribute("cancel", "/Web/loginAccount");
			request.getRequestDispatcher("/views/web/otp.jsp").forward(request, response);
		} else {
			request.setAttribute("username_email", username_email);
			request.getRequestDispatcher("/views/web/forget-password.jsp").forward(request, response);
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

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
