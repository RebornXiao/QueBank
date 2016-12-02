<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		//查随机取题
		$("#btnQuery").bind("click", function() {
			$('#questiontable').datagrid('load');
		});
		//保存
		$.fn.stringifyArray = function(array) {
			return JSON.stringify(array)
		}

		$.fn.parseArray = function(array) {
			return JSON.parse(array)
		}

		function ObjStory(questionId, questionText, questionAnswer,
				questionLevelId, questionTypeId, questionGradeId,
				questionChapterId, questionEmphasisId, questionVersionId,
				questionLevelText, questionTypeText, questionGradeText,
				questionChapterText, questionEmphasisText, questionVersionText) {
			this.questionId = questionId;
			this.questionText = questionText;
			this.questionAnswer = questionAnswer;
			this.questionLevelId = questionLevelId;
			this.questionTypeId = questionTypeId;
			this.questionGradeId = questionGradeId;
			this.questionChapterId = questionChapterId;
			this.questionEmphasisId = questionEmphasisId;
			this.questionVersionId = questionVersionId;
			this.questionLevelText = questionLevelText;
			this.questionTypeText = questionTypeText;
			this.questionGradeText = questionGradeText;
			this.questionChapterText = questionChapterText;
			this.questionEmphasisText = questionEmphasisText;
			this.questionVersionText = questionVersionText;
		}
		var url = '${proPath}/basket/insert.action';
		$("#btnAdd").bind(
				"click",
				function() {
					//alert(1111);
					var table = $("#questiontable").datagrid("getRows");//获取当前页的所有行
					//alert(table.length);
					//var total = 0;
					var myArray = new Array();

					for ( var i = 0; i < table.length; i++) {
						//alert(table[i]['VYpmc']);
						//total += table[i]['MLsjByRsl'];
						var writer = new ObjStory(table[i]['questionId'],
								table[i]['questionText'],
								table[i]['questionAnswer'],
								table[i]['questionLevelId'],
								table[i]['questionTypeId'],
								table[i]['questionGradeId'],
								table[i]['questionChapterId'],
								table[i]['questionEmphasisId'],
								table[i]['questionVersionId'],
								table[i]['questionLevelText'],
								table[i]['questionTypeText'],
								table[i]['questionGradeText'],
								table[i]['questionChapterText'],
								table[i]['questionEmphasisText'],
								table[i]['questionVersionText']);//声明对象
						//alert(String(writer));
						myArray[i] = writer;
					}
					var json = JSON.stringify(myArray)
					//var str = myArray.serializeArray();
					//var str = $.toJSON(table);
					//var json = $(myArray).stringifyArray(array)
					//alert(json);
					$.post('${proPath}/basket/insert.action', {
						"listData" : String(json)
					}, function(data) {
						if (data == "success") {
							$("#questiontable").datagrid("reload");
						} else {
							$.messager.alert("提示", "保存失败", "info");
						}
					}, "text");
				});

		$('#questiontable').datagrid({
			url : '${proPath}/basket/randomQuestion.action',
			fitColumns : true,
			nowrapL : true,
			idField : 'questionId',
			rownumbers : true,
			queryParams : {
				num : '50'
			},
			columns : [ [ {
				checkbox : true,
			}, {
				field : 'questionId',
				title : '题目编号'
			}, {
				field : 'questionText',
				title : '题目内容',
				width : 250
			}, {
				field : 'questionLevelText',
				title : '难度',
				width : 20
			}, {
				field : 'questionGradeText',
				title : '年级',
				width : 30
			} ] ]
		});
	});
</script>

</head>

<body>
	<table id="questiontable" toolbar="#toolbar"></table>
	<div id="toolbar" style="height:auto">
		<form id="queryForm" method="post" action="#"
			enctype="multipart/form-data">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-search" plain="true" id="btnQuery">随机取题</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" id="btnAdd">保存</a>
		</form>
	</div>
</body>
</html>
