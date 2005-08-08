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
			
			<!-- Die komplette Header-Zeile wird als Subview (header.jsp) eingefügt -->
			<f:subview id="header">
				<jsp:include page="header.jsp" />
			</f:subview>
			
			<tr height="494">
				<td width="150" height="494">
				<div align="center">
				
				<!-- Navigation -->
				<f:subview id="navigation">
					<jsp:include page="navigation.jsp" />
				</f:subview>
				
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
									action="#{LoginBean.logoutUser}"
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
						<h1><!-- TODO: Vor- und Nachname des Users werden derzeit aus der ProjectBean gelesen 
									 Sinnvoller wäre es wahrscheinlich die Informationen aus einer anderen Bean zu holen z.B. LoginBean -->
						<h:outputText value="Willkommen" /> <h:outputText
							value="#{ProjectBean.user.firstname}" /> <h:outputText
							value="#{ProjectBean.user.lastname}" /></h1>
						</td>
					</tr>
					<tr height="240">
						<td height="240"><!-- Hier folgt der Div-Bereich für die Projekte -->
						<div id="Projects">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:commandLink action="#{NavigationBean.gotoPage}"
									value="#{bundle.str_projects}">
									<f:param name="link" value="projects" />
								</h:commandLink>
								</td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
						Sie nehmen derzeit an <h:outputText
							value="#{ProjectBean.projectCount}" /> Projekt(en) teil <!-- Datatable für dynamische Inhalte -->
						<h:dataTable width="100%"
							rendered="#{ProjectBean.projectCount > 0}"
							value="#{ProjectBean.projectList}" var="pr" cellpadding="2" cellspacing="0" headerClass="headerColumn" columnClasses="tableContent" style="border: 1px silver solid">

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_projectname}" />
								</f:facet>
								
								<h:commandLink action="showprojectpage">
									<h:outputText value="#{pr.name}" />
									<f:param name="proj" value="#{pr.idProjects}" />
								</h:commandLink>
							</h:column>
						</h:dataTable>
						<h:commandLink action="addprojectpage">
							<h:outputText value="Neues Projekt anlegen" />
						</h:commandLink>
					</div>

						<!-- Der Div-Bereich für die Nachrichten folgt hier -->
						<div id="Messages">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:commandLink action="#{NavigationBean.gotoPage}"
									value="#{bundle.str_messages}">
									<f:param name="link" value="messages" />
								</h:commandLink></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
						<!-- Statusmeldung über Anzahl der ungelesenen Nachrichten	--> Sie
						haben <h:outputText value="#{MessageBean.unreadMessagesCount}" />
						ungelesene Nachricht(en) <!-- Data Table für dynamische Ausgabe der Nachrichten -->
						<h:dataTable width="100%"
							rendered="#{MessageBean.unreadMessagesCount > 0}"
							value="#{MessageBean.unreadMessages}" var="msg" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" style="border: 1px silver solid">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:commandLink action="showmessagepage">
									<h:outputText value="#{msg.subject}" />
									<f:param name="Message" value="#{msg.idMessages}" />	
								</h:commandLink>
								
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_sender}" />
								</f:facet>
								<h:outputText value="#{msg.user.login.screenname}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_date}" />
								</f:facet>
								<h:outputText value="#{msg.date}">
									<f:convertDateTime dateStyle="short" type="date"/>
								</h:outputText>
							</h:column>
						</h:dataTable>
						
						<h:commandLink action="newmessagepage">
							<h:outputText value="Neue Nachricht erstellen" />
						</h:commandLink>
						
						</div>

						<!-- Hier folgt der Div-Bereich für die Tasks -->
						<div id="Tasks">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:commandLink action="#{NavigationBean.gotoPage}"
									value="#{bundle.str_tasks}">
									<f:param name="link" value="tasks" />
								</h:commandLink></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
						Sie haben <h:outputText value="#{TaskBean.taskCount}" />
						Aufgaben(en) <!-- Data Table zur dynamischen Ausgabe der Tasks des Users
						     Die Table soll nur angezeigt werden, wenn Tasks für den User vorhanden sind (rendered Attribut)  -->
						<h:dataTable width="100%"
							rendered="#{TaskBean.taskCount > 0}"
							value="#{TaskBean.tasksList}" var="tasks" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" style="border: 1px silver solid">

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:outputText value="#{tasks.subject}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_projectname}" />
								</f:facet>
								<h:outputText value="#{tasks.project.name}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_tasksolved}" />
								</f:facet>
								<h:outputText value="#{tasks.solved}" />
							</h:column>
						</h:dataTable>
						<h:commandLink action="addtaskpage">
							<h:outputText value="Neue Aufgabe erstellen" />
						</h:commandLink>
						</div>

						<!-- Der Div-Bereich für die Appointments folgt hier -->
						<div id="Appointments">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:commandLink action="showappointmentspage"
									value="#{bundle.str_appointments}">
								</h:commandLink></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
					
						Sie haben <h:outputText value="#{AppointmentBean.appointmentCount}" /> Termin(e) <!-- Data Table für dynamische Ausgabe der Termine
						     Tabelle soll nicht angezeigt werden, wenn keine Termine vorhanden sind (rendered Attribut) -->
						<h:dataTable width="100%"
							rendered="#{AppointmentBean.appointmentCount > 0}"
							value="#{AppointmentBean.appointmentsList}" var="appointments" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" style="border: 1px silver solid">

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:outputText value="#{appointments.subject}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_projectname}" />
								</f:facet>
								<h:outputText value="#{appointments.project.name}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_date}" />
								</f:facet>
								<h:outputText value="#{appointments.date}" >
									<f:convertDateTime dateStyle="short" type="date" />
								</h:outputText>
							</h:column>
						</h:dataTable>
						<h:commandLink action="newappointmentpage">
							<h:outputText value="Neuen Termin erstellen" />
						</h:commandLink>
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
