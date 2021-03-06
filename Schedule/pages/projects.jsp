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

<title>Projekte</title>
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
						<h1><h:outputText value="Project Center" /></h1>
						</td>
					</tr>
					<tr height="40">
						<td><h:outputText
							value="Hier finden Sie ein �bersicht �ber alle Projekte an denen Sie gew�hrtig teilnehmen" />
						</td>
					</tr>
					<tr height="200">
						<td valign="top"><h:dataTable value="#{ProjectBean.projectList}"
							var="project" width="100%" headerClass="headerColumn"
							columnClasses="tableContent" cellpadding="2" cellspacing="0"
							style="border: 1px solid silver">

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_projectname}" />
								</f:facet>
								<h:commandLink action="showprojectpage">
									<h:outputText value="#{project.name}" />
									<f:param name="proj" value="#{project.idProjects}" />
								</h:commandLink>

							</h:column>

							<h:column>
								<f:facet name="header">
									<h:outputText value="#{bundle.str_projectdescription}" />
								</f:facet>
								<h:outputText value="#{project.description}" />
							</h:column>

						</h:dataTable></td>
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
