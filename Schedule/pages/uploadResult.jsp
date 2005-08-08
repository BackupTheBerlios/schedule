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

    <h:panelGrid columns="2" border="0" cellspacing="5" rendered="#{UploadBean.isSet == 1}">

        <h:outputText value="FileName:"/>
        <h:outputText value="#{UploadBean.myFile.name}" />

        <h:outputText value="FileSize:"/>
        <h:outputText value="#{UploadBean.myFile.size}" />

        <h:outputText value="Param:"/>
        <h:outputText value="#{UploadBean.myParam}"/>

        <h:outputText value="Result:"/>
        <h:outputText value="#{UploadBean.myResult}"/>

    </h:panelGrid>
	</f:view>
</body>
</html>

