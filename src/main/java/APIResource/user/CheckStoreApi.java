package APIResource.user;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.StoreDAO;
import DaoImpl.StoreDAOImpl;
import Entity.Store;
import Entity.api.APIResponse;

@WebServlet(urlPatterns = {"/api/v1/stores"})
public class CheckStoreApi extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private final StoreDAO storeDao;
	public CheckStoreApi() {
		this.storeDao = new StoreDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String userId = req.getParameter("user");
		try {
			int id = Integer.parseInt(userId);
		} catch (NumberFormatException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			APIResponse<String> response = new APIResponse<>("Sai format", true);
			sendJsonResponse(resp, response);
			return;
		}
		
		if (userId != null && !userId.isEmpty()) {
			int storeId = storeDao.GetStoreIdFromUID(Integer.parseInt(userId));
			if(storeId <= 0) {
				APIResponse<String> response = new APIResponse<>("Không tìm thấy cửa hàng", true);
				sendJsonResponse(resp, response);
			} else {
				Store store = storeDao.getStoreById(storeId);
				if(store != null) {
					APIResponse<Store> response = new APIResponse<>("success", false, "store", store);
					sendJsonResponse(resp, response);
				} else {
					APIResponse<String> response = new APIResponse<>("Có lỗi xảy ra khi lấy thông tin cửa hàng", true);
					sendJsonResponse(resp, response);
				}
			}
		}
	}
	
	private <T> void sendJsonResponse(HttpServletResponse resp, APIResponse<T> response) throws IOException {
		OutputStream outputStream = resp.getOutputStream();
		Gson gson = new Gson();
		outputStream.write(gson.toJson(response).getBytes());
		outputStream.flush();
	}

}
