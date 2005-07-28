<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		
		/*response.setHeader("Refresh", "60");*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Schedule Main Page</title>
<link rel="stylesheet" type="text/css"
	href="pages/data/clixstylesv2.css">

</head>
<body>
<f:view>
	<f:loadBundle basename="com.schedule.Internationalization" var="bundle" />
	<h:form id="mainForm">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="100">
				<td colspan="2" width="151" height="100"
					background="pages/data/schedule.gif">
				<div align="center">&nbsp;<br>
				<br>
				<br>
				(pre-alpha)</div>
				</td>
				<td width="10" height="100" background="pages/data/navitoppic.gif">
				<table border="0" cellspacing="0" cellpadding="0" height="100">
					<tr height="70">
						<td width="10" height="70" background="pages/data/back_tab_70.gif"></td>
					</tr>
					<tr bgcolor="#103052" height="30">
						<td width="10" height="30"></td>
					</tr>
				</table>
				</td>
				<td nowrap width="549" height="100">
				<table width="549" border="0" cellspacing="0" cellpadding="0"
					height="100">
					<tr height="70">
						<td width="549" height="70"
							background="pages/data/back_tab_70.gif"><font size="5">ProjectPlaner</font></td>
					</tr>
					<tr bgcolor="#103052" height="30">
						<td width="549" height="30"></td>
					</tr>
				</table>
				</td>
				<td width="212" height="100">
				<table width="212" border="0" cellspacing="0" cellpadding="0"
					height="100">
					<tr bgcolor="#8393A3" height="65">
						<td height="65">
						<div align="center">&nbsp;(c)2005<br>
						<h:commandLink action="#{NavigationBean.gotoPage}"
							value="#{bundle.str_team}">
							<f:param name="link" value="team" />
						</h:commandLink></div>
						</td>
					</tr>
					<tr bgcolor="#103052" height="35">
						<td height="35" background="pages/data/back_tab.gif"></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr height="494">
				<td width="150" height="494">
				<div align="center">
				<table width="150" border="0" cellspacing="0" cellpadding="0"
					height="494">
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><a title="Projekt Home" href="pages/index.jsp">Schedule
						Home</a></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><a title="EMail an Reinhard Prechtl"
							href="mailto:neo36@spymac.com">Reinhard Prechtl</a></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><a title="EMail an Christian Sukale"
							href="mailto:s0503706@fhtw-berlin.de">Christian Sukale</a></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><a title="EMail an Frank Otto"
							href="mailto:frank.otto@fhtw-berlin.de">Frank Otto</a></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="205">
						<td width="150" height="205"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="104">
						<td width="150" height="104"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
				</table>
				</div>
				</td>
				<td width="1" height="494"></td>
				<td width="10" height="494"></td>
				<td rowspan="3" colspan="2" width="761">

				<table width="760" border="0" cellspacing="0" cellpadding="0">
					<tr height="30">
						<td height="30"><!-- Statuszeile -->
						<div id="Statuszeile">
						<table border="0" cellspacing="0">
							<tr bgcolor="#8393A3">
								<td width="260">aktuelles Datum: <%
		java.util.Date date;
		date = new java.util.Date();
		out.println(date.toLocaleString());
	%></td>
								<td width="300">&nbsp;</td>
								<!-- TODO: Show users real name, not screenname, maybe...-->
								<td width="190" align="right"><h:outputText
									value="#{LoginBean.screenname}" /> <h:commandLink
									action="#{NavigationBean.gotoPage}"
									value="#{bundle.str_logout}">
									<f:param name="link" value="logout" />
								</h:commandLink></td>
								<td width="10">&nbsp;</td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<tr height="60">
						<td>	
							<h1>
								<!-- TODO: Vor- und Nachname des Users werden derzeit aus der ProjectBean gelesen 
									 Sinnvoller w�re es wahrscheinlich die Informationen aus einer anderen Bean zu holen z.B. LoginBean -->							
								<h:outputText value="Willkommen" />
							</h1>
						</td>
					</tr>
					<tr height="240">
						<td height="240"><!-- Hier folgt der Div-Bereich f�r die Projekte -->
						
					<div id="projtasks">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_tasks}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					</div>
					
					<div id="projappoint">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_appointments}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					</div>
					
					<div id="projboard">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_blackboard}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					</div>
					
					<div id="projusers">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_projectmembers}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					</div>
					
					<div id="projgroups">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_projectgroups}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					</div>

						</td>
					</tr>
					<tr height="225">
						<td height="225"></td>
					</tr>
				</table>

				</td>
			<tr height="15">
				<td rowspan="3" width="150">
				<div align="center"></div>
				</td>
				<td width="1"></td>
				<td width="10"></td>
			</tr>
			<tr>
				<td width="1"></td>
				<td width="10"></td>
			</tr>
			<tr height="15">
				<td width="1" height="15"></td>
				<td width="10" height="15"></td>
				<td width="549" height="15">&nbsp;</td>
				<td width="212" height="15">&nbsp;</td>
			</tr>
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