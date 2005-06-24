
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

	<title>Schedule user registration</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
        <h2><h:outputText value="#{bundle.registration_header}" /></h2>

        <p>
        <h:outputText value="#{bundle.register_login_comment}" />
        </p>
        
        <h:form id="loginRegisterForm">
        <table>
            <tr>
                <td><h:outputText value="#{bundle.user_name_label}" /></td>
                <td><h:inputText id="regScreenname" value="#{LoginBean.screenname}" required="true">
                            <f:validateLength minimum="5" />
                            </h:inputText></td>
                <td><h:message for="regScreenname" style="font-weight: bold; color: #FF0000;"/>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.user_password_label}" /></td>
                <td><h:inputSecret id="regPassword" value="#{LoginBean.password}" required="true">
                            <f:validateLength minimum="5" />
                            </h:inputSecret></td>
                <td><h:message for="regPassword" style="font-weight: bold; color: #FF0000;"/>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <h:commandButton id="submit" action="#{LoginBean.registerLogin}" value="#{bundle.register_button_label}" />
                </td>
            </tr>
        </table>
        </h:form>
	</f:view>
</body>
</html>
