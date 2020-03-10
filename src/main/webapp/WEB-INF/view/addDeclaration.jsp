<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie déclaration</title>
</head>
<body>
	<%@include file="decorator/header.jsp"%>
	<div class="container col-md-12">
		<div class="col-md-3">
			<%@ include file="decorator/left.jsp"%>
		</div>
		<div class="col-md-9">
			<h1>Creer déclaration</h1>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">Library</a></li>
						<li class="active">Data</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div>Basic panel example</div>
					<div>
						<a href="/listDeclarations" class="btn btn-primary">Retour</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>