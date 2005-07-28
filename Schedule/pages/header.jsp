
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:verbatim>
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
				<td width="549" height="70" background="pages/data/back_tab_70.gif"><font
					size="5">ProjectPlaner</font></td>
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
				<td height="65">
				<div align="center">&nbsp;(c)2005<br>
				</f:verbatim> <h:commandLink action="#{NavigationBean.gotoPage}"
					value="#{bundle.str_team}">
					<f:param name="link" value="team" />
				</h:commandLink> <f:verbatim></div>
				</td>
			</tr>
			<tr bgcolor="#103052" height="35">
				<td height="35" background="pages/data/back_tab.gif"></td>
			</tr>
		</table>
		</td>
	</tr>
</f:verbatim>
