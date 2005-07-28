
<%@ page language="java" pageEncoding="UTF-8"%>
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

	<title>My JSF 'projects.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  
<body>
	<f:view>
		<f:loadBundle basename="com.schedule.Internationalization" var="bundle"/>
		
    <h:form>
    
        <h:dataTable value="#{ProjectBean.projectList}" var="pr">
          
          <h:column>
            <f:facet name="header">
              <h:outputText value="#{bundle.str_projectname}" />
            </f:facet>
            
            <h:commandLink action="showprojectspage" value="#{pr.name}">
       			<f:param name="project" value="pr" />
   		    </h:commandLink>
   			
            
            
          </h:column>
          
          <h:column>
            <f:facet name="header">
              <h:outputText value="#{bundle.str_projectdescription}" />
            </f:facet>
            <h:outputText value="#{pr.description}" />
          </h:column>
    
        </h:dataTable>
    </h:form>



	</f:view>
</body>
</html>

