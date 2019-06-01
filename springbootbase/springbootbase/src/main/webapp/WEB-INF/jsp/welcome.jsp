<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
	<blockquote class="layui-elem-quote">为节省服务器开销，以下示例均未配置真实上传接口，所以每次上传都会报提示：请求上传接口出现异常，这属于正常现象。</blockquote>
	选择文件:<input type="file" id="file1"><br>
	<input type="button" class="layui-btn" id="upload" onclick="upload();" value="上传">
	<h1 align="center">UEditor富文本框</h1>
	<script id="container" name="content" type="text/plain">
		hello,小虎
	</script>
	<div id="html"></div>
	<script src="layui/layui.all.js" charset="utf-8"></script>
		<!-- 配置文件 -->
	<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="utf8-jsp/ueditor.all.js"></script>
	<script type="text/javascript">
	 var ue = UE.getEditor('container',{
		 autoHeightEnabled:true
	 });
	function upload(){
		var $ = layui.jquery, upload = layui.upload;
		var formData = new FormData();
		formData.append('myfile',document.getElementById("file1").files[0]);
		$.ajax({
			url : "upload",
			type : "POST",
			data : formData,
			async : false,
			contentType : false,
			processData : false,
			success:function(ret){
// 				$("#html").html(ret.html);
				ue.ready(function(ed){
					var keyi = ret.html;
//		 			'<html><head><style>p{margin-top:0pt;margin-bottom:1pt;}p.a{text-align:justified;}p.a3{text-indent:21.0pt;}</style></head><body><div style="width:612.0pt;margin-bottom:72.0pt;margin-top:72.0pt;margin-left:90.0pt;margin-right:90.0pt;"><p><span style="font-weight:bold;white-space:pre-wrap;">一些文本</span>再见再见再见jlk</p><p><span id="_GoBack"/></p><p><br/></p><p></p><p><br/></p><p></p><p class="a a3"><span class="a a3">1. </span><span class="a a3">sdfsdf</span></p><p class="a a3"><span class="a a3">2. </span><span class="a a3">s</span><span class="a a3">dfsd</span></p></div></body></html>';
//					var s = JSON.stringify(ret.html);
//		 			sss = sss.replace(/<img(([\s\S])*?)>/g,'')
					keyi = keyi.replace('</body>','<body>')
					var arr = keyi.split("<body>");
					ue.setContent(arr[1]);
				});

			},
			error: function(){
				alert("上传失败");
			}
		});

	}
	</script>
</body>
</html>