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
	<table id="questiontable" class="easyui-datagrid" toolbar="#toolbar">
	</table>
	<!--列表工具栏 -->
	<div id="toolbar" style="height:auto">
		<form id="queryForm" method="post" action="#"
			enctype="multipart/form-data">
			所属章节:<input class="easyui-combobox" name="_chapter_type" id="_city_code"
				style="width: 80px;"
				data-options=" url:'sys_cityCombobox',method:'get',valueField:'id',editable:false,textField:'text',panelHeight:'auto'">
			章节内容:<input class="easyui-combobox" name="__chapter_content"
				id="_use_status" style="width:80px"
				data-options=" url:'sys_dic',method:'get',valueField:'code',textField:'name',panelHeight:'auto',editable:false">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-search" plain="true" id="btnQuery">加入试题篮</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-clear" plain="true" id="clearQuery">清空</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" id="btnAdd">添加</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" id="btnRemove">删除</a>
		</form>
	</div>

</body>
</html>
