<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>
 <style type="text/css">  
  
        body {  
            margin: 0 auto;  
        }  
  
        #show {  
            margin: 10px auto;  
            width: 450px;  
            font-size: 14px;  
        }  
  
        .content {  
            float: left;  
            width: 450px;  
            margin: 10px 0px 20px 10px;  
        }  
  
        .bigfont {  
            font-size: 14px;  
        }  
  
        .la {  
            float: left;  
            width: 50px;  
            height: 20px;  
            margin: 5px 0;  
            line-height: 20px;  
        }  
  
        .la input {  
            float: left;  
        }  
  
        .la span {  
            float: left;  
            line-height: 20px;  
        }  
  
    </style>  
  
  
    <script type="text/javascript" src="../../libs/jquery/jquery-1.11.2.min.js"></script>  
  
    <script type="text/javascript">  
  
        window.onload = function () {  
            var years = ["2013", "2014"];  
            var months = {  
                "2013": [12, 11, 10, 9, 8, 7],  
                "2014": [6, 5, 4, 3, 2, 1]  
            };  
            var yearMonth = [years, months];  
            genCheck(yearMonth);  
        }  
  
  
        function genCheck(yearMonth) {  
            var content = "content";  
            var checkText = "checkbox";  
            var link = "link";  
            var size;  
  
            $("#show").html("");  
  
            var years = yearMonth[0];  
            size = years.length;  
            for (var i = 0; i < years.length; i++) {  
                genShowContent("show", checkText + i, i, years[i] + "年", content + i);  
            }  
            var monthObj = yearMonth[1];  
  
            for (var i = 0; i < years.length; i++) {  
                var array = monthObj["" + years[i] + ""];  
                for (var j = 0; j < array.length; j++) {  
                    genCheckBox(content + i, link + i, array[j], array[j] + "月", i, false);  
                }  
  
                var flag = isAllCheck(link + i);  
                var box = document.getElementById(checkText + i);  
                if (flag) {  
                    box.checked = true;  
                } else {  
                    box.checked = false;  
                }  
                $("input[name=" + link + i + "]").each(function () {  
                    $(this).unbind();  
                    $(this).change(function () {  
                        var flag = isAllCheck($(this).attr("name"));  
                        var box = document.getElementById(checkText + $(this).attr("parentIndex"));  
                        if (flag) {  
                            box.checked = true;  
                        } else {  
                            box.checked = false;  
                        }  
                    });  
                });  
            }  
            for (var i = 0; i < size; i++) {  
                $("#" + checkText + i).unbind();  
                $("#" + checkText + i).change(function () {  
                    var temp = link + $(this).attr("index");  
                    var p = document.getElementById(checkText + $(this).attr("index"));  
                    var box = document.getElementsByName(temp);  
                    for (var j = 0; j < box.length; j++) {  
                        if (p.checked) {  
                            box[j].checked = true;  
                        } else {  
                            box[j].checked = false;  
                        }  
                    }  
                });  
            }  
        }  
  
  
        function genCheckBox(id, name, value, showText, parentIndex, isCheck) {  
            if (!isCheck) {  
                var checkbox = "<div class='la'><input type='checkbox' parentIndex=" + parentIndex + " name=".concat(name).concat(" value=").concat(value).concat(" alt=").concat(showText).concat(" /><span>").concat(showText).concat("</span></div>");  
                $("#" + id).append(checkbox);  
            } else {  
                var checkbox = "<div class='la'><input type='checkbox' parentIndex=" + parentIndex + " name=".concat(name).concat(" checked='checked' value=").concat(value).concat(" alt=").concat(showText).concat(" /><span>").concat(showText).concat("</span></div>");  
                $("#" + id).append(checkbox);  
            }  
        }  
  
  
        function genShowContent(id, checkboxId, index, showText, idName) {  
            var showContent = "<div class='msg'><span class='bigfont'>".concat(showText).concat("： </span><input type='checkbox' index=").concat(index).concat(" id='").concat(checkboxId).concat("'/><span>全选</span><div class='content' id='").concat(idName).concat("' ></div></div>");  
            $("#" + id).append(showContent);  
        }  
  
  
        function isAllCheck(name) {  
            var box = document.getElementsByName(name);  
            for (var j = 0; j < box.length; j++) {  
                if (!box[j].checked) {  
                    return false;  
                }  
            }  
            return true;  
        }  
    </script>  
</head>

<body>
	<center>
		<h3>添加章节</h3>
	</center>
	<div class="show" id="show"></div> 
	<form id="add"
		action="${prePath}/chapter/insert.action"
		method="post">

		<div>
			<th>章节内容</th>
			<td><input type="text" name="chapterContent" style = "width:500px"/></td>
			
		</div>
		</div>
		<div>
			<th>题目年级</th>
			<td><input type="radio" name="chapterGrade" value="1"
				checked="checked" />
				五年级上 <input type="radio" name="chapterGrade"
				value="2" />五年级下 <input type="radio" name="chapterGrade"
				value="3" />六年级上 <input type="radio" name="chapterGrade"
				value="4" />六年级下 <input type="radio" name="chapterGrade"
				value="5" />七年级上 <input type="radio" name="chapterGrade"
				value="6" />七年级下 <input type="radio" name="chapterGrade"
				value="7" />八年级上 <input type="radio" name="chapterGrade"
				value="8" />八年级下 <input type="radio" name="chapterGrade"
				value="9" />九年级上 <input type="radio" name="chapterGrade"
				value="10" />九年级下</td>
		</div>
		<div>
			<th>章节所属章数</th>
			<td><input type="text" name="chapterNum" style = "width:500px"/></td>
		</div>

		<div>
			<td colspan="2" align="center"><input type="submit" value="保存" />&nbsp;
				<input type="reset" value="重置" />
			</td>
		</div>
	</form>

</body>
</html>



用JS实现的radio图片选择按钮效果


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用JS实现的radio图片选择按钮效果-懒人图库</title>
<style>
.lanrentuku img{border:1px solid #008800;}
</style>
</head>

<body>
<script>
  function myFun(sId) {
    var oImg = document.getElementsByTagName('img');

    for (var i = 0; i < oImg.length; i++) {
      if (oImg[i].id == sId) {
        oImg[i].previousSibling.previousSibling.checked = true;
        oImg[i].style.border = '1px solid #FF6600';
      } else {
        oImg[i].style.border = '1px solid #008800';

      }
    }
  }
</script>
<div class="lanrentuku">
 <input type="radio" value= "lanrentuku" id= "111" name="aaa" style="display:none"> <img id="aa" src="http://www.lanrentuku.com/down/js/images/12625207690.gif " onclick="myFun(this.id)"> 
 <input type="radio" value= "lanrentuku" id= "222" name="aaa" style="display:none"> <img id="bb" src="http://www.lanrentuku.com/down/js/images/12625207691.gif" onclick="myFun(this.id)"> 
 <input type="radio" value= "lanrentuku" id= "333" name="aaa" style="display:none"> <img id="cc" src="http://www.lanrentuku.com/down/js/images/12625207692.gif" onclick="myFun(this.id)">
</div>
<p>用JS实现的radio图片选择按钮效果，可应用在dedecms的留言板程序上。</p>
<p>注意：input后面的空格。</p>
<p>作者：<a href="http://www.maitianquan.com/" target="_blank">麦田圈</a></p>
 尊重他人劳动，转载请保留出处！</p>
<p>查找更多代码，请访问：<a href="http://www.lanrentuku.com/" target="_blank">懒人图库</a></p>
</body>
</html>
