<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	
	$(function() {
		$('#tt').etree({
			url : '${proPath}/emphasis/getAllTypeTree.action',
		});
	});
</script>

</head>

<body>

	<ul id="tt"></ul>

</body>
</html>
