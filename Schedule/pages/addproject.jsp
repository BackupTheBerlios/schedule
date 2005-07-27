
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

	<title>Add a project</title>
	<link rel="stylesheet" type="text/css"
	href="pages/data/clixstylesv2.css">
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
		<h:form id="mainForm">
		<table>
		<tr>
		<td>
		</td>
		<td><h:messages />
		</td>
		</tr>
			<tr>
			<!----   TODO: 
			Internaionization fuer beschriftung labels u Buttons ------>
				<td>Project name:</td>
				<td><h:inputText id="projName" value="#{ProjectBean.name}" required="true"> 
					</h:inputText></td></td>
			</tr>
			<tr>
				<td>Description:</td><td><h:inputText id="projDescr" value="#{ProjectBean.description}" required="true">
					</h:inputText></td>
			</tr>
			<tr>
				<td><h:commandButton id="submit"
										action="#{ProjectBean.addProject}"
										value="#{bundle.login_button_label}" /></td>
				<td></td>
			</tr>
		</table>
			
			
		
		
		</h:form>
	</f:view>
</body>
</html>
