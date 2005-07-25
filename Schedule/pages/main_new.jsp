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
									 <h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_team}"><f:param name="link" value="team" /></h:commandLink></div>
							</td>
						</tr>
						<tr bgcolor="#103052" height="35">
							<td height="35" background="pages/data/back_tab.gif"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="494">
											<div align="center">
									</tr>
							</tr>
								<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
						</table>
					</div>
				</td>
				<td width="1" height="494"></td>
				<td width="10" height="494">
					
				</td>
						<td rowspan="3" colspan="2" width="761">
					<table width="757" border="0" cellspacing="0" cellpadding="0">
								<tr height="297">
							<td height="297">
										<table border="0" cellspacing="0">
        <tr bgcolor="#8393A3">
            <td width="10">&nbsp;</td>
            <td width="98">Datum</td>
            <td width="452">&nbsp;</td>
            <!-- TODO: Show users real name, not screenname, maybe...-->
            <td width="190" align="right"><h:outputText value="#{LoginBean.screenname}" /> <h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_logout}"><f:param name="link" value="logout" /> </h:commandLink></td>
            <td width="10">&nbsp;</td>
        </tr>
        </table>
										<br>
										<table border="0" cellspacing="0">
        <tr bgcolor="#A8B6C6">
            <td width="10">&nbsp;</td>
            <td width="167"><h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_messages}"><f:param name="link" value="messages" /></h:commandLink></td>
            <td width="219"><h:outputText value="#{bundle.str_projects}" /></td>
            <td width="260"><h:outputText value="#{bundle.str_blackboard}" /></td>
            <td width="104">&nbsp;</td>
        </tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="10" height="7" background="pages/data/naviseparator.gif"></td>
			<td width="167" height="7" background="pages/data/naviseparator.gif"></td>
			<td width="219" height="7" background="pages/data/naviseparator.gif"></td>
			<td width="260" height="7" background="pages/data/naviseparator.gif"></td>
			<td width="104" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		<tr bgcolor="#C6DADA">
            <td valign="top" width="10">&nbsp;</td>
            <!-- Dummy content -->
            <td valign="top" width="167">2 ungelesene Nachrichten<p>von <a href="bsp">Reinhard 24.6.2005</a><br>von <a href="bsp">Frank 25.6.2005</a></td>
            <td valign="top" width="219">2 abonnierte Projekte<p><a href="bsp">Projekt Schedule</a><br><a href="bsp">Projekt Weltherrschaft</a></td>
            <td valign="top" width="260"><strong>25.6.2005 von <a href="bsp">Reinhard</a></strong><br><i>Hi Leute, das ist ein erster Vorschlag wie die Hauptseite etwa aufgebaut 
            werden k�nnte. Design ist nat�rlich wie immer noch nicht drin!</i><p></p>
            <strong>23.6.2005 von <a href="bsp">Reinhard</a></strong><br><i>Ich bin ein Blindtext. Von Geburt an. Es hat lange gedauert, bis ich begriffen habe, was es bedeutet, ein blinder 
            Text zu sein. Auch der Optiker hilft da nicht weiter.</i></td>
            <td valign="top" width="104">&nbsp;</td>
        </tr>
        <tr bgcolor="#C6DADA">
            <td valign="top" width=10">&nbsp;</td>
            <td valign="top" width="167">&nbsp;</td>
            <td valign="top" width="219">&nbsp;</td>
            <td valign="top" width="260">&nbsp;</td>
            <td valign="top" width="104">&nbsp;</td>
        </tr>
            <td valign="top" width=10">&nbsp;</td>
            <td valign="top" width="167"><a href="bsp">Neue Nachricht</a></td>
            <td valign="top" width="104">&nbsp;</td>
				</td>
					
							
<tr height="15">
				<td width="1" height="15"></td>
				<td width="10" height="15"></td>
				<td width="549" height="15">&nbsp;</td>
<tr>
				<td width="150"></td>
				<td width="1"></td>
				<td width="10"></td>
				<td width="549">&nbsp;</td>
				<td width="212">&nbsp;</td>
			</tr>
</table>
</h:form>
</f:view>
</body>
</html>