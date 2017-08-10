<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.web.client.dto.ApplicationLog"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Logs</title>
</head>
<body style="text-align: center;">
	
	<h1>Application Logs</h1>
	
	<%
	ApplicationLog[] logs = (ApplicationLog[]) request.getAttribute("logs");
	for (ApplicationLog log : logs) {
		out.println("<p>" + log.getDate() + " " +
					 "[" + log.getLogLevel() + "]: " +
					"\"" + log.getMessage() + "\" " +
					", size:" + log.getDataSize() + ", " +
					"source:" + log.getSource() + "</p>");
	}
	%>

</body>
</html>