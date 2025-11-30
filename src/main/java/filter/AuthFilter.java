package filter;

import java.io.IOException;

import entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthFilter implements Filter {
	// lưu đuòng dẫn người dùng muốn vào trước khi bị chặn
	public static final String SECURITY_URI = "securityUri";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		// lấy đường dẫn hiện tại người dùng truy cập
		String uri = req.getRequestURI();

		// đăng nhập thành công
		boolean isLogin = (user != null);
		// đăng nhập thành công và là admin
		boolean isAdmin = (isLogin && Boolean.TRUE.equals(user.getAdmin()));

		if (!isLogin || (uri.contains("/admin/") && !isAdmin)) {
			session.setAttribute(SECURITY_URI, uri);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}
	}

}
