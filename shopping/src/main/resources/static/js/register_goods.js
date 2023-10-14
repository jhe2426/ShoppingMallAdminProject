function checkNumber(event) {
    if(event.key >= 0 && event.key <= 9) return true;
    return false;
  }
  

$(function(){
    //파일업로드시 썸네일
    $('#upload-image').change(function(e){
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

