<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quest</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<body>
	<script src="script.js"></script>
	<script src="jquery.js"></script>
	

	<div id="login">
		<div class="topcorner">
			<s:form name="validation" id="validation" action="#" method="post">
				<input class="float-right" type="button" onclick="registerForm()" id="registerButton" value="Register" />
				<input class="float-right" type="submit" id="loginSubmit" name="loginSubmit" value="Login" />
				<input class="textbox float-right" tabindex=2 type="password" name="password" id="password" placeholder="Password" required="required"/>
				<input class="textbox float-right" tabindex=1 type="text" name="username" id="username" placeholder="Username" required="required" />
			</s:form>
		</div>
		<div id="reg1" style="height:50px;display:none;">
			<s:form name="register" id="register" action="#" method="post">
			<input id="registerSubmit" type="submit" onsubmit="validateRegistration()" value="submit" />
			<input class="textbox" type="text" name="password" placeholder="Password" required="required" />
			<input class="textbox" type="text" name="inumber" placeholder="SAP ID" required="required" />
			<input class="textbox" type="text" name="userid" placeholder="User Name" required="required" />
			</s:form>
		</div>
		<div class="topcorner-err">
			<div class="topseccorner float-right" id="register"></div>
			<div class="topthirdcorner float-right" id="error"></div>
			<div class="header float-right" id="header"></div>
		</div>
	</div>
	
	<div class="topcorner-logout">
		<div class="topcorner">
			<input type="button" id="logoutId" name="Logout" value="Logout" class="float-right" style="display:none;">
		</div>
	</div>
	
	
	<div id="fileUpload">
		<input type="file" id="myFile" size="50" style="display:none;">
		<button type="button" id="filebtn" onclick="uploadFile()" style="display:none;">Import</button>
		<p id="fileDiv"></p>
	</div>
	

	<div class="center-search" id="sea">
		<div class="search">
			<input class="searchbox" id="searchid" type="text" name="search" onkeyup="loadQuestions()" onclick="" />
		</div>
		<div class="adder">
			<a href="#" style="text-decoration: none; color: gray;">
				Add Question
			</a>
		</div>
	</div>
	
	<div class="list-group">
  		<a href="#" class="list-group-item active">
	    	Cras justo odio
  		</a>
  		<a href="#" class="list-group-item">l1</a>
  		<a href="#" class="list-group-item">l2</a>
  		<a href="#" class="list-group-item">l3</a>
  		<a href="#" class="list-group-item">l4</a>
	</div>
	
	<div class="hidden">
		<s:form name="question" id="question" action="#" method="post">
			<table class="question-form-table">
				<caption class="question-form-title">
					Add Your Question
				</caption>
				<tr>
					<td class="question-form-lbl-cntr">
						<span>Title</span>
					</td>
					<td colspan="2">
						<input id="summaryid" placeholder="Please be specific..." type="text" name="summary"  required="required"/>
					</td>
				</tr>
				<tr>
					<td class="question-form-lbl-cntr">
						<span>Description</span>
					</td>
					<td colspan="2">
						<textarea id="questionDesc" placeholder="Describe your question" name="questionDesc" onkeyup="textAreaAdjust(this)"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<select	id="team" name="team" class="custom-select1" required="required">
							<option disabled selected value="">Team</option>
							<option value="payroll">EC-Payroll</option>
							<option value="sbs">EC-SBS</option>
							<option value="timeoff">Time Off</option>
							<option value="imports">Imports</option>
						</select>
					</td>
					<td>
						<select id="category" name="category" class="custom-select2">
							<option disabled selected value="">Category</option>
							<option value="issue">Issue</option>
							<option value="feature">Feature</option>
							<option value="information">Information</option>
						</select>
					</td>
					<td>
						<select id="subCategory" name="subCategory" class="custom-select3">
							<option disabled selected value="">Sub Category</option>
							<option value="replicationError">Replication Errors</option>
							<option value="payrollRun">Payroll run</option>
							<option value="paymentInformation">Payment Information</option>
							<option value="ptp">PTP</option>
							<option value="mapping">Mapping</option>
							<option value="erpFilter">ERP filter</option>
							<option value="pp3">PP3</option>
							<option value="rbp">RBP</option>
							<option value="boomi">Boomi</option>
							<option value="alternativeCostDistribution">Alternative Cost Distribution</option>
							<option value="hci">HCI</option>
							<option value="provisioning">Provisioning</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="question-form-lbl-cntr">
						<span>Answer</span>
					</td>
					<td colspan="2">
						<textarea id="answer" placeholder="Describe your answer" name="answer" onkeyup="textAreaAdjust(this)"></textarea>
					</td>
				</tr>
				<caption align="bottom" class="question-form-submit">
					<input id="submitId" type="submit" value="Submit" />
					<input id="cancel" type="button" value="Cancel" />
				</caption>
			</table>
		</s:form>
	</div>
	
	<div id="questionsList"></div>
    <div></div>
    
    
</body>
</html>