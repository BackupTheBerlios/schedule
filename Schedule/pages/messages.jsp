
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

    <h:form>

    <h:dataTable value="#{MessageBean.messageList}" var="msg">
	
	  <h:column>
	    <f:facet name="header">
	      <h:outputText value="#{bundle.str_sender}" />
	    </f:facet>
	    <h:outputText value="#{msg.uid}" />
	
	  </h:column>
	
	  <h:column>
        <f:facet name="header">
	      <h:outputText value="#{bundle.str_subject}" />
	    </f:facet>
	    <h:outputText value="#{mgs.subject}" />
	  </h:column>
	
	  <h:column>
	    <f:facet name="header">
	      <h:outputText value="#{bundle.str_date}" />
	    </f:facet>
	    <h:outputText value="#{msg.date}" />
	  </h:column>

	</h:dataTable>

  </h:form>

</f:view>
</body>
</html>
