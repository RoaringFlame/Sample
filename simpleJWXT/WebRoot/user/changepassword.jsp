
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: medium;
	color: #0033FF;
}

body {
	background-color: #AAEC79;
	background-image: url(image/wrapBg_1.jpg);
}
-->
</style>
</head>
<body class="emx_nav_left">
	<s:form name="form1" method="post" action="changePassword">
		<table align="center" border="1">
			<tr>
				<td colspan="2"><div align="center" class="STYLE1">修改密码</div>
					<div align="left"></div></td>
			</tr>
			<tr>
				<td><div align="right">姓名：</div></td>
				<td><div align="left">
						<s:if test="#session.flag==1">
							<s:property value="#session.sname" />
						</s:if>
						<s:if test="#session.flag==2">
							<s:property value="#session.tname" />
						</s:if>
						<s:if test="#session.flag==3">
							<s:property value="#session.aname" />
						</s:if>
					</div></td>
			</tr>
			<tr>
				<td><div align="right">旧密码：</div></td>
				<td><div align="left">
						<s:password theme="simple" name="password" />
					</div></td>
			</tr>
			<tr>
				<td><div align="right">新密码：</div></td>
				<td><div align="left">
						<s:password theme="simple" name="password1" />
					</div></td>
			</tr>
			<tr>
				<td><div align="right">确认新密码：</div></td>
				<td><div align="left">
						<s:password theme="simple" name="password2" />
					</div></td>
			</tr>
			<tr>
				<td><div align="right"></div></td>
				<td><div align="center">
						<label> <input type="submit" name="Submit" value="提交" />
						</label> <label> <input type="reset" name="Submit2" value="重置" />
						</label>
					</div></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
