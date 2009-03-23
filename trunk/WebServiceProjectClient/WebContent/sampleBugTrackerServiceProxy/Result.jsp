<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBugTrackerServiceProxyid" scope="session" class="wsbugtracker.BugTrackerServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBugTrackerServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleBugTrackerServiceProxyid.getEndpoint();
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
        sampleBugTrackerServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wsbugtracker.BugTrackerService getBugTrackerService10mtemp = sampleBugTrackerServiceProxyid.getBugTrackerService();
if(getBugTrackerService10mtemp == null){
%>
<%=getBugTrackerService10mtemp %>
<%
}else{
        if(getBugTrackerService10mtemp!= null){
        String tempreturnp11 = getBugTrackerService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String description_1id=  request.getParameter("description28");
            java.lang.String description_1idTemp = null;
        if(!description_1id.equals("")){
         description_1idTemp  = description_1id;
        }
        String type_2id=  request.getParameter("type30");
            java.lang.String type_2idTemp = null;
        if(!type_2id.equals("")){
         type_2idTemp  = type_2id;
        }
        String owner_3id=  request.getParameter("owner32");
            java.lang.String owner_3idTemp = null;
        if(!owner_3id.equals("")){
         owner_3idTemp  = owner_3id;
        }
        String project_4id=  request.getParameter("project34");
            java.lang.String project_4idTemp = null;
        if(!project_4id.equals("")){
         project_4idTemp  = project_4id;
        }
        String status_5id=  request.getParameter("status36");
            java.lang.String status_5idTemp = null;
        if(!status_5id.equals("")){
         status_5idTemp  = status_5id;
        }
        wsbugtracker.Bug submitBug13mtemp = sampleBugTrackerServiceProxyid.submitBug(description_1idTemp,type_2idTemp,owner_3idTemp,project_4idTemp,status_5idTemp);
if(submitBug13mtemp == null){
%>
<%=submitBug13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">owner:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typeowner16 = submitBug13mtemp.getOwner();
        String tempResultowner16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeowner16));
        %>
        <%= tempResultowner16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typestatus18 = submitBug13mtemp.getStatus();
        String tempResultstatus18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatus18));
        %>
        <%= tempResultstatus18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typetype20 = submitBug13mtemp.getType();
        String tempResulttype20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype20));
        %>
        <%= tempResulttype20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(submitBug13mtemp != null){
%>
<%=submitBug13mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typedescription24 = submitBug13mtemp.getDescription();
        String tempResultdescription24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription24));
        %>
        <%= tempResultdescription24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">project:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typeproject26 = submitBug13mtemp.getProject();
        String tempResultproject26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeproject26));
        %>
        <%= tempResultproject26 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 38:
        gotMethod = true;
        String number_6id=  request.getParameter("number53");
        int number_6idTemp  = Integer.parseInt(number_6id);
        String status_7id=  request.getParameter("status55");
            java.lang.String status_7idTemp = null;
        if(!status_7id.equals("")){
         status_7idTemp  = status_7id;
        }
        wsbugtracker.Bug changeBugStatus38mtemp = sampleBugTrackerServiceProxyid.changeBugStatus(number_6idTemp,status_7idTemp);
if(changeBugStatus38mtemp == null){
%>
<%=changeBugStatus38mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">owner:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
java.lang.String typeowner41 = changeBugStatus38mtemp.getOwner();
        String tempResultowner41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeowner41));
        %>
        <%= tempResultowner41 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
java.lang.String typestatus43 = changeBugStatus38mtemp.getStatus();
        String tempResultstatus43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatus43));
        %>
        <%= tempResultstatus43 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
java.lang.String typetype45 = changeBugStatus38mtemp.getType();
        String tempResulttype45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype45));
        %>
        <%= tempResulttype45 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
%>
<%=changeBugStatus38mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
java.lang.String typedescription49 = changeBugStatus38mtemp.getDescription();
        String tempResultdescription49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription49));
        %>
        <%= tempResultdescription49 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">project:</TD>
