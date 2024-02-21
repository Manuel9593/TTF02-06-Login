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
		<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
	</head>
	<body>
		<div class="container container-sm align-middle h-100">
			<div class="row">
				<div class="col d-inline-flex justify-content-center p-4">
					<form class="d-flex flex-column mb-3 gap-3" action="login" method="post" style="min-width: 300px">
						<div class="form-floating d-flex flex-column justify-content-center">
							<input type="text" id="login" class="form-control <% out.println(err!=null ? "is-invalid" : ""); %>" name="login" placeholder="Nome utente" required>
							<label for="login">Nome utente</label>
							<div class="invalid-feedback">Non esiste utente con questo username</div>
						</div>
						<div class="form-floating d-flex flex-column justify-content-center">
							<input type="password" id="password" class="form-control  <% out.println(err!=null ? "is-invalid" : ""); %>" name="password" placeholder="Password" required>
							<label for="password">Password</label>
							<div class="invalid-feedback">La password non corrisponde</div>
						</div>
						<div class="d-flex flex-column justify-content-center">
							<input type="submit" class="btn btn-primary btn-lg m-1" value="Login">
						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript">
			const login = document.getElementById("login")
			const password = document.getElementById("password")
			login.addEventListener('input', (event) => {
				const el = event.srcElement
				el.classList.remove("is-invalid")
			})
			password.addEventListener('input', (event) => {
				const el = event.srcElement
				el.classList.remove("is-invalid")
			})
		</script>
	</body>
</html>