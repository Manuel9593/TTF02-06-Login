<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String err = request.getParameter("err");
%>
<html>
	<head>
		<meta charset="ISO-8859-1\">
		<title>Portale admins</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="d-flex flex-column h-100 justify-content-strech align-content-center p-4">
			<form class="container-sm" action="login" method="post" style="{ max-width: 400px }">
				<div class="p-1 form-floating">
					<input type="text" id="login" class="form-control <% out.println(err!=null ? "is-invalid" : ""); %>" name="login" required>
					<label for="login">Nome utente</label>
					<div class="invalid-feedback">Non esiste utente con questo username</div>
				</div>
				<div class="p-1 form-floating">
					<input type="password" id="password" class="form-control  <% out.println(err!=null ? "is-invalid" : ""); %>" name="password" required>
					<label for="password">Password</label>
					<div class="invalid-feedback">La password non corrisponde</div>
				</div>
				<div class="p-1"><input type="submit" class="btn btn-primary btn-lg m-1" name="submit" value="Login"></div>
			</form>
			<div> 
			<%
				out.println(err!=null ? "ERRORE" : "");
			%>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>