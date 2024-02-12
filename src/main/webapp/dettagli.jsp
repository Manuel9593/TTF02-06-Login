<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="portale.backend.User,portale.web.Utils"%>
<!DOCTYPE html>
<%
User u = Utils.checkUser(request, response);
if (u == null)
	return;
String userError = request.getParameter("update-user");
String passwordError = request.getParameter("update-auth");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli <%=u.getLogin()%></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<div
		class="d-flex flex-column justify-content-center align-content-center m-4">
		<div class="container-sm bg-body-secondary pb-3 pt-3 pe-5 ps-5">
			<div class="fs-5 mb-2">
				<a href="./home.jsp?user=<%=u.getLogin()%>"
					class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">
					<i class="bi bi-arrow-left-circle"></i>
					Home
				</a>
			</div>
			<div class="pb-3 pt-3">
				<h2>DETTAGLI DELL'UTENTE</h2>
				<h4 class="fs-5 mb-3"><%=u.getFullName()%></h4>
			</div>
			<h4>Cambia dati utente</h4>
			<form class="mt-4 pt-2 pb-2 ps-3 pe-3 bg-body-tertiary"
				action="./update-user" method="post">
				<div class="mb-3 row">
					<label for="login" class="col-sm-auto col-form-label">Username</label>
					<div class="col-sm-auto">
						<input type="text" id="login" class="form-control form-control-md"
							value='<%=u.getLogin()%>' disabled readonly>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="name" class="col-sm-auto col-form-label">Nome</label>
					<div class="col-sm-auto">
						<input type="text" id="name" name="name"
							class='form-control form-control-md <%if (userError != null)
	if (userError.equals("name"))
		out.print("is-invalid");%>'
							value="<%=u.getName()%>" required>
						<div class="invalid-feedback">Inserisci un nome valido</div>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="surname" class="col-sm-auto col-form-label">Cognome</label>
					<div class="col-sm-auto">
						<input type="text" id="surname" name="surname"
							class="form-control form-control-md <%if (userError != null)
	if (userError.equals("surname"))
		out.print("is-invalid");%>"
							value="<%=u.getSurname()%>" required>
						<div class="invalid-feedback">Inserisci un cognome valido</div>
					</div>
				</div>
				<input type="submit" class="btn btn-outline-primary" value="Cambia">
			</form>
			<h4 class="mt-4">Cambia password</h4>
			<form class="mt-4 pt-2 pb-2 ps-3 pe-3 bg-body-tertiary"
				action="./update-password" method="post">
				<div class="mb-3 row">
					<label for="old" class="col-sm-auto col-form-label">Vecchia
						password</label>
					<div class="col-sm-auto">
						<input type="password" id="old" name="old"
							class="form-control form-control-md <%if (passwordError != null)
	if (passwordError.equals("pass"))
		out.print("is-invalid");%>"
							required>
						<div class="invalid-feedback">Password errata</div>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="newAuth" class="col-sm-auto col-form-label">Nuova
						Password</label>
					<div class="col-sm-auto">
						<input type="password" id="newAuth" name="newAuth"
							class="form-control form-control-md <%if (passwordError != null)
	if (passwordError.equals("newAuth"))
		out.print("is-invalid");%>"
							required>
						<div class="invalid-feedback">Hai già utilizzato questa
							password</div>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="reconfAuth" class="col-sm-auto col-form-label">Riconferma
						password</label>
					<div class="col-sm-auto">
						<input type="password" id="reconfAuth" name="reconfAuth"
							class="form-control form-control-md <%if (passwordError != null)
	if (passwordError.equals("reconf"))
		out.print("is-invalid");%>"
							required>
						<div class="invalid-feedback">Password non uguali</div>
					</div>
				</div>
				<input type="submit" class="btn btn-outline-primary" value="Cambia">
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>