<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

</head>

<body>
	<center>
		<h3>添加章节数</h3>
	</center>
	<form id="add"
		action="${pageContext.request.contextPath}/question/insert.action"
		method="post">

		<div>
			<th>章节内容</th>
			<textarea name="questionText" cols="80 " rows="10 "></textarea>
			<font color="red">${msg }</font>
		</div>
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
			<th>章节所属章数</th>
			<td><input type="radio" name="questionTypeId" value="1"
				checked="checked" />选择题 <input type="radio" name="questionTypeId"
				value="2" />填空题 <input type="radio" name="questionTypeId" value="3" />解答题</td>
		</div>


		<div>
			<td colspan="2" align="center"><input type="submit" value="保存" />&nbsp;
				<input type="reset" value="重置" />
			</td>
		</div>
	</form>

</body>
</html>
