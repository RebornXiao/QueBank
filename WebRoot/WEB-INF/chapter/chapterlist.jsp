<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<script type="text/javascript">
	$(function() {

		$('#questiontable').datagrid({
			url : '${proPath}/chapter/selectPageByNum.action',
			fitColumns : true,
			nowrapL : true,
			idField : 'chapterId',
			rownumbers : true,
			pagination : true,
			pageSize : 1,
			pageList : [ 5, 10, 20, 50 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'chapterId',
				title : '题目编号'
			}, {
				field : 'chapterContent',
				title : '章节内容',
				width : 150
			} ] ]
		});
	});
</script>

</head>

<body>

	<table id="questiontable" class="easyui-datagrid"></table>
</body>
</html>
