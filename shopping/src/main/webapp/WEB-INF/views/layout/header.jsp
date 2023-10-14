<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <script src="https://kit.fontawesome.com/e6f78261b2.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/register_goods.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="/js/jquery.js"></script>
</head>
<body>
    <nav>
        <div class="side-title"><a href="/api/v1/admin/main" title="메인 페이지로 이동">관리자 모드</a></div>
        <ul class="side-menu">
            <li class="menu-dropdown">
                <span>상품관리 <i class="fas fa-chevron-down"></i></span>
                <ul class="dropdown hide">
                    <li><a href="/api/v1/admin/product" title="상품 등록">상품 등록</a></li>
                    <li><a href="#" title="상품 목록">상품 목록</a></li>
                </ul>
            </li>
            <li><a href="" title="결제 내역">결제 내역</a></li>
            <li><a href='#' title="로그아웃">LOGOUT</a></li>
        </ul>
    </nav>
