function sendToServer(){ //기본정보 작성 안되어 있을 시 튕겨내기
    if($('.cmode1').val() == ''){
        alert('상품 분류를 선택해주세요');
        return false;
    }
    if($('input[name=item_name]').val() == ''){
        alert('상품명을 입력해주세요');
        return false;
    }
    if($('input[name=price]').val() == ''){
        alert('판매가격을 입력해주세요');
        return false;
    }
    if($('input[type=file]').val() == ''){
        alert('파일 이미지를 업로드해주세요');
        return false;
    }
}

$(function(){
    // 1차 옵션 변경시 2차옵션 드롭
    const cmode1 = $('.cmode1');
    cmode1.change(function(){
        $('.cmode2').empty();
        switch(cmode1.val()){
            case 'earring': 
                options = 
                '<option value="pearl">진주</option>'+
                '<option value="chain">체인</option>';
                break;
            case 'necklace':
                options = 
                '<option value="ring">링</option>'+
                '<option value="bold">볼드</option>';
                break;
            default:
                options = '<option>2차 분류</option>';
        }
        $('.cmode2').append(options);
    })

    //파일업로드시 썸네일
    $('#upload_image').change(function(e){
    const images = e.target.files
    $('.img-box').empty();
    for(let i=0 ; i<images.length; i++){
        const Reader = new FileReader();
        Reader.readAsDataURL(images[i]);
        Reader.onload = function(){
            const img = '<img src="'+ Reader.result +'" alt="사진">';
            $('.img-box').append(img);
        }
    }
        
    })
})

