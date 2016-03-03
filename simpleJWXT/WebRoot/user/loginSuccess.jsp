<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>内容管理系统</title>
<style>
body
{
  scrollbar-base-color:#C0D586;
  scrollbar-arrow-color:#FFFFFF;
  scrollbar-shadow-color:DEEFC6;
}
</style>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="user/top.jsp" name="topFrame" scrolling="no">
  <frameset cols="180,*" id="btFrame" frameborder="NO" border="0" framespacing="0"> 
  <s:if test="flag==1">
    <frame src="student/menu.jsp" noresize name="menu" scrolling="yes"></s:if>
  <s:if test="flag==2">
    <frame src="teacher/menu.jsp" noresize name="menu" scrolling="yes"></s:if>
  <s:if test="flag==3">
  
    <frame src="admin/menu.jsp" noresize name="menu" scrolling="yes"></s:if>    
    <frame src="user/main.jsp" noresize name="main" scrolling="yes">
  </frameset>
</frameset>
<noframes>
	<body>您的浏览器不支持框架！</body>
</noframes>
</html>
