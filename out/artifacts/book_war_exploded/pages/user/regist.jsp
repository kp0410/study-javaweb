<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--静态包含base标签、CSS样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        //页面加载完成之后
        $(function () {
            //给验证码图片绑定单击事件
            $("#code_img").click(function () {
                // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
                // src属性表示验证码img标签的 图片路径。它可读，可写
                <%--this.src = "${basePath}kaptcha.jpg?d="+new Date();--%>
                this.src = "${basePath}kaptcha.jpg";
            });
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2.创建正则表达式
                var usernamePatt = /^\w{5,12}$/;
                // var usernamePatt =  /^[a-z0-9_-]{3,16}$/;
                //3.使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4.提示用户结果
                    $("span.errorMsg").text("用户名不合法");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取密码输入框里的内容
                var passwordText = $("#password").val();
                //2.创建正则表达式
                var passwordPatt = /^\w{5,12}$/;
                // var usernamePatt =  /^[a-z0-9_-]{3,16}$/;
                //3.使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4.提示用户结果
                    $("span.errorMsg").text("密码不合法");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1.获取确认密码内容
                var password = $("#repwd").val();
                //2.两侧输入的密码相比较
                if (password != passwordText) {
                    //3.提示用户
                    $("span.errorMsg").text("两次输入的密码不一样");
                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                var emailtext = $("#email").val();
                var emailpatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailpatt.test(emailtext)) {
                    $("span.errorMsg").text("邮箱格式不合法");
                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codetext = $("#code").val();
                //去掉验证码前后空格
                // alert("去空格前：[" + codetext + "]");
                codetext = $.trim(codetext);
                // alert("去空格后：[" + codetext + "]");
                if (codetext == null || codetext == "") {
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }


                $("span.errorMsg").text("");

            })
        })
    </script>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               value="${requestScope.username}"
                               name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               value="${requestScope.email}"
                               name="email" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 50px;width: 150px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>