$(function() {

	$('#question')
			.datagrid(
					{
						title : '综合题库',
						width : 'auto',
						height : 'auto',
						fit : true,
						fitColumns : false,
						nowrap : true,
						striped : true,
						collapsible : true,
						singleSelect : true,
						url : '${pageContext.request.contextPath}/question/selectPage.action',
						
						pageSize : 200,
						idField : 'id',
						columns : [ [
								
								{
									field : 'questionText',
									title : '题目',
									width : $(this).width() * 0.08,
									align : 'center'
								},
								{
									field : 'questionLevelText',
									title : '难度',
									width : $(this).width() * 0.08,
									align : 'center'
								} ] ],
						pagination : true,
						rownumbers : true
					});

	// query
	$("#btnQuery").bind("click", function() {
		$("#grid").datagrid("load", {
			'cityCode' : $("#scityCode").combobox("getValue"),
			'name' : $("#s-name").textbox("getValue"),
			'phone' : $("#s-phone").textbox("getValue")
		});
	});

	// clear
	$("#btnClear").bind("click", function() {
		$("#memberSearchForm").form("clear");
	});

	$("#btnFrozen").bind("click", function() {
		var selectedRows = $("#grid").datagrid("getSelections");
		if (selectedRows.length <= 0) {
			$.messager.alert("提示", "请选择需要冻结资金的用户", "error");
		} else if (selectedRows[0].accoutStatus == "1") {
			$.messager.alert("提示", "用户资金已被冻结", "error");
		} else {
			var _memberId = selectedRows[0].memberId;
			var _accoutStatus = "1";
			$.post("member_card_frozen_thaw", {
				memberId : _memberId,
				accoutStatus : _accoutStatus
			}, function(data) {
				if (data == "succ") {
					$.messager.alert("提示", "操作成功", "info");
					$("#grid").datagrid("reload");
				} else {
					$.messager.alert("提示", "操作失败", "error");
				}
			}, "text");
		}
	});

	$("#btnThaw").bind("click", function() {
		var selectedRows = $("#grid").datagrid("getSelections");
		if (selectedRows.length <= 0) {
			$.messager.alert("提示", "请选择需要解冻资金的用户", "error");
		} else if (selectedRows[0].accoutStatus == "0") {
			$.messager.alert("提示", "用户资金已被解冻", "error");
		} else {
			var _memberId = selectedRows[0].memberId;
			var _accoutStatus = "0";
			$.post("member_card_frozen_thaw", {
				memberId : _memberId,
				accoutStatus : _accoutStatus
			}, function(data) {
				if (data == "succ") {
					$.messager.alert("提示", "操作成功", "info");
					$("#grid").datagrid("reload");
				} else {
					$.messager.alert("提示", "操作失败", "error");
				}
			}, "text");
		}
	});

});