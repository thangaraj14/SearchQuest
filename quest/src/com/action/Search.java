package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.action.dao.DAO;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport {

	private static final long serialVersionUID = 1L;

	String question = "";
	private HttpServletResponse response;

	public String execute() {
				
		String query=formQuery(question);

		DAO dao = new DAO();

		try {
			PrintWriter pr = response.getWriter();
			if (dao.executeResponseQuery(query)) {
				System.out.println("testing ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return NONE;
	}

	private String formQuery(String question) {
		String[] stringArray=question.split("");
		stringArray=removeStopperWords(stringArray);
		return null;
	}

	private String[] removeStopperWords(String[] stringArray) {
		
		return null;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
