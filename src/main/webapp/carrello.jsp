<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="portale.backend.*,portale.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="./WEB-INF/portal.tld" prefix="p"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Esempio JSP</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
<%-- 		<c:out value="${ cart }"></c:out> --%>
<%-- 		<c:forEach var="prod" items="${ cart.getProducts() }"> --%>
<%-- 			<c:out value="${ prod.getName() }"></c:out> --%>
<%-- 		</c:forEach> --%>
		<p:check-user var="u" />
		<div
			class="d-flex flex-column justify-content-center align-content-center m-4">
			<div class="container-sm bg-body-secondary pb-3 pt-3 pe-5 ps-5">
				<jsp:useBean id="cart" class="portale.backend.Cart" scope="session">
				</jsp:useBean>
				<p:cart user="${ u }" add="aggiungi.jsp" cart="${ cart }" product="p">
					<p:cart-row remove="remove-product?id=" product="${ p }"/>
				</p:cart>
				<div>
					<a href='logout'>logout</a>
				</div>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>