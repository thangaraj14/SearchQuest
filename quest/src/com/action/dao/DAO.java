package com.action.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.action.db.DBConnection;

public class DAO {

	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;

	public Boolean executeResponseQuery(String query) throws SQLException {
		int result = 0;
		try {
			resultSet = getConnection().executeQuery(query);

			while (resultSet.next()) {
				result = resultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		if (result >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public void executeInsertQuery(String query) throws SQLException {
		try {
			getConnection().executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private Statement getConnection() throws SQLException {
		connection = DBConnection.getConnection();
		statement = connection.createStatement();
		return statement;
	}

}
