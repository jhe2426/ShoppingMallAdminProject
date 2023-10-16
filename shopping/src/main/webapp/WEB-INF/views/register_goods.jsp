<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="layout/header.jsp"%>
<link rel="stylesheet" href="/css/register_goods.css">
    <div class="section">
        <form id="form" enctype="multipart/form-data">
            <!-- 상품 기본정보 -->
            <div class="basic-info item">
                <div class="item-caption">
                    <div class="item-title">상품 작성하기</div>
                </div>
                <div class="item-content">

                    <div class="form-group">
                        <label class="form-label">상품분류</label>

                        <span class="cmode-box">
                            <select name="cmode1" class="cmode1">
                                <option value="">1차 분류</option>
                                <c:forEach items="${categoryList}" var="category">  
                                    <option value="${category.categoryTypeNumber}">${category.categoryType}</option>
                                </c:forEach>
                            </select>

                            <select name="cmode2" class="cmode2">
                                <option value="">2차 분류</option>
                            </select>

                            <script>
                                // 1차 옵션 변경시 2차옵션 드롭
                                $(function(){
                                    const cmode1 = $('.cmode1');
                                    cmode1.change(function(){
                                        $('.cmode2').empty();
                                        var categoryTypeList = new Array();
                                        function categoryDetail(categoryTypeNumber, categoryDetailNumber, categoryDetail){
                                        this.categoryTypeNumber = categoryTypeNumber;
                                        this.categoryDetailNumber = categoryDetailNumber;
                                        this.categoryDetail = categoryDetail;
                                        }
                                        var categoryDetailList = new Array();

                                        <c:forEach items="${categoryList}" var="category">
                                            categoryTypeList.push("${category.categoryTypeNumber}");
                                            <c:forEach items="${category.categoryDetailDtoList}" var="categoryDetailList">
                                                categoryDetailList.push(new categoryDetail("${categoryDetailList.categoryTypeNumber}", "${categoryDetailList.categoryDetailNumber}", "${categoryDetailList.categoryDetail}"));
                                            </c:forEach>
                                        </c:forEach>

                                        if(cmode1.val() == "") {
                                            options = '<option>2차 분류</option>';
                                        }                

                                        if(cmode1.val() != "") {
                                            function selectCategoryDetail(categoryDetailNumber, categoryDetail){
                                                this.categoryDetailNumber = categoryDetailNumber;
                                                this.categoryDetail = categoryDetail;
                                            }
                                            var detailList = new Array();
                                            for(let index = 0; index < categoryDetailList.length; index++){
                                            let categoryDetailTypeNumber = categoryDetailList[index].categoryTypeNumber;
                                            let categoryDetailNumber = categoryDetailList[index].categoryDetailNumber;
                                            let categoryDetail = categoryDetailList[index].categoryDetail;
                                                if(cmode1.val() == categoryDetailTypeNumber) {
                                                    detailList.push(new selectCategoryDetail(categoryDetailNumber, categoryDetail));
                                                }
                                            }

                                            var detailValue;
                                            for(let index = 0; index < detailList.length; index++) {
                                                detailValue += 
                                                    '<option value='+detailList[index].categoryDetailNumber+'>'+detailList[index].categoryDetail+'</option>';
                                            }
                                            options = detailValue;
                                        }                                   

                                        $('.cmode2').append(options);
                                    })
                            })
                            </script>
                        </span>

                    </div>
                    <div class="form-group">
                        <label class="form-label">판매가격</label>
                        <span><input type="text" id="price" name="price" autocomplete="off" onkeypress="return checkNumber(event)"></span>
                    </div>
                    <div class="form-group">
                        <label class="form-label">상품 이미지</label>
                        <span>
                            <div class="imgupload">
                                <label class=imguploadbtn for="upload-image">
                                    이미지 찾기
                                </label>
                                <input type="file" name="upload_image" id="upload-image" multiple="multiple">
                            </div>
                            <div class="img-box"></div>
                            <div class="discription-box">
                                <div class="discription-blue">권장 이미지 사이즈(가로: 1200px, 세로: 1200px)</div>
                                <div class="discription-blue">파일 저장시 상품내용 저장 후 적용됩니다</div>
                            </div>
                        </span>
                    </div>
                </div>
            </div>
            
    
            <div class="bottom">
                <div class="bottombtn">
                    <input type="button" id="post-product-button" value="저장">
                    <input type="button" id="get-product-list-button" value="목록">   
                </div>
            </div>
        </form>
    </div>
        

<script src="/js/product.js"></script>
<script src="/js/register_goods.js"></script>
<%@ include file="layout/footer.jsp"%>
