<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<title>添加题目</title>
<script type="text/javascript">
	$(function() {
		window.onload = function() {
			var editor = CKEDITOR.replace('questionText');
			CKFinder.setupCKEditor(editor, '/ckeditor/');
		};

		$('#cc_chapter').combobox({
			url : '${proPath}/chapter/selectAll.action',
			valueField : 'id',
			onLoadSuccess : onLoadSuccess,
			textField : 'text'
		});
		function onLoadSuccess() {
			$('#cc_emphasis').combobox({
				url : '${proPath}/emphasis/selectAll.action',
				valueField : 'id',
				textField : 'text'
			});
		} 

		$("#btnAdd").bind("click", function() {
			var emphasis = $("#emphasis").val();
			if (emphasis == null || emphasis == "") {
				$.messager.alert("提示", "请输入考点内容", "info");
				return;
			}
			$.post('${proPath}/question/insert.action', {
				"questionContent" : question
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
		<h3>添加题目</h3>
	</center>
	<center>
		<div>
			<th>题目内容</th>
			<textarea name="questionText" cols="80 " rows="10 "></textarea>

		</div>
	</center>

	<center>
		<div>
			<th>题目难度</th>
			<td><input type="radio" name="questionLevelId" value="1"
				checked="checked" />基础 <input type="radio" name="questionLevelId"
				value="2" />中档 <input type="radio" name="questionLevelId" value="3" />难题</td>
		</div>
	</center>
	</center>
	<div>
		<th>题目类型</th>
		<td><input type="radio" name="questionTypeId" value="1"
			checked="checked" />选择题 <input type="radio" name="questionTypeId"
			value="2" />填空题 <input type="radio" name="questionTypeId" value="3" />解答题</td>
	</div>

	<div>
		<th>题目年级</th>
		<td><input type="radio" name="questionGradeId" value="1"
			checked="checked" />五年级上 <input type="radio" name="questionGradeId"
			value="2" />五年级下 <input type="radio" name="questionGradeId"
			value="3" />六年级上 <input type="radio" name="questionGradeId"
			value="4" />六年级下 <input type="radio" name="questionGradeId"
			value="5" />七年级上 <input type="radio" name="questionGradeId"
			value="6" />七年级下 <input type="radio" name="questionGradeId"
			value="7" />八年级上 <input type="radio" name="questionGradeId"
			value="8" />八年级下 <input type="radio" name="questionGradeId"
			value="9" />九年级上 <input type="radio" name="questionGradeId"
			value="10" />九年级下</td>
	</div>

	<div>
		<th>题目章节</th>
		<td colspan="2" align="center"><select id="cc_chapter"
			class="easyui-combobox" editable="false" style="width:200px;"></select>
		</td>
	</div>
	
	<div>
		<th>题目考点</th>
		<td colspan="2" align="center"><select id="cc_emphasis"
			class="easyui-combobox" editable="false" style="width:200px;"></select>
		</td>
	</div>
	<div>
		<td colspan="2" align="center"><a href="javascript:void(0);"
			class="easyui-linkbutton" iconCls="icon-add" plain="true" id="btnAdd">保存</a>
		</td>
	</div>

</body>
</html>
