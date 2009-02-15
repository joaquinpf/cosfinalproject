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
        String description_1id=  request.getParameter("description22");
            java.lang.String description_1idTemp = null;
        if(!description_1id.equals("")){
         description_1idTemp  = description_1id;
        }
        String type_2id=  request.getParameter("type24");
            java.lang.String type_2idTemp = null;
        if(!type_2id.equals("")){
         type_2idTemp  = type_2id;
        }
        wsbugtracker.Bug submitBug13mtemp = sampleBugTrackerServiceProxyid.submitBug(description_1idTemp,type_2idTemp);
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
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(submitBug13mtemp != null){
java.lang.String typetype16 = submitBug13mtemp.getType();
        String tempResulttype16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype16));
        %>
        <%= tempResulttype16 %>
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
java.lang.String typedescription20 = submitBug13mtemp.getDescription();
        String tempResultdescription20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription20));
        %>
        <%= tempResultdescription20 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 26:
        gotMethod = true;
        String number_3id=  request.getParameter("number35");
        int number_3idTemp  = Integer.parseInt(number_3id);
        wsbugtracker.Bug closeBug26mtemp = sampleBugTrackerServiceProxyid.closeBug(number_3idTemp);
if(closeBug26mtemp == null){
%>
<%=closeBug26mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(closeBug26mtemp != null){
java.lang.String typetype29 = closeBug26mtemp.getType();
        String tempResulttype29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype29));
        %>
        <%= tempResulttype29 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(closeBug26mtemp != null){
%>
<%=closeBug26mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(closeBug26mtemp != null){
java.lang.String typedescription33 = closeBug26mtemp.getDescription();
        String tempResultdescription33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription33));
        %>
        <%= tempResultdescription33 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 37:
        gotMethod = true;
        String number_4id=  request.getParameter("number46");
        int number_4idTemp  = Integer.parseInt(number_4id);
        wsbugtracker.Bug getBug37mtemp = sampleBugTrackerServiceProxyid.getBug(number_4idTemp);
if(getBug37mtemp == null){
%>
<%=getBug37mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">type:</TD>
<TD>
<%
if(getBug37mtemp != null){
java.lang.String typetype40 = getBug37mtemp.getType();
        String tempResulttype40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetype40));
        %>
        <%= tempResulttype40 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">number:</TD>
<TD>
<%
if(getBug37mtemp != null){
%>
<%=getBug37mtemp.getNumber()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getBug37mtemp != null){
java.lang.String typedescription44 = getBug37mtemp.getDescription();
        String tempResultdescription44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription44));
        %>
        <%= tempResultdescription44 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 48:
        gotMethod = true;
        String type_5id=  request.getParameter("type51");
            java.lang.String type_5idTemp = null;
        if(!type_5id.equals("")){
         type_5idTemp  = type_5id;
        }
        int[] getBugsByType48mtemp = sampleBugTrackerServiceProxyid.getBugsByType(type_5idTemp);
if(getBugsByType48mtemp == null){
%>
<%=getBugsByType48mtemp %>
<%
}else{
        String tempreturnp49 = "[";        for(int ireturnp49=0;ireturnp49< getBugsByType48mtemp.length;ireturnp49++){
            tempreturnp49 = tempreturnp49 + getBugsByType48mtemp[ireturnp49] + ",";
        }
        int lengthreturnp49 = tempreturnp49.length();
        tempreturnp49 = tempreturnp49.substring(0,(lengthreturnp49 - 1)) + "]";
        %>
        <%=tempreturnp49%>
        <%
}
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