<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIST GARE</title>

<script src="${pageContext.request.contextPath}/scripts/gara.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.min.js"
	type="text/javascript"></script>



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
			<c:url var="home" value="/" scope="request" />

			<div class=col-5>
				<table class="table" style="font-size: 20px;" id="tabella"
					border="2">
					<caption>
						<p>Lista delle GARE</p>

						<thead>
							<tr>
								<th>Nome</th>
								<th>Luogo</th>
								<th>Data</th>
								<th>Operazione</th>
							</tr>
						</thead>

						<tbody id="myResult">

							<c:forEach items="${result}" var="gara">

								<tr>
									<td class="text-center">${gara.nome}</td>
									<td>${gara.luogo }</td>
									<td>${gara.data }</td>
									<td>
										<button id="prova" type="button" class="btn btn-success"
											value="${gara.nome}" onclick='rimuovere("${gara.nome}")'>
											rimuovi</button> <span></span> <span></span>
											
											<c:url var="url" value="/gara/listPartecipante?id=${gara.id}" />
										  <button id="prova" type="button" class="btn btn-success"
											value="${gara.id}" onclick="location.href='${url}'">
											ListPartecipanti</button>
									</td>

								</tr>
							</c:forEach>

						</tbody>
				</table>

				<span></span> <span></span>
				<p>
					<c:url var="url" value="/gara/ritorno" />
					<input type="button" name="indietro" value="INDIETRO"
						class="btn btn-primary" onclick="location.href='${url}'" />
			</div>

		</div>
	</div>
</body>
</html>