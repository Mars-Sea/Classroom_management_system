var canGetCookie = 0; //是否支持存储Cookie 0 不支持 1 支持
var CodeVal = 0;
Code();
var mm = document.getElementById("mm").value;
if (mm != null) {
    alert(mm);
}

function Code() {
    if (canGetCookie == 1) {
        createCode("AdminCode");
        var AdminCode = getCookieValue("AdminCode");
        showCheck(AdminCode);
    } else {
        showCheck(createCode(""));
    }
}

function showCheck(a) {
    CodeVal = a;
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, 1000, 1000);
    ctx.font = "80px 'Hiragino Sans GB'";
    ctx.fillStyle = "#E8DFE8";
    ctx.fillText(a, 0, 100);
}

function login() {
    var uid = document.getElementById("uid");
    var password = document.getElementById("password");
    var ValidateNum = document.getElementById("code");
    if (uid.value != null && password.value != null && ValidateNum.value != null) {

        if (ValidateNum.value.toUpperCase() == CodeVal.toUpperCase()) {
            document.submit.submit();
        } else {
            alert("验证码输入错误");
        }
    } else {
        alert("请输入账号和密码！");
    }
}
$(document).keypress(function(e) {
    // 回车键事件  
    if (e.which == 13) {
        $('#log_on').click();
    }
});