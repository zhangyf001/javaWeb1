<%
    String url = "http://" + request.getServerName() //服务器地址
            + ":"
            + request.getServerPort()  ;      //端口号
            //+ request.getContextPath()      //
            //+ request.getServletPath()      //请求页面或其他地址
            //+ "?" + (request.getQueryString()); //参数

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>comprehansive</title>

    <!-- jQuery -->
    <script src="../static/bower_components/jquery/jquery.min.js"></script>
    <!-- The styles -->
    <link  id="cssStyle" href="../static/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="../static/css/charisma-app.css" rel="stylesheet">
    <link href='../static/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='../static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='../static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='../static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='../static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='../static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='../static/css/jquery.noty.css' rel='stylesheet'>
    <link href='../static/css/noty_theme_default.css' rel='stylesheet'>
    <link href='../static/css/elfinder.min.css' rel='stylesheet'>
    <link href='../static/css/elfinder.theme.css' rel='stylesheet'>
    <link href='../static/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='../static/css/uploadify.css' rel='stylesheet'>
    <link href='../static/css/animate.min.css' rel='stylesheet'>


    <!-- The fav icon -->
    <link rel="shortcut icon" href="../static/img/favicon.ico">

</head>

<body>
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-inner">
        <a class="navbar-brand" href=""> <img alt="Charisma Logo" src="../static/img/logo20.png" class="hidden-xs"/>
            <span>综合</span></a>
        <c:choose>
            <c:when test="${empty name}">
                <div class="btn-group pull-right">
                           游客你好
                </div>
            </c:when>
            <c:otherwise>
                <div class="btn-group pull-right">
                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i>
                        <span class="hidden-sm hidden-xs">${name}</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li class="divider"></li>
                        <li><a href=""onclick="logout();return false;">Logout</a></li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>
        <!-- user dropdown ends -->

        <!-- theme selector starts -->
        <div class="btn-group pull-right theme-container animated tada">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-tint"></i><span
                    class="hidden-sm hidden-xs"> 更换主题  / 皮肤</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" id="themes">
                <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
            </ul>
        </div>

    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">

        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">
                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> CompanyManage</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/emp/emp_list.do" onclick="toLink(this);return false">员工管理</a></li>
                                <li><a href="#">部门管理</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->
        <div id="content" class="col-lg-10 col-sm-10">


        </div>
    </div>
    <hr>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="#" >Muhammad
            Usman</a> 2018</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="#">ZhangYF</a></p>
    </footer>

</div><!--/.fluid-container-->


<!-- external javascript -->
<script src="../static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="../static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='../static/bower_components/moment/min/moment.min.js'></script>
<script src='../static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='../static/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="../static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="../static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="../static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="../static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="../static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="../static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="../static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="../static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="../static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="../static/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="../static/js/charisma.js"></script>
<script>
    var path = "<%=url%>";
    $(function () {
        $("#content").load(path+"/default.jsp");
    });

    function logout() {
        window.location.href= path+"/login.jsp";
    }
</script>
<script>


    /*$(".accordion li a").click(function () {
        var url = url+$(this).attr("href");
        $("#content").load(url);
        return false;
    });*/


    function toLink(obj) {
        /**var url = obj.href;
        var urlArr = url.split("/");
        url = urlArr[urlArr.length-1];*/
        var url = path+$(obj).attr("href");
        $("#content").load(url);

    }

    $("#themes a").click(function () {
        var cssValue = $(this).text();
        cssValue = cssValue.toLowerCase().trim();
        var url = "../static/css/bootstrap-"+cssValue+".min.css"
        $("#cssStyle").attr("href",url);
    });
</script>
</body>




</html>