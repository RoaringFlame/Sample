<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <script language="JavaScript" type="text/javascript">
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------
</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>信息查看</title>
         <style type="text/css">
        #ge{ height:20px; background-color:#AAEC79;}
        </style>
    </head>
    <body id="ge"><center><table border="1">
            <tr>
            <td>序列</td>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>院系</td>
            <td>学分</td>
            <td colspan="2">操作</td>
        </tr>
            <s:iterator value="allStudent" status="st">
          <tr>
              <td>
                  <s:property value="#st.getIndex()+1+(pageNumber-1)*10"/>
              </td>
              <td>
                  <s:property value="sno"/>
              </td>
              <td>
                  <s:url id="gets" action="getAction!getStudent.action">
                      <s:param name="sid">
                         <s:property value="sid"/></s:param>
                      <s:param name="pageNumber">
                         <s:property value="pageNumber"/></s:param>
                  </s:url>
                  <s:a href="%{gets}"><s:property value="name"/></s:a>
              </td>
              <td>
                   <s:property value="sex"/>
              </td>
                  <td>
                      <s:property value="department"/>
                  </td>
                  <td>
			             <s:property value="mark"/>
                  </td>
                  <td>
                    <s:url id="update" action="getAction">
                      <s:param name="sid">
                        <s:property value="sid"/></s:param>
                      <s:param name="pageNumber">
                        <s:property value="pageNumber"/></s:param>  
                    </s:url>
                      <s:a href="%{update}">修改</s:a>
                  </td>
                  <td>
                      <s:url id="delete" action="delStudent">
                          <s:param name="sid">
                            <s:property value="sid"/></s:param>
                         <s:param name="pageNumber">
                            <s:property value="pageNumber"/></s:param>
                      </s:url>
                      <s:a href="%{delete}">删除</s:a>
                  </td>
            </tr>
        </s:iterator></table>
            <ul id="ulLink">
            <s:property value="pageNumber+'|'"/><s:property value="totalPage"/>
            
            <s:url id="firstPage" action="spageAction">
                <s:param name="pageNumber">1</s:param>
            </s:url>
            <s:a cssClass="myst" href='spageAction'>首页</s:a>
            <s:url id="prePage" action="spageAction">
                <s:param name="pageNumber"><s:property value='pageNumber-1'/></s:param>
            
            </s:url>
            <s:a cssClass="myst" href="%{prePage}">上一页</s:a>
            <s:url id="nextPage" action="spageAction">
                <s:param name="pageNumber"><s:property value='pageNumber+1'/>
                </s:param>
            </s:url>
            <s:a cssClass="myst" href="%{nextPage}">下一页</s:a>
            <s:url id="lastPage" action="spageAction"><s:param name="pageNumber"><s:property value="totalPage"/>
                </s:param></s:url>
            <s:a cssClass="myst" href="%{lastPage}">末页</s:a>
            </ul>
        </center> </body>
</html>