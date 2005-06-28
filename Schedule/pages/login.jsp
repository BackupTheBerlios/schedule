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
	<link href="../data/clixstylesv2.css" rel="stylesheet" type="text/css" media="all">
	
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">
			<tr height="100">
				<td colspan="2" width="151" height="100" background="../data/schedule.gif">
					<div align="center">
						&nbsp;<br>
						<br>
						<br>
						(pre-alpha)</div>
				</td>
				<td width="10" height="100" background="../data/navitoppic.gif">
					<table border="0" cellspacing="0" cellpadding="0" height="100">
						<tr height="70">
							<td width="10" height="70" background="../data/back_tab_70.gif"></td>
						</tr>
						<tr bgcolor="#103052" height="30">
							<td width="10" height="30"></td>
						</tr>
					</table>
				</td>
				<td nowrap width="549" height="100">
					<table width="549" border="0" cellspacing="0" cellpadding="0" height="100">
						<tr height="70">
							<td width="549" height="70" background="../data/back_tab_70.gif">
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
									 <a href="../team.html">Projektteam Schedule</a></div>
							</td>
						</tr>
						<tr bgcolor="#103052" height="35">
							<td height="35" background="../data/back_tab.gif"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="292">
				<td  width="150" height="292" >
					<div align="center">
						<table width="150" border="0" cellspacing="0" cellpadding="0" height="294">
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
										<a href="http://localhost:8080/Schedule/pages/register.faces">registrieren</a></div>
								</td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="../data/naviseparator.gif"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
										<a href="http://localhost:8080/Schedule/pages/login.faces">einloggen</a></div>
								</td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="../data/naviseparator.gif"></td>
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
							<tr bgcolor="#A8B6C6" height="100">
								<td width="150" height="100"></td>
							</tr>
						</table>
					</div>
				</td>
				<td width="1" height="292"></td>
				<td width="10" height="292">
					
				</td>
				<td rowspan="3" width="549">
					<table width="549" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<p>Herzlich willkommen bei Schedule! <br>
									<br>
									<br>Bitte geben sie Ihre Login und IIhr Passwort in dei unten augef&uuml;hrten Felder ein.</p>
							</td>
						</tr>
						<tr height="35">
							<td height="35"></td>
						</tr>
						<tr height="130">
							<td height="130">
							
							<f:view>
							<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
					        
					        <h2><h:outputText value="#{bundle.login_header}"/></h2>
					        <p>
					        <h:outputText value="#{bundle.login_comment}" />
					        </p>
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
						                            <h:inputSecret id="password" value="#{LoginBean.password}" required="true">
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
							
							</td>
						</tr>
					</table>
					
				</td>
				<td width="212" height="292"></td>
			
							
<tr height="15">
				<td rowspan="3" width="150">
					<div align="center">
						</div>
				</td>
				<td width="1"></td>
				<td width="10"></td>
				<td width="212" height="15"></td>
			</tr>
<tr>
				<td width="1"></td>
				<td width="10"></td>
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
</body>
</html>
