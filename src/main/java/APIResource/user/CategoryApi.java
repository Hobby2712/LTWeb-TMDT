package APIResource.user;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.CategoryDAO;
import DaoImpl.CategoryDAOImpl;
import Entity.Category;
import Entity.Product;
import Entity.api.APIResponse;

@WebServlet(urlPatterns = "/api/v1/categories/*")
public class CategoryApi extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final CategoryDAO categoryDao;
	public CategoryApi() {
		this.categoryDao = new CategoryDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
		String pathInfo = req.getPathInfo();
	    if (pathInfo == null || pathInfo.equals("/")) {
	    	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        APIResponse<String> response = new APIResponse<>("URL không đúng", true);
	        OutputStream outputStream = resp.getOutputStream();
	        Gson gson = new Gson();
	        outputStream.write(gson.toJson(response).getBytes());
	        outputStream.flush();
	    } else {
	    	if (pathInfo.equals("/cate1")) {
	            // Xử lý cho URL /api/v1/categories/cate1
	    		APIResponse<List<Category>> response = new APIResponse<>("success", false, "categories1", categoryDao.getAllCategory1());
	            OutputStream outputStream = resp.getOutputStream();
	            Gson gson = new Gson();
	            outputStream.write(gson.toJson(response).getBytes());
	            outputStream.flush();
	        } else if (pathInfo.equals("/cate2")) {
	            // Xử lý cho URL /api/v1/categories/cate2
	        	APIResponse<List<Category>> response = new APIResponse<>("success", false, "categories2", categoryDao.getAllCategory2());
	            OutputStream outputStream = resp.getOutputStream();
	            Gson gson = new Gson();
	            outputStream.write(gson.toJson(response).getBytes());
	            outputStream.flush();
	        } else {
	            // Xử lý cho các URL khác
	        	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		        APIResponse<String> response = new APIResponse<>("URL không đúng", true);
		        OutputStream outputStream = resp.getOutputStream();
		        Gson gson = new Gson();
		        outputStream.write(gson.toJson(response).getBytes());
		        outputStream.flush();
	        }
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
