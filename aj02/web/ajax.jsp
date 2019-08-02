<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loadName(){
		var xmlHttp;
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();//谷歌火狐
		}else{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");//浏览器是ＩＥ一代
		}
		alert("readState状态："+xmlHttp.readyState+";status状态："+xmlHttp.status);
		xmlHttp.onreadystatechange=function(){//回调函数
			alert("readState状态："+xmlHttp.readyState+";status状态："+xmlHttp.status);
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
				alert(xmlHttp.responseText);
				document.getElementById("name").innerHTML=xmlHttp.responseText;
			}
		};
		 xmlHttp.open("get", "getAjaxName?name=jack&age=11", true);//地址栏会显示参数
		 //xmlHttp.open("post", "getAjaxName?name=jack&age=11", true);//地址栏会显示参数
		 xmlHttp.send();
		
	   /*	xmlHttp.open("post", "getAjaxName", true);//另外一种post方式  地址栏不显示参数
	    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");//加头信息
	    xmlHttp.send("name=jack&age=11"); */
	    	/*var name="aa";
	    	var age=20;
	    	xmlHttp.send("name=" + name+" &age=" +age);*/
	}
</script>
</head>
<body>
<div style="text-align: center;">
	<div><input type="button" onclick="loadName()" value="Ajax获取数据"/>&nbsp;&nbsp;</div>
</div>

<div  id="name" name="name" ></div>
</body>
</html>