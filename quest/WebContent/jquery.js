$(document).ready(function() {

	$("#loginSubmit").click(function() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;

		$("#validation").submit(function(event) {

			event.preventDefault();

			$.ajax({
				type : 'POST',
				url : 'login.action',
				data : {
					'username' : username,
					'password' : password
				},
				success : function(response) {
					alert(response);
					if(response=="admin"){
						$('#myFile').show();
						$('#filebtn').show();
						$('#login').hide();
						$('#logoutId').show();
					}
					else if(response == "success") {
						$('#login').hide();
						$('#logoutId').show();
					} else {
						$('#error').text("Invalid Password");
					}
				}
			});
			return false;
		});
	});

	$("#logoutId").click(function() {

		event.preventDefault();
		$.ajax({
			type : 'POST',
			url : 'logout.action',
			success : function(response) {
				if (response == "success") {
					$('#login').show();
					$('#logoutId').hide();
				} else {
					$('#error').text("Do refresh");
				}
			}
		});
		return false;
	});

	$("#submitId").click(function() {

		$("#question").submit(function(event) {

			event.preventDefault();

			$.ajax({
				type : 'POST',
				url : 'insert.action',
				data : $(this).serialize(),
				success : function(response) {
					alert("success");
					hideOptions();
					if (response == "success") {
						$('#error').text("Thanks for adding the question");
					}
					if (response == "invalid") {
						$('#error').text("Please login to ask question");
					}
				},
				error : function(response) {
					alert("fail");
				}
			});
			return false;
		});
	});

	$("#seaBox").click(function() {
		event.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'search.action',
			data : {
				'question' : search
			},
			success : function(response) {
				alert("success");
			},
			error : function(response) {
				alert("error");
				hideOptions();
				alert("Couldn't submit question.");
				if (response == "success") {
					$('#error').text("Thanks for adding the question");
				}
				if (response == "invalid") {
					$('#error').text("Please login to ask question");
				}
			}
		});
		return false;

	});

	$("input").focus(function() {
		$(this).css("background-color", "#cccccc");
	});
	$("input").blur(function() {
		$(this).css("background-color", "#ffffff");
	});
});
$(document).ready(function() {
	$("#cancel").click(function() {
		$(".hidden").hide();
		$("#sea").show();
		$(".adder").show();
	});
	$("#registerButton").click(function() {
		$(".topcorner").hide();
	});
	$('.adder').click(function() {
		$('.hidden').show();
		$('.center-search').hide();
		$('.adder').hide();
	});
	$('.hidden').hide();
});
$(document).ready(function() {
	$(".custom-select1").each(function() {
		$(this).wrap("<span class='select-wrapper1'></span>");
		$(this).after("<span class='holder1'></span>");
	});
	$(".custom-select1").change(function() {
		var selectedOption = $(this).find(":selected").text();
		$(this).next(".holder1").text(selectedOption);
	}).trigger('change');
	$(".custom-select2").each(function() {
		$(this).wrap("<span class='select-wrapper2'></span>");
		$(this).after("<span class='holder2'></span>");
	});
	$(".custom-select2").change(function() {
		var selectedOption = $(this).find(":selected").text();
		$(this).next(".holder2").text(selectedOption);
	}).trigger('change');
	$(".custom-select3").each(function() {
		$(this).wrap("<span class='select-wrapper3'></span>");
		$(this).after("<span class='holder3'></span>");
	});
	$(".custom-select3").change(function() {
		var selectedOption = $(this).find(":selected").text();
		$(this).next(".holder3").text(selectedOption);
	}).trigger('change');

});