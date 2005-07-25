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
	<link href="pages/data/clixstylesv2.css" rel="stylesheet" type="text/css" media="all">
	
</head>
<body>

<f:view>
<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
<h:form id="indexForm">
<table border="0" cellspacing="0" cellpadding="0">
			<tr height="100">
				<td colspan="2" width="151" height="100" background="pages/data/schedule.gif">
					<div align="center">
						&nbsp;<br>
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
					<table width="549" border="0" cellspacing="0" cellpadding="0" height="100">
						<tr height="70">
							<td width="549" height="70" background="pages/data/back_tab_70.gif"><font size="5">ProjectPlaner</font></td>
						</tr>
						<tr bgcolor="#103052" height="30">
							<td width="549" height="30"></td>
						</tr>
					</table>
				</td>
				<td width="212" height="100">
					<table width="212" border="0" cellspacing="0" cellpadding="0" height="100">
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
				<td  width="150" height="494" >
					<div align="center">
						<table width="150" border="0" cellspacing="0" cellpadding="0" height="494">
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
                                       	<h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_main}"><f:param name="link" value="home" /></h:commandLink>    
                                       </div>
								</td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
									<div align="center">
                                            <h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_messages}"><f:param name="link" value="messages" /></h:commandLink></div>
								</td>
							</tr>
							<tr bgcolor="#A8B6C6" height="7">
								<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
							</tr>
							<tr bgcolor="#A8B6C6" height="30">
								<td width="150" height="30">
                                    <div align="center">
                                    	<h:commandLink action="#{NavigationBean.gotoPage}" value="#{bundle.str_calendar}"><f:param name="link" value="calendar" /></h:commandLink>
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
										<td width="150" height="7" background="pages/data/naviseparator.gif"></td>
									</tr>
								</table>
					</div>
				</td>
				<td width="1" height="494"></td>
				<td width="10" height="494">
					
				</td>
				<td rowspan="3" width="549">
					<table width="549" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<p>Herzlich willkommen bei Schedule! <br>
									<br>
									Mit dieser Anwendung k&ouml;nnen Sie Projekte jeder Art verwalten. Um das System zu benutzen m&uuml;ssen Sie sich registrieren und anschliessend einloggen.<br>
								Schedule befindet sich momentan noch in der Entwicklung, in den n&auml;chsten Wochen werden deshalb immer mehr Funktionen hinzukommen, die Sie benutzen k&ouml;nnen. Sollten Sie Fehler feststellen oder Verbesserungsvorschl&auml;ge haben, wenden Sie sich bitte vertrauensvoll an uns.</p>
							</td>
						</tr>
						<tr height="35">
							<td height="35"></td>
						</tr>
						<tr height="343">
							<td height="343"></td>
						</tr>
					</table>
					
				</td>
				<td width="212" height="494">
				
					<table width="220" border="0" cellspacing="0" cellpadding="1" class="linecolor">
					<tr><td align="center" valign="middle" >
						<table cellspacing='0' width='100%' border='0' cellpadding='0'>
							<tr class='labelledboxmyhomehead'><td height='18' width='100%' class='labelledboxmyhomehead'>Deadlines</td></tr>
							<tr class='labelledboxmyhomehead'><td colspan='1' class='linecolor'><img height='1' width='1' border='0' alt='' src='pages/data/transparent.gif'></td></tr>
						</table>
						<table cellspacing='0' width='100%' class='backcolorgrey' border='0' cellpadding='0'>
							<tr><td colspan='2'><img height='5' src='pages/data/transparent.gif'></td></tr>
							<tr class='labelledboxcontent'>
								<td valign='top' width='1%'><span class='paddingleftrightNN5'><img vspace='3' border='0' src='pages/data/icon_starterbullet.gif'></span></td>
								<td width='75%' class='permtext'><span class='paddingleftrightNN5'>Als Student/in registrieren:<br><a href="http://ecampus.fhtw-berlin.de/support/register/student.php" target="contentframe">bitte hier klicken</a></span></td>
							</tr>
							
							<tr><td colspan='2'><img height='5' src='pages/data/transparent.gif'></td></tr><tr class='labelledboxcontent'>
								<td valign='top' width='1%'><span class='paddingleftrightNN5'><img vspace='3' border='0' src='pages/data/icon_starterbullet.gif'></span></td>
								<td width='75%' class='permtext'><span class='paddingleftrightNN5'>Als Dozent/in registrieren:<br>
		<a href="http://ecampus.fhtw-berlin.de/support/register/dozent.php" target="contentframe">bitte hier klicken</a></span></td>
							</tr>
						</table>
					</td></tr>
				</table>
				<br>
				<table width="220" border="0" cellspacing="0" cellpadding="1" class="linecolor">
				<tr><td align="center" valign="middle" >
					<table cellspacing='0' width='100%' border='0' cellpadding='0'>
						<tr class='labelledboxmyhomehead'><td height='18' width='100%' class='labelledboxmyhomehead'>Open Tasks</td></tr>
						<tr class='labelledboxmyhomehead'><td colspan='1' class='linecolor'><img height='1' width='1' border='0' alt='' src='pages/data/transparent.gif'></td></tr>
					</table>
					<table cellspacing='0' width='100%' class='backcolorgrey' border='0' cellpadding='0'>
						<tr><td colspan='2'><img height='5' src='pages/data/transparent.gif'></td></tr>
						<tr class='labelledboxcontent'>
							<td valign='top' width='1%'><span class='paddingleftrightNN5'><img vspace='3' border='0' src='pages/data/icon_starterbullet.gif'></span></td>
							<td width='75%' class='permtext'><span class='paddingleftrightNN5'>Als Student/in registrieren:<br><a href="http://ecampus.fhtw-berlin.de/support/register/student.php" target="contentframe">bitte hier klicken</a></span></td>
						</tr>
						
						<tr><td colspan='2'><img height='5' src='pages/data/transparent.gif'></td></tr><tr class='labelledboxcontent'>
							<td valign='top' width='1%'><span class='paddingleftrightNN5'><img vspace='3' border='0' src='pages/data/icon_starterbullet.gif'></span></td>
							<td width='75%' class='permtext'><span class='paddingleftrightNN5'>Als Dozent/in registrieren:<br>
	<a href="http://ecampus.fhtw-berlin.de/support/register/dozent.php" target="contentframe">bitte hier klicken</a></span></td>
						</tr>
					</table>
 				</td></tr>
			</table>
			<br>
			<table width="220" border="0" cellspacing="0" cellpadding="1" class="linecolor">
				<tr><td align="center" valign="middle" >
       				<table cellspacing='0' width='100%' border='0' cellpadding='0'>
						<tr class='labelledboxmyhomehead'><td height='18' width='100%' class='labelledboxmyhomehead'>Last Messages</td></tr>
						<tr class='labelledboxmyhomehead'><td colspan='1' class='linecolor'><img height='1' width='1' border='0' alt='' src='pages/data/transparent.gif'></td></tr>
					</table>
       				<table cellspacing='0' width='100%' class='backcolorgrey' border='0' cellpadding='0'>
          				<tr><td colspan='2'><img height='5' src='pages/data/transparent.gif'></td></tr>
						<tr class='labelledboxcontent'><td width='75%' class='permtext'><span class='paddingleftrightNN5'><ul>
							<li><a href="http://www.studentenwerk-berlin.de/mensen/speiseplan/fhtw/index.html" target="_blank">Speiseplan der Mensa</a><P></li>
							<li> <a href="https://lsf.fhtw-berlin.de/" target="_blank">Pr¸fungsanmeldungen und Leistungs¸bersichten</a> <P></li>
							<li> <a href="http://www.f3.fhtw-berlin.de/aktuelles.html" target="_blank">Newsseite des FB3</a><P> </li>
							<li><a href="http://www.f4.fhtw-berlin.de" target="_blank">Newsseite des FB4</a><P> </li>
							<li><a href="http://www.rz.fhtw-berlin.de" target="_blank">Hochschulrechenzentrum<P></li>
							</ul></span></td>
						</tr>
          				<tr><td><img height='5' src='pages/data/transparent.gif'></td></tr>
						<tr class='labelledboxcontent'><td width='75%' class='permtext'><span class='paddingleftrightNN5'><a href="javascript:openDemoWindow200402211017(' ')"> </a></span></td></tr>
    					<tr class='backcolorgrey'><td>&nbsp;</td></tr>
					</table>
 				</td></tr>
			</table>
				
				
				
				
				</td>
			
							
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
</h:form>
</f:view>

</body>
</html>
