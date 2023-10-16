<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="layout/header.jsp"%>


    <div class="payment-content">
        <div class="payment-title">
            <p>결제 내역</p>
        </div>

        <div class="payment-title-line"></div>

        <div class="payment-table-title">
            <ul class="table-title">
                <li>주문 번호</li>
                <li>상품 이미지</li>
                <li>구매자 이메일</li>
                <li>가격</li>
                <li>주문 개수</li>
                <li class="list-crate-date">작성날짜</li>
            </ul>
        </div>

        <c:forEach var="payment" items="${paymentList.content}">
            <div class="payment-line"></div>

            <ul class="payment-table-content">
                <div class="payment" href="">
                <li class="payment-text">${payment.ordersNumber}</li>
                <li><img class="payment-image" src="${payment.productEntity.imageUrl}" alt="상품이미지"></li>
                <li class="payment-text">${payment.userEntity.email}</li>
                <li class="payment-text list-price">${payment.totalPrice}원</li>
                <li class="payment-text list-second-category">${payment.totalOrderCount}개</li>
                <li class="payment-text list-create-date">${payment.ordersDate}</li>
                </div>
            </ul>
        </c:forEach>

        

        <div class="payment-line"></div>

        <ul class="pagination justify-content-center">
            <c:choose>
                <c:when test="${paymentList.first}">
                    <li class="page-item disabled"><a class="page-link" href="?page=${paymentList.number-1}">이전</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${paymentList.number-1}">이전</a></li>
                </c:otherwise>
            </c:choose>
            
            <c:choose>
                <c:when test="${paymentList.last}">
                    <li class="page-item disabled"><a class="page-link" href="?page=${paymentList.number+1}">다음</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${paymentList.number+1}">다음</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

    </div>
 




<%@ include file="layout/footer.jsp"%>