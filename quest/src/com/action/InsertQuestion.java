package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;

import com.action.dao.DAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InsertQuestion extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, SessionAware {

	private String questionDesc = null;
	private String summary = null;
	private String team = null;
	private String subCategory = null;
	private String category = null;
	private String answer = null;
	private HttpServletResponse response;
	private HttpServletRequest resquest;
	private Map<String, Object> sessionMap;

	private static final long serialVersionUID = 1L;

	public String execute() throws ServletException, IOException, JSONException {
		DAO dao = new DAO();
		DateTimeZone timeZone = DateTimeZone.forID("Europe/Paris");
		DateTime todayStart = new DateTime(timeZone).withTimeAtStartOfDay();
		String date = ISODateTimeFormat.date().print(todayStart);

		String loggedUserName = (String) ActionContext.getContext().getSession().get("userid");

		System.out.println("userid" + loggedUserName);

		String query = "INSERT INTO question(question, sub_category, team, category, created_date, author, last_modified_date, answer, questiondesc)"
				+ " VALUES ('" + summary + "','" + subCategory + "','" + team + "','" + category + "','" + date + "','"
				+ loggedUserName + "','" + date + "','" + answer + "','" + questionDesc + "')";

		System.out.println(query);

		String selectQuery = "SELECT count(*) FROM `question` WHERE question='" + summary + "'";
		

		try {
			PrintWriter pr = response.getWriter();
			if (loggedUserName != null) {
				if (dao.executeResponseQuery(selectQuery)) {
					pr.write("fail");
				} else {
					dao.executeInsertQuery(query);
					pr.write("success");
					pr.close();
					return NONE;
				}
			} else {
				System.out.println("InsertQuestion.execute() 1");
				pr.write("invalid");
			}
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return NONE;

	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String data) {
		this.questionDesc = data;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.resquest = arg0;

	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getResquest() {
		return resquest;
	}

	public void setResquest(HttpServletRequest resquest) {
		this.resquest = resquest;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}
}
