<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		$('#cc_emphasis').combobox({
			url : '${proPath}/emphasis/selectAll.action',
			valueField : 'id',
			textField : 'text',
			onSelect : onCCselect,
			onLoadSuccess : onLoadSuccess,
		});

		function onCCselect() {
			var questionEmphasisText = $('#cc_emphasis').combobox('getText');
			$('#questiontable').datagrid('load', {
				questionEmphasisText : questionEmphasisText,
				questionTypeId : questionTypeId,
				questionLevelId : questionLevelId,
			});

		}
		function onLoadSuccess() {
			$('#questiontable').datagrid({
				url : '${proPath}/question/selectPageListUseDyc.action',
				title : '题目列表',
				fitColumns : true,
				nowrapL : true,
				idField : 'questionId',
				singleSelect : true,
				rownumbers : true,
				pagination : true,
				pageSize : 50,
				pageList : [ 50, 100, 200, 500 ],

				columns : [ [ {
					checkbox : true,
				}, {
					field : 'questionText',
					title : '题目内容',
					width : 1000
				} ] ],
				pagination : true,
				rownumbers : true
			});
		}

		//题型  全部 0，ct选择  填空  解答  123
		//难度  全部 0 dg 123
		//
		var bookID, f = '0';
		var q = '', ct = 0, dg = 0, fg = 0, po = 0, pd = 1, pi = 1;
		var questionTypeId;
		var questionLevelId;
		function setCT(el, val) {

			el = $(el);
			ct = val;
			if (ct == 0) {
				questionTypeId = null;
			} else if (ct == 1) {
				questionTypeId = 1;
			} else if (ct == 2) {
				questionTypeId = 2;
			} else if (ct == 3) {
				questionTypeId = 3;
			} else {
				questionTypeId = null;
			}
			
			pi = 1;
			$('li', el.closest('ul')).each(function() {
				$('a', $(this)).removeClass('cur');
			});
			el.addClass('cur');
			onCCselect();
		}

		function setDG(el, val) {
			
			el = $(el);
			dg = val;
			pi = 1;

			if (dg == 0) {
				questionLevelId = null;
			} else if (dg == 1) {
				questionTypeId = 1;
			} else if (dg == 2) {
				questionLevelId = 2;
			} else if (dg == 3) {
				questionLevelId = 3;
			} else {
				questionLevelId = null;
			}

			$('li', el.closest('ul')).each(function() {
				$('a', $(this)).removeClass('cur');
			});
			el.addClass('cur');
			onCCselect();
		}

		$("#all_type").bind("click", function() {
			setCT(this, 0);
		});
		$("#all_type1").bind("click", function() {
			setCT(this, 1);
		});
		$("#all_type2").bind("click", function() {
			setCT(this, 2);
		});
		$("#all_type3").bind("click", function() {
			setCT(this, 3);
		});
		$("#all_level").bind("click", function() {
			setDG(this, 0);
		});
		$("#all_level1").bind("click", function() {
			setDG(this, 1);
		});
		$("#all_level2").bind("click", function() {
			setDG(this, 2);
		});
		$("#all_level3").bind("click", function() {
			setDG(this, 3);
		});

		$("#btnQuery").bind("click", function() {
			var row = $("#questiontable").datagrid('getSelected');
			if (row == null) {
				alert("请先选择你要添加的试题");
			} else {
				var id = row['questionId']
				$.post('${proPath}/basket/insertTemp.action', {
					"id" : id
				}, function(data) {
					if (data == "success") {
						$.messager.alert("提示", "添加成功", "info");
					} else if (data == "have") {
						$.messager.alert("提示", "这道题已经存在", "info");
					} else {
						$.messager.alert("提示", "添加失败", "info");
					}
				}, "text");
			}
		});
	});
</script>

</head>

<body>
	<table width="100%" class="degree">
		<tbody>
			<tr>
				<th style="width: 3em;">题型</th>
				<td>
					<ul>
						<li><a id="all_type" class="cur" onclick="setCT(this,0)"
							href="javascript:void(0)">全部</a>
						</li>
						<li><a id="all_type1" onclick="setCT(this,1)"
							href="javascript:void(0)" class="">选择题</a>
						</li>
						<li><a id="all_type2" onclick="setCT(this,2)"
							href="javascript:void(0)">填空题</a>
						</li>
						<li><a id="all_type3" onclick="setCT(this,9)"
							href="javascript:void(0)" class="">解答题</a>
						</li>
					</ul>
				</td>
			</tr>
			<tr>
				<th>难度</th>
				<td>
					<ul>
						<li><a id="all_level" class="cur" onclick="setDG(this,0)"
							href="javascript:void(0)">全部</a>
						</li>
						<li><a id="all_level1" onclick="setDG(this,1)"
							href="javascript:void(0)">基础题</a></li>
						<li><a id="all_level2" onclick="setDG(this,2)"
							href="javascript:void(0)" class="">中档题</a>
						</li>
						<li><a id="all_level3" onclick="setDG(this,3)"
							href="javascript:void(0)">难题</a></li>
					</ul>
				</td>
			</tr>

		</tbody>
	</table>
	<div style="float:left">
		<th>题目考点</th>
		<td colspan="2" align="left"><select id="cc_emphasis"
			class="easyui-combobox" editable="false" style="width:200px;"></select>
		</td>
	</div>

	<table id="questiontable" class="easyui-datagrid" toolbar="#toolbar">
	</table>
	<!--列表工具栏 -->
	<div id="toolbar" style="height:auto">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" id="btnQuery">添加到试题篮</a>
	</div>
</body>
</html>
