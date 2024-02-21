<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="portale.backend.*,portale.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/portal.tld" prefix="p"%>
<!DOCTYPE html>
<html>
	<p:check-user var="u"/>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home <c:out value="${ u.getFullName() }" /></title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="d-flex flex-column justify-content-center align-content-center m-4">
			<div class="bg-body-secondary pb-3 pt-3 pe-5 ps-5">
				<div class="h2 fs-2 mb-3"><c:out value="${ u.getFullName() }" /></div>
				<div class="fs-5 mb-2">
					<a href="./dettagli.jsp" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Profilo</a>
				</div>
				<div class="fs-5 mb-2">
					<a href="./carrello.jsp" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Carrello</a>
				</div>
				<c:if test="${ u.isAdmin() }">
					<div class="fs-5 mb-2">
						<a href="./prodotti.jsp" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Gestione prodotti</a>
					</div>
				</c:if>
				<div class="fs-5">
					<a href="./logout" class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover">Logout</a>
				</div>			
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>