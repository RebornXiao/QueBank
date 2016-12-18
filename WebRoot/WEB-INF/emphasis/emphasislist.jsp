<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<script type="text/javascript">
	$(function() {
		$('#questiontable').datagrid({
			url : '${proPath}/emphasis/selectPage.action',
			fitColumns : true,
			nowrapL : true,
			idField : 'emphasisId',
			rownumbers : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 50, 100, 200 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'emphasisId',
				title : '题目编号'
			}, {
				field : 'emphasisContent',
				title : '章节内容',
				width : 150
			} ] ]
		});
	});
</script>

</head>

<body>

	<table id="questiontable" class="easyui-datagrid" ></table>
</body>
</html>
