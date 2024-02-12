<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="portale.backend.User,portale.web.Utils"%>
<!DOCTYPE html>
<%
User u = Utils.checkUser(request, response);
if (u == null)
	return;
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home <%=u.getLogin()%></title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="d-flex flex-column justify-content-center align-content-center m-4">
			<div class="container-sm bg-body-secondary pb-3 pt-3 pe-5 ps-5">
				<div class="h2 fs-2 mb-3"><%=u.getFullName() %></div>
				<div class="fs-5 mb-2">
					<a href="./dettagli.jsp?user=<%=u.getLogin()%>" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Home</a>
				</div>
				<div class="fs-5 mb-2">
					<a href="./carrello.jsp?user=<%=u.getLogin()%>" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Carrello</a>
				</div>
				<div class="fs-5">
					<a href="./logout" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Logout</a>
				</div>			
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>