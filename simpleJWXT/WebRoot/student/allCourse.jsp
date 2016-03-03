<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课</title>
<style type="text/css">
table {
	text-align: left;
	border: 1px solid silver;
}

th, tr, td {
	border: 1px solid silver;
}

ul li {
	margin-bottom: 20px;
}
</style>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<div align="center">
		<h1 style="color:red;" align="center">
			已选课程数/最大选课数：
			<s:property value="chooseNumber" />
			/
			<s:property value="stu.maxCourse" />
		</h1>
		<table border="1" align="center">
			<tr>
				<td>序列</td>
				<td>课程名称</td>
				<td>已选/名额上限</td>
			</tr>
			<s:iterator value="courseList" status="row">
				<tr>
					<td align="center"><s:property
							value="#row.getIndex()+1+(pageNumber-1)*10" /></td>
					<td><s:url id="detail" action="courseInit!detail">
							<s:param name="cid">
								<s:property value="cid" />
							</s:param>
						</s:url> <s:a href="%{detail}">
							<s:property value="cname" />
						</s:a></td>
					<td>（<s:property value="chooseCurNum" /> / <s:property
							value="chooseMax" />）
					</td>
				</tr>
			</s:iterator>
		</table>
		<ul id="ulLink">
			<s:property value="pageNumber+'|'" />
			<s:property value="totalPage" />
			<s:url id="firstPage" action="scpageAction">
				<s:param name="pageNumber">1</s:param>
			</s:url>
			<s:a cssClass="myst" href='scpageAction'>首页</s:a>
			<s:url id="prePage" action="scpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber-1' />
				</s:param>

			</s:url>
			<s:a cssClass="myst" href="%{prePage}">上一页</s:a>
			<s:url id="nextPage" action="scpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber+1' />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{nextPage}">下一页</s:a>
			<s:url id="lastPage" action="scpageAction">
				<s:param name="pageNumber">
					<s:property value="totalPage" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{lastPage}">末页</s:a>
		</ul>
	</div>
	</body>
</html>
