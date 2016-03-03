<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课成绩</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<center>
		<h1>
			选课成绩<br>
		</h1>
		<table border="1" align="center">
			<tr>
				<td>序号</td>
				<td>课程号</td>
				<td>课程名</td>
				<td>学分</td>
				<td>分数</td>
			</tr>

			<s:iterator value="s" status="row">
				<tr>
					<td><s:property value="#row.getIndex()+1" /></td>
					<td><s:property value="cno" /></td>
					<td><s:property value="cname" /></td>
					<td><s:property value="cmark" /></td>
					<td><s:property value="score" /></td>
				</tr>
			</s:iterator>

		</table>
	</center>
</body>
</html>
