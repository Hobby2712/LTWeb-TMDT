package Controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.CategoryDAO;
import DaoImpl.CategoryDAOImpl;
import Entity.Category;
import Util.Constant;

@WebServlet(urlPatterns = { "/admin/addcategory" })
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryDAO dao = new CategoryDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/CategoryManagement.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category cate = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			List<FileItem> items = servletFileUpload.parseRequest((HttpServletRequest) req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					cate.setName(item.getString("UTF-8"));
				}
				if (item.getFieldName().equals("parent_category")) {
					cate.setcIdBig(Integer.parseInt(item.getString("UTF-8")));
				}
				if (item.getFieldName().equals("image")) {

					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/uploads/category/" + fileName);
					item.write(file);
					cate.setImage("/uploads/category/" + fileName);
				}

			}

			dao.addCategory2(cate);

			resp.sendRedirect("ManagerCategory");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
