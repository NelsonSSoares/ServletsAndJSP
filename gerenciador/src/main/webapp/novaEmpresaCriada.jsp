<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova empresa criada</title>
</head>
<body>
	<c:if test="${not empty empresa}">
		<h3>Empresa: ${empresa} cadastrada com sucesso!!</h3>
	</c:if>
	<c:if test="${empty empresa}">
		<h3>O Campo Não pode ser Vazio</h3>
	</c:if>
	


</body>
</html>