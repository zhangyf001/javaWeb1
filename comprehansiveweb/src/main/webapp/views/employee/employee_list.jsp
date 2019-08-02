<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String url = "http://" + request.getServerName() //服务器地址
            + ":"
            + request.getServerPort()  ;      //端口号
    //+ request.getContextPath()      //
    //+ request.getServletPath()      //请求页面或其他地址
    //+ "?" + (request.getQueryString()); //参数

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../static/bower_components/jquery/jquery.min.js"></script>
    <%--Ajax方式提交form表单需要引入的js--%>
    <script src="../../static/js/jquery.form.js"></script>
</head>
<body>
<div class="ch-container">
    <div class="row">
        <form action="/emp/queryList.do" method="post" id="Form">
            <%--搜索信息--%>
        <div class="row">
            <div class="col-md-9">
            <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                <tr>
                    <td>员工姓名:</td>
                    <td><input type="text" class="form-control" id="employeeName" value="${params.employeeName}" name="employeeName"></td>
                    <td>所在部门:</td>
                    <td>
                        <select class="form-control" id="partCode" name="partCode">
                            <option value="0">
                                --请选择--
                            </option>
                            <c:forEach items="${partList}" var="var">
                                <option value="${var.typeId}"
                                <c:if test="${params.partCode==var.typeId}">selected</c:if> >
                                        ${var.typeName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>员工级别:</td>
                    <td>
                        <select class="form-control" id="levelCode" name="levelCode">
                            <option value="0">
                                --请选择--
                            </option>
                            <c:forEach items="${levelList}" var="var">
                                <option value="${var.typeId}"  <c:if test="${params.levelCode==var.typeId}">selected</c:if>>
                                        ${var.typeName }
                                </option>
                            </c:forEach>

                        </select>
                    </td>
                    <td><a class="btn btn-success" onclick="tosearch('search')"><i class="glyphicon glyphicon-search"></i>搜索</a></td>
                </tr>
            </table>
            </div>
        </div>
        <div class="row">
            <div class="box col-md-12">
                <div class="box-inner">
                    <%--表格名称--%>
                    <div class="box-header well" data-original-title="">
                        <h2><i class="glyphicon glyphicon-user"></i> 员工管理</h2>

                        <%--<div class="box-icon">
                            <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                    class="glyphicon glyphicon-chevron-up"></i></a>
                            <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                        </div>--%>
                    </div>
                        <%--表格内容--%>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                            <thead>
                            <tr>
                                <th >
                                    <label ><input type="checkbox"  id="zcheckbox" onchange="selectAll()"/><span></span></label>
                                </th>
                                <th>
                                    序号
                                </th>
                                <th>
                                    编号
                                </th>
                                <th>
                                    员工姓名
                                </th>

                                <th>
                                    所在部门
                                </th>
                                <th>
                                    所处级别
                                </th>
                                <th>
                                    员工手机
                                </th>
                                <th>
                                    操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${not empty employeeList}">
                                    <c:forEach items="${employeeList}" var="var" varStatus="vs"  >
                                        <tr>
                                            <td >
                                                <label ><input type='checkbox' name='ids' value="${var.employeeId}" /><span></span></label>
                                            </td>
                                            <td>${vs.index+1}</td>
                                            <td>${var.employeeId}</td>
                                            <td>${var.employeeName}</td>
                                            <td>${var.employeePart.typeName}</td><!--部门名称-->
                                            <td>${var.employeeLevel.typeName}</td><!--员工级别名称-->
                                            <td>${var.employeePhone}</td>
                                            <td>
                                                <a class="btn btn-success" href="#">
                                                    <i class="glyphicon glyphicon-zoom-in icon-white"></i>
                                                    查看
                                                </a>
                                                <a class="btn btn-primary" href="#">
                                                    <i class="glyphicon glyphicon-edit icon-white"></i>
                                                    编辑
                                                </a>
                                                <a class="btn btn-danger" href="#">
                                                    <i class="glyphicon glyphicon-trash icon-white"></i>
                                                    删除
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="100">没有相关数据</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                        <%--表格页码--%>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="dataTables_info" >show ${pageInfo.startRow} to ${pageInfo.endRow} of ${pageInfo.total}</div>
                            </div>
                            <div class="col-md-12 center-block">
                                <input type="hidden" name="pageNum" value="" id="pageNum">
                                <div class="dataTables_paginate paging_bootstrap pagination">
                                <ul class="pagination">
                                   <%--上一页--%>
                                    <c:choose>
                                        <c:when test="${pageInfo.hasPreviousPage}">
                                            <li class="prev"><a href="#" onclick="tosearch('previous');return false">← Previous</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="prev disabled"><a href="#">← Previous</a></li>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:forEach items="${pageInfo.navigatepageNums}" var="var" varStatus="vs">
                                        <c:choose>
                                            <c:when test="${params.pageNum== var }">
                                                <li class="active"><a href="#" >${var}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="${var}"onclick="tosearch(this);return false" >${var}</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                    <%--下一页--%>
                                    <c:choose>
                                        <c:when test="${pageInfo.hasNextPage}">
                                            <li class="next"><a onclick="tosearch('next');return false">Next → </a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="next disabled"><a href="#">Next → </a></li>
                                        </c:otherwise>
                                    </c:choose>

                                    <li >
                                        <select name="records" style="height: 37px" onchange="tosearch('records')">
                                            <option <c:if test="${params.records==2}">selected</c:if> >2</option>
                                            <option <c:if test="${params.records==5}">selected</c:if> >5</option>
                                            <option <c:if test="${params.records==10}">selected</c:if> >10</option>
                                            <option <c:if test="${params.records==25}">selected</c:if> >25</option>
                                            <option <c:if test="${params.records==50}">selected</c:if> >50</option>
                                            <option <c:if test="${params.records==100}">selected</c:if> >100</option>
                                        </select>
                                    </li>
                                </ul>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



        </div>

        </form>

    </div>
</div>
<script>
    function tosearch(obj) {

        if("previous"==obj){//上一页
            var pageNum = "${params.pageNum-1}";
            $("#pageNum").val(pageNum);
        }else if("next"==obj){//下一页
            var pageNum = "${params.pageNum+1}";
            $("#pageNum").val(pageNum);
        }else if("search"==obj){

        }else if("records"==obj){//一页显示几条数据的搜索
            $("#pageNum").val(1);
        }else{//第1 2 3 4 5 页的搜索
            var url = obj.href;
            var urlArr = url.split("/");
            var pageNum  = urlArr[urlArr.length-1];
            $("#pageNum").val(pageNum);
        }
        var options={
            target:$("#content"),
            success:function(){
            },
            complete:function () {//请求完成
            }
        };
        $("#Form").ajaxSubmit(options);
    }

    //全选
    function selectAll() {
        var isCheck = $("#zcheckbox").is(':checked');  //获得全选复选框是否选中
        $("input[type='checkbox']").each(function () {
            this.checked = isCheck;       //循环赋值给每个复选框是否选中
        });
    }
    var path = "<%=url%>";
    function timer() {
        var url = path+"/emp/timer.do";
        $.ajax({
            url:url,
            headers:{
                Accept:"application/json, text/javascript, */*",
            },
            success:function (data) {
                debugger
                //将返回的json数组串转为json数组
                data=eval("("+data+")");
                var type01 = data[0].typeId;
            },
            error:function (textStatus) {
                debugger;
                alert(textStatus);
            }
        });
    }
    //每隔3秒执行timer方法
     setInterval(timer,3000);
</script>
</body>
</html>
