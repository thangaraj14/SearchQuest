package com.action.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.action.dao.DAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

	private static final long serialVersionUID = 1L;
	private String username = "";
	private String password = "";
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> sessionMap;

	public String execute() throws SQLException, IOException {

		DAO dao = new DAO();
		Boolean result = dao.executeResponseQuery(
				"select count(*) from registration where username='" + username + "' and password='" + password + "'");
		PrintWriter pr = response.getWriter();
		if (result) {
			sessionMap.put("userid", username);
			if (username.equalsIgnoreCase("admin")) {
				pr.write("admin");
				pr.close();
			}
			pr.write("success");

		} else {
			pr.write("false");
		}
		pr.close();
		return NONE;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {

		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

	public String getSession() {
		return (String) sessionMap.get("userid");
	}

	public void removeSession() {
		System.out.println("getSession" + getSession());
		sessionMap.remove("userid");
	}

}