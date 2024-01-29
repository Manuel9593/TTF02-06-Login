<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esempio di JSP</title>
</head>
<body>
	<div>Questa è una landing page</div>
	<%
		response.getWriter().print("MESSAGGIO DA JAVA");
	%>
</body>
</html>