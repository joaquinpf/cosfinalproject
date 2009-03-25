<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMailServiceProxyid" scope="session" class="wsmail.MailServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMailServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleMailServiceProxyid.getEndpoint();
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
        sampleMailServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wsmail.MailService getMailService10mtemp = sampleMailServiceProxyid.getMailService();
if(getMailService10mtemp == null){
%>
<%=getMailService10mtemp %>
<%
}else{
        if(getMailService10mtemp!= null){
        String tempreturnp11 = getMailService10mtemp.toString();
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
        <jsp:useBean id="wsmail1Auth_1id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_1id.setPass(pass_2idTemp);
        wsmail1Auth_1id.setUsername(username_3idTemp);
        String status_5id=  request.getParameter("status24");
            java.lang.String status_5idTemp = null;
        if(!status_5id.equals("")){
         status_5idTemp  = status_5id;
        }
        String subject_6id=  request.getParameter("subject26");
            java.lang.String subject_6idTemp = null;
        if(!subject_6id.equals("")){
         subject_6idTemp  = subject_6id;
        }
        String text_7id=  request.getParameter("text28");
            java.lang.String text_7idTemp = null;
        if(!text_7id.equals("")){
         text_7idTemp  = text_7id;
        }
        String to_8id=  request.getParameter("to30");
            java.lang.String to_8idTemp = null;
        if(!to_8id.equals("")){
         to_8idTemp  = to_8id;
        }
        String from_9id=  request.getParameter("from32");
            java.lang.String from_9idTemp = null;
        if(!from_9id.equals("")){
         from_9idTemp  = from_9id;
        }
        %>
        <jsp:useBean id="wsmail1Mail_4id" scope="session" class="wsmail.Mail" />
        <%
        wsmail1Mail_4id.setStatus(status_5idTemp);
        wsmail1Mail_4id.setSubject(subject_6idTemp);
        wsmail1Mail_4id.setText(text_7idTemp);
        wsmail1Mail_4id.setTo(to_8idTemp);
        wsmail1Mail_4id.setFrom(from_9idTemp);
        int sendMail13mtemp = sampleMailServiceProxyid.sendMail(wsmail1Auth_1id,wsmail1Mail_4id);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendMail13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 34:
        gotMethod = true;
        String pass_11id=  request.getParameter("pass39");
            java.lang.String pass_11idTemp = null;
        if(!pass_11id.equals("")){
         pass_11idTemp  = pass_11id;
        }
        String username_12id=  request.getParameter("username41");
            java.lang.String username_12idTemp = null;
        if(!username_12id.equals("")){
         username_12idTemp  = username_12id;
        }
        %>
        <jsp:useBean id="wsmail1Auth_10id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_10id.setPass(pass_11idTemp);
        wsmail1Auth_10id.setUsername(username_12idTemp);
        int validUser34mtemp = sampleMailServiceProxyid.validUser(wsmail1Auth_10id);
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validUser34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
break;
case 43:
        gotMethod = true;
        String user_13id=  request.getParameter("user46");
            java.lang.String user_13idTemp = null;
        if(!user_13id.equals("")){
         user_13idTemp  = user_13id;
        }
        int validUserName43mtemp = sampleMailServiceProxyid.validUserName(user_13idTemp);
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validUserName43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
break;
case 48:
        gotMethod = true;
        String pass_15id=  request.getParameter("pass53");
            java.lang.String pass_15idTemp = null;
        if(!pass_15id.equals("")){
         pass_15idTemp  = pass_15id;
        }
        String username_16id=  request.getParameter("username55");
            java.lang.String username_16idTemp = null;
        if(!username_16id.equals("")){
         username_16idTemp  = username_16id;
        }
        %>
        <jsp:useBean id="wsmail1Auth_14id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_14id.setPass(pass_15idTemp);
        wsmail1Auth_14id.setUsername(username_16idTemp);
        java.lang.String[] getMails48mtemp = sampleMailServiceProxyid.getMails(wsmail1Auth_14id);
if(getMails48mtemp == null){
%>
<%=getMails48mtemp %>
<%
}else{
        String tempreturnp49 = null;
        if(getMails48mtemp != null){
        java.util.List listreturnp49= java.util.Arrays.asList(getMails48mtemp);
        tempreturnp49 = listreturnp49.toString();
        }
        %>
        <%=tempreturnp49%>
        <%
}
break;
case 57:
        gotMethod = true;
        String pass_18id=  request.getParameter("pass62");
            java.lang.String pass_18idTemp = null;
        if(!pass_18id.equals("")){
         pass_18idTemp  = pass_18id;
        }
        String username_19id=  request.getParameter("username64");
            java.lang.String username_19idTemp = null;
        if(!username_19id.equals("")){
         username_19idTemp  = username_19id;
        }
        %>
        <jsp:useBean id="wsmail1Auth_17id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_17id.setPass(pass_18idTemp);
        wsmail1Auth_17id.setUsername(username_19idTemp);
        String status_21id=  request.getParameter("status68");
            java.lang.String status_21idTemp = null;
        if(!status_21id.equals("")){
         status_21idTemp  = status_21id;
        }
        String subject_22id=  request.getParameter("subject70");
            java.lang.String subject_22idTemp = null;
        if(!subject_22id.equals("")){
         subject_22idTemp  = subject_22id;
        }
        String text_23id=  request.getParameter("text72");
            java.lang.String text_23idTemp = null;
        if(!text_23id.equals("")){
         text_23idTemp  = text_23id;
        }
        String to_24id=  request.getParameter("to74");
            java.lang.String to_24idTemp = null;
        if(!to_24id.equals("")){
         to_24idTemp  = to_24id;
        }
        String from_25id=  request.getParameter("from76");
            java.lang.String from_25idTemp = null;
        if(!from_25id.equals("")){
         from_25idTemp  = from_25id;
        }
        %>
        <jsp:useBean id="wsmail1Mail_20id" scope="session" class="wsmail.Mail" />
        <%
        wsmail1Mail_20id.setStatus(status_21idTemp);
        wsmail1Mail_20id.setSubject(subject_22idTemp);
        wsmail1Mail_20id.setText(text_23idTemp);
        wsmail1Mail_20id.setTo(to_24idTemp);
        wsmail1Mail_20id.setFrom(from_25idTemp);
        int saveMail57mtemp = sampleMailServiceProxyid.saveMail(wsmail1Auth_17id,wsmail1Mail_20id);
        String tempResultreturnp58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(saveMail57mtemp));
        %>
        <%= tempResultreturnp58 %>
        <%
break;
case 78:
        gotMethod = true;
        String pass_27id=  request.getParameter("pass83");
            java.lang.String pass_27idTemp = null;
        if(!pass_27id.equals("")){
         pass_27idTemp  = pass_27id;
        }
        String username_28id=  request.getParameter("username85");
            java.lang.String username_28idTemp = null;
        if(!username_28id.equals("")){
         username_28idTemp  = username_28id;
        }
        %>
        <jsp:useBean id="wsmail1Auth_26id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_26id.setPass(pass_27idTemp);
        wsmail1Auth_26id.setUsername(username_28idTemp);
        String status_30id=  request.getParameter("status89");
            java.lang.String status_30idTemp = null;
        if(!status_30id.equals("")){
         status_30idTemp  = status_30id;
        }
        String subject_31id=  request.getParameter("subject91");
            java.lang.String subject_31idTemp = null;
        if(!subject_31id.equals("")){
         subject_31idTemp  = subject_31id;
        }
        String text_32id=  request.getParameter("text93");
            java.lang.String text_32idTemp = null;
        if(!text_32id.equals("")){
         text_32idTemp  = text_32id;
        }
        String to_33id=  request.getParameter("to95");
            java.lang.String to_33idTemp = null;
        if(!to_33id.equals("")){
         to_33idTemp  = to_33id;
        }
        String from_34id=  request.getParameter("from97");
            java.lang.String from_34idTemp = null;
        if(!from_34id.equals("")){
         from_34idTemp  = from_34id;
        }
        %>
        <jsp:useBean id="wsmail1Mail_29id" scope="session" class="wsmail.Mail" />
        <%
        wsmail1Mail_29id.setStatus(status_30idTemp);
        wsmail1Mail_29id.setSubject(subject_31idTemp);
        wsmail1Mail_29id.setText(text_32idTemp);
        wsmail1Mail_29id.setTo(to_33idTemp);
        wsmail1Mail_29id.setFrom(from_34idTemp);
        int deleteMail78mtemp = sampleMailServiceProxyid.deleteMail(wsmail1Auth_26id,wsmail1Mail_29id);
        String tempResultreturnp79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteMail78mtemp));
        %>
        <%= tempResultreturnp79 %>
        <%
break;
case 99:
        gotMethod = true;
        String pass_36id=  request.getParameter("pass104");
            java.lang.String pass_36idTemp = null;
        if(!pass_36id.equals("")){
         pass_36idTemp  = pass_36id;
        }
        String username_37id=  request.getParameter("username106");
            java.lang.String username_37idTemp = null;
        if(!username_37id.equals("")){
         username_37idTemp  = username_37id;
        }
        %>
        <jsp:useBean id="wsmail1Auth_35id" scope="session" class="wsmail.Auth" />
        <%
        wsmail1Auth_35id.setPass(pass_36idTemp);
        wsmail1Auth_35id.setUsername(username_37idTemp);
        int addUserMail99mtemp = sampleMailServiceProxyid.addUserMail(wsmail1Auth_35id);
        String tempResultreturnp100 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUserMail99mtemp));
        %>
        <%= tempResultreturnp100 %>
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