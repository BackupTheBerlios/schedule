
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

	<title>Schedule Login</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
        
        <h:outputText value="#{bundle.login_header}"/>
        
        <h:form id="loginForm">
            <table>
                <tbody>
                    <tr>
                        <td><h:outputText value="#{bundle.user_name_label}" /></td>
                        <td>
                            <h:inputText id="userName" value="#{LoginBean.screenname}" required="true">
                                <f:validateLength minimum="5" />
                            </h:inputText>
                        </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="#{bundle.user_password_label}" /></td>
                        <td>
                            <h:inputSecret id="password" value="#{LoginBean.passwort}" required="true">
                                <f:validateLength minimum="5" />
                            </h:inputSecret>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <h:messages style="font-weight: bold; color: #FF0000;" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2">
                            <h:commandButton id="submit" action="#{LoginBean.loginUser}" value="#{bundle.login_button_label}" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </h:form>
        
		
	</f:view>
</body>
</html>
