<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="portale.backend.*,portale.web.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/portal.tld" prefix="p"%>
<!DOCTYPE html>
<html>
<% session.setAttribute("products", ProductRepository.getInstance().getProducts()); %>
<head>
	<title>Prodotti su admin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<p:check-user var="u" admin="true" />
	<table>
		<thead>
			<tr>
				<th>name</th>
				<th>price</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${products}">
				<tr>
					<td><c:out value="${p.name}" /></td>
					<td><c:out value="${p.price}" /></td>
					<td><a href="remove-product?id=${p.id}">remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<form action="add-product" method="post">
		<input type="text" name="name" />
		<input type="number" name="price" />
		<input type="submit" name="add" />
	</form>
	<div>
		<a href='home.jsp'>HOME</a>
	</div>
	<div>
		<a href='logout'>logout</a>
	</div>
</body>
</html>
