<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/extensions" prefix="x"%>

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
	<h:form id="MyForm" enctype="multipart/form-data" >

    <h:messages globalOnly="true" styleClass="message"/>

    <h:panelGrid columns="3" border="0" cellspacing="5">

        <h:outputLabel for="myFileId" value="File: "/>
        <x:inputFileUpload id="myFileId"
            value="#{UploadBean.myFile}"
            storage="file"
            required="true"/>
        <h:message for="myFileId"/>

        <h:outputText value=" "/>
        <h:commandButton value="Submit"
            action="#{UploadBean.processMyFile}"/>
        <h:outputText value=" "/>

    </h:panelGrid>

</h:form>
</f:view>
</body>
</html>

