package com.action.search;

public class Search {
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String text) {
		this.search = text;
	}

	public String execute() {
		System.out.println("test");
		return "success";
	}
}
