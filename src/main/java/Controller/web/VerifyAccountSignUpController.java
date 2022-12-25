package Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.UserDAO;
import DaoImpl.CategoryDAOImpl;
import DaoImpl.UserDAOImpl;
import Entity.Category;
import Entity.User;

@WebServlet(urlPatterns = { "/verify" })
public class VerifyAccountSignUpController extends HttpServlet {

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

		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String otp = request.getParameter("otp");
		String otp_send = request.getParameter("otpSend");
		
		//Category(Header)
		List<Category> clist = category.getAllCategory1();
		request.setAttribute("cList", clist);
		List<Category> clist2 = category.getAllCategory2();
		request.setAttribute("cList2", clist2);
		
		if (!otp.equals(otp_send)) {
			request.setAttribute("mess", "Mã OTP sai!");
			request.setAttribute("user", user);
        	request.setAttribute("pass", pass);
        	request.setAttribute("email", email);
        	request.setAttribute("otpSend", otp_send);
        	request.setAttribute("action", "verify");
        	request.setAttribute("cancel", "/Web/loginAccount");
			request.getRequestDispatcher("/views/web/otp.jsp").forward(request, response);
		} else {
			UserDAO dao = new UserDAOImpl();
			dao.singup(user, pass, email);
			User u = dao.login(user, pass);
			HttpSession session = request.getSession();
			session.setAttribute("acc", u);
			session.setMaxInactiveInterval(1000);
			response.sendRedirect("home");
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