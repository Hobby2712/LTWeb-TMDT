package APIResource.user;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.CartDAO;
import DaoImpl.CartDAOImpl;
import Entity.api.APIResponse;



@WebServlet(urlPatterns = {"/api/v1/addCartItems/*"})
public class AddCartItemsApi extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        //String pathInfo = req.getPathInfo();
        String id = req.getParameter("id");
        int intID = Integer.parseInt(id);
        String pid = req.getParameter("pid");
        int intPID = Integer.parseInt(id);
        String quantity = req.getParameter("quantity");
        int intQuantity = Integer.parseInt(quantity);
		CartDAO dao = new CartDAOImpl();
		int cId = dao.getCartIdByUId(intID);
		
		try{
			dao.insertCartItemDetail(cId, intPID, intQuantity);
			APIResponse<String> response = new APIResponse<>("Thêm giỏ hàng thành công", false);
			// Chuyển đổi đối tượng JSON thành chuỗi và trả về cho client
			OutputStream outputStream = resp.getOutputStream();
		    Gson gson = new Gson();
		    outputStream.write(gson.toJson(response).getBytes());
		    outputStream.flush();

	}catch (Exception e) {
        e.printStackTrace();
        APIResponse<String> response = new APIResponse<>("Thêm giỏ hàng thất bại", false);
		// Chuyển đổi đối tượng JSON thành chuỗi và trả về cho client
		OutputStream outputStream = resp.getOutputStream();
	    Gson gson = new Gson();
	    outputStream.write(gson.toJson(response).getBytes());
	    outputStream.flush();
    }
    }
}
