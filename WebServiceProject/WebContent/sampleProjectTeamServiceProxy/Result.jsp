<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleProjectTeamServiceProxyid" scope="session" class="wsprojectteam.ProjectTeamServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleProjectTeamServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleProjectTeamServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleProjectTeamServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wsprojectteam.ProjectTeamService getProjectTeamService10mtemp = sampleProjectTeamServiceProxyid.getProjectTeamService();
if(getProjectTeamService10mtemp == null){
%>
<%=getProjectTeamService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        java.lang.String[] getProjects15mtemp = sampleProjectTeamServiceProxyid.getProjects();
if(getProjects15mtemp == null){
%>
<%=getProjects15mtemp %>
<%
}else{
        String tempreturnp16 = null;
        if(getProjects15mtemp != null){
        java.util.List listreturnp16= java.util.Arrays.asList(getProjects15mtemp);
        tempreturnp16 = listreturnp16.toString();
        }
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 18:
        gotMethod = true;
        String pass_2id=  request.getParameter("pass23");
            java.lang.String pass_2idTemp = null;
        if(!pass_2id.equals("")){
         pass_2idTemp  = pass_2id;
        }
        String username_3id=  request.getParameter("username25");
            java.lang.String username_3idTemp = null;
        if(!username_3id.equals("")){
         username_3idTemp  = username_3id;
        }
        %>
        <jsp:useBean id="wsprojectteam1Auth_1id" scope="session" class="wsprojectteam.Auth" />
        <%
        wsprojectteam1Auth_1id.setPass(pass_2idTemp);
        wsprojectteam1Auth_1id.setUsername(username_3idTemp);
        java.lang.String[] getProjectsForUser18mtemp = sampleProjectTeamServiceProxyid.getProjectsForUser(wsprojectteam1Auth_1id);
if(getProjectsForUser18mtemp == null){
%>
<%=getProjectsForUser18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(getProjectsForUser18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(getProjectsForUser18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 27:
        gotMethod = true;
        String project_4id=  request.getParameter("project30");
            java.lang.String project_4idTemp = null;
        if(!project_4id.equals("")){
         project_4idTemp  = project_4id;
        }
        java.lang.String[] getGroupsForProject27mtemp = sampleProjectTeamServiceProxyid.getGroupsForProject(project_4idTemp);
if(getGroupsForProject27mtemp == null){
%>
<%=getGroupsForProject27mtemp %>
<%
}else{
        String tempreturnp28 = null;
        if(getGroupsForProject27mtemp != null){
        java.util.List listreturnp28= java.util.Arrays.asList(getGroupsForProject27mtemp);
        tempreturnp28 = listreturnp28.toString();
        }
        %>
        <%=tempreturnp28%>
        <%
}
break;
case 32:
        gotMethod = true;
        String description_5id=  request.getParameter("description35");
            java.lang.String description_5idTemp = null;
        if(!description_5id.equals("")){
         description_5idTemp  = description_5id;
        }
        String name_6id=  request.getParameter("name37");
            java.lang.String name_6idTemp = null;
        if(!name_6id.equals("")){
         name_6idTemp  = name_6id;
        }
        boolean addProject32mtemp = sampleProjectTeamServiceProxyid.addProject(description_5idTemp,name_6idTemp);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addProject32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
case 39:
        gotMethod = true;
        String description_7id=  request.getParameter("description42");
            java.lang.String description_7idTemp = null;
        if(!description_7id.equals("")){
         description_7idTemp  = description_7id;
        }
        String project_8id=  request.getParameter("project44");
            java.lang.String project_8idTemp = null;
        if(!project_8id.equals("")){
         project_8idTemp  = project_8id;
        }
        String name_9id=  request.getParameter("name46");
            java.lang.String name_9idTemp = null;
        if(!name_9id.equals("")){
         name_9idTemp  = name_9id;
        }
        boolean addGroupToProject39mtemp = sampleProjectTeamServiceProxyid.addGroupToProject(description_7idTemp,project_8idTemp,name_9idTemp);
        String tempResultreturnp40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addGroupToProject39mtemp));
        %>
        <%= tempResultreturnp40 %>
        <%
break;
case 48:
        gotMethod = true;
        String description_10id=  request.getParameter("description51");
            java.lang.String description_10idTemp = null;
        if(!description_10id.equals("")){
         description_10idTemp  = description_10id;
        }
        String group_11id=  request.getParameter("group53");
            java.lang.String group_11idTemp = null;
        if(!group_11id.equals("")){
         group_11idTemp  = group_11id;
        }
        String project_12id=  request.getParameter("project55");
            java.lang.String project_12idTemp = null;
        if(!project_12id.equals("")){
         project_12idTemp  = project_12id;
        }
        String pass_14id=  request.getParameter("pass59");
            java.lang.String pass_14idTemp = null;
        if(!pass_14id.equals("")){
         pass_14idTemp  = pass_14id;
        }
        String username_15id=  request.getParameter("username61");
            java.lang.String username_15idTemp = null;
        if(!username_15id.equals("")){
         username_15idTemp  = username_15id;
        }
        %>
        <jsp:useBean id="wsprojectteam1Auth_13id" scope="session" class="wsprojectteam.Auth" />
        <%
        wsprojectteam1Auth_13id.setPass(pass_14idTemp);
        wsprojectteam1Auth_13id.setUsername(username_15idTemp);
        boolean addMemberToProject48mtemp = sampleProjectTeamServiceProxyid.addMemberToProject(description_10idTemp,group_11idTemp,project_12idTemp,wsprojectteam1Auth_13id);
        String tempResultreturnp49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addMemberToProject48mtemp));
        %>
        <%= tempResultreturnp49 %>
        <%
break;
case 63:
        gotMethod = true;
        String pass_17id=  request.getParameter("pass68");
            java.lang.String pass_17idTemp = null;
        if(!pass_17id.equals("")){
         pass_17idTemp  = pass_17id;
        }
        String username_18id=  request.getParameter("username70");
            java.lang.String username_18idTemp = null;
        if(!username_18id.equals("")){
         username_18idTemp  = username_18id;
        }
        %>
        <jsp:useBean id="wsprojectteam1Auth_16id" scope="session" class="wsprojectteam.Auth" />
        <%
        wsprojectteam1Auth_16id.setPass(pass_17idTemp);
        wsprojectteam1Auth_16id.setUsername(username_18idTemp);
        int addUser63mtemp = sampleProjectTeamServiceProxyid.addUser(wsprojectteam1Auth_16id);
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>