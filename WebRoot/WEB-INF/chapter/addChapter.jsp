<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>
<script type="text/javascript">
	$(function() {
		$("#btnAdd").bind("click", function() {
			var text = $('#cc').combobox('getValue');
			var str = $("#chapter").val();
			if (str == null || str == "") {
				$.messager.alert("提示", "请输入章节内容", "info");
				return;
			}
			var chapter = text + str;
			$.post('${proPath}/chapter/insert.action', {
				"chapter" : chapter
			}, function(data) {
				if (data == "success") {
					$.messager.alert("提示", "保存成功", "info");
				} else {

					if (data == "have") {
						$.messager.alert("提示", "章节内容已存在", "info");
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
		<h3>添加章节</h3>
	</center>

	<div>
		<th>章节内容</th> <select id="cc" class="easyui-combobox" name="dept"
			editable="false" style="width:200px;">
			<option>第一章</option>
			<option>第二章</option>
			<option>第三章</option>
			<option>第四章</option>
			<option>第五章</option>
			<option>第六章</option>
			<option>第七章</option>
			<option>第八章</option>
			<option>第九章</option>
			<option>第十章</option>
			<option>第十一章</option>
			<option>第十二章</option>
			<option>第十三章</option>
			<option>第十四章</option>
			<option>第十五章</option>
			<option>第十六章</option>
			<option>第十七章</option>
			<option>第十八章</option>
			<option>第十九章</option>
			<option>第二十章</option>
			<option>第二十一章</option>
			<option>第二十二章</option>
			<option>第二十三章</option>
			<option>第二十四章</option>
			<option>第二十五章</option>
			<option>第二十六章</option>
			<option>第二十七章</option>
			<option>第二十八章</option>
			<option>第二十九章</option>
			<option>第三十章</option>
			<option>第三十一章</option>
			<option>第三十二章</option>
			<option>第三十三章</option>
			<option>第三十四章</option>
			<option>第三十五章</option>
			<option>第三十六章</option>
			<option>第三十七章</option>
			<option>第三十八章</option>
			<option>第三十九章</option>
			<option>第四十章</option>
			<option>第四十一章</option>
			<option>第四十二章</option>
			<option>第四十三章</option>
			<option>第四十四章</option>
			<option>第四十五章</option>
			<option>第四十六章</option>
			<option>第四十七章</option>
			<option>第四十八章</option>
			<option>第四十九章</option>
			<option>第五十章</option>
			<option>第五十一章</option>
			<option>第五十二章</option>
			<option>第五十三章</option>
			<option>第五十四章</option>
			<option>第五十五章</option>
			<option>第五十六章</option>
			<option>第五十七章</option>
			<option>第五十八章</option>
			<option>第五十九章</option>
			<option>第六十章</option>
			<option>第六十一章</option>
			<option>第六十二章</option>
			<option>第六十三章</option>
			<option>第六十四章</option>
			<option>第六十五章</option>
			<option>第六十六章</option>
			<option>第六十七章</option>
			<option>第六十八章</option>
			<option>第六十九章</option>
			<option>第七十章</option>
			<option>第七十一章</option>
			<option>第七十二章</option>
			<option>第七十三章</option>
			<option>第七十四章</option>
			<option>第七十五章</option>
			<option>第七十六章</option>
			<option>第七十七章</option>
			<option>第七十八章</option>
			<option>第七十九章</option>
			<option>第八十章</option>
			<option>第八十一章</option>
			<option>第八十二章</option>
			<option>第八十三章</option>
			<option>第八十四章</option>
			<option>第八十五章</option>
			<option>第八十六章</option>
			<option>第八十七章</option>
			<option>第八十八章</option>
			<option>第八十九章</option>
			<option>第九十章</option>
			<option>第九十一章</option>
			<option>第九十二章</option>
			<option>第九十三章</option>
			<option>第九十四章</option>
			<option>第九十五章</option>
			<option>第九十六章</option>
			<option>第九十七章</option>
			<option>第九十八章</option>
			<option>第九十九章</option>
			<option>第一百章</option>
		</select>

		<td><input id="chapter" type="text" name="chapterContent"
			style="width:500px" /></td>

	</div>
	</div>

	<div>
		<form>
			<td colspan="2" align="center"><a href="javascript:void(0);"
				class="easyui-linkbutton" iconCls="icon-add" plain="true"
				id="btnAdd">保存</a>
			</td>
		</form>
	</div>

</body>
</html>



