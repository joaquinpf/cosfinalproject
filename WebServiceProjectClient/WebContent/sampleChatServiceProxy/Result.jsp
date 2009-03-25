<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleChatServiceProxyid" scope="session" class="wschat.ChatServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleChatServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleChatServiceProxyid.getEndpoint();
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
        sampleChatServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wschat.ChatService getChatService10mtemp = sampleChatServiceProxyid.getChatService();
if(getChatService10mtemp == null){
%>
<%=getChatService10mtemp %>
<%
}else{
        if(getChatService10mtemp!= null){
        String tempreturnp11 = getChatService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String pass_2id=  request.getParameter("pass18");
            java.lang.String pass_2idTemp = null;
        if(!pass_2id.equals("")){
         pass_2idTemp  = pass_2id;
        }
        String username_3id=  request.getParameter("username20");
            java.lang.String username_3idTemp = null;
        if(!username_3id.equals("")){
         username_3idTemp  = username_3id;
        }
        %>
        <jsp:useBean id="wschat1Auth_1id" scope="session" class="wschat.Auth" />
        <%
        wschat1Auth_1id.setPass(pass_2idTemp);
        wschat1Auth_1id.setUsername(username_3idTemp);
        int login13mtemp = sampleChatServiceProxyid.login(wschat1Auth_1id);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(login13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 22:
        gotMethod = true;
        String pass_5id=  request.getParameter("pass27");
            java.lang.String pass_5idTemp = null;
        if(!pass_5id.equals("")){
         pass_5idTemp  = pass_5id;
        }
        String username_6id=  request.getParameter("username29");
            java.lang.String username_6idTemp = null;
        if(!username_6id.equals("")){
         username_6idTemp  = username_6id;
        }
        %>
        <jsp:useBean id="wschat1Auth_4id" scope="session" class="wschat.Auth" />
        <%
        wschat1Auth_4id.setPass(pass_5idTemp);
        wschat1Auth_4id.setUsername(username_6idTemp);
        int logout22mtemp = sampleChatServiceProxyid.logout(wschat1Auth_4id);
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(logout22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
break;
case 31:
        gotMethod = true;
        String message_8id=  request.getParameter("message36");
            java.lang.String message_8idTemp = null;
        if(!message_8id.equals("")){
         message_8idTemp  = message_8id;
        }
        String usernameSrc_9id=  request.getParameter("usernameSrc38");
            java.lang.String usernameSrc_9idTemp = null;
        if(!usernameSrc_9id.equals("")){
         usernameSrc_9idTemp  = usernameSrc_9id;
        }
        String usernameDst_10id=  request.getParameter("usernameDst40");
            java.lang.String usernameDst_10idTemp = null;
        if(!usernameDst_10id.equals("")){
         usernameDst_10idTemp  = usernameDst_10id;
        }
        %>
        <jsp:useBean id="wschat1TextMessage_7id" scope="session" class="wschat.TextMessage" />
        <%
        wschat1TextMessage_7id.setMessage(message_8idTemp);
        wschat1TextMessage_7id.setUsernameSrc(usernameSrc_9idTemp);
        wschat1TextMessage_7id.setUsernameDst(usernameDst_10idTemp);
        int sendMessage31mtemp = sampleChatServiceProxyid.sendMessage(wschat1TextMessage_7id);
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendMessage31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
break;
case 42:
        gotMethod = true;
        String username_11id=  request.getParameter("username45");
            java.lang.String username_11idTemp = null;
        if(!username_11id.equals("")){
         username_11idTemp  = username_11id;
        }
        java.lang.String[] getContacts42mtemp = sampleChatServiceProxyid.getContacts(username_11idTemp);
if(getContacts42mtemp == null){
%>
<%=getContacts42mtemp %>
<%
}else{
        String tempreturnp43 = null;
        if(getContacts42mtemp != null){
        java.util.List listreturnp43= java.util.Arrays.asList(getContacts42mtemp);
        tempreturnp43 = listreturnp43.toString();
        }
        %>
        <%=tempreturnp43%>
        <%
}
break;
case 47:
        gotMethod = true;
        String username_12id=  request.getParameter("username50");
            java.lang.String username_12idTemp = null;
        if(!username_12id.equals("")){
         username_12idTemp  = username_12id;
        }
        String contact_13id=  request.getParameter("contact52");
            java.lang.String contact_13idTemp = null;
        if(!contact_13id.equals("")){
         contact_13idTemp  = contact_13id;
        }
        int addContact47mtemp = sampleChatServiceProxyid.addContact(username_12idTemp,contact_13idTemp);
        String tempResultreturnp48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addContact47mtemp));
        %>
        <%= tempResultreturnp48 %>
        <%
break;
case 54:
        gotMethod = true;
        String username_14id=  request.getParameter("username57");
            java.lang.String username_14idTemp = null;
        if(!username_14id.equals("")){
         username_14idTemp  = username_14id;
        }
        java.lang.String[] receiveMessage54mtemp = sampleChatServiceProxyid.receiveMessage(username_14idTemp);
if(receiveMessage54mtemp == null){
%>
<%=receiveMessage54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(receiveMessage54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(receiveMessage54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 59:
        gotMethod = true;
        String username_15id=  request.getParameter("username62");
            java.lang.String username_15idTemp = null;
        if(!username_15id.equals("")){
         username_15idTemp  = username_15id;
        }
        int getStatus59mtemp = sampleChatServiceProxyid.getStatus(username_15idTemp);
        String tempResultreturnp60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getStatus59mtemp));
        %>
        <%= tempResultreturnp60 %>
        <%
break;
case 64:
        gotMethod = true;
        String username_16id=  request.getParameter("username67");
            java.lang.String username_16idTemp = null;
        if(!username_16id.equals("")){
         username_16idTemp  = username_16id;
        }
        int existUserName64mtemp = sampleChatServiceProxyid.existUserName(username_16idTemp);
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existUserName64mtemp));
        %>
        <%= tempResultreturnp65 %>
        <%
break;
case 69:
        gotMethod = true;
        String pass_18id=  request.getParameter("pass74");
            java.lang.String pass_18idTemp = null;
        if(!pass_18id.equals("")){
         pass_18idTemp  = pass_18id;
        }
        String username_19id=  request.getParameter("username76");
            java.lang.String username_19idTemp = null;
        if(!username_19id.equals("")){
         username_19idTemp  = username_19id;
        }
        %>
        <jsp:useBean id="wschat1Auth_17id" scope="session" class="wschat.Auth" />
        <%
        wschat1Auth_17id.setPass(pass_18idTemp);
        wschat1Auth_17id.setUsername(username_19idTemp);
        int addUser69mtemp = sampleChatServiceProxyid.addUser(wschat1Auth_17id);
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser69mtemp));
        %>
        <%= tempResultreturnp70 %>
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