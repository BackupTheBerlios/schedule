
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

	<title>Schedule message center</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
        
        <h:form id="messageForm">
        <h:dataTable var="msg" value="#{MessageBean.messageList}" binding="#{employeeSearch.msgData}" >
	        <h:column>
		        <f:facet name="header">
		            <h:outputText value="Message Date"/> <!-- TODO: Localize! -->
		        </f:facet>
	            <h:commandLink action="#{MessageBean.viewMessage}" value="#{msg.date}" />
            </h:column>
            <h:column>
	            <f:facet name="header">
	                <h:outputText value="Absender" /> <!-- TODO: Localize! -->
	            </f:facet>
	            <h:outputText value="#{msg.sender}"/>
            </h:column>
        </h:dataTable>
        </h:form>
    
		
	</f:view>
</body>
</html>
