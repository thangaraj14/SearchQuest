function registerUsers(uname, inum, pwd) {

	var url = "registerdb.jsp?uname=" + uname + "&inum=" + inum + "&pwd=" + pwd;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);
		request.send();
		hideRegister(uname);
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function checkQuestion(valueArray) {
	var url = "checkQuestiondb.jsp?summary=" + valueArray[0];
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);
		request.send();
		hideRegister(uname);
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function insertQuestion(varArray) {

	var url = "insertQuestiondb.jsp?summary=" + summary + "&questionDesc="
			+ questionDesc + "&team" + getTeam + "&category" + getCategory
			+ "&subCategory" + getSubCategory;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);
		request.send();
		hideRegister(uname);
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function hideRegister(uname) {
	$("#reg1").hide();
	// header.innerHTML = "Welcome " + uname;
}
function validateRegistration() {
	var uname = document.getElementsByName("userid")[0].value;
	alert(uname);
	var inum = document.getElementsByName("inumber")[0].value;
	var pwd = document.getElementsByName("rpassword")[0].value;
	registerUsers(uname, inum, pwd);
	return true;
}

function registerForm() {
	$("#reg1").show();
}

function loadQuestions() {
	var v = document.getElementById("searchid").value;
	var url = "db.jsp?val=" + v;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);
		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function getInfo() {
	if (request.readyState == 4) {
		var val = request.responseText;
		for(var key in val){
			val;
		}
		document.getElementById('questionsList').innerHTML = val;
		
	}
}
function hideOptions() {
	$(".hidden").hide();
	$("#sea").show();
	$(".adder").show();
	$("#question").find("input[type=text], textarea, select").val("");
	$("#question").find("select").change();
}
function textAreaAdjust(o) {
	o.style.height = "1px";
	o.style.height = (25 + o.scrollHeight) + "px";
}
function uploadFile() {
    var x = document.getElementById("myFile").value;
    document.getElementById("fileDiv").innerHTML = x;
}