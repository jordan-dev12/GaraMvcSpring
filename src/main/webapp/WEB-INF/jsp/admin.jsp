<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- codice html restituito al client -->
<html>
<head>
<meta name="Author" content="cg">
<title>Admin Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
</head>

<body>

	<div class=container>

		<div class=row>

			<div class=col-4></div>
			<h3>ADMIN</h3>

			<p>Aggiungere un'altra gara:</p>

			<c:url var="url" value="/gara/add" />
			<c:url var="url2" value="/gara/list" />

			<div class=col-4>
				<form name="admin" action="${url}" method="post">
					<div class="mb-1">
						<label for="nome" class="form-label">Nome:</label> <input
							type="text" class="form-control" name="nome" />
					</div>

					<div class="mb-1">
						<label for="luogo" class="form-label">Luogo:</label> <input
							type="text" class="form-control" name="luogo" />
					</div>

					<div class="mb-1">
						<label for="data" class="form-label">Data:</label> <input
							type="text" class="form-control" name="data" />
					</div>


					<input type="submit" name="saveButton" class="btn btn-primary"
						value="SAVE GARA" /> <span></span> <input type="button"
						name="LISTA" value="LISTA" class="btn btn-primary"
						onclick="location.href='${url2}'" />
				</form>
			</div>
			<p>${ OK }
		</div>
	</div>
</body>
</html>
