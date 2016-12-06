<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	
</script>

</head>

<body>
	<table width="100%" class="degree">
  <tbody>
  <tr>
    <th style="width: 3em;">题型</th>
    <td>
      <ul>
        <li><a class="cur" onclick="setCT(this,0)" href="javascript:void(0)">全部</a></li>
        <li><a onclick="setCT(this,1)" href="javascript:void(0)" class="">选择题</a></li>
        <li><a onclick="setCT(this,2)" href="javascript:void(0)">填空题</a></li>
        <li><a onclick="setCT(this,9)" href="javascript:void(0)" class="">解答题</a></li></ul></td></tr>
  <tr>
    <th>难度</th>
    <td>
      <ul>
        <li><a class="cur" onclick="setDG(this,0)" href="javascript:void(0)">全部</a></li>
        <li><a onclick="setDG(this,1)" href="javascript:void(0)">基础题</a></li>
        <li><a onclick="setDG(this,2)" href="javascript:void(0)" class="">中档题</a></li>
        <li><a onclick="setDG(this,3)" href="javascript:void(0)">难题</a></li></ul></td></tr>
  <tr>
    <th style="border: currentColor; border-image: none;">题类</th>
    <td style="border: currentColor; border-image: none;">
      <ul>
        <li><a class="cur" onclick="setFG(this,0)" href="javascript:void(0)">全部</a></li>
        <li><a onclick="setFG(this,1)" href="javascript:void(0)" class="">中考题</a></li>
        <li><a onclick="setFG(this,8)" href="javascript:void(0)" class="">常考题</a></li>
        <li><a onclick="setFG(this,4)" href="javascript:void(0)" class="">易错题</a></li>
        <li><a onclick="setFG(this,2)" href="javascript:void(0)" class="">好题</a></li>
        <li><a onclick="setFG(this,16)" href="javascript:void(0)">压轴题</a></li></ul></td></tr></tbody></table>

	
</body>
</html>
