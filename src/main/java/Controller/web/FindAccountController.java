package Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.UserDAO;
import DaoImpl.CategoryDAOImpl;
import DaoImpl.UserDAOImpl;
import Entity.Category;
import Entity.User;

@WebServlet(urlPatterns = { "/findAccount" })
public class FindAccountController extends HttpServlet {

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

		String username_email = request.getParameter("username_email");
		UserDAO dao = new UserDAOImpl();
        User u = dao.checkAccount(username_email);
        if(u != null){
            //Được đổi pass
        	String otp = dao.getRandom();
        	//Category(Header)
    		List<Category> clist = category.getAllCategory1();
    		request.setAttribute("cList", clist);
    		List<Category> clist2 = category.getAllCategory2();
    		request.setAttribute("cList2", clist2);
        	request.setAttribute("user", username_email);
        	request.setAttribute("otpSend", otp);
        	request.setAttribute("email", u.getEmail());
        	request.setAttribute("action", "verifyForgot");
        	request.setAttribute("cancel", "/Web/loginAccount");
        	dao.sendEmail(u.getEmail(), otp);
        	request.getRequestDispatcher("/views/web/otp.jsp").forward(request, response);
        }
        else{
            //day ve trang signup.jsp
        	request.setAttribute("mess", "Tài khoản không tồn tại");
        	request.getRequestDispatcher("/forgotAccountPass").forward(request, response);
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
