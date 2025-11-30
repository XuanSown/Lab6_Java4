package servlet;

import java.io.IOException;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import filter.AuthFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAOImpl();
		User user = dao.findById(username);

		if (user == null) {
			req.setAttribute("message", "Sai username");
		} else if (!user.getPassword().equals(password)) {
			req.setAttribute("message", "Sai password");
		} else {
			req.setAttribute("message", "Login thành công");
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			// Kiểm tra xem có cần quay lại trang bị chặn trước đó không
			// (Key "securityUri" được lưu bên AuthFilter ở Bài 2)
			String securityUri = (String) session.getAttribute(AuthFilter.SECURITY_URI);

			if (securityUri != null) {
				// xóa uri để tránh redirect lặp lại lần sau
				session.removeAttribute(AuthFilter.SECURITY_URI);
				resp.sendRedirect(securityUri);
				return;
			}
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
