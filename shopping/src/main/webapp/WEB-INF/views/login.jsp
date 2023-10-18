<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="/css/login.css">
    <script src="/js/jquery.js"></script>
</head>

<body>

    <div class="header">
        <div class="title">
            <p>관리자 페이지</p>
        </div>
    </div>



    <div class="login-form-wrap">
        <form class="login-form">
            <h1 class="login-head">
                <p>Login</p>
            </h1>
            <div class="login-id">
                <h4>아이디</h4><br>
                <input type="text" placeholder="아이디" id="admin-id"><br>
            </div>
            <div class="login-password">
                <h4>비밀번호</h4><br>
                <input type="password" placeholder="비밀번호" id="admin-password">
            </div>
            <button id="login-send-button">로그인</button>
        </form>
    </div>


<script src="/js/login.js"></script>
</body>
</html>