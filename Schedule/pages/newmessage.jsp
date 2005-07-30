
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

	<title>Message Center - New Message</title>

	<link rel="stylesheet" type="text/css" 	href="pages/data/clixstylesv2.css">

</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
		<h:form>
		<table border="0" cellspacing="0" cellpadding="0">
			
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
							<h1>Neue Nachricht erstellen</h1>
						</td>
					</tr>
					<tr height="240">
						<td height="240">
							<!-- Tabelle für die Eingabemaske -->
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50">
										<strong>An:</strong>
									</td>
									<td>
										<h:inputText id="Recipient" value="#{MessageBean.recipient}" size="75" />
									</td>
								</tr>
								<tr>
									<td width="50"> 
										<strong>Betreff:</strong>
									</td>
									<td>
										<h:inputText id="Subject" value="#{MessageBean.subject}" size="75" />
									</td>
								</tr>
								<tr>	
									<td colspan="2">
										<h:inputTextarea id="Body" value="#{MessageBean.body}" cols="80" rows="15" />
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<h:commandButton action="" value="Submit" />
									</td> 
								</tr>
							</table>
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
