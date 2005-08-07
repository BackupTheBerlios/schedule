<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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

<title>Kalender</title>
<link rel="stylesheet" type="text/css"
	href="pages/data/clixstylesv2.css">

</head>
<body>
<f:view>
	<f:loadBundle basename="com.schedule.Internationalization" var="bundle" />
	<h:form id="mainForm">
		<table border="0" cellspacing="0" cellpadding="0">

			<f:subview id="header">
				<jsp:include page="header.jsp" />
			</f:subview>

			<tr height="494">
				<td width="150" height="494">
				<div align="center">
				
				<!-- Naviagtion -->
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
						<h1><h:outputText value="Kalender" /></h1>
						</td>
					</tr>
					<tr height="40">
						<td><h:outputText
							value="Hier finden Sie ein Übersicht über alle Ihre Termine" />
						</td>
					</tr>
	
					<tr height="200">
						<td valign="top">
						
						
						
					<h:dataTable width="100%"	
						cellpadding="2" cellspacing="0" headerClass="headerColumn" columnClasses="tableContent" style="border: 1px silver solid">
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="#{CalendarBean.datePointerString}" />
								
								</f:facet>
								
						</h:column>	
							</h:dataTable>
							
						<h:dataTable width="100%"
							
							value="#{CalendarBean.appointmentsList}" var="appointments" cellpadding="2" cellspacing="0" headerClass="headerColumn" columnClasses="tableContent" style="border: 1px silver solid">

							<h:column>
								<f:facet name="header">
									
									<h:outputText value="Termine" />
								
								</f:facet>
								
								<h:outputText value="#{appointments.subject}" />
								
							</h:column>
							
								
							
							<h:column>
								<f:facet name="header">
									
									<h:outputText value="Beschreibung" />
								
								</f:facet>
								
								
								
								<h:outputText value="#{appointments.description}" />
								
							</h:column>
							
							<h:column>
								<f:facet name="header">
								
									<h:outputText value="Projekt" />
								
								</f:facet>
								
								
								<h:commandLink action="showprojectpage">
									<h:outputText value="#{appointments.project.name}" />
									<f:param name="proj" value="#{appointments.project.idProjects}" />
								</h:commandLink>
							
							
							</h:column>
						
						
							</h:dataTable>
						
						
						
							<h:dataTable value="#{CalendarBean.tasksList}"
							var="task" width="100%" headerClass="headerColumn"
							columnClasses="tableContent" cellpadding="2" cellspacing="0"
							style="border: 1px solid silver">

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_tasks}" />
								</f:facet>
									<h:outputText value="#{task.subject}" />
							</h:column>

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_taskdescription}" />
								</f:facet>
								<h:outputText value="#{task.description}" />
							</h:column>
							
							
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_tasksolved}" />
								</f:facet>
								<h:outputText value="#{task.solved}" />
							</h:column>
							
							<h:column>
								<f:facet name="header">
									<h:outputText value="Projekt" />
								</f:facet>
								<h:commandLink action="showprojectpage">
									<h:outputText value="#{task.project.name}" />
									<f:param name="proj" value="#{task.project.idProjects}" />
								</h:commandLink>
								
							</h:column>
							

					
						
						
						
						
						
						
							
							<f:facet name="footer">
								<h:panelGroup>
									<h:commandButton value= "zurück" action="backward" 
									actionListener="#{CalendarBean.backwardDay}" />
									<h:commandButton value ="vorwärts" action="forward" 
									actionListener="#{CalendarBean.forwardDay}" />
								</h:panelGroup>
							</f:facet>
						</h:dataTable>
						</td>
					</tr>
					
					
					
					
					
					
					
					
					
					
					
				<tr height="200">
						<td valign="top">
						
						
						
					<h:dataTable 
						value="#{CalendarBean.weekList}" var ="blub" width="100%"	
						cellpadding="2" cellspacing="0" headerClass="headerColumn" columnClasses="tableContent" style="border: 1px silver solid">
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Montag" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
								
						</h:column>		
					
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Dienstag" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Mittwoch" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Donnerstag" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Freitag" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="Sa" />
									
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
						<h:column>
							<f:facet name="header">
								
									<h:outputText value="So" />
								
								</f:facet>
								<h:commandLink action="calendarpage" actionListener="#{CalendarBean.backwardDay}">
									<h:outputText value="#{CalendarBean.weekPointer.simpleDateString}" />
									
								</h:commandLink>
								
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Termine  (#{CalendarBean.taskCount})" />
									<f:verbatim><br/></f:verbatim>
									<h:outputText value="Aufgaben (#{CalendarBean.taskCount})" />
						</h:column>		
					
					
					
					<f:facet name="footer">
								<h:panelGroup>
									<h:commandButton value= "zurück" action="backward" 
									actionListener="#{CalendarBean.backwardWeek}" />
									<h:commandButton value ="vorwärts" action="forward" 
									actionListener="#{CalendarBean.forwardWeek}" />
								</h:panelGroup>
							</f:facet>
					
					</h:dataTable>
					
					
					
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