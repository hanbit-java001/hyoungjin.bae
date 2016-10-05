<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="msapplication-tap-highlight" content="no" />
<link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/main.css" />
<title>한빛 스케쥴러</title>
</head>
<body>
	<div class="main-container">
		<div class="main-top">
			<div class="main-top-body">
				<div class="main-logo">한빛 스케쥴러</div>
				<div class="main-menu">
					<ul>
						<li id="menuJoin">회원가입</li>
						<li id="menuLogin">로그인</li>
						<li id="menuScheduler">스케쥴러</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-body">
				스케쥴러에 가입하세요<br>
				무료입니다.<br>
				<button class="btn btn-primary">무료로가입하기</button>
			</div>
		</div>

		<div class="main-bottom">
			한빛 스케쥴러 이즈 낫 디피컬트
		</div>

		<div class="login-dialog">
			<div class="form-group">
	   			<label for="txtEmail" class="input-required">이메일</label>
	   			<input type="text" class="form-control" id="txtEmail" placeholder="이메일">
			</div>
			<div class="form-group">
	   			<label for="txtPassword" class="input-required">비밀번호</label>
	   			<input type="password" class="form-control" id="txtPassword" placeholder="비밀번호">
			</div>
			<div class="bottom-buttons">
				<button class="btnLogin btn btn-success" id="btnJoin">로그인</button>
				<button class="btnLoginCancel btn btn-default" id="btnLoginCancel">취소</button>
			</div>
		</div>
	</div>
<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/main.js"></script>
</body>
</html>