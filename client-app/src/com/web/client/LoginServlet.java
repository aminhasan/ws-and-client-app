package com.web.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.client.dto.ApplicationLog;
import com.web.client.service.LoginService;

@WebServlet(description = "Fetch logs from REST WS", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user, password;
		user = request.getParameter("user");
		password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		
		LoginService loginService = new LoginService();
		ApplicationLog[] applLogs = loginService.fetchAppLogs(user, password);
		
		
		if (applLogs == null) {
			request.setAttribute("error", "Please check your credentials");
			
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
		request.setAttribute("logs", applLogs);
		
		dispatcher =  request.getRequestDispatcher("showLogs.jsp");
		dispatcher.forward(request, response);
	
	}

}
