<%@ page language="java"%><%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%><%		String path = request.getContextPath();		String basePath = request.getScheme() + "://" + request.getServerName()				+ ":" + request.getServerPort() + path + "/";		%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html><head><base href="<%=basePath%>"><title>Schedule Main Page</title><link rel="stylesheet" type="text/css"	href="pages/data/clixstylesv2.css"></head><body><f:view>	<f:loadBundle basename="com.schedule.Internationalization" var="bundle" />	<h:form id="mainForm">		<table border="0" cellspacing="0" cellpadding="0">			
			<!-- Header -->
			<f:subview id="header">
				<jsp:include page="header.jsp" />
			</f:subview>
			
						<tr height="494">				<td width="150" height="494">				<div align="center">				
				<!-- Navigation  -->
				<f:subview id="navigation">
					<jsp:include page="navigation.jsp" />
				</f:subview>
								</div>				</td>				<td width="1" height="494"></td>				<td width="10" height="494"></td>				<td rowspan="3" colspan="2" width="761">				<table width="760" border="0" cellspacing="0" cellpadding="0">					<tr height="30">						<td height="30"><!-- Statuszeile -->						<div id="Statuszeile">						<table border="0" cellspacing="0">							<tr bgcolor="#8393A3">								<td width="260">aktuelles Datum: <%		java.util.Date date;		date = new java.util.Date();		out.println(date.toLocaleString());	%>			</td>								<td width="300">&nbsp;</td>								<!-- TODO: Show users real name, not screenname, maybe...-->								<td width="190" align="right"><h:outputText									value="#{LoginBean.screenname}" /> <h:commandLink									action="#{NavigationBean.gotoPage}"									value="#{bundle.str_logout}">									<f:param name="link" value="logout" />								</h:commandLink></td>								<td width="10">&nbsp;</td>							</tr>						</table>						</div>						</td>					</tr>					<tr height="60">						<td>								<h1>															<h:outputText value="Willkommen im Project" />								<h:outputText value="#{ProjectBean.currentProject.name}" style="font-style: italic;" />								</h1>
							<h3>								<h:outputText value="Projektbeschreibung:" />
							</h3>								<h:outputText value="#{ProjectBean.currentProject.description}" style="" />						</td>					</tr>					<tr height="240">						<td height="240">											<div id="projtasks">						<table width="100%" border="0" cellspacing="0">							<tr bgcolor="#A8B6C6">								<td><h:outputText value="#{bundle.str_tasks}" /></td>							</tr>							<tr bgcolor="#A8B6C6" height="7">								<td height="7" background="pages/data/naviseparator.gif"></td>							</tr>						</table>
						Das Projekt enth�lt derzeit <h:outputText value="" /> Aufgabe(n)						<h:dataTable value="#{ProjectBean.taskList}" var="task" cellpadding="2" cellspacing="0" headerClass="headerColumn" columnClasses="tableContent" width="100%" rendered="#{ProjectBean.taskList[0] != null}">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:outputText value="#{task.subject}" />
							</h:column>
						</h:dataTable>					</div>
										<div id="projappoint">						<table width="100%" border="0" cellspacing="0">							<tr bgcolor="#A8B6C6">								<td><h:outputText value="#{bundle.str_appointments}" /></td>							</tr>							<tr bgcolor="#A8B6C6" height="7">								<td height="7" background="pages/data/naviseparator.gif"></td>							</tr>						</table>
						<h:dataTable value="#{ProjectBean.appointmentList}" var="appointment" rendered="#{ProjectBean.appointmentList[0] != null}" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:outputText value="#{appointment.subject}" />
							</h:column>
						</h:dataTable>					</div>					
					<div id="projboard">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_blackboard}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
						<h:dataTable value="#{ProjectBean.blackboardEntryList}" var="bbEntry" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" width="100%" rendered="#{ProjectBean.blackboardEntryList[0] != null}">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_subject}" />
								</f:facet>
								<h:outputText value="#{bbEntry.subject}" />
							</h:column>
						</h:dataTable>
					</div>
										<div id="projusers">						<table width="100%" border="0" cellspacing="0">							<tr bgcolor="#A8B6C6">								<td><h:outputText value="#{bundle.str_projectmembers}" /></td>							</tr>							<tr bgcolor="#A8B6C6" height="7">								<td height="7" background="pages/data/naviseparator.gif"></td>							</tr>						</table>
						<h:dataTable value="#{ProjectBean.userList}" var="user" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" rendered="#{ProjectBean.userList[0] != null}" width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Name" />
								</f:facet>
								<h:outputText value="#{user.login.screenname}" />
							</h:column>
						</h:dataTable>					</div>										<div id="projgroups">						<table width="100%" border="0" cellspacing="0">							<tr bgcolor="#A8B6C6">								<td><h:outputText value="#{bundle.str_projectgroups}" /></td>							</tr>							<tr bgcolor="#A8B6C6" height="7">								<td height="7" background="pages/data/naviseparator.gif"></td>							</tr>						</table>
						<h:dataTable value="#{ProjectBean.groupsList}" var="group" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" rendered="#{ProjectBean.groupsList[0] != null}" width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Name" />
								</f:facet>
								
									<h:outputText value="#{group.name}" />
								
							</h:column>
						</h:dataTable>					</div>
					
					<div id="projadmin">
						<table width="100%" border="0" cellspacing="0">
							<tr bgcolor="#A8B6C6">
								<td><h:outputText value="#{bundle.str_projectadmin}" /></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
						</table>
						<h:dataTable value="#{ProjectBean.groupsList}" var="group" rendered="#{ProjectBean.isAdmin == true}" cellpadding="2" cellspacing="0" columnClasses="tableContent" headerClass="headerColumn" width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Projektmitglieder verwalten" />
								</f:facet>
								<h:commandLink action="projadduser" actionListener="#{ProjectBean.projectToAddUser}">
									<h:outputText value="Projektmitglieder hinzufuegen" />
								</h:commandLink>
								<f:verbatim><br/></f:verbatim>
								<h:commandLink action="projdeluser" actionListener="#{ProjectBean.projectToAddUser}">
									<h:outputText value="Projektmitglieder entfernen" />
								</h:commandLink>
								
							</h:column>
						</h:dataTable>
					</div>						</td>					</tr>					<tr height="225">						<td height="225"></td>					</tr>				</table>				</td>			<tr height="15">				<td rowspan="3" width="150">				<div align="center"></div>				</td>				<td width="1"></td>				<td width="10"></td>			</tr>			<tr>				<td width="1"></td>				<td width="10"></td>			</tr>			<tr height="15">				<td width="1" height="15"></td>				<td width="10" height="15"></td>				<td width="549" height="15">&nbsp;</td>				<td width="212" height="15">&nbsp;</td>			</tr>			<tr>				<td width="150"></td>				<td width="1"></td>				<td width="10"></td>				<td width="549">&nbsp;</td>				<td width="212">&nbsp;</td>			</tr>		</table>	</h:form></f:view></body></html>