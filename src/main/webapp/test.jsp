<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="portale.backend.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Esempio JSP</title>
	</head>
	<body>
		<div>
			<c:set var="messaggio" value="buongiorno a tutti" scope="page"/>
		<div>
			msg= <%=pageContext.getAttribute("messaggio") %>
		</div>
		msg via cout=<c:out value="${messaggio}"></c:out>
		</div>
		<%
			pageContext.setAttribute("utenti", UserRepository.getInstance().getAll());
		%>
		<c:forEach var="i" begin="5" end="15">
			<div><c:out value="${i}"></c:out></div>
		</c:forEach>
		<hr/>
		<c:forEach var="u" items="${utenti}">
			<div><c:out value="${u.login}"></c:out></div>
		</c:forEach>
		
		<hr/>
		
		<c:choose>
			<c:when test="${messaggio.isEmpty()}">
				<div>il messaggio è vuoto</div>
			</c:when>
			<c:otherwise>
				<div>il messaggio non è vuoto</div>	
			</c:otherwise>
		</c:choose>
		
		
		<%!
			public int somma(int x, int y){
				User u;
				return x+y;
			}
		%>
		
		<jsp:useBean id="utente" class="portale.backend.User" scope="session">
		
		</jsp:useBean>
		<%
			session.setAttribute("utente", new User());
		%>
		<jsp:setProperty property="name" name="utente" value="Carlo"/>
		
		<div>nome= <jsp:getProperty property="name" name="utente"/></div>
		<%
			User u = (User)session.getAttribute("utente");
		%>
		<%=u %>
		<div>questa è una JSP di test</div>
		<%
			out.println("MESSAGGIO DA JAVA");
			for(int i=0;i<10;i++){%>
				<div><%=i %></div>
		<%
			}
			out.println("<div>io sono " + this + "</div>");
			String msg = "messaggio dinamico";
			boolean ok = request.getParameter("ok")!=null;
		%>
		<div>messaggio=<%=msg %> - <%out.println(msg);%></div>
		
		<div>5+6=<%=somma(5,6) %></div>
		<div>FINE</div>
		
		<%if (ok) {%>
			<div>
				messaggio opzionale se ok=true
			</div>
		<%} %>
		
		
	</body>
</html>