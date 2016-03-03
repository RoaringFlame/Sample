<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<s:form id="form1" name="form1" method="post" action="updateTeacher">
		<table border="1" align="center">
			<tr>
				<td colspan="2"><div align="center">修改教师</div></td>
				<s:hidden name="tid" value="%{tea.tid}" />
				<s:hidden name="pageNumber" value="%{pageNumber}" />
			</tr>
			<tr>
				<td><div align="right">教师编号：</div></td>
				<td><s:property value="%{tea.tno}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师姓名：</div></td>
				<td><s:textfield theme="simple" name="name" value="%{tea.name}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">年龄：</div></td>
				<td><s:textfield theme="simple" name="age" value="%{tea.age}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师职称：</div></td>
				<td><s:textfield theme="simple" name="rank" value="%{tea.rank}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师邮箱：</div></td>
				<td><s:textfield theme="simple" name="email"
						value="%{tea.email}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师电话：</div></td>
				<td><s:textfield theme="simple" name="tel" value="%{tea.tel}" />&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit theme="simple" value="修改" /> <s:reset
						theme="simple" value="重置 " />&nbsp;</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
