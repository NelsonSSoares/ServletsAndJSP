<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresaCriada.jsp" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criar Empresa</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">
		<label>Nome:<input type="text" name="nome"/><br></label>
		<label>Data:<input type="text" name="data"/><br></label>
		<input type="submit"/>
	</form>
</body>
</html>