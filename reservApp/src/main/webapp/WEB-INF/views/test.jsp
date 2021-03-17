<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Etudiant</title>
</head>
<body>

	<h1>Gérer les etudiants</h1>

	<a href="#addEtudiant">Nouvel etudiant</a>

	<table style="width: 100%">
		<thead>
			<tr>
				<th>idEtudiant</th>
				<th>nom</th>
				<th>dateNaissance</th>
				<th>email</th>
				<th>photo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="etudiant" items="${etudiants}" varStatus="e">
				<tr>
					<td>${etudiant.idEtudiant}</td>
					<td>${etudiant.nom}</td>
					<td>${etudiant.dateNaissance}</td>
					<td>${etudiant.email}</td>
					<td>${etudiant.photo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>