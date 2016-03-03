<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课结果</title>
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
			课程名:
			<s:property value="cname" />
			<br>
		</h1>
		<table border="1" align="center">
			<tr>
				<td>序号</td>
				<td>学号</td>
				<td>姓名</td>
				<td>分数</td>
				<td>院系</td>
				<td>录入</td>
			</tr>

			<s:iterator value="s" status="row">
				<tr>
					<td><s:property value="#row.getIndex()+1+(pageNumber-1)*10" />
					</td>
					<td><s:property value="sno" /></td>
					<td><s:property value="sname" /></td>
					<td><s:property value="department" /></td>
					<td><s:property value="score" /></td>
					<td><s:if test="score > 0"></s:if> <s:else>
							<s:form theme="simple" method="post" action="logScore">
								<s:hidden name="sid" value="%{sid}" />
								<s:hidden name="cid" value="%{cid}" />
								<s:hidden name="cname" value="%{cname}" />
								<s:hidden name="pageNumber" value="%{pageNumber}" />
								<s:textfield name="score" size="3"></s:textfield>
								<s:submit value="提交"></s:submit>
							</s:form>
						</s:else></td>
				</tr>
			</s:iterator>
		</table>

		<ul id="ulLink">
			<s:property value="pageNumber+|" />
			<s:property value="totalPage" />

			<s:url id="firstPage" action="tscpageAction">
				<s:param name="pageNumber">1</s:param>
				<s:param name="cid">
					<s:property value="cid" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{firstPage}">首页</s:a>


			<s:url id="prePage" action="tscpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber-1' />
				</s:param>
				<s:param name="cid">
					<s:property value="cid" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{prePage}">上一页</s:a>


			<s:url id="nextPage" action="tscpageAction">
				<s:param name="pageNumber">
					<s:property value='pageNumber+1' />
				</s:param>
				<s:param name="cid">
					<s:property value="cid" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{nextPage}">下一页</s:a>


			<s:url id="lastPage" action="tscpageAction">
				<s:param name="pageNumber">
					<s:property value="totalPage" />
				</s:param>
				<s:param name="cid">
					<s:property value="cid" />
				</s:param>
			</s:url>
			<s:a cssClass="myst" href="%{lastPage}">末页</s:a>
		</ul>
	</center>
</body>
</html>
