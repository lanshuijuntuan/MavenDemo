<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title>superui框架</title>
    <meta name="keywords" content="supershopui框架" />
    <meta name="description" content="supershopui框架" />
    <link href="content/ui/css/layout.css" rel="stylesheet" />
    <link href="content/ui/css/login.css" rel="stylesheet"/>
    <style>
        .ibar {
            display: none;
        }
    </style>
</head>
<body>

  <div class="main ">
        <!--登录-->
        <div class="login-dom login-max">
            <div class="logo text-center">
                <a href="#">
                    <img src="content/ui/img/logo.png" width="180px" height="180px" />
                </a>
            </div>
            <div class="login container " id="login">
                <p class="text-big text-center logo-color">
                    同一个账号，连接一切
                </p>

                <p class="text-center margin-small-top logo-color text-small">
                  SuperUI框架
                </p>
                <form class="login-form" action="/rent/ProManagement" method="post" autocomplete="off">
                    <div class="login-box border text-small" id="box">
                        <div class="name border-bottom">
                            <input type="text" placeholder="手机/邮箱/账号（随便填）" id="username" name="username" datatype="*" nullmsg="请填写帐号信息" />
                        </div>
                        <div class="pwd">
                            <input type="password" placeholder="密码（随便填）" datatype="*" id="password" name="password" nullmsg="请填写帐号密码" />
                        </div>
                    </div>
                    <input type="submit" class="btn text-center login-btn" value="立即登录" />
                </form>
                <div class="forget">
                   
                    <a href="#" class="forget-pwd text-small fl"> 忘记登录密码？</a><a href="#" class="forget-new text-small fr" id="forget-new">注册账号</a>
                </div>
            </div>
        </div>
        <div class="footer text-center text-small ie">
            Copyright 2013-2016 版权所有 ©tzhsweet 2015-2018      <a href="#" target="_blank">粤ICP备16024545号-1</a>
            <span class="margin-left margin-right">|</span>
            <script src="#" language="JavaScript"></script>
        </div>
        <div class="popupDom">
            <div class="popup text-default">
            </div>
        </div>
    </div>
<script src="/content/ui/global/jQuery/jquery.min.js"></script>
<script type="text/javascript">
    function popup_msg(msg) {
        $(".popup").html("" + msg + "");
        $(".popupDom").animate({
            "top": "0px"
        }, 400);
        setTimeout(function () {
            $(".popupDom").animate({
                "top": "-40px"
            }, 400);
        }, 2000);
    }

    /*动画（注册）*/
    $(document).ready(function (e) {
        // $("input[name=username]").focus();
        // $('.login-form').Validform({
        // 	ajaxPost: true,
        // 	tiptype: function(msg) {
        // 		if (msg) popup_msg('' + msg + '');
        // 	},
        // 	callback: function(ret) {
        // 		popup_msg('' + ret.info + '');
        // 		if (ret.status == 1) {
        // 			if (ret.uc_user_synlogin) {
        // 				$("body").append(ret.uc_user_synlogin);
        // 			}
        // 			setTimeout("window.location='" + ret.url + "'", 2000);
        // 		}
        // 	}
        // })

    });
</script>
</body>
</html>