<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<s:form id="form1" name="form1" method="post" action="addCourse">
		<table border="1" align="center">
			<tr>
				<td colspan="2"><div align="center">添加课程</div></td>
			</tr>
			<tr>
				<td><div align="right">课程号：</div></td>
				<td><s:textfield theme="simple" name="cno" />&nbsp;</td>

			</tr>
			<tr>
				<td><div align="right">课程名：</div></td>
				<td><s:textfield theme="simple" name="cname" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师id：</div></td>
				<td><s:textfield theme="simple" name="tid" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">授课时间：</div></td>
				<td><s:textfield theme="simple" name="ctime" /></td>

			</tr>
			<tr>
				<td><div align="right">教室：</div></td>
				<td><s:textfield theme="simple" name="roomid" />&nbsp;</td>

			</tr>
			<tr>
				<td><div align="right">学分：</div></td>
				<td><s:textfield theme="simple" name="cmark" />&nbsp;</td>

			</tr>
			<tr>
				<td><div align="right">最多选课人数：</div></td>
				<td><s:textfield theme="simple" name="chooseMax" />&nbsp;</td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="提交" /> <input
					type="reset" name="Submit2" value="重置" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
