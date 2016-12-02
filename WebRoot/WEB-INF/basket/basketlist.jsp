<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {

		$('#questiontable').datagrid({
			url : '${proPath}/basket/selectPage.action',
			fitColumns : true,
			nowrapL : true,
			idField : 'basketListId',
			singleSelect : true,
			rownumbers : true,
			pagination : true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'basketListId',
				title : '试卷篮编号'
			}, {
				field : 'questionNumbers',
				title : '题目个数',
				width : 100
			}, {}, {
				field : 'fillingNo',
				title : '选择题',
				width : 250
			}, {
				field : 'chooseNo',
				title : '填空题',
				width : 250
			}, {
				field : 'explainNo',
				title : '解答题',
				width : 250
			} ] ]
		});

		$("#btnQuery").bind("click", function() {
			var row = $("#questiontable").datagrid('getSelected');
			if (row == null) {
				alert("请先选择你要导出的试题篮");
			} else {
				var id = row['basketListId']
				$.post('${proPath}/basket/outPrint.action', {
						"id" : id
					}, function(data) {
						if (data == "success") {
							alert("导出成功！");	
											
						} else {
							$.messager.alert("提示", "导出失败", "info");
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
			iconCls="icon-search" plain="true" id="btnQuery">导出为word</a>
	</div>
</body>
</html>
