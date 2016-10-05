$(function(){

	$(".main-menu ul li").on("click", function() {
		var menuId = $(this).attr("id");				//$(this)지금 클릭된 애

		if(menuId == "menuJoin"){
			location.href = "/member/join";
		}
		else if(menuId == "menuLogin"){
			showLoginDialog();
		}
		else if(menuId == "menuScheduler")
		{
			location.href = "/schedule/list";
		}
	});

	$("#btnJoin").on("click", function(){
		location.href = "/member/join";
	});

	$("#btnLoginCancel").on("click", function(){
		hideLoginDialog();
	});

	function showLoginDialog(){
		$(".login-dialog").fadeIn();
	}
	function hideLoginDialog(){
		$(".login-dialog").fadeOut();
	}

});