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
        String description_1id=  request.getParameter("description16");
            java.lang.String description_1idTemp = null;
        if(!description_1id.equals("")){
         description_1idTemp  = description_1id;
        }
        String type_2id=  request.getParameter("type18");
            java.lang.String type_2idTemp = null;
        if(!type_2id.equals("")){
         type_2idTemp  = type_2id;
        }
        int submitBug13mtemp = sampleBugTrackerServiceProxyid.submitBug(description_1idTemp,type_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(submitBug13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String number_3id=  request.getParameter("number23");
        int number_3idTemp  = Integer.parseInt(number_3id);
        java.lang.String closeBug20mtemp = sampleBugTrackerServiceProxyid.closeBug(number_3idTemp);
if(closeBug20mtemp == null){
%>
<%=closeBug20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(closeBug20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 25:
        gotMethod = true;
        String number_4id=  request.getParameter("number28");
        int number_4idTemp  = Integer.parseInt(number_4id);
        java.lang.String getBug25mtemp = sampleBugTrackerServiceProxyid.getBug(number_4idTemp);
if(getBug25mtemp == null){
%>
<%=getBug25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getBug25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
}
break;
case 30:
        gotMethod = true;
        String type_5id=  request.getParameter("type33");
            java.lang.String type_5idTemp = null;
        if(!type_5id.equals("")){
         type_5idTemp  = type_5id;
        }
        int[] getBugsByType30mtemp = sampleBugTrackerServiceProxyid.getBugsByType(type_5idTemp);
if(getBugsByType30mtemp == null){
%>
<%=getBugsByType30mtemp %>
<%
}else{
        String tempreturnp31 = "[";        for(int ireturnp31=0;ireturnp31< getBugsByType30mtemp.length;ireturnp31++){
            tempreturnp31 = tempreturnp31 + getBugsByType30mtemp[ireturnp31] + ",";
        }
        int lengthreturnp31 = tempreturnp31.length();
        tempreturnp31 = tempreturnp31.substring(0,(lengthreturnp31 - 1)) + "]";
        %>
        <%=tempreturnp31%>
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