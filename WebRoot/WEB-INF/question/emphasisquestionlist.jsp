<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<script type="text/javascript">
	var bookID, f = '0';
	var q = '', ct = 0, dg = 0, fg = 0, po = 0, pd = 1, pi = 1;
	function setFG(el, val) {
		el = $(el);
		fg = val;
		pi = 1;
		$('li', el.closest('ul')).each(function() {
			$('a', $(this)).removeClass('cur');
		});
		el.addClass('cur');
		_loadList();
	}
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

		var url = '/math/ques/partialques?q=' + encodeURIComponent(q) + '&f='
				+ f;

		url += '&ct=' + ct;
		url += '&dg=' + dg;
		url += '&fg=' + fg;
		url += '&po=' + po;
		url += '&pd=' + pd;
		url += '&pi=' + pi;
		url += '&r=' + Math.random();

		var divList = $("#divList")
				.empty()
				.loading("CT")
				.load(
						url,
						function(response, status, xhr) {
							divList.loaded();

							switch (status) {
							case 'success':
							case 'notmodified':
								_setCookiePM();
								try {
									renderLatex(this);
								} catch (e) {
								}
								break;
							case 'error':
								divList
										.html('<div class="message emsg">系统错误，请与客服联系。</div>');
								break;
							case 'timeout':
								divList
										.html('<div class="message emsg">系统繁忙，请稍后再试。</div>');
								break;
							case 'parsererror':
								divList
										.html('<div class="message emsg">系统错误，请与客服联系。</div>');
								break;
							default:
								divList
										.html('<div class="message emsg">参数传入错误。</div>');
								break;
							}
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
							href="javascript:void(0)">全部</a>
						</li>
						<li><a onclick="setCT(this,1)" href="javascript:void(0)"
							class="">选择题</a>
						</li>
						<li><a onclick="setCT(this,2)" href="javascript:void(0)">填空题</a>
						</li>
						<li><a onclick="setCT(this,9)" href="javascript:void(0)"
							class="">解答题</a>
						</li>
					</ul>
				</td>
			</tr>
			<tr>
				<th>难度</th>
				<td>
					<ul>
						<li><a class="cur" onclick="setDG(this,0)"
							href="javascript:void(0)">全部</a>
						</li>
						<li><a onclick="setDG(this,1)" href="javascript:void(0)">基础题</a>
						</li>
						<li><a onclick="setDG(this,2)" href="javascript:void(0)"
							class="">中档题</a>
						</li>
						<li><a onclick="setDG(this,3)" href="javascript:void(0)">难题</a>
						</li>
					</ul>
				</td>
			</tr>
			<tr>
				<th style="border: currentColor; border-image: none;">题类</th>
				<td style="border: currentColor; border-image: none;">
					<ul>
						<li><a class="cur" onclick="setFG(this,0)"
							href="javascript:void(0)">全部</a>
						</li>
						<li><a onclick="setFG(this,1)" href="javascript:void(0)"
							class="">中考题</a>
						</li>
						<li><a onclick="setFG(this,8)" href="javascript:void(0)"
							class="">常考题</a>
						</li>
						<li><a onclick="setFG(this,4)" href="javascript:void(0)"
							class="">易错题</a>
						</li>
						<li><a onclick="setFG(this,2)" href="javascript:void(0)"
							class="">好题</a>
						</li>
						<li><a onclick="setFG(this,16)" href="javascript:void(0)">压轴题</a>
						</li>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>


</body>
</html>
