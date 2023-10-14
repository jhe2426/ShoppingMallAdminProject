let index = {
    init: function() {
        $("#post-product-button").on("click", () => {
            this.postProduct();
            
        });
    },

    postProduct: function() {

        let categoryType = $(".cmode1").val();
        let categoryDetailNumber = $(".cmode2").val();
        let price = $("#price").val();
        let uploadImage = $('input[type=file]').val();
        const imageInput = $("#upload-image")[0];

        var formData = new FormData();
        formData.append("image", imageInput.files[0]);
        formData.append("categoryDetailNumber", categoryDetailNumber);
        formData.append("price", price);

        if (categoryType == '' && categoryDetailNumber == '' && price == '' && uploadImage == '') {
            alert("이미지 첨부와 모두 입력해주세요.");
            return false;
        } else if (categoryType == '' || categoryDetailNumber == ''){
            alert("분류를 선택해주세요.");
            return false;
        } else if (price == '') {
            alert("가격을 입력해주세요.");
            return false;
        } else if (uploadImage == '') {
            alert("이미지를 넣어주세요.");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "/api/v1/admin/product/register",
            processData: false,
            contentType: false,
            data: formData,
            dataType: "TEXT",
            success: function(response,statusText,jqXHR) {
                var status = jqXHR.status;
                if (status == 200) {
                    alert("정상적으로 상품 등록이 완료되었습니다.");
                    window.location.replace("http://localhost:4000/api/v1/admin/main");
                }
            },
            error: function(jqXHR) {
                var status = jqXHR.status;
                if (status == 500) {
                    alert("상품 등록이 실패되었습니다.");
                }
            }
		});
    }
}

index.init();