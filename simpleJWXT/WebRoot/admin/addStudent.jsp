<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<form method="post" action="addStudent">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">添加学生</td>
			</tr>
			<tr>
				<td><div align="right">学号：</div></td>
				<td><s:textfield theme="simple" name="sno" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">姓名：</div></td>
				<td><s:textfield theme="simple" name="name" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">性别：</div></td>
				<td><s:textfield theme="simple" name="sex" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">院系：</div></td>
				<td><s:textfield theme="simple" name="department" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">籍贯：</div></td>
				<td><s:textfield theme="simple" name="nativePlace" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">学分：</div></td>
				<td><s:textfield theme="simple" name="mark" />&nbsp;</td>

			</tr>
			<tr>
				<td><div align="right">电子邮箱：</div></td>
				<td><s:textfield theme="simple" name="email" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">联系方式：</div></td>
				<td><s:textfield theme="simple" name="tel" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">最大选课数：</div></td>
				<td><s:textfield theme="simple" name="maxCourse" />&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><label> <input type="submit" value="提交" /> <input
						type="reset" value="重置" />
				</label></td>
			</tr>
		</table>
	</form>
</body>
</html>
