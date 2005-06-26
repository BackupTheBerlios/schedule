
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>Schedule Main Page</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
        
        <table border="0" cellspacing="0">
        <tr bgcolor="#FF6633">
            <td width="10">&nbsp;</td>
            <td width="100">Datum</td>
            <td width="490">&nbsp;</td>
            <!-- TODO: Show users real name, not screenname, maybe...-->
            <td width="190" align="right"><h:outputText value="#{LoginBean.screenname}" /> <a href="logout.jsp"><h:outputText value="#{bundle.str_logout}" /></a></td>
            <td width="10">&nbsp;</td>
        </tr>
        </table>
        <p>
        <table border="0" cellspacing="0">
        <tr bgcolor="#AAAAAA">
            <td width="10">&nbsp;</td>
            <td width="260"><a href="messages.jsp"><h:outputText value="#{bundle.str_messages}" /></a></td>
            <td width="260"><h:outputText value="#{bundle.str_projects}" /></td>
            <td width="260"><h:outputText value="#{bundle.str_blackboard}" /></td>
            <td width="10">&nbsp;</td>
        </tr>
        <tr bgcolor="#DDDDDD">
            <td valign="top" width="10">&nbsp;</td>
            <!-- Dummy content -->
            <td valign="top" width="260">2 ungelesene Nachrichten<p>von <a href="bsp">Reinhard 24.6.2005</a><br>von <a href="bsp">Frank 25.6.2005</a></td>
            <td valign="top" width="260">2 abonnierte Projekte<p><a href="bsp">Projekt Schedule</a><br><a href="bsp">Projekt Weltherrschaft</a></td>
            <td valign="top" width="260"><strong>25.6.2005 von <a href="bsp">Reinhard</a></strong><br><i>Hi Leute, das ist ein erster Vorschlag wie die Hauptseite etwa aufgebaut 
            werden könnte. Design ist natürlich wie immer noch nicht drin!</i><p></p>
            <strong>23.6.2005 von <a href="bsp">Reinhard</a></strong><br><i>Ich bin ein Blindtext. Von Geburt an. Es hat lange gedauert, bis ich begriffen habe, was es bedeutet, ein blinder 
            Text zu sein. Auch der Optiker hilft da nicht weiter.</i></td>
            <td valign="top" width="10">&nbsp;</td>
        </tr>
        <tr bgcolor="#DDDDDD">
            <td valign="top" width=10">&nbsp;</td>
            <td valign="top" width="260">&nbsp;</td>
            <td valign="top" width="260">&nbsp;</td>
            <td valign="top" width="260">&nbsp;</td>
            <td valign="top" width="10">&nbsp;</td>
        </tr>
        <tr bgcolor="#DDDDDD">
            <td valign="top" width=10">&nbsp;</td>
            <td valign="top" width="260"><a href="bsp">Neue Nachricht</a></td>
            <td valign="top" width="260"><a href="bsp">Neues Projekt abonnieren</a></td>
            <td valign="top" width="260"><a href="bsp">Neuen Eintrag schreiben</a></td>
            <td valign="top" width="10">&nbsp;</td>
        </tr>
        </table>


	</f:view>
</body>
</html>
