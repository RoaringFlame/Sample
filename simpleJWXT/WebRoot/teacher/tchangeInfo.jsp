<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人基本信息</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<s:form id="form1" name="form1" method="post"
		action="tgetInfo!saveInfo">
		<table border="1" align="center">
			<tr>
				<td colspan="4"><div align="center">
						个人基本信息
						<s:hidden name="tid" value="%{tea.tid}" />
					</div></td>
			<tr>
				<td>教师编号：</td>
				<td><s:property value="%{tea.tno}" />&nbsp;</td>
				<td>姓名：</td>
				<td><s:property value="%{tea.name}" />&nbsp;</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><s:textfield theme="simple" name="age" value="%{tea.age}" />&nbsp;</td>
				<td>职称：</td>
				<td><s:property value="%{tea.rank}" />&nbsp;</td>
			</tr>
			<tr>
				<td>电话</td>
				<td colspan="3"><s:textfield theme="simple" name="tel"
						value="%{tea.tel}" />&nbsp;</td>
			</tr>
			<tr>
				<td>电子邮件</td>
				<td colspan="3"><s:textfield theme="simple" name="email"
						value="%{tea.email}" />&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><input type="submit"
					name="Submit" value="修改" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>