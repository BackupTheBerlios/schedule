
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
        <h:outputText value="#{bundle.register_user_comment}" />
        </p>
        
        <h:form id="registerForm">
		<table>
            <tr>
                <td><h:outputText value="#{bundle.register_title}" /></td>
                <td><h:inputText id="regTitle" value="#{UserBean.title}">
                            </h:inputText></td>
                <td><h:message for="regTitle" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_lastname}" /></td>
                <td><h:inputText id="regLastname" value="#{UserBean.lastname}" required="true">
                            </h:inputText></td>
                <td><h:message for="regLastname" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_firstname}" /></td>
                <td><h:inputText id="regFirstname" value="#{UserBean.firstname}" required="true">
                            </h:inputText></td>
                <td><h:message for="regFirstname" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_email}" /></td>
                <td><h:inputText id="regEmail" value="#{UserBean.email}" required="true">
                            <!-- Check for email format -->
                            </h:inputText></td>
                <td><h:message for="regEmail" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_phone}" /></td>
                <td><h:inputText id="regPhone" value="#{UserBean.phone}">
                            </h:inputText></td>
                <td><h:message for="regPhone" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_street}" /></td>
                <td><h:inputText id="regStreet" value="#{UserBean.street}">
                            </h:inputText></td>
                <td><h:message for="regStreet" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_zip}" /></td>
                <td><h:inputText id="regZip" value="#{UserBean.zip}">
                            </h:inputText></td>
                <td><h:message for="regZip" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_city}" /></td>
                <td><h:inputText id="regCity" value="#{UserBean.city}">
                            </h:inputText></td>
                <td><h:message for="regCity" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <h:commandButton id="submit" action="#{UserBean.registerUser}" value="#{bundle.register_button_label}" />
                </td>
            </tr>
        </table>
        </h:form>
	</f:view>
</body>
</html>
