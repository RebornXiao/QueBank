<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	$(function() {
		$('#questiontable').datagrid({
			url : '${proPath}/question/selectByEmphasis.action',
			title : '题目列表',
			fitColumns : true,
			nowrapL : true,
			idField : 'questionId',
			rownumbers : true,
			pagination : true,
			pageSize : 50,
			pageList : [ 50, 100, 200, 500 ],

			queryParams : {
				questionLevelId : '%%',
				questionTypeId : '%%'
			},

			columns : [ [ {
				checkbox : true,
			}, {
				field : 'questionText',
				title : '题目内容',
				width : 1000
			}, {
				field : 'questionLevelText',
				title : '难度',
				width : 75
			}, {
				field : 'questionTypeText',
				title : '类型',
				width : 75
			}, {
				field : 'questionGradeText',
				title : '年级',
				width : 75
			}, {
				field : 'questionChapterText',
				title : '分类',
				width : 75
			}, {
				field : 'questionEmphasisText',
				title : '考点',
				width : 75
			}, {
				field : 'questionVersionText',
				title : '版本',
				width : 75
			} ] ],
			pagination : true,
			rownumbers : true
		});
	});

	//题型  全部 0，ct选择  填空  解答  123
	//难度  全部 0 dg 123
	//
	var bookID, f = '0';
	var q = '', ct = 0, dg = 0, fg = 0, po = 0, pd = 1, pi = 1;

	function setCT(el, val) {
		el = $(el);
		ct = val;
		pi = 1;
		$('li', el.closest('ul')).each(function() {
			$('a', $(this)).removeClass('cur');
		});
		el.addClass('cur');
		_loadList();
	}
	
	function setDG(el, val) {
		el = $(el);
		dg = val;
		pi = 1;
		$('li', el.closest('ul')).each(function() {
			$('a', $(this)).removeClass('cur');
		});
		el.addClass('cur');
		_loadList();
	}
	
	function _loadList() {
		$('#questiontable').datagrid('load', {
			questionLevelId : '%' + dg + '%',
			questionTypeId : '%' + ct + '%'
		});

	}
	function _setCookiePM() {
		$.cookie('j_math_q_q_' + f, q);
		$.cookie('j_math_q_ct', ct);
		$.cookie('j_math_q_dg', dg);
		$.cookie('j_math_q_fg', fg);
		$.cookie('j_math_q_po', po);
		$.cookie('j_math_q_pd', pd);

	}
	$(function() {
		var divTree = $("#divTree"), nav = $(".nav"), navTop = nav.offset().top, treeTop = divTree
				.offset().top, divAd = $("#ja017");

		_getCookiePM();

		if (f == 0) {
			var tr = $('tr.JYE_EDITION'), v = $.cookie('QS_ED'), a = $(
					'a[data-id=' + v + ']', tr);
			if (a.size() == 0) {
				$('a', tr).eq(0).click();
			} else {
				a.click();
			}
		} else {
			_loadTree();
		}

		divTree.css({
			"max-height" : $(window).height() - divTree.offset().top - 44
		});

		$(window).scroll(
				function() {
					var s = $(document).scrollTop();
					if (s > treeTop) {
						if (!divTree.hasClass('tree-box-show')) {
							divTree.addClass('tree-box-show');
						}
					} else {
						divTree.removeClass('tree-box-show');
					}

					if (s > navTop) {
						if (!nav.hasClass('nav-box-show')) {
							nav.addClass('nav-box-show')
						}
					} else {
						nav.removeClass('nav-box-show')
					}

					var tS = divAd.offset().top - $(window).height();
					var maxHight = divTree.height();
					if (s > tS) {
						maxHight = divAd.offset().top - s - 40 - 44;
						divTree.css({
							"max-height" : maxHight
						});
					} else {
						maxHight = $(window).height()
								- (divTree.offset().top - s) - 44;
						divTree.css({
							"max-height" : maxHight
						});
					}
					if (maxHight < divTree.find("ul").height() + 44) {
						divTree.css({
							"overflow-y" : "scroll"
						});
					} else {
						divTree.css({
							"overflow-y" : ""
						});
					}
				});

		QuesCart.init('math');

		if ('False' == 'True') {
			openBox({
				width : 400,
				height : 190,
				title : "【验证手机送优点】"
			}, '/api/mobileverify?r=' + Math.random());
		}
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
						<li><a class="cur" onclick="setCT(this,0)"
							href="javascript:void(0)">全部</a></li>
						<li><a onclick="setCT(this,1)" href="javascript:void(0)"
							class="">选择题</a></li>
						<li><a onclick="setCT(this,2)" href="javascript:void(0)">填空题</a>
						</li>
						<li><a onclick="setCT(this,9)" href="javascript:void(0)"
							class="">解答题</a></li>
					</ul></td>
			</tr>
			<tr>
				<th>难度</th>
				<td>
					<ul>
						<li><a class="cur" onclick="setDG(this,0)"
							href="javascript:void(0)">全部</a></li>
						<li><a onclick="setDG(this,1)" href="javascript:void(0)">基础题</a>
						</li>
						<li><a onclick="setDG(this,2)" href="javascript:void(0)"
							class="">中档题</a></li>
						<li><a onclick="setDG(this,3)" href="javascript:void(0)">难题</a>
						</li>
					</ul></td>
			</tr>

		</tbody>
	</table>

	<table id="questiontable" class="easyui-datagrid">
	</table>

</body>
</html>
