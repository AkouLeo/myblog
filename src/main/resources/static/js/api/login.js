var vm = new Vue({
    el: "#app",
    data: {
        title: '登录页面',
        queryLoginUser: {
            account: '',
            password: '',
            code: ''
        }
    },
    methods: {
        // 登录方法
        login() {
            axios.post("/api/login/logined", this.queryLoginUser).then(res => {
                if (res.data == "success") {
                    window.location.href = "/"
                } else if (res.data == "falicode") {
                    document.getElementById("code").value = ""
                    document.getElementById("code").focus();
                    document.getElementById("kaptcha_code").src = "/kaptcha?d" + new Date().getTime();
                    alert("您的验证码输入有误")
                } else {
                    document.getElementById("pwd").value = ""
                    document.getElementById("pwd").focus();
                    alert("账号密码错误")
                }

            })
        }
    }
})