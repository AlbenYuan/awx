<%@ page language="java" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/include/head.jsp" %>
    <title>登录-后台管理系统</title>
    <%@include file="/WEB-INF/include/title.jsp" %>
    <link href="${staticPath}/css/login1.css" rel="stylesheet"/>
</head>
<body>
<div class="login-container">
    <div class="login-title">后台管理系统</div>
    <form class="form-horizontal">


        <div class="form-group">
            <div class="input-group input-group-lg ">
                <span class="input-group-addon "><i class="fa fa-user"></i></span>
                <input type="text" class="form-control input-lg username"
                       name="username" placeholder="Username"
                       aria-describedby="basic-addon1">
                <%--<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>--%>
            </div>
            <%--<span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>--%>
            <%--<p class="help-inline">Example block-level help text here.</p>--%>
        </div>

        <div class="form-group">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control input-lg password"
                       name="password"
                       placeholder="Password"
                       aria-describedby="basic-addon1">
            </div>
        </div>

        <div class="form-group">
            <button type="button" class="btn btn-info btn-lg login-btn">登录</button>
        </div>
    </form>
</div>
<footer class="footer navbar-fixed-bottom text-center">
    Copyright © 2014-2016 <a href="javascript:void(0);">AlbenYuan</a>
</footer>

<script src="${staticPath}/backstretch/2.1.15/js/jquery.backstretch.min.js"></script>
<script>

    $(function () {
        $.backstretch([
            '${contextPath}/image/backgrounds/1.jpg',
            '${contextPath}/image/backgrounds/2.jpg',
            '${contextPath}/image/backgrounds/3.jpg',
        ], {
            fade: 1000,
            duration: 8000
        });
    });


    $(function () {

        let $form = $('.login-container form');
        $form.find('.login-btn').click(function () {
            console.log($form.serialize());
        });
    });


</script>

</body>
</html>
