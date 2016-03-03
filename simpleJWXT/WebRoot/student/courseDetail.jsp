<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程详情</title>
<style type="text/css">
#ge {
	height: 20px;
	background-color: #AAEC79;
}
</style>
</head>
<body id="ge">
	<center>
		<h3>欢迎查看您所选课程详细信息</h3>
		<table border="1">
			<tr>
				<td>课程名：</td>
				<td>人数上限：</td>
				<td>已选人数：</td>
				<td>上课教室：</td>
				<td>课时：</td>
				<td>学分：</td>
				<td>选择</td>
			</tr>
			<tr>
				<td><s:property value="cou.cname" /></td>
				<td><s:property value="cou.chooseMax" /></td>
				<td><s:property value="cou.chooseCurNum" /></td>
				<td><s:property value="cou.roomid" /></td>
				<td><s:property value="cou.ctime" /></td>
				<td><s:property value="cou.cmark" /></td>
				<td><s:url id="choose" action="chooseCourse">
						<s:param name="cid">
							<s:property value="cou.cid" />
						</s:param>
					</s:url> <s:a href="%{choose}" style="font-size: 25px;">选修</s:a></td>
				<!--                 <td><a href="choose!confirmChoosecouses.action?cid=<s:property value="cou.csId"/>" style="font-size: 30px;">选修</a></td> -->
			</tr>

			<!--             <tr><td>已选课人：</td><td colspan="6">  <s:iterator value="cou.students" id="row"> -->
			<!--                 <li > -->
			<!--                     <h3 style=";"><s:property value="#row.username"/></h3> <br/> -->
			<!--                 </li> -->
			<!--             </s:iterator></td></tr> -->


		</table>
	</center>
</body>
</html>
