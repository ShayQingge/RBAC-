package com.athena.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.athena.pojo.Url;
import com.athena.pojo.Users;

@WebFilter("/*")
public class UrlFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		String uri = request.getRequestURI();
		System.out.println("uri=="+uri);
		if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif")){
			filterchain.doFilter(req, res);
		} else {
			if(uri.equals("/RBAC/login")||uri.equals("/RBAC/login.jsp")){
				filterchain.doFilter(req, res);
			} else {
				HttpSession session = request.getSession();
				//��¼��֤
				Object obj = session.getAttribute("user");
				if(obj!=null) {
					List<Url> listUrl = (List<Url>) session.getAttribute("allurl");
					boolean isExists = false;
					for (Url url : listUrl) {
						if(url.getName().equals(uri)) {
							isExists = true;
						}
					}
					//�����url��Ҫ����Ȩ�޿���
					if(isExists) {
						Users users = (Users) obj;
						boolean isRight = false;
						for (Url url : users.getUrls()) {
							System.out.println(url);
							if(url.getName().equals(uri)) {
								isRight = true;
							}
						}
						//��¼�û��Ը�uri���з���Ȩ��
						System.out.println("isRight===="+isRight);
						if(isRight) {
							filterchain.doFilter(req, res);
						} else {
							//���session������
							session.removeAttribute("user");
							session.removeAttribute("allurl");
							((HttpServletResponse)res).sendRedirect("/RBAC/login.jsp");
						}
					}else {
						filterchain.doFilter(req, res);
					}
				} else {
					//δ��¼
					((HttpServletResponse)res).sendRedirect("/RBAC/login.jsp");
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
