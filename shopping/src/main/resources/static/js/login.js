let index = {
    init: function() {
        $("#login-send-button").on("click", () => {
            this.login();
        });
    },

    login: function() {
        let id = $("#admin-id").val();
        let password = $("#admin-password").val();

        if (id == '' & password == '') {
            alert("아이디 비밀번호를 입력해주세요.")
            return false;
        } else if (id == '') {
            alert("아이디를 입력해주세요.")
            return false;
        } else if (password == '') {
            alert("비밀번호를 입력해주세요.")
            return false;
        }
  


        let data = {
            adminId:  $("#admin-id").val(),
            adminPassword:$("#admin-password").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/v1/admin/login",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "TEXT",
            success: function(response,statusText,jqXHR) {
                var status = jqXHR.status;
                if (status == 200) {
                    window.location.replace("http://localhost:4000/api/v1/admin/main");
                }
            },
            error: function(jqXHR) {
                var status = jqXHR.status;	
                if (status == 400) {
                    alert ("아이디와 비밀번호가 틀렸습니다.");
                }
            }
		});

    }
}

index.init();