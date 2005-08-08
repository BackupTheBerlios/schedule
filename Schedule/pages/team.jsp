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

<title>Schedule Startseite</title>
<link href="pages/data/clixstylesv2.css" rel="stylesheet"
	type="text/css" media="all">

</head>
<body>
<f:view>
	<f:loadBundle basename="com.schedule.Internationalization" var="bundle" />
	<h:form id="indexForm">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr height="100">
				<td colspan="2" width="151" height="100"
					background="pages/data/schedule.gif">
				<div align="center">&nbsp;<br>
				<br>
				<br>
				(pre-alpha)</div>
				</td>
				<td width="10" height="100" background="pages/data/navitoppic.gif">
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
				<table width="549" border="0" cellspacing="0" cellpadding="0"
					height="100">
					<tr height="70">
						<td width="549" height="70"
							background="pages/data/back_tab_70.gif"><font size="5">ProjectPlaner</font></td>
					</tr>
					<tr bgcolor="#103052" height="30">
						<td width="549" height="30"></td>
					</tr>
				</table>
				</td>
				<td width="212" height="100">
				<table width="212" border="0" cellspacing="0" cellpadding="0"
					height="100">
					<tr bgcolor="#8393A3" height="65">
						<td height="65">&nbsp;</td>
					</tr>
					<tr bgcolor="#103052" height="35">
						<td height="35" background="pages/data/back_tab.gif"></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr height="494">
				<td width="150" height="494">
				<div align="center">
				<table width="150" border="0" cellspacing="0" cellpadding="0"
					height="494">
					
				  
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><h:commandLink
							action="#{NavigationBean.gotoPage}" value="#{bundle.str_home}">
							<f:param name="link" value="home" />
						</h:commandLink></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><h:commandLink
							action="#{NavigationBean.gotoPage}"
							value="#{bundle.str_register}">
							<f:param name="link" value="register" />
						</h:commandLink></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center"><h:commandLink
							action="#{NavigationBean.gotoPage}" value="#{bundle.str_login}">
							<f:param name="link" value="login" />
						</h:commandLink></div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30">
						<div align="center">&nbsp;(c)2005<br>
						<h:commandLink action="#{NavigationBean.gotoPage}"
							value="#{bundle.str_team}">
							<f:param name="link" value="team" />
						</h:commandLink>
						</div>
						</td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="30">
						<td width="150" height="30"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="254">
						<td width="150" height="254"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="70">
						<td width="150" height="70"></td>
					</tr>
					<tr bgcolor="#A8B6C6" height="7">
						<td width="150" height="7"
							background="pages/data/naviseparator.gif"></td>
					</tr>
				</table>
				</div>
				</td>
				<td width="1" height="494"></td>
				<td width="10" height="494"></td>
				<td rowspan="3" width="549">
				<table width="549" border="0" cellspacing="0" cellpadding="0">
					<h:form id="loginForm">
					<tr><h2><h:outputText value="#{bundle.proj_team_header}" /></h2>
						
					</tr>
					<tr>
						<td>
						Dieses System wurde im Rahmen der Vorlesungen <b>K</b>omponenten <b>T</b>echnologien und Verteilte Systeme<br>
								unter Betreuung von <a href="http://www.f4.fhtw-berlin.de/people/elke/" target="_blank">Frau Prof. Dr. Elke Naumann </a> und <a href="http://www.f4.fhtw-berlin.de/people/forte/" target="_blank">Herr Prof. Dr. Albrecht Fortenbacher </a>im Sommersemester 2005 an der<a href="http://www.fhtw-berlin.de" target="_blank"> FHTW-Berlin</a> entwickelt.<br>
								<br>
								<b>Eingesetzte Technologien:<font size="2"><br>
									</font></b><br>
								
								<a href="http://java.sun.com/j2ee/javaserverfaces/"
								 target="_blank">- Java Server Faces </a>
								<br>
								<br><a href="http://www.hibernate.org/"
								 target="_blank">- Hibernate Persistens Layer</a><br>
								<br><a href="http://jakarta.apache.org/tomcat/"
								 target="_blank">- Applicationserver: Tomcat 5.0</a>
								<br>
								<br>
								<b>
								Projekt Mitglieder:<br>
								</b><br>Reinhard Prechtl (KT) <br>
								Frank Otto (KT)<br>
								Christian Sukale (KT,VSYS)<br>
								Andreas Pusian (KT, VSYS)<br>
								Kevin Klein (KT, VSYS)
						</td>
					</tr>
					<tr height="35">
						<td height="35"></td>
					</tr>
					<tr height="343">
						<td height="343"></td>
					</tr>
					</h:form>
				</table>

				</td>
				<td width="212" height="494"></td>
			<tr height="15">
				<td rowspan="3" width="150">
				<div align="center"></div>
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
	</h:form>
</f:view>
</body>
</html>

