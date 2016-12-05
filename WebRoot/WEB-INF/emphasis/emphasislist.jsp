<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<script type="text/javascript">
	$(function() {
		$('#tt').treegrid({
			url : '${proPath}/emphasis/getAllTypeTree.action',
			idField : 'emphasisTypeId',
			treeField : 'emphasisTypeText',
			columns : [ [ {
				field : 'emphasisTypeId',
				title : 'emphasisTypeId',
				width : 60,
				align : 'right'
			}, {
				field : 'emphasisTypeText',
				title : 'emphasisTypeText',
				width : 80
			}, ] ]
		});
		
		$('#tt').treegrid('append', {
			parent : emphasisTypeId, // the node has a 'id' value that defined through 'idField' property
			data : [ {
				id : '073',
				name : 'name73'
			} ]
		});

	});
</script>

</head>

<body>

	<table id="tt" style="width:1600px;height:400px"></table>

</body>
</html>
