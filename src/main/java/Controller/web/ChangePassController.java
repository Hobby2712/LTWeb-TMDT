package Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.CategoryDAO;
import DAO.UserDAO;
import DaoImpl.CartDAOImpl;
import DaoImpl.CategoryDAOImpl;
import DaoImpl.UserDAOImpl;
import Entity.Category;
import Entity.User;

@WebServlet(urlPatterns = { "/changePassword" })
public class ChangePassController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryDAO category = new CategoryDAOImpl();
	CartDAO cart = new CartDAOImpl();
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("acc");

		String oldpass = request.getParameter("oldPass");
		String pass = request.getParameter("newPass");
		String repass = request.getParameter("repeatNewPass");

		// Category(Header)
		List<Category> clist = category.getAllCategory1();
		request.setAttribute("cList", clist);
		List<Category> clist2 = category.getAllCategory2();
		request.setAttribute("cList2", clist2);
		
		int countCart = cart.countCart(cart.getCartIdByUId(u.getId()));
		request.setAttribute("countC", countCart);

		if (!pass.equals(repass)) {
			request.setAttribute("mess", "Mật khẩu không khớp");
			request.getRequestDispatcher("/profile").forward(request, response);
		} else if (!oldpass.equals(u.getPass())) {
			request.setAttribute("mess", "Mật khẩu sai");
			request.getRequestDispatcher("/profile").forward(request, response);
		} else {
			UserDAO dao = new UserDAOImpl();
			// dc signup
			String otp = dao.getRandom();
			request.setAttribute("user", u.getUserName());
			request.setAttribute("pass", pass);
			request.setAttribute("email", u.getEmail());
			request.setAttribute("otpSend", otp);
			request.setAttribute("action", "verifyChangePass");
			request.setAttribute("cancel", "/Web/profile");
			dao.sendEmail(u.getEmail(), otp);
			request.getRequestDispatcher("/views/web/otp.jsp").forward(request, response);
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
