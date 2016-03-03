<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<s:form id="form1" name="form1" method="post" action="updateCourse">
		<table border="1" align="center">
			<tr>
				<td colspan="2"><div align="center">
						课程基本信息修改
						<s:hidden name="cid" value="%{cou.cid}" />
						<s:hidden name="pageNumber" value="%{pageNumber}" />
					</div></td>
			</tr>
			<tr>
				<td><div align="right">课程号：</div></td>
				<td><s:textfield theme="simple" name="cno" value="%{cou.cno}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">课程名：</div></td>
				<td><s:textfield theme="simple" name="cname"
						value="%{cou.cname}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教师编号：</div></td>
				<td><s:textfield theme="simple" name="tno" value="%{cou.tno}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">授课时间：</div></td>
				<td><s:textfield theme="simple" name="ctime"
						value="%{cou.ctime}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">教室：</div></td>
				<td><s:textfield theme="simple" name="roomid"
						value="%{cou.roomid}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">学分：</div></td>
				<td><s:textfield theme="simple" name="cmark"
						value="%{cou.cmark}" />&nbsp;</td>
			</tr>
			<tr>
				<td><div align="right">最多选课人数：</div></td>
				<td><s:textfield theme="simple" name="chooseMax"
						value="%{cou.chooseMax}" />&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="Submit" value="提交" /> <input type="reset" name="Submit2"
					value="重置" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
