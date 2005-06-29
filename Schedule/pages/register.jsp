
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

	<link href="pages/data/clixstylesv2.css" rel="stylesheet" type="text/css" media="all">
</head>
  
<body>
<f:view>
<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>       

<table border="0" cellspacing="0" cellpadding="0">
<h:form id="navForm">   
			<tr height="100">
				<td colspan="2" width="151" height="100" background="pages/data/schedule.gif">
					<div align="center">
						&nbsp;<br>
						<br>
						<br>
						(pre-alpha)</div>
				</td>
				<td width="10" height="100" background="../pages/data/navitoppic.gif">
					<table border="0" cellspacing="0" cellpadding="0" height="100">
						<tr height="70">
							<td width="10" height="70" background="pages/data/back_tab_70.gif"></td>
						</tr>
						<tr bgcolor="#103052" height="30">
							<td width="10" height="30"></td>
						</tr>
					</table>
				</td>
				<td nowrap width="549" height="100">
					<table width="549" border="0" cellspacing="0" cellpadding="0" height="100">
						<tr height="70">
							<td width="549" height="70" background="pages/data/back_tab_70.gif">
								<div align="left">
									<font size="5">ProjectPlaner</font></div>
							</td>
						</tr>
						<tr bgcolor="#103052" height="30">
							<td width="549" height="30"></td>
						</tr>
					</table>
				</td>
				<td width="212" height="100">
					<table width="212" border="0" cellspacing="0" cellpadding="0" height="100">
						<tr bgcolor="#8393A3" height="65">
						  <td height="65">                         
                			     <div align="center">&nbsp;(c)2005<br>
						     <h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_team}"><f:param name="link" value="team" /></h:commandLink></div>
                            </td>
						</tr>
						<tr bgcolor="#103052" height="35">
							<td height="35" background="pages/data/back_tab.gif"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="379">
				<td  width="150" height="379" >
					<div align="center">
						<table width="150" border="0" cellspacing="0" cellpadding="0" height="382">
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
									<h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_register}"><f:param name="link" value="register" /></h:commandLink></div>
                                </td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
									<h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_login}"><f:param name="link" value="login" /></h:commandLink></div>
                                </td>
							</tr>
                              
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="188">
								<td width="150" height="188"></td>
							</tr>
					     </table>
					</div>
                    </h:form>
				</td>
				<td width="1" height="379"></td>
				<td width="10" height="379">
					
				</td>
				<td rowspan="3" width="549">
					<table width="549" border="0" cellspacing="0" cellpadding="0">
						<tr height="35">
							<td rowspan="2" height="359">

        <h2><h:outputText value="#{bundle.registration_header}" /></h2>

        <p>
        <h:outputText value="#{bundle.register_comment}" />
        </p>

        <table>
        <h:form id="registerForm">
            <tr>
                <td><h:outputText value="#{bundle.user_name_label}" /></td>
                <td><h:inputText id="regScreenname" value="#{RegisterBean.screenname}" required="true">
                            <f:validateLength minimum="5" />
                            </h:inputText></td>
                <td><h:message for="regScreenname" style="font-weight: bold; color: #FF0000;"/>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.user_password_label}" /></td>
                <td><h:inputSecret id="regPassword" value="#{RegisterBean.password}" required="true">
                            <f:validateLength minimum="5" />
                            </h:inputSecret></td>
                <td><h:message for="regPassword" style="font-weight: bold; color: #FF0000;"/>
            </tr>
            <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_title}" /></td>
                <td><h:inputText id="regTitle" value="#{RegisterBean.title}">
                            </h:inputText></td>
                <td><h:message for="regTitle" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_lastname}" /></td>
                <td><h:inputText id="regLastname" value="#{RegisterBean.lastname}" required="true">
                            </h:inputText></td>
                <td><h:message for="regLastname" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_firstname}" /></td>
                <td><h:inputText id="regFirstname" value="#{RegisterBean.firstname}" required="true">
                            </h:inputText></td>
                <td><h:message for="regFirstname" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_email}" /></td>
                <td><h:inputText id="regEmail" value="#{RegisterBean.email}" required="true">
                            <!-- Check for email format -->
                            </h:inputText></td>
                <td><h:message for="regEmail" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_phone}" /></td>
                <td><h:inputText id="regPhone" value="#{RegisterBean.phone}">
                            </h:inputText></td>
                <td><h:message for="regPhone" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_street}" /></td>
                <td><h:inputText id="regStreet" value="#{RegisterBean.street}">
                            </h:inputText></td>
                <td><h:message for="regStreet" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_zip}" /></td>
                <td><h:inputText id="regZip" value="#{RegisterBean.zip}">
                            </h:inputText></td>
                <td><h:message for="regZip" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>
            <tr>
                <td><h:outputText value="#{bundle.register_city}" /></td>
                <td><h:inputText id="regCity" value="#{RegisterBean.city}">
                            </h:inputText></td>
                <td><h:message for="regCity" style="font-weight: bold; color: #FF0000;" /></td>
            </tr>

            <tr>
                <td align="right" colspan="2">
                    <h:commandButton id="submit" action="#{RegisterBean.register}" value="#{bundle.register_button_label}" />
                </td>
            </tr>
        </h:form>
        </table>
        <h:messages style="font-weight: bold; color: #FF0000;" />
							</td>
						</tr>
						<tr height="324">
							
						</tr>
					</table>
					
				</td>
				<td width="212" height="379"></td>
			
							
<tr height="15">
				<td rowspan="3" width="150">
					<div align="center">
						</div>
				</td>
				<td width="1"></td>
				<td rowspan="2" width="10"></td>
				<td width="212" height="15"></td>
			</tr>
<tr>
				<td width="1"></td>
				<td width="212">&nbsp;</td>
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

</f:view>
</body>
</html>
