<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/22 0022
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>comprehansiveLogin</title>
    <!-- The styles -->
    <link  href="static/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="static/css/charisma-app.css" rel="stylesheet">
    <link href='static/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='static/css/jquery.noty.css' rel='stylesheet'>
    <link href='static/css/noty_theme_default.css' rel='stylesheet'>
    <link href='static/css/elfinder.min.css' rel='stylesheet'>
    <link href='static/css/elfinder.theme.css' rel='stylesheet'>
    <link href='static/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='static/css/uploadify.css' rel='stylesheet'>
    <link href='static/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="static/bower_components/jquery/jquery.min.js"></script>
    <!-- The fav icon -->
    <link rel="shortcut icon" href="static/img/favicon.ico">
</head>
<body>
<div class="ch-container">
    <div class="row">

        <div class="row">
            <div class="col-md-12 center login-header">
                <h2>Welcome</h2>
            </div>
        </div>

        <div class="row">
            <div class="well col-md-5 center login-box">
                <div class="alert alert-info">
                    Please login with your Username and Password.
                </div>
                <form class="form-horizontal" action="/login/isOK.do" method="post">
                    <fieldset>
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                            <input type="text" class="form-control" placeholder="Username"name="userName">
                        </div>
                        <div class="clearfix"></div><br>

                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                            <input type="password" class="form-control" placeholder="Password" name="password">
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend">
                            <label class="remember" for="remember"><input type="checkbox" id="remember"> Remember me</label>
                        </div>
                        <div class="clearfix"></div>

                        <p class="center col-md-5">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </p>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</div>



<script src="static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='static/bower_components/moment/min/moment.min.js'></script>
<script src='static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='static/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="static/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="static/js/charisma.js"></script>


</body>
</html>