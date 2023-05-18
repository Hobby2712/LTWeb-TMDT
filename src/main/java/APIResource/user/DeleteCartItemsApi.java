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

import DAO.CartDAO;
import DAO.UserDAO;
import DaoImpl.CartDAOImpl;
import DaoImpl.UserDAOImpl;
import Entity.Product;
import Entity.User;
import Entity.api.APIResponse;

@WebServlet(urlPatterns = {"/api/v1/deleteCart/*"})
public class DeleteCartItemsApi extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        //String pathInfo = req.getPathInfo();
        String id = req.getParameter("id");
        int intID = Integer.parseInt(id);
		CartDAO dao = new CartDAOImpl();
		
		try{
			dao.deleteAllItemCart(dao.getCartIdByUId(intID));
			APIResponse<String> response = new APIResponse<>("Xóa hết sản phẩm trong giỏ hàng thành công", false);
			// Chuyển đổi đối tượng JSON thành chuỗi và trả về cho client
			OutputStream outputStream = resp.getOutputStream();
		    Gson gson = new Gson();
		    outputStream.write(gson.toJson(response).getBytes());
		    outputStream.flush();

	}catch (Exception e) {
        e.printStackTrace();
        APIResponse<String> response = new APIResponse<>("Xóa hết sản phẩm trong giỏ hàng thất bại", false);
		// Chuyển đổi đối tượng JSON thành chuỗi và trả về cho client
		OutputStream outputStream = resp.getOutputStream();
	    Gson gson = new Gson();
	    outputStream.write(gson.toJson(response).getBytes());
	    outputStream.flush();
    }
    }

}
	