<TD>
<%
if(changeBugStatus38mtemp != null){
java.lang.String typeproject51 = changeBugStatus38mtemp.getProject();
        String tempResultproject51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeproject51));
        %>
        <%= tempResultproject51 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 57:
        gotMethod = true;
        String number_8id=  request.getParameter("number72");
        int number_8idTemp  = Integer.parseInt(number_8id);
        wsbugtracker.Bug getBug57mtemp = sampleBugTrackerServiceProxyid.getBug(number_8idTemp);
if(getBug57mtemp == null){
%>
<%=getBug57mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">owner:</TD>
<TD>
<%
if(getBug57mtemp != null){
java.lang.String typeowner60 = getBug57mtemp.getOwner();
        String tempResultowner60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeowner60));
        %>
        <%= tempResultowner60 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(getBug57mtemp != null){
java.lang.String typestatus62 = getBug57mtemp.getStatus();
        String tempResultstatus62 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatus62));
        %>
        <%= tempResultstatus62 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(getBug57mtemp != null){
java.lang.String typetype64 = getBug57mtemp.getType();
        String tempResulttype64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype64));
        %>
        <%= tempResulttype64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(getBug57mtemp != null){
%>
<%=getBug57mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getBug57mtemp != null){
java.lang.String typedescription68 = getBug57mtemp.getDescription();
        String tempResultdescription68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription68));
        %>
        <%= tempResultdescription68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">project:</TD>
<TD>
<%
if(getBug57mtemp != null){
java.lang.String typeproject70 = getBug57mtemp.getProject();
        String tempResultproject70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeproject70));
        %>
        <%= tempResultproject70 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 74:
        gotMethod = true;
        String type_9id=  request.getParameter("type77");
            java.lang.String type_9idTemp = null;
        if(!type_9id.equals("")){
         type_9idTemp  = type_9id;
        }
        int[] getBugsByType74mtemp = sampleBugTrackerServiceProxyid.getBugsByType(type_9idTemp);
if(getBugsByType74mtemp == null){
%>
<%=getBugsByType74mtemp %>
<%
}else{
        String tempreturnp75 = "[";        for(int ireturnp75=0;ireturnp75< getBugsByType74mtemp.length;ireturnp75++){
            tempreturnp75 = tempreturnp75 + getBugsByType74mtemp[ireturnp75] + ",";
        }
        int lengthreturnp75 = tempreturnp75.length();
        tempreturnp75 = tempreturnp75.substring(0,(lengthreturnp75 - 1)) + "]";
        %>
        <%=tempreturnp75%>
        <%
}
break;
case 79:
        gotMethod = true;
        String project_10id=  request.getParameter("project82");
            java.lang.String project_10idTemp = null;
        if(!project_10id.equals("")){
         project_10idTemp  = project_10id;
        }
        int[] getBugsByProject79mtemp = sampleBugTrackerServiceProxyid.getBugsByProject(project_10idTemp);
if(getBugsByProject79mtemp == null){
%>
<%=getBugsByProject79mtemp %>
<%
}else{
        String tempreturnp80 = "[";        for(int ireturnp80=0;ireturnp80< getBugsByProject79mtemp.length;ireturnp80++){
            tempreturnp80 = tempreturnp80 + getBugsByProject79mtemp[ireturnp80] + ",";
        }
        int lengthreturnp80 = tempreturnp80.length();
        tempreturnp80 = tempreturnp80.substring(0,(lengthreturnp80 - 1)) + "]";
        %>
        <%=tempreturnp80%>
        <%
}
break;
case 84:
        gotMethod = true;
        String pass_12id=  request.getParameter("pass89");
            java.lang.String pass_12idTemp = null;
        if(!pass_12id.equals("")){
         pass_12idTemp  = pass_12id;
        }
        String username_13id=  request.getParameter("username91");
            java.lang.String username_13idTemp = null;
        if(!username_13id.equals("")){
         username_13idTemp  = username_13id;
        }
        %>
        <jsp:useBean id="wsbugtracker1Auth_11id" scope="session" class="wsbugtracker.Auth" />
        <%
        wsbugtracker1Auth_11id.setPass(pass_12idTemp);
        wsbugtracker1Auth_11id.setUsername(username_13idTemp);
        int addUser84mtemp = sampleBugTrackerServiceProxyid.addUser(wsbugtracker1Auth_11id);
        String tempResultreturnp85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser84mtemp));
        %>
        <%= tempResultreturnp85 %>
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