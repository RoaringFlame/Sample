<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>
	var curopenItem = '1';
</script>
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body>
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left:3px;padding-top:8px' valign="top">
				<!-- Item 1 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'>
						<b>学生管理</b>
					</dt>
					<dd style='display:block' class='sitem' id='items1_1'>
						<ul class='sitemu'>
							<li>
								<div class='items'>
									<div class='fllct' align="left">
										<a href='spageAction' target='main'>查看所有学生</a>
									</div>
								</div>
							</li>
							<li><div class='fllct' align="left">
									<a href='addStudent.jsp' target='main'>添加学生</a>
								</div></li>
							<!--  <li> <div class='fllct'><a href='importStudent.jsp' target='main'>导入学生</a></div>-->
						</ul>
					</dd>
				</dl> <!-- Item 1 End --> <!-- Item 2 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>教师管理</b>
					</dt>
					<dd style='display:block' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><div align="left">
									<a href='tpageAction' target='main'>查看所有教师</a>
								</div></li>
							<li><div align="left">
									<a href='addTeacher.jsp' target='main'>添加教师</a>
								</div></li>
							<!--  	<li><a href='importTeacher.jsp' target='main'>导入教师</a></li>  -->
						</ul>
					</dd>
				</dl>
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>课程管理</b>
					</dt>
					<dd style='display:block' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><div align="left">
									<a href='cpageAction' target='main'>查看所有课程</a>
								</div></li>
							<li><div align="left">
									<a href='addCourse.jsp' target='main'>添加课程</a>
								</div></li>
							<!--   <li><a href='' target='main'>导入课程</a></li>  -->
						</ul>
					</dd>
				</dl>
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>个人信息管理</b>
					</dt>
					<dd style='display:block' class='sitem' id='items2_1'>
						<ul class='sitemu'>

							<li><div align="left">
									<a href="<%=request.getContextPath()%>/user/changepassword.jsp"
										target='main'>修改密码</a>
								</div></li>
						</ul>
					</dd>
				</dl> <!-- Item 2 End -->
			</td>
		</tr>
	</table>
</body>
</html>
