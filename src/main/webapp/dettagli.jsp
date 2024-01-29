<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="portale.backend.User,portale.web.Utils"%>
<!DOCTYPE html>
<%
User u = Utils.checkUser(request, response);
if (u == null)
	return;
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		DETTAGLI DELL'UTENTE
		<%=u.getFullName()%>
		<form>
			<div></div>
			<div></div>
			<div></div>
			<input type="submit">
		</form>
		<form>
			<div></div>
			<div></div>
			<div></div>
			<input type="submit">
		</form>
	</div>
</body>
</html>