
<!-- import di classi Java -->
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- codice html restituito al client -->
<html>
<head>
<meta name="Author" content="cg">
<title>Pagina Login</title>
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

			<h3>Effettua il login</h3>


			<p>Insert your credentialis:</p>



			<div>
				<c:url var="url" value="/login" />

				<div class=col-4>
					<form name="login" action="${url}" method="post">
						<div class="mb-1">

							<label for="username" class="form-label">Username:</label> <input
								type="text" class="form-control" name="username" />

						</div>
						<div class="mb-1">

							<label for="password" class="form-label">Password:</label> <input
								type="password" name="password" class="form-control" />

						</div>
						<input type="submit" name="loginButton" class="btn btn-primary"
							value="login" />
					</form>
					<span></span> <span></span>
					<c:url var="url" value="/registra" />
					<input type="button" name="indietro" value="REGISTRATI"
						class="btn btn-primary" onclick="location.href='${url}'" />
				</div>
				<p>${ result }
			</div>

		</div>
	</div>

</body>
</html>

