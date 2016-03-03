<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课结果</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<div align="center">
		<h1>已选课程</h1>
		姓名:
		<s:property value="stu.name" />
		&nbsp;&nbsp; 学号:
		<s:property value="stu.sno" />
		<table border="1" align="center">
			<tr>
				<td>课程号</td>
				<td>您已选的课程:</td>
				<td>所选学分</td>
				<td>操作&nbsp;</td>
			</tr>
			<s:iterator value="courseList" id="row">
				<tr>
					<td><s:property value="#row.cno" /></td>
					<td><s:property value="#row.cname" /></td>
					<td><s:property value="#row.cmark" /></td>
					<s:url id="cancel" action="cancelCourse">
						<s:param name="sid">
							<s:property value="stu.sid" />
						</s:param>
						<s:param name="cid">
							<s:property value="#row.cid" />
						</s:param>
					</s:url>
					<td><s:a href="%{cancel}">取消此课</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
