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
<title>课程信息查看</title>
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
				<td>序列</td>
				<td>课程号</td>
				<td>课程名</td>
				<td>授课时间</td>
				<td>教室</td>
				<td>学分</td>
				<td>最大选课人数</td>
				<td>已选人数</td>
				<td colspan="2">操作</td>
			</tr>
			<s:iterator value="allCourse" status="st">
				<tr>
					<td><s:property value="#st.getIndex()+1+(pageNumber-1)*10" />
					</td>
					<td><s:property value="cno" /></td>
					<td><s:property value="cname" /></td>
					<td><s:property value="ctime" /></td>
					<td><s:property value="roomid" /></td>
					<td><s:property value="cmark" /></td>
					<td><s:property value="chooseMax" /></td>
					<td><s:property value="chooseCurNum" /></td>
					<td><s:url id="update" action="getAction!course">
							<s:param name="cid">
								<s:property value="cid" />
							</s:param>
							<s:param name="pageNumber">
								<s:property value="pageNumber" />
							</s:param>
						</s:url> <s:a href="%{update}">修改</s:a></td>
					<td><s:url id="delete" action="delCourse">
							<s:param name="cid">
								<s:property value="cid" />
							</s:param>
							<s:param name="pageNumber">
								<s:property value="pageNumber" />
							</s:param>
						</s:url> <s:a href="%{delete}">删除</s:a></td>
				</tr>
			</s:iterator>
		</table>
		<ul id="ulLink">
			<s:property value="pageNumber+'|'" />
			<s:property value="totalPage" />
			<s:url id="firstPage" action="cpageAction">
				<s:param name="pageNumber">1</s:param>
			</s:url>
			<s:a cssClass="myst" href='cpageAction'>首页</s:a>
			<s:url id="prePage" action="cpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber-1' />
				</s:param>

			</s:url>
			<s:a cssClass="myst" href="%{prePage}">上一页</s:a>
			<s:url id="nextPage" action="cpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber+1' />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{nextPage}">下一页</s:a>
			<s:url id="lastPage" action="cpageAction">
				<s:param name="pageNumber">
					<s:property value="totalPage" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{lastPage}">末页</s:a>
		</ul>
	</center>
</body>
</html>
