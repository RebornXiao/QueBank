<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<script type="text/javascript">
	$(function() {

		$('#questiontable').datagrid({
			url : '${proPath}/question/selectPage.action',
			fitColumns : true,
			nowrapL : true,
			idField : 'questionId',
			rownumbers : true,
			pagination : true,
			pageSize : 1,
			pageList : [ 1, 2, 4, 8 ],
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
			} ] ]
		});
	});
</script>

</head>

<body>


	<table id="questiontable" class="easyui-datagrid"></table>
</body>
</html>
