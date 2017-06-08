import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

public class LoginFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		String url = new String(servletRequest.getRequestURL());
		if (url.contains("index")||url.contains("image")||url.contains("style")) {
			System.out.println("index");
			filterChain.doFilter(request, response);
			return;
		}
		if (servletRequest.getSession().getAttribute("existEmployee") != null) {
			filterChain.doFilter(request, response);
		} else {
			servletResponse.sendRedirect("index.jsp");
			System.out.println("未登录");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
