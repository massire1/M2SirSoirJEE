<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      xmlns:th="http://www.thymeleaf.org"
      layout:decorate="~{fragments/layout}">
<head>
    <title>Access Denied</title>
	<link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	
	<div class="container col-md-6 col-md-offset-3">
			<div class="jumbotron">
				<h1 class="text-danger">Access denied !</h1>
				<div class="alert alert-danger" role="alert">
					<strong>Oh snap! </strong> 
					You gotta get the hell out here as fast as possible
				</div>
				<p><a href="/home" class="btn btn-danger btn-lg">Retour</a></p>
			</div>
		</div>
</body>
</html>