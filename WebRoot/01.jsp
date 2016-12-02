<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>
<title>刘思阳数学题库</title>

</head>

<body>

	<div id="myfirst" class="easyui-layout"
		style="width:100%;height:100%;padding=10px">

		<!-- 区域面板--北边 -->
		<div
			data-options="region:'north',title:'刘思阳数学题库',split:true,border:true,iconCls:'icon-remove',collapsible:true"
			style="height:1px;"></div>

		<!-- 区域面板--南边 -->
		<!-- 	<div data-options="region:'south',title:'South Title',split:true"
			style="height:100px;"></div> -->

		<!-- 区域面板--东边 -->
		<!-- 	<div
			data-options="region:'east',iconCls:'icon-reload',title:'East',split:true"
			style="width:100px;"></div> -->

		<!-- 区域面板--西边 -->
		<div data-options="region:'west',title:'导航',split:true"
			style="width:100px;">

			<div id="aa" class="easyui-accordion"
				style="width:300px;height:400px;">

				<div title="综合题库">

					<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
					<ul style="list-style: none;padding: 0px;margin:0px;">
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/question/questionlist.action"
							title="综合题库"
							style="text-decoration: none;display: block;font-weight:bold;">综合题库</a>
						</li>
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/question/addQuestion.action"
							title="题目录入"
							style="text-decoration: none;display: block;font-weight:bold;">题目录入</a>
						</li>
					</ul>
				</div>

				<div title="题目类型管理">

					<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
					<ul style="list-style: none;padding: 0px;margin:0px;">
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/emphasis/addEmphasis.action"
							title="题目考点"
							style="text-decoration: none;display: block;font-weight:bold;">题目类型</a>
						</li>
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/chapter/addChapter.action"
							title="题目章节"
							style="text-decoration: none;display:
							block;font-weight:bold;">题目章节</a>
						</li>
					</ul>
				</div>

				<div title="试卷篮">

					<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
					<ul style="list-style: none;padding: 0px;margin:0px;">
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/basket/basketlist.action" title="试卷篮"
							style="text-decoration: none;display: block;font-weight:bold;">试卷篮</a>
						</li>
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/basket/addbasket.action" title="随机试题篮"
							style="text-decoration: none;display: block;font-weight:bold;">随机试题篮</a>
						</li>
						<li style="padding: 6px;"><a
							href="${proPath}/base/goURL/basket/tempbasket.action" title="临时试题篮"
							style="text-decoration: none;display: block;font-weight:bold;">临时试题篮</a>
						</li>

					</ul>
				</div>

			</div>

		</div>

		<!-- 区域面板--中间 -->
		<div data-options="region:'center',title:'内容'"
			style="padding:5px;background:#eee;">

			<div id="tt" class="easyui-tabs" style="width:1700px;height:800px;">
				<div href="${proPath}/welcome.jsp" title="欢迎您"
					style="text-decoration: none;display: block;font-weight:bold;">欢迎您</div>
			</div>

		</div>

		<script type="text/javascript">
			$("a[title]")
					.click(
							function() {
								var text = this.href;

								//判断是否存在
								if ($('#tt').tabs("exists", this.title)) {
									//存在则选中
									$('#tt').tabs("select", this.title);
								} else {
									$('#tt')
											.tabs(
													'add',
													{
														title : this.title,
														//面板有关闭按键
														closable : true,
														//href对远程页面js的支持不好 
														//href: text			
														//可以加载内容填充到选项卡，页面有Js时，也可加载
														content : "<iframe src='"
																+ text
																+ "' title='"
																+ this.title
																+ "' height='100%' width='100%' frameborder='0px' ></iframe>"

													});

								}
								return false;
							});
		</script>
</body>
</html>
