<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		$('#questiontable').datagrid({
			url : '${proPath}/question/selectPage.action',
			title : '题目列表',
			fitColumns : true,
			nowrapL : true,
			idField : 'questionId',
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'questionText',
				title : '题目内容',
				width : 1000
			}, {
				field : 'questionLevelText',
				title : '难度',
				width : 75
			}, {
				field : 'questionTypeText',
				title : '类型',
				width : 75
			}, {
				field : 'questionGradeText',
				title : '年级',
				width : 75
			}, {
				field : 'questionChapterText',
				title : '分类',
				width : 75
			}, {
				field : 'questionEmphasisText',
				title : '考点',
				width : 75
			}, {
				field : 'questionVersionText',
				title : '版本',
				width : 75
			} ] ],
			pagination : true,
			rownumbers : true
		});

		$("#btnQuery").bind("click", function() {
			var row = $("#questiontable").datagrid('getSelected');
			if (row == null) {
				alert("请先选择你要添加的试题");
			} else {
				var id = row['questionId']
				$.post('${proPath}/basket/insertTemp.action', {
					"id" : id
				}, function(data) {
					if (data == "success") {
						$.messager.alert("提示", "添加成功", "info");
					} else if (data == "have") {
						$.messager.alert("提示", "这道题已经存在", "info");
					} else {
						$.messager.alert("提示", "添加失败", "info");
					}
				}, "text");
			}
		});

		$("#btnDelete").bind("click", function() {
			var row = $("#questiontable").datagrid('getSelected');
			if (row == null) {
				alert("请先选择你要删除的试题");
			} else {
				var id = row['questionId'];
				$.post('${proPath}/question/delete.action', {
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

	<table id="questiontable" class="easyui-datagrid" toolbar="#toolbar">
	</table>
	<!--列表工具栏 -->
	<div id="toolbar" style="height:auto">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" id="btnQuery">添加到试题篮</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-delete" plain="true" id="btnDelete">删除这道题</a>
	</div>


</body>
</html>
