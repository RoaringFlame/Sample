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
	<s:form method="post" action="updateStudent">
		<table border="1" align="center">
			<tr>
				<td colspan="4"><div align="center">
						修改个人基本信息
						<s:hidden name="sid" value="%{stu.sid}" />
						<s:hidden name="pageNumber" value="%{pageNumber}" />
					</div></td>
				<td>照片</td>
			</tr>
			<tr>
				<td>学号：</td>
				<td><s:property value="%{stu.sno}" />&nbsp;</td>
				<td>姓名：</td>
				<td><s:textfield theme="simple" name="name" value="%{stu.name}" />&nbsp;</td>
				<td rowspan="3"><img
					src="upload/<s:property value="%{stu.image}"/>" width="148"
					height="206" />&nbsp;</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><s:textfield theme="simple" name="sex" value="%{stu.sex}" />&nbsp;</td>
				<td>院系：</td>
				<td><s:textfield theme="simple" name="department"
						value="%{stu.department}" />&nbsp;</td>
			</tr>
			<tr>
				<td>籍贯：</td>
				<td><s:textfield theme="simple" name="nativePlace"
						value="%{stu.nativePlace}" />&nbsp;</td>
				<td>学分：</td>
				<td><s:textfield theme="simple" name="mark" value="%{stu.mark}" />&nbsp;</td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td><s:textfield theme="simple" name="email"
						value="%{stu.email}" />&nbsp;</td>
				<td>最大选课数：</td>
				<td><s:textfield theme="simple" name="maxCourse"
						value="%{stu.maxCourse}" />&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><s:textfield theme="simple" name="tel" value="%{stu.tel}" />&nbsp;</td>
				<td><input type="submit" name="Submit" value="提交" /></td>
				<td><input type="reset" name="Submit2" value="重置" /></td>
				<td>上传照片</td>
			</tr>
		</table>
	</s:form>

</body>
</html>