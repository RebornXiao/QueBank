<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {

		$('#questiontable').datagrid({
			url : '${proPath}/basket/selectPageTemp.action',
			title : '试题篮',
			fitColumns : true,
			nowrapL : true,
			idField : 'questionId',
			singleSelect : true,
			rownumbers : true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'questionId',
				title : '题目编号'
			}, {
				field : 'questionText',
				title : '题目内容',
				width : 100
			}, {
				field : 'questionAnswer',
				title : '答案',
				width : 100
			}, {
				field : 'questionLevelText',
				title : '难度',
				width : 100
			}, {
				field : 'questionGradeText',
				title : '年级',
				width : 100
			} ] ],
			pagination : true,
			rownumbers : true
		});

		$("#btnDelete").bind("click", function() {
			var row = $("#questiontable").datagrid('getSelected');
			if (row == null) {
				alert("请先选择你要添加的试题");
			} else {
				var id = row['questionId'];
				$.post('${proPath}/basket/deleteTemp.action', {
					"id" : id
				}, function(data) {
					if (data == "success") {
						$.messager.alert("提示", "删除成功", "info");
						$('#questiontable').datagrid('load');
					} else if (data == "have") {
						$.messager.alert("提示", "这道题不存在,请刷新页面", "info");
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				}, "text");
			}
		});
	});
</script>

</head>

<body>
	<table id="questiontable" class="easyui-datagrid" toolbar="#toolbar"></table>
	<!--列表工具栏 -->
	<div id="toolbar" style="height:auto">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-delete" plain="true" id="btnDelete">删除这道题</a>
	</div>
</body>
</html>
