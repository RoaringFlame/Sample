<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<script language="JavaScript" type="text/javascript">
	//--------------- LOCALIZEABLE GLOBALS ---------------
	var d = new Date();
	var monthname = new Array("January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November",
			"December");
	//Ensure correct for language. English is "January 1, 2004"
	var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", "
			+ d.getFullYear();
	//---------------   END LOCALIZEABLE   ---------------
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息查看</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<center>
		<table border="1">
			<tr>
				<td>序号</td>
				<td>课程号</td>
				<td>课程名</td>
				<td>学分</td>
				<td>最大选课数</td>
				<td>已选人数</td>
				<td>详情</td>
			</tr>
			<s:iterator value="courseList" status="st">
				<tr>
					<td><s:property value="#st.getIndex()+1" /></td>
					<td><s:property value="cno" /></td>
					<td><s:property value="cname" /></td>
					<td><s:property value="cname" /></td>
					<td><s:property value="chooseMax" /></td>
					<td><s:property value="chooseCurNum" /></td>
					<td><s:url id="allStudent" action="tscpageAction">
							<s:param name="cid">
								<s:property value="cid" />
							</s:param>
						</s:url> <s:a href="%{allStudent}">登分</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>
