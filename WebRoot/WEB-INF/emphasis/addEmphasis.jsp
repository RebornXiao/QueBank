<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<title>添加题目</title>
<script type="text/javascript">
	$(function() {

		$("#btnAdd").bind("click", function() {
			var emphasis = $("#emphasis").val();
			if (emphasis == null || emphasis == "") {
				$.messager.alert("提示", "请输入考点内容", "info");
				return;
			}
			$.post('${proPath}/emphasis/insert.action', {
				"emphasis" : emphasis
			}, function(data) {
				if (data == "success") {
					$.messager.alert("提示", "保存成功", "info");
				} else {

					if (data == "have") {
						$.messager.alert("提示", "考点内容已存在", "info");
					} else {
						$.messager.alert("提示", "保存失败", "info");
					}
				}
			}, "text");
		});
	});
</script>
</head>

<body>
	<center>
		<h3>添加考点</h3>
	</center>

	<div>
		<th>考点分类</th>

		<td><input id="emphasis" type="text" name="emphasisContent"
			style="width:500px" /></td>

	</div>
	<div>
		<form>
			<td colspan="2" align="center"><a href="javascript:void(0);"
				class="easyui-linkbutton" iconCls="icon-add" plain="true"
				id="btnAdd">保存</a>
			</td>
		</form>
	</div>

</body>
</html>
