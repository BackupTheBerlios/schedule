
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Add a project</title>
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
				<div align="center"><!-- Navigation --> <f:subview id="navigation">
					<jsp:include page="navigation.jsp" />
				</f:subview></div>
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
						<h1>Neuen Task erstellen</h1>
						</td>
					</tr>
					<tr height="40">
						<td>
							Auf dieser Seite können Sie neue Tasks anlegen.
						</td>
					</tr>
					<tr height="200">
						<td height="240" valign="top">
						
						<!-- Tabelle für die Eingabemaske -->
						<table>
							<tr>
								<td></td>
								<td><h:messages /></td>
							</tr>
							<tr>
								<!----   TODO: 
			Internationization fuer beschriftung labels u Buttons ------>
								<td>Tasktitel:</td>
								<td><h:inputText id="taskSubj" value="#{TaskBean.subject}" /></td>
							</tr>
							<tr>
								<td>Beschreibung:</td>
								<td><h:inputText id="taskDescr"
									value="#{TaskBean.description}" /></td>
							</tr>
							<tr>
								<td>Projekt:</td>
								<td><h:inputText id="taskProj"
									value="#{TaskBean.pid}" /></td>
							</tr>
							<tr>
								<td><h:commandButton id="submit"
									action="#{TaskBean.addTask}"
									value="#{bundle.login_button_label}" /></td>
								<td></td>
							</tr>
							<tr><td>
							

							
							</td><td></td></tr>
						</table>
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
