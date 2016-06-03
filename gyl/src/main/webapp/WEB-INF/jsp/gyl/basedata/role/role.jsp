<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="style/style/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/role.js"></script>
<html>
<BODY>
	<TABLE border=0 height=600px align=left>
		<TR>
			<TD width=230px align=left valign=top>
				<ul id="roleTree" class="tree" style="width:230px; overflow:auto;"></ul>
			</TD>
		</TR>
	</TABLE>
	
<div class="addnodes" id="rMenu" style="position:absolute;display:none;overflow:hidden">
       <ul>
         <li id="addRole" style="background: url(${pageContext.request.contextPath}/style/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">增加角色</li>
         <li id="deleteRole" style="background: url(${pageContext.request.contextPath}/style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">删除角色</li>
         <li id="updateRole" style="background: url(${pageContext.request.contextPath}/style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">修改角色</li>
       </ul>
</div>
</BODY>
</html>