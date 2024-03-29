<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="portale.backend.*,portale.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<%
User u = Utils.checkUser(request, response);
if (u == null)
	return;
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Aggiungi prodotto</title>
		<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	</head>
	<body>
		
		<div
			class="d-flex flex-column justify-content-center align-content-center m-4">
			<div class="container-sm bg-body-secondary pb-3 pt-3 pe-5 ps-5">
				<div class="h1">AGGIUNGI PRODOTTO</div>
				<form class="mt-4 pt-2 pb-2 ps-3 pe-3 bg-body-tertiary"
					action="add-product" method="POST">
					<div class="mb-3 row align-middle">
						<label for="product" class="col-sm-auto col-form-label">Prodotto</label>
						<div class="col-sm-auto align-middle">
							<select id="product" name="product" class="form-select" aria-label="Default select example">
								<c:forEach var="p" items="${ ProductRepository.getInstance().getProducts() }">
									<option value="${ p.getId() }">
										<c:out value="${ p.getName() }"/>
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="mb-3 row align-middle">
						<label for="quantity" class="col-sm-auto col-form-label">Quantità</label>
						<div class="col-sm-auto align-middle">
							<input id="quantity" type="number" value="1" name="q" class="form-control" />
						</div>
					</div>
					<div class="mb-3">
						<button type="submit" class="btn btn-primary">Aggiungi</button>
					</div>
				</form>
				<div class="mt-4 row">
					<div class="col-md-auto">
						<a href='carrello.jsp'>
							<i class="bi bi-cart4"></i>
							Home
						</a>
					</div>
					<div class="col-md-auto">
						<a href='logout'>
							<i class="bi bi-arrow-left-circle"></i>
							Logout
						</a>
					</div>
				</div>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>