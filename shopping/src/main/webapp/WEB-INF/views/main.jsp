<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="layout/header.jsp"%>

  <div class="content">
        <div class="main-title">
            <p>상품 목록</p>
            <button class="product-write-button"><a href="/api/v1/admin/product">작성하기</a></button>
        </div>

        <div class="main-title-line"></div>

        <div class="main-table-title">
            <ul class="table-title">
                <li>상품 번호</li>
                <li>상품 이미지</li>
                <li>가격</li>
                <li>1차 분류</li>
                <li>2차 분류</li>
                <li>작성날짜</li>
                <li>삭제</li>
            </ul>
        </div>

        <c:forEach var="product" items="${productList.content}">
            <div class="line"></div>


            <ul class="table-content">
                <a href="#">
                <div class="product">
                <li class="product-text">No.${product.productNumber}</li>
                <li><img class="product-image" src="${product.imageUrl}" alt="상품이미지"></li>
                <li class="product-text list-price">${product.price}</li>
                <li class="product-text">${product.categoryDetailEntity.categoryTypeEntity.categoryType}</li>
                <li class="product-text list-second-category">${product.categoryDetailEntity.categoryDetail}</li>
                <li class="product-text list-create-date">${product.createDate}</li>     
                </div>
                </a>
                <li><button class="product-delete-button">삭제하기</button></li>
            </ul>
        </c:forEach>



        <div class="line"></div>

        <ul class="pagination justify-content-center">
            <c:choose>
                <c:when test="${productList.first}">
                    <li class="page-item disabled"><a class="page-link" href="?page=${productList.number-1}">이전</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${productList.number-1}">이전</a></li>
                </c:otherwise>
            </c:choose>
            
            <c:choose>
                <c:when test="${productList.last}">
                    <li class="page-item disabled"><a class="page-link" href="?page=${productList.number+1}">다음</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${productList.number+1}">다음</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

    </div>
 


<%@ include file="layout/footer.jsp"%>