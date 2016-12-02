<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<title>添加题目</title>


</head>

<body>
	<center>
		<h3>添加考点</h3>
	</center>
	<form id="add"
		action="${proPath}/emphasis/insert.action"
		method="post">

		<div>
			<th>考点分类</th>

			<td><input id="cc" class="easyui-combobox" name="dept"
				data-options="valueField:'id',textField:'text',url:'${proPath}/emphasis/getAllType.action'" />

				<input type="text" name="emphasisContent" />
			</td>

		</div>
		<div>
			<th>提高拓展专题</th>
			<td><input type="text" name="emphasisTypeText" />
			</td>
			</tr>
			<div>
				<td colspan="2" align="center"><input type="submit" value="保存" />&nbsp;
					<input type="reset" value="重置" />
				</td>
			</div>
	</form>

</body>
</html>
