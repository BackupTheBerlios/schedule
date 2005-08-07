<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<!-- Link zur Hauptseite -->
<f:verbatim>
	<table width="150" border="0" cellspacing="0" cellpadding="0" height="494">
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="home" value="#{bundle.str_main}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		
<!-- Link zur Projektseite -->
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="projectspage" value="#{bundle.str_projects}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		
<!-- Link zur Nachrichtenseite -->		
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="messagepage" value="#{bundle.str_messages}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		
<!-- Link zur Aufgabeseite -->
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="taskpage" value="#{bundle.str_tasks}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		
<!-- Link zur Terminseite -->
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="showappointmentspage" value="#{bundle.str_appointments}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
		
<!-- Link zum Kalender -->
		<tr bgcolor="#A8B6C6" height="30">
			<td width="150" height="30">
				<div align="center">
</f:verbatim>
<h:commandLink action="calendarpage" value="#{bundle.str_calendar}" />
<f:verbatim>
				</div>
			</td>
		</tr>
		<tr bgcolor="#A8B6C6" height="7">
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
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
			<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
		</tr>
</table>
</f:verbatim>
