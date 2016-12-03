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
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'questionText',
				title : '题目内容',
				width : 500
			}, {
				field : 'questionLevelText',
				title : '难度',
				width : 100
			}, {
				field : 'questionTypeText',
				title : '类型',
				width : 100
			}, {
				field : 'questionGradeText',
				title : '年级',
				width : 100
			}, {
				field : 'questionChapterText',
				title : '分类',
				width : 100
			}, {
				field : 'questionEmphasisText',
				title : '考点',
				width : 100
			}, {
				field : 'questionVersionText',
				title : '版本',
				width : 100
			} ] ],
			pagination : true,
			rownumbers : true
		});
	});
</script>

</head>

<body>

	<table id="questiontable" class="easyui-datagrid">
	</table>


</body>
</html>
