<%@ page import="java.sql.*"%>

<%
	String s = request.getParameter("val");
	if (s == null || s.trim().equals("")) {
		
	} else {
		out.print(s);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quest", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from question where question LIKE \"%" + s + "%\"");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.print(rs.getString(1) + "\n " + rs.getString(2) + "\n " + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>