<!-- import di classi Java -->
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- codice html restituito al client -->
<html>
	<head>
		<meta name="Author" content="cg">
		<title>Registrazione</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	</head>

	<body>
	<div class=container>
	
	<div class=row> 
		
		<div class=col-6>  </div>
		
		<h3>Registrazione</h3>
		
		
		<p>REGISTRATION:</p>
		
		<div>
		<c:url var="url" value="/part/add" />
      
      <div class=col-4>
		<form name="login" action="${url}" method="post">
		      <div class="mb-1"> 
		      
               <label for="nome" class="form-label" >Nome:</label>
			   <input type="text" class="form-control" name="nome"/>
			   
			   </div>
			   
			   <div class="mb-1"> 
		      
               <label for="cognome" class="form-label" >Cognome:</label>
			   <input type="text" class="form-control" name="cognome"/>
			   
			   </div>
			   
			   <div class="mb-1"> 
		      
               <label for="email" class="form-label" >Email:</label>
			   <input type="text" class="form-control" name="email"/>
			   
			   </div>
			   
			   <div class="mb-1"> 
		      
               <label for="nome" class="form-label" >Password:</label>
			   <input type="text" class="form-control" name="password"/>
			   
			   </div>
			   
			<input type="submit" name="loginButton" class="btn btn-primary" value="REGISTRARTI"/>
		</form>
		</div>
		<p> ${ result }
		</div>
		
		</div>
		</div>

	</body>
</html>

