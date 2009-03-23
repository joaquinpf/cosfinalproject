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
        wsbugtracker.Bug closeBug38mtemp = sampleBugTrackerServiceProxyid.closeBug(number_6idTemp);
if(closeBug38mtemp == null){
%>
<%=closeBug38mtemp %>
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
if(closeBug38mtemp != null){
java.lang.String typeowner41 = closeBug38mtemp.getOwner();
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
if(closeBug38mtemp != null){
java.lang.String typestatus43 = closeBug38mtemp.getStatus();
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
if(closeBug38mtemp != null){
java.lang.String typetype45 = closeBug38mtemp.getType();
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
if(closeBug38mtemp != null){
%>
<%=closeBug38mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(closeBug38mtemp != null){
java.lang.String typedescription49 = closeBug38mtemp.getDescription();
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
if(closeBug38mtemp != null){
java.lang.String typeproject51 = closeBug38mtemp.getProject();
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
case 55:
        gotMethod = true;
        String number_7id=  request.getParameter("number70");
        int number_7idTemp  = Integer.parseInt(number_7id);
        wsbugtracker.Bug getBug55mtemp = sampleBugTrackerServiceProxyid.getBug(number_7idTemp);
if(getBug55mtemp == null){
%>
<%=getBug55mtemp %>
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
if(getBug55mtemp != null){
java.lang.String typeowner58 = getBug55mtemp.getOwner();
        String tempResultowner58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeowner58));
        %>
        <%= tempResultowner58 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(getBug55mtemp != null){
java.lang.String typestatus60 = getBug55mtemp.getStatus();
        String tempResultstatus60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatus60));
        %>
        <%= tempResultstatus60 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(getBug55mtemp != null){
java.lang.String typetype62 = getBug55mtemp.getType();
        String tempResulttype62 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype62));
        %>
        <%= tempResulttype62 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(getBug55mtemp != null){
%>
<%=getBug55mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getBug55mtemp != null){
java.lang.String typedescription66 = getBug55mtemp.getDescription();
        String tempResultdescription66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription66));
        %>
        <%= tempResultdescription66 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">project:</TD>
<TD>
<%
if(getBug55mtemp != null){
java.lang.String typeproject68 = getBug55mtemp.getProject();
        String tempResultproject68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeproject68));
        %>
        <%= tempResultproject68 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 72:
        gotMethod = true;
        String type_8id=  request.getParameter("type75");
            java.lang.String type_8idTemp = null;
        if(!type_8id.equals("")){
         type_8idTemp  = type_8id;
        }
        int[] getBugsByType72mtemp = sampleBugTrackerServiceProxyid.getBugsByType(type_8idTemp);
if(getBugsByType72mtemp == null){
%>
<%=getBugsByType72mtemp %>
<%
}else{
        String tempreturnp73 = "[";        for(int ireturnp73=0;ireturnp73< getBugsByType72mtemp.length;ireturnp73++){
            tempreturnp73 = tempreturnp73 + getBugsByType72mtemp[ireturnp73] + ",";
        }
        int lengthreturnp73 = tempreturnp73.length();
        tempreturnp73 = tempreturnp73.substring(0,(lengthreturnp73 - 1)) + "]";
        %>
        <%=tempreturnp73%>
        <%
}
break;
case 77:
        gotMethod = true;
        String project_9id=  request.getParameter("project80");
            java.lang.String project_9idTemp = null;
        if(!project_9id.equals("")){
         project_9idTemp  = project_9id;
        }
        int[] getBugsByProject77mtemp = sampleBugTrackerServiceProxyid.getBugsByProject(project_9idTemp);
if(getBugsByProject77mtemp == null){
%>
<%=getBugsByProject77mtemp %>
<%
}else{
        String tempreturnp78 = "[";        for(int ireturnp78=0;ireturnp78< getBugsByProject77mtemp.length;ireturnp78++){
            tempreturnp78 = tempreturnp78 + getBugsByProject77mtemp[ireturnp78] + ",";
        }
        int lengthreturnp78 = tempreturnp78.length();
        tempreturnp78 = tempreturnp78.substring(0,(lengthreturnp78 - 1)) + "]";
        %>
        <%=tempreturnp78%>
        <%
}
break;
case 82:
        gotMethod = true;
        String pass_11id=  request.getParameter("pass87");
            java.lang.String pass_11idTemp = null;
        if(!pass_11id.equals("")){
         pass_11idTemp  = pass_11id;
        }
        String username_12id=  request.getParameter("username89");
            java.lang.String username_12idTemp = null;
        if(!username_12id.equals("")){
         username_12idTemp  = username_12id;
        }
        %>
        <jsp:useBean id="wsbugtracker1Auth_10id" scope="session" class="wsbugtracker.Auth" />
        <%
        wsbugtracker1Auth_10id.setPass(pass_11idTemp);
        wsbugtracker1Auth_10id.setUsername(username_12idTemp);
        int addUser82mtemp = sampleBugTrackerServiceProxyid.addUser(wsbugtracker1Auth_10id);
        String tempResultreturnp83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser82mtemp));
        %>
        <%= tempResultreturnp83 %>
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