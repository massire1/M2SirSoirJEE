<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<div class="container col-md-12">
		<div class="col-md-3">
			<%@ include file="decorator/left.jsp"%>
		</div>
		<div class="col-md-9">
			<!-- <h1>Dashboard</h1> -->
			<div class="row">
				<div class="col-md-12">
					<!-- <ol class="breadcrumb">
						<li><a href="/home" class="active">Dashboard</a></li>
						<li></li>
					</ol> -->
					<div class="jumbotron">
				<h1>Welcome, dashboard!</h1>
<!-- 				<p>...</p> -->
				<p>
<!-- 					<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a> -->
				</p>
			</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Gestion déclarations</h3>
						</div>
						<div class="panel-body">Panel content</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">Gestion Habitations</h3>
						</div>
						<div class="panel-body">Panel content</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3 class="panel-title">Gestion des utilisateus </h3>
						</div>
						<div class="panel-body">Panel content</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<h3 class="panel-title">Paramétrages</h3>
						</div>
						<div class="panel-body">Panel content</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>