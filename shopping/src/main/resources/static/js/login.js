let index = {
    init: function() {
        $("#login-send-button").on("click", () => {
            this.login();
        });
    },

    login: function() {
        let id = $("#admin-id").val();
        let password = $("#admin-password").val();

        if (id == '' || password == '') {
            alert("아이디 비밀번호를 입력해주세요")
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
            success: function(response, textStatus, jqXHR) {
                window.location.replace("http://localhost:4000/api/v1/admin/main");
            },
            error: function(jqXHR) {
                
                var status = jqXHR.status;
                if (status = 500) {
                    alert("500코드 출력");
                }
                alert(JSON.stringify(jqXHR, ["status"]));   				
            }
		});

    }
}

index.init